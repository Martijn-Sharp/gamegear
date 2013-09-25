namespace MapEditor
{
    using System;
    using System.Collections.Generic;
    using System.Drawing;
    using System.IO;
    using System.Windows.Forms;
    using Newtonsoft.Json;

    public partial class MapEditor : Form
    {
        private Dictionary<string, Node> map;
        private Dictionary<string, Bitmap> images;
        private CategoryEnum categorySelected = CategoryEnum.Default;

        private string actorSelected;
        private int xButtonCount = 10;
        private int yButtonCount = 100;
        private int buttonWidth = 30;
        private int buttonHeight = 30;
        private int distance = 10;
        private int startX = 0;
        private int startY = 0;

        public MapEditor()
        {
            this.map = new Dictionary<string, Node>();
            this.images = new Dictionary<string, Bitmap>();
            this.InitializeComponent();
            this.BuildGui(BuildOptions.Build);
            this.PopulateLists();
            this.lblSelectedType.Text = "Default";
        }

        private enum CategoryEnum
        {
            Default = 0,
            Enemy = 1,
            Level = 2,
        }

        private enum BuildOptions
        {
            Clear,
            Build,
            Import,
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
            int[] coords = GetCoordsFromString(clickedButton.Name);

            string tmpName = clickedButton.Name;

            // Check if tile exists
            if (!this.map.ContainsKey(tmpName))
            {
                switch (this.categorySelected)
                {
                    case CategoryEnum.Enemy:
                        this.map.Add(tmpName, new Node(coords[1], 9 - coords[0]) { Name = this.actorSelected, Type = Node.NodeType.Spawner});
                        clickedButton.BackgroundImage = this.GetImage(this.actorSelected, CategoryEnum.Enemy);
                        break;
                    case CategoryEnum.Level:
                        this.map.Add(tmpName, new Node(coords[1], 9 - coords[0]) { Name = this.actorSelected, Type = Node.NodeType.Tile });
                        clickedButton.BackgroundImage = this.GetImage(this.actorSelected, CategoryEnum.Level);
                        break;
                    case CategoryEnum.Default:
                        clickedButton.BackgroundImage = this.GetImage("default");
                        break;
                }
            }
            else
            {
                this.map.Remove(tmpName);
                clickedButton.BackgroundImage = this.GetImage("default");
            }
        }

        private void CurrentButtonMouseHover(object sender, EventArgs e)
        {
            try
            {
                Node node = this.map[((Control)sender).Name];
                this.lblButtonX.Text = "X = " + node.X;
                this.lblButtonY.Text = "Y = " + node.Y;
                this.lblButtonValue.Text = "Name = " + node.Name;
            }
            catch (KeyNotFoundException)
            {
                var coords = GetCoordsFromString(((Control)sender).Name);
                this.lblButtonX.Text = "X = " + coords[1];
                this.lblButtonY.Text = "Y = " + (9 - coords[0]);
                this.lblButtonValue.Text = "Name = ";
            }
        }

        private void BuildGui(BuildOptions options)
        {
            switch (options)
            {
                case BuildOptions.Build:
                    for (int x = 0; x < this.xButtonCount; x++)
                    {
                        for (int y = 0; y < this.yButtonCount; y++)
                        {
                            var tmpButton = new Panel
                            {
                                Top = this.startX + (x * this.buttonHeight) + this.distance,
                                Left = this.startY + (y * this.buttonWidth) + this.distance,
                                Width = this.buttonWidth,
                                Height = this.buttonHeight,
                                Name = x + "," + y,
                                BackgroundImage = this.GetImage("default"),
                                BackColor = Color.Transparent
                            };

                            tmpButton.MouseHover += this.CurrentButtonMouseHover;
                            tmpButton.Click += this.ChangeTileClick;
                            this.mapPanel.Controls.Add(tmpButton);
                        }
                    }

                    break;
                case BuildOptions.Clear:
                    foreach (KeyValuePair<string, Node> a in this.map)
                    {
                        Control fillButton = this.mapPanel.Controls.Find(a.Key, false)[0];
                        fillButton.BackgroundImage = this.GetImage("default");
                    }

                    this.map.Clear();
                    break;
                case BuildOptions.Import:
                    foreach (KeyValuePair<string, Node> a in this.map)
                    {
                        // Restore imported map here
                        Control fillButton = this.mapPanel.Controls.Find(a.Key, false)[0];
                        if (a.Value.Type == Node.NodeType.Spawner)
                        {
                            fillButton.BackgroundImage = this.GetImage("spawner", CategoryEnum.Enemy);
                        }
                        else if (a.Value.Type == Node.NodeType.Tile)
                        {
                            fillButton.BackgroundImage = this.GetImage(a.Value.Name, CategoryEnum.Level);
                        }
                    }

                    break;
            }
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
                foreach (var enemy in LevelProps.Enemies)
                {
                    this.map.Add(9 - enemy.Y + "," + enemy.X, enemy);
                }

                foreach (var tile in LevelProps.Tiles)
                {
                    this.map.Add(9 - tile.Y + "," + tile.X, tile);
                }

                this.BuildGui(BuildOptions.Import);
            }
        }

        private void ExportClick(object sender, EventArgs e)
        {
            LevelProps.Enemies = new List<Node>();
            LevelProps.Tiles = new List<Node>();

            foreach (KeyValuePair<string, Node> a in this.map)
            {
                if (a.Value.Type == Node.NodeType.Spawner)
                {
                    LevelProps.Enemies.Add(a.Value);
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
                this.categorySelected = CategoryEnum.Enemy;
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
                case CategoryEnum.Enemy:
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
    }
}