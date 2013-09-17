namespace MapEditor
{
    using System;
    using System.Collections.Generic;
    using System.Drawing;
    using System.IO;
    using System.Linq;
    using System.Windows.Forms;
    using Newtonsoft.Json;

    public partial class Editor : Form
    {
        private Dictionary<string, Node> map;
        private Dictionary<CategoryEnum, Bitmap> images; 
        private CategoryEnum categorySelected = CategoryEnum.Damage;

        private int typeSelected = -1;
        private int xButtonCount = 10;
        private int yButtonCount = 100;
        private int buttonWidth = 30;
        private int buttonHeight = 30;
        private int distance = 10;
        private int startX = 0;
        private int startY = 0;

        public Editor()
        {
            this.map = new Dictionary<string, Node>();
            this.InitializeComponent();
            this.LoadImages();
            this.BuildGui(BuildOptions.Build);

            /*for (int x = 0; x < this.xButtonCount; x++)
            {
                for (int y = 0; y < this.yButtonCount; y++)
                {
                    var tmpButton = new Control
                    {
                        Top = startX + (x * buttonHeight) + distance,
                        Left = startY + (y * buttonWidth) + distance,
                        Width = buttonWidth,
                        Height = buttonHeight,
                        Name = x + "," + y,
                        Text = string.Empty,
                        BackColor = Color.AliceBlue,
                        BackgroundImage = this.images[CategoryEnum.Default]
                    };

                    tmpButton.MouseHover += this.CurrentButtonMouseHover;
                    tmpButton.Click += this.ChangeTileClick;
                    this.mapPanel.Controls.Add(tmpButton);
                }
            }*/
        }

        private enum CategoryEnum
        {
            Default = 0,
            Damage = 1,
            Enemy = 2,
            Level = 3,
            Special = 4,
        }

        private enum BuildOptions
        {
            Clear,
            Build,
            Import
        }

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
                    CategoryEnum.Damage, new Bitmap("assets/images/damage.png")
                },
                {
                    CategoryEnum.Enemy, new Bitmap("assets/images/enemy.png")
                },
                {
                    CategoryEnum.Level, new Bitmap("assets/images/level.png")
                },
                {
                    CategoryEnum.Special, new Bitmap("assets/images/special.png")
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
                    //case CategoryEnum.Damage:
                    //    this.map[tmpName].damage = true;
                    //    break;
                    case CategoryEnum.Enemy:
                        this.map.Add(tmpName, new Enemy(coords[1], 9 - coords[0]));
                        break;
                    case CategoryEnum.Level:
                        this.map.Add(tmpName, new Tile(coords[1], 9 - coords[0]));
                        break;
                    default:
                        this.map.Add(tmpName, new Node(coords[1], 9 - coords[0]));
                        break;
                    //case CategoryEnum.Special:
                    //    this.map[tmpName].special = true;
                    //    break;
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
                Node tile = this.map[((Control)sender).Name];
                this.lblButtonX.Text = "x = " + tile.xCoord;
                this.lblButtonY.Text = "y = " + tile.yCoord;
                //this.lblButtonValue.Text = "Type = " + tile.type;
            }
            catch (KeyNotFoundException)
            {
                var coords = GetCoordsFromString(((Control)sender).Name);
                this.lblButtonX.Text = "x = " + coords[1];
                this.lblButtonY.Text = "y = " + (9 - coords[0]);
                this.lblButtonValue.Text = "Type = Empty";
            }
        }

        private void TabPickerIndexChanged(object sender, EventArgs e)
        {
            this.lblSelectedType.Text = this.tabPicker.SelectedTab.Name;
            switch (this.tabPicker.SelectedTab.Name)
            {
                case "Damage":
                    this.categorySelected = CategoryEnum.Damage;
                    break;
                case "Enemy":
                    this.categorySelected = CategoryEnum.Enemy;
                    break;
                case "Level":
                    this.categorySelected = CategoryEnum.Level;
                    break;
                case "Special":
                    this.categorySelected = CategoryEnum.Special;
                    break;
            }
        }

        private void ExportButtonClick(object sender, EventArgs e)
        {
            Level level = new MapEditor.Level();
            level.enemies = new List<Enemy>();
            level.tiles = new List<Tile>();

            foreach (KeyValuePair<string, Node> a in map)
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
                using (FileStream f = new FileStream(saveFileDialog1.FileName, FileMode.Create, FileAccess.ReadWrite))
                {
                    using (StreamWriter s = new StreamWriter(f))
                    {
                        s.WriteLine(lines);
                    }
                }
            }
        }

        private void ImportButtonClick(object sender, EventArgs e)
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


                using (FileStream f = new FileStream(openFileDialog1.FileName, FileMode.OpenOrCreate, FileAccess.ReadWrite))
                {
                    using (StreamReader s = new StreamReader(f))
                        lines = s.ReadToEnd();
                }

                this.BuildGui(BuildOptions.Clear);
                Level level = JsonConvert.DeserializeObject<Level>(lines);
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
                        //if (a.Value is Tile)
                        //{
                        //    fillButton.BackgroundImage = this.images[CategoryEnum.Damage];
                        //}
                        //else 
                        if (a.Value is Enemy)
                        {
                            fillButton.BackgroundImage = this.images[CategoryEnum.Enemy];
                        }
                        else if (a.Value is Tile)
                        {
                            fillButton.BackgroundImage = this.images[CategoryEnum.Level];
                        }
                        //else if (a.Value.special)
                        //{
                        //    fillButton.BackgroundImage = this.images[CategoryEnum.Special];
                        //}
                    }

                    break;
            }
        }

        private void ClearButtonClick(object sender, EventArgs e)
        {
            if (MessageBox.Show("Clear map?", "Confirm delete", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                // Clear map
                this.BuildGui(BuildOptions.Clear);
            }
        }

        private void IntOnlyKeyPress(object sender, KeyPressEventArgs e)
        {
            // This does NOT guarantee safe output, but atleast prevents the accidental mistake

            // Filter all but numeric characters
            if (!char.IsControl(e.KeyChar)
                && !char.IsDigit(e.KeyChar))
            {
                e.Handled = true;
            }

            // Prevent too big numbers
            if (((TextBox)sender).Text.Count() > 9)
            {
                e.Handled = true;
            }

            // For non integer numbers
            /*if (!char.IsControl(e.KeyChar)
                && !char.IsDigit(e.KeyChar)
                && e.KeyChar != '.')
            {
                e.Handled = true;
            }

            if (e.KeyChar == '.'
                && (sender as TextBox).Text.IndexOf('.') > -1)
            {
                e.Handled = true;
            }*/
        }
    }

    public class Level
    {
        //Spawnpoint
        public int spawnX, spawnY;

        public List<Tile> tiles;
        public List<Enemy> enemies;
    }

    public class Node
    {
        //Coordinates on local map
        public int xCoord, yCoord;

        //Properties
        public int id;
        public string name;
        public int animationLength;
        
        public Node(int x, int y)
        {
            this.xCoord = x;
            this.yCoord = y;
        }
    }

    public class Tile : Node
    {
        public Tile(int x, int y): base(x, y)
        {
        }
    }

    public class Enemy : Node
    {
        //Properties
        public bool boss;
        public int additionalHealth;
        public int type;

        public Enemy(int x, int y) : base(x,y)
        {
        }
    }

}
