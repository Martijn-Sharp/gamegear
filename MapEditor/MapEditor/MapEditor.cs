﻿namespace MapEditor
{
    using System;
    using System.Collections.Generic;
    using System.Drawing;
    using System.IO;
    using System.Linq;
    using System.Windows.Forms;
    using Newtonsoft.Json;

    public partial class MapEditor : Form
    {
        private Dictionary<Point, Node> map;
        private Dictionary<string, Bitmap> images;
        private CategoryEnum categorySelected = CategoryEnum.Default;

        private Spawner currentSelectedSpawner;

        private string actorSelected;
        private int yButtonCount = 10;
        private int buttonWidth = 30;
        private int buttonHeight = 30;
        private int distance = 10;
        private int startX = 0;
        private int startY = 0;
        private int guiLeftX = 0;
        private int guiRightX = 24;

        public MapEditor()
        {
            this.map = new Dictionary<Point, Node>();
            this.images = new Dictionary<string, Bitmap>();
            this.InitializeComponent();
            this.BuildGui(BuildOptions.Build);
            this.PopulateLists();
        }

        private enum CategoryEnum
        {
            Default = 0,
            Spawner = 1,
            Level = 2,
        }

        private enum BuildOptions
        {
            Clear,
            Build,
            Import,
            ChangeView
        }

        public static ActorFile Actors { get; set; }

        public static LevelProperties LevelProps { get; set; }

        /// <summary>
        /// Parses x and y coords from input
        /// </summary>
        /// <param name="coordinates">format: "x,y"</param>
        /// <returns>Array with y = [0] and x = [1]</returns>
        public static int[] GetCoordsFromString(string coordinates)
        {
            string[] coords = coordinates.Split(',');
            var temp = new int[2];
            for (int i = 0; i < 2; i++)
            {
                temp[i] = Convert.ToInt32(coords[i]);
            }

            return temp;
        }

        private void ChangeTileClick(object sender, EventArgs e)
        {
            // When the button is clicked,
            // change the button text, and disable it.
            var clickedButton = (Control)sender;
            var tmpPoint = (Point)clickedButton.Tag;

            // Check if tile exists
            if (!this.map.ContainsKey(tmpPoint))
            {
                switch (this.categorySelected)
                {
                    case CategoryEnum.Spawner:
                        this.map.Add(tmpPoint, new Spawner(tmpPoint.X + this.guiLeftX, 9 - tmpPoint.Y, LevelProps.Colors) { Name = this.actorSelected, Type = Node.NodeType.Spawner, SpawnedActorSpeed = 0.5f });
                        clickedButton.BackgroundImage = this.GetImage(this.actorSelected, CategoryEnum.Spawner);
                        break;
                    case CategoryEnum.Level:
                        this.map.Add(tmpPoint, new Node(tmpPoint.X + this.guiLeftX, 9 - tmpPoint.Y) { Name = this.actorSelected, Type = Node.NodeType.Tile });
                        clickedButton.BackgroundImage = this.GetImage(this.actorSelected, CategoryEnum.Level);
                        break;
                    case CategoryEnum.Default:
                        clickedButton.BackgroundImage = this.GetImage("default");
                        break;
                }
            }
            else
            {
                if (this.chkDelete.Checked)
                {
                    this.map.Remove(tmpPoint);
                    clickedButton.BackgroundImage = this.GetImage("default");
                    this.pnlSpawnerProps.Visible = false;
                }
                else if (this.map[tmpPoint] is Spawner)
                {
                    this.currentSelectedSpawner = (Spawner)this.map[tmpPoint];
                    this.pnlSpawnerProps.Visible = true;
                    this.FillSpawnProperties(this.currentSelectedSpawner);
                }
                else
                {
                    this.pnlSpawnerProps.Visible = false;
                }
            }
        }

        private void CurrentButtonMouseHover(object sender, EventArgs e)
        {
            try
            {
                Node node = this.map[(Point)((Control)sender).Tag];
                this.lblButtonX.Text = "X = " + (node.X + this.guiLeftX);
                this.lblButtonY.Text = "Y = " + node.Y;
                this.lblButtonValue.Text = "Name = " + node.Name;
            }
            catch (KeyNotFoundException)
            {
                var point = (Point)((Control)sender).Tag;
                this.lblButtonX.Text = "X = " + (point.X + this.guiLeftX);
                this.lblButtonY.Text = "Y = " + (9 - point.Y);
                this.lblButtonValue.Text = "Name = ";
            }
        }

        private void BuildGui(BuildOptions options)
        {
            switch (options)
            {
                case BuildOptions.Build:
                    this.mapPanel.Controls.Clear();
                    for (int x = 0; x < 25; x++)
                    {
                        for (int y = 0; y < this.yButtonCount; y++)
                        {
                            var tmpButton = new Panel
                            {
                                Top = this.startY + (y * this.buttonHeight) + this.distance,
                                Left = this.startX + (x * this.buttonWidth) + this.distance,
                                Width = this.buttonWidth,
                                Height = this.buttonHeight,
                                Tag = new Point(x, y),
                                BackgroundImage = this.GetImage("default")
                            };

                            tmpButton.MouseHover += this.CurrentButtonMouseHover;
                            tmpButton.Click += this.ChangeTileClick;
                            this.mapPanel.Controls.Add(tmpButton);
                        }
                    }

                    break;
                case BuildOptions.Clear:
                    foreach (var button in this.mapPanel.Controls.OfType<Panel>())
                    {
                        button.BackgroundImage = this.GetImage("default");
                    }

                    this.map.Clear();
                    break;
                case BuildOptions.Import:
                    foreach (KeyValuePair<Point, Node> a in this.map.Where(x => x.Key.X >= this.guiLeftX && x.Key.X <= this.guiRightX))
                    {
                        // Restore imported map here
                        //Control fillButton = this.mapPanel.Controls.Find(a.Key, false)[0];
                        var position = a.Key;
                        position.X -= this.guiLeftX;
                        Control fillButton = this.mapPanel.Controls.OfType<Panel>().FirstOrDefault(x => (Point)x.Tag == position);
                        if (fillButton != null)
                        {
                            if (a.Value.Type == Node.NodeType.Spawner)
                            {
                                fillButton.BackgroundImage = this.GetImage("spawner", CategoryEnum.Spawner);
                            }
                            else if (a.Value.Type == Node.NodeType.Tile)
                            {
                                fillButton.BackgroundImage = this.GetImage(a.Value.Name, CategoryEnum.Level);
                            }
                        }
                    }

                    break;
                case BuildOptions.ChangeView:
                    for (int x = 0; x < 25; x++)
                    {
                        for (int y = 0; y < this.yButtonCount; y++)
                        {
                            var button = this.mapPanel.Controls.OfType<Panel>().FirstOrDefault(z => (Point)z.Tag == new Point(x, y));
                            if (button != null)
                            {
                                var node = this.map.FirstOrDefault(mapNode => mapNode.Key == new Point(x + this.guiLeftX, y));
                                button.BackgroundImage = 
                                    node.Value != null ?
                                    this.GetImage(node.Value.Name, node.Value is Spawner ? CategoryEnum.Spawner : CategoryEnum.Level) 
                                    : this.GetImage("default");
                            }
                        }
                    }

                    break;
            }
        }

        public void ChangeGuiPosition(int step)
        {
            int newGuiLeftX = this.guiLeftX + step;
            if (newGuiLeftX >= 0 && newGuiLeftX < int.MaxValue)
            {
                this.guiLeftX = newGuiLeftX;
                this.guiRightX = this.guiRightX + step;
            }
            else
            {
                this.guiLeftX = 0;
                this.guiRightX = 24;
            }

            this.lblPageStretch.Text = string.Format("{0} - {1}", this.guiLeftX, this.guiRightX);
            this.BuildGui(BuildOptions.ChangeView);
        }

        public void PopulateLists()
        {
            this.listEnemies.Items.Clear();
            //foreach (var enemy in Actors.DynamicActors)
            //{
            //    this.listEnemies.Items.Add(new ListViewItem(enemy.Key));
            //}
            this.listEnemies.Items.Add(new ListViewItem("drone"));

            this.listLevels.Items.Clear();
            foreach (var level in Actors.StaticActors)
            {
                this.listLevels.Items.Add(new ListViewItem(level.Key));
            }
        }

        #region Import/Export
        private void ImportClick(object sender, EventArgs e)
        {
            // Displays an OpenFileDialog so the user can select a Cursor.
            var openFileDialog1 = new OpenFileDialog
            {
                Filter = "Map files|*.dat",
                Title = "Select a Map File"
            };

            // Show the Dialog.
            // If the user clicked OK in the dialog and
            // a .dat file was selected, open it.
            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                string lines;

                using (var f = new FileStream(openFileDialog1.FileName, FileMode.OpenOrCreate, FileAccess.ReadWrite))
                {
                    using (var s = new StreamReader(f))
                    {
                        lines = s.ReadToEnd();
                    }
                }

                this.BuildGui(BuildOptions.Clear);
                LevelProps = JsonConvert.DeserializeObject<LevelProperties>(lines);
                foreach (var enemy in LevelProps.Spawners)
                {
                    this.map.Add(new Point(enemy.X, 9 - enemy.Y), enemy);
                }

                foreach (var tile in LevelProps.Tiles)
                {
                    this.map.Add(new Point(tile.X, 9 - tile.Y), tile);
                }

                this.BuildGui(BuildOptions.Import);
            }
        }

        private void ExportClick(object sender, EventArgs e)
        {
            LevelProps.Spawners = new List<Spawner>();
            LevelProps.Tiles = new List<Node>();

            foreach (KeyValuePair<Point, Node> a in this.map)
            {
                if (a.Value.Type == Node.NodeType.Spawner)
                {
                    LevelProps.Spawners.Add((Spawner)a.Value);
                }
                else if (a.Value.Type == Node.NodeType.Tile)
                {
                    LevelProps.Tiles.Add(a.Value);
                }
            }

            // Convert map to JSON
            string lines = JsonConvert.SerializeObject(LevelProps);

            // Displays a SaveFileDialog so the user can save the map
            var saveFileDialog1 = new SaveFileDialog
            {
                Filter = "Map file|*.dat",
                Title = "Save a Map File"
            };
            saveFileDialog1.ShowDialog();

            // If the file name is not an empty string open it for saving.
            if (saveFileDialog1.FileName != string.Empty)
            {
                using (var f = new FileStream(saveFileDialog1.FileName, FileMode.Create, FileAccess.ReadWrite))
                {
                    using (var s = new StreamWriter(f))
                    {
                        s.WriteLine(lines);
                    }
                }
            }
        }
        #endregion

        private void CloseClick(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void ClearClick(object sender, EventArgs e)
        {
            if (MessageBox.Show("Clear map?", "Confirm delete", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                // Clear map
                this.BuildGui(BuildOptions.Clear);
            }
        }

        private void PropertiesClick(object sender, EventArgs e)
        {
            if (new PropertiesForm().ShowDialog() != DialogResult.Abort)
            {
                this.PopulateLists();
            }
        }

        private void ListEnemiesSelectedIndexChanged(object sender, EventArgs e)
        {
            if (this.listEnemies.SelectedItems.Count == 1)
            {
                this.categorySelected = CategoryEnum.Spawner;
                this.actorSelected = this.listEnemies.SelectedItems[0].Text;
            }
        }

        private void ListLevelsSelectedIndexChanged(object sender, EventArgs e)
        {
            if (this.listLevels.SelectedItems.Count == 1)
            {
                this.categorySelected = CategoryEnum.Level;
                this.actorSelected = this.listLevels.SelectedItems[0].Text;
            }
        }

        private Image GetImage(string name, CategoryEnum category = CategoryEnum.Default)
        {
            if (this.images.ContainsKey(name))
            {
                return this.images[name];
            }

            Bitmap image;
            switch (category)
            {
                case CategoryEnum.Spawner:
                    image = new Bitmap("assets/images/spawner.png");
                    break;
                case CategoryEnum.Level:
                    image = new Bitmap("assets/static/" + name + ".png");
                    break;
                default:
                    image = new Bitmap("assets/images/" + name + ".png");
                    break;
            }

            if (image.Size.Height != 30)
            {
                image = new Bitmap(image, new Size(30, 30));
            }

            this.images.Add(name, image);
            return image;
        }

        private void FillSpawnProperties(Spawner spawner)
        {
            this.ddlColors.Items.Clear();
            this.ddlColors.Items.Add("All");
            if (LevelProps.Colors != null)
            {
                foreach (var color in LevelProps.Colors)
                {
                    this.ddlColors.Items.Add(color);
                }
            }

            if (spawner.SpawnColor != null)
            {
                if (spawner.SpawnColor.Count > 1)
                {
                    this.ddlColors.SelectedItem = "All";
                }
                else
                {
                    this.ddlColors.SelectedItem = spawner.SpawnColor[0];
                }
            }

            this.speedUpDown.Value = Convert.ToDecimal(spawner.SpawnedActorSpeed);
            this.intervalUpDown.Value = Convert.ToDecimal(spawner.SpawnInterval);
            this.chkMultiple.Checked = spawner.Multiple;
            this.lblInterval.Visible = spawner.Multiple;
            this.intervalUpDown.Visible = spawner.Multiple;
        }

        private void DdlColorsSelectedIndexChanged(object sender, EventArgs e)
        {
            if (this.currentSelectedSpawner.SpawnColor == null)
            {
                this.currentSelectedSpawner.SpawnColor = new List<LevelProperties.ColorEnum>();
            }

            if (this.ddlColors.SelectedItem == "All")
            {
                foreach (var color in Enum.GetValues(typeof(LevelProperties.ColorEnum)))
                {
                    this.currentSelectedSpawner.SpawnColor.Add((LevelProperties.ColorEnum)color);
                }
            }
            else
            {
                this.currentSelectedSpawner.SpawnColor.Add((LevelProperties.ColorEnum)this.ddlColors.SelectedItem);
            }
        }

        private void SpeedUpDownValueChanged(object sender, EventArgs e)
        {
            this.currentSelectedSpawner.SpawnedActorSpeed = Convert.ToSingle(this.speedUpDown.Value);
        }

        private void ChkMultipleCheckedChanged(object sender, EventArgs e)
        {
            this.currentSelectedSpawner.Multiple = this.chkMultiple.Checked;
            this.lblInterval.Visible = this.chkMultiple.Checked;
            this.intervalUpDown.Visible = this.chkMultiple.Checked;
        }

        private void IntervalUpDownValueChanged(object sender, EventArgs e)
        {
            this.currentSelectedSpawner.SpawnInterval = Convert.ToSingle(this.intervalUpDown.Value);
        }

        private void BtnFasterBackwardClick(object sender, EventArgs e)
        {
            this.ChangeGuiPosition(-25);
        }

        private void BtnFastBackwardClick(object sender, EventArgs e)
        {
            this.ChangeGuiPosition(-10);
        }

        private void BtnBackwardClick(object sender, EventArgs e)
        {
            this.ChangeGuiPosition(-1);
        }

        private void BtnForwardClick(object sender, EventArgs e)
        {
            this.ChangeGuiPosition(1);
        }

        private void BtnFastForwardClick(object sender, EventArgs e)
        {
            this.ChangeGuiPosition(10);
        }

        private void BtnFasterForwardClick(object sender, EventArgs e)
        {
            this.ChangeGuiPosition(25);
        }
    }
}