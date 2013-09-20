﻿namespace MapEditor
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
        private Dictionary<CategoryEnum, Bitmap> images;
        private CategoryEnum categorySelected = CategoryEnum.Enemy;

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
            this.InitializeComponent();
            this.LoadImages();
            this.BuildGui(BuildOptions.Build);
            this.PopulateLists();
            this.lblSelectedType.Text = "Enemy";
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
            Import
        }

        public static ActorFile Actors { get; set; }

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

        private void LoadImages()
        {
            this.images = new Dictionary<CategoryEnum, Bitmap>
            {
                {
                    CategoryEnum.Default, new Bitmap("assets/images/default.png")
                },
                {
                    CategoryEnum.Enemy, new Bitmap("assets/images/enemy.png")
                },
                {
                    CategoryEnum.Level, new Bitmap("assets/images/level.png")
                }
            };
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
                clickedButton.BackgroundImage = this.images[this.categorySelected];
                switch (this.categorySelected)
                {
                    case CategoryEnum.Enemy:
                        this.map.Add(tmpName, new Enemy(coords[1], 9 - coords[0]) { name = this.actorSelected });
                        break;
                    case CategoryEnum.Level:
                        this.map.Add(tmpName, new Tile(coords[1], 9 - coords[0]) { name = this.actorSelected });
                        break;
                    default:
                        this.map.Add(tmpName, new Node(coords[1], 9 - coords[0]) { name = this.actorSelected });
                        break;
                }
            }
            else
            {
                this.map.Remove(tmpName);
                clickedButton.BackgroundImage = this.images[CategoryEnum.Default];
            }
        }

        private void CurrentButtonMouseHover(object sender, EventArgs e)
        {
            try
            {
                Node node = this.map[((Control)sender).Name];
                this.lblButtonX.Text = "X = " + node.xCoord;
                this.lblButtonY.Text = "Y = " + node.yCoord;
                this.lblButtonValue.Text = "Name = " + node.name;
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
                            var tmpButton = new Control
                            {
                                Top = this.startX + (x * this.buttonHeight) + this.distance,
                                Left = this.startY + (y * this.buttonWidth) + this.distance,
                                Width = this.buttonWidth,
                                Height = this.buttonHeight,
                                Name = x + "," + y,
                                BackgroundImage = this.images[CategoryEnum.Default]
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
                        fillButton.BackgroundImage = this.images[CategoryEnum.Default];
                    }

                    this.map.Clear();
                    break;
                case BuildOptions.Import:
                    foreach (KeyValuePair<string, Node> a in this.map)
                    {
                        // Restore imported map here
                        Control fillButton = this.mapPanel.Controls.Find(a.Key, false)[0];
                        /*if (a.Value is Tile)
                        {
                            fillButton.BackgroundImage = this.images[CategoryEnum.Damage];
                        }
                        else*/
                        if (a.Value is Enemy)
                        {
                            fillButton.BackgroundImage = this.images[CategoryEnum.Enemy];
                        }
                        else if (a.Value is Tile)
                        {
                            fillButton.BackgroundImage = this.images[CategoryEnum.Level];
                        }
                        /*else if (a.Value.special)
                        {
                            fillButton.BackgroundImage = this.images[CategoryEnum.Special];
                        }*/
                    }

                    break;
            }
        }

        public void PopulateLists()
        {
            this.listEnemies.Items.Clear();
            foreach (var enemy in Actors.DynamicActors)
            {
                this.listEnemies.Items.Add(new ListViewItem(enemy.Key));
            }

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
                var level = JsonConvert.DeserializeObject<Level>(lines);
                foreach (var enemy in level.enemies)
                {
                    this.map.Add(9 - enemy.yCoord + "," + enemy.xCoord, enemy);
                }

                foreach (var tile in level.tiles)
                {
                    this.map.Add(9 - tile.yCoord + "," + tile.xCoord, tile);
                }

                this.BuildGui(BuildOptions.Import);
            }
        }

        private void ExportClick(object sender, EventArgs e)
        {
            var level = new Level { enemies = new List<Enemy>(), tiles = new List<Tile>() };

            foreach (KeyValuePair<string, Node> a in this.map)
            {
                if (a.Value is Enemy)
                {
                    level.enemies.Add((Enemy)a.Value);
                }
                else if (a.Value is Tile)
                {
                    level.tiles.Add((Tile)a.Value);
                }
            }

            // Convert map to JSON
            string lines = JsonConvert.SerializeObject(level);

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
            if (new PropertiesForm().ShowDialog() == DialogResult.OK)
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
    }
}