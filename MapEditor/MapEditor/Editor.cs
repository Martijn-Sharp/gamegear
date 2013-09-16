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
        private Dictionary<string, Tile> map;
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
            this.map = new Dictionary<string, Tile>();
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
                this.map.Add(tmpName, new Tile(coords[1], 9 - coords[0]));
                clickedButton.BackgroundImage = this.images[this.categorySelected];
                switch (this.categorySelected)
                {
                    case CategoryEnum.Damage: 
                        this.map[tmpName].damage = true;
                        break;
                    case CategoryEnum.Enemy: 
                        this.map[tmpName].enemy = true;
                        break;
                    case CategoryEnum.Level: 
                        this.map[tmpName].level = true;
                        break;
                    case CategoryEnum.Special: 
                        this.map[tmpName].special = true;
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
                Tile tile = this.map[((Control)sender).Name];
                this.lblButtonX.Text = "x = " + tile.xCoord;
                this.lblButtonY.Text = "y = " + tile.yCoord;
                this.lblButtonValue.Text = "Type = " + tile.type;
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
            // Convert map to JSON
            string lines = JsonConvert.SerializeObject(this.map);

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
                using (var sw = new StreamWriter(saveFileDialog1.FileName))
                {
                    sw.WriteLine(lines);
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
                // Assign the cursor in the Stream to the Form's Cursor property.
                openFileDialog1.OpenFile();
                var file = new StreamReader(openFileDialog1.FileName);

                // Read the file as one string.
                // System.IO.StreamReader file = new System.IO.StreamReader("d:\\map.dat");
                string lines = file.ReadToEnd();
                file.Close();

                this.BuildGui(BuildOptions.Clear);
                this.map = JsonConvert.DeserializeObject<Dictionary<string, Tile>>(lines);
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
                    foreach (KeyValuePair<string, Tile> a in this.map)
                    {
                        Control fillButton = this.mapPanel.Controls.Find(a.Key, false)[0];
                        fillButton.BackgroundImage = this.images[CategoryEnum.Default];
                    }

                    this.map.Clear();
                    break;
                case BuildOptions.Import:
                    foreach (KeyValuePair<string, Tile> a in this.map)
                    {
                        // Restore imported map here
                        Control fillButton = this.mapPanel.Controls.Find(a.Key, false)[0];
                        fillButton.Text = Convert.ToString(this.map[a.Key].damage);
                        if (a.Value.damage)
                        {
                            fillButton.BackgroundImage = this.images[CategoryEnum.Damage];
                        }
                        else if (a.Value.enemy)
                        {
                            fillButton.BackgroundImage = this.images[CategoryEnum.Enemy];
                        }
                        else if (a.Value.level)
                        {
                            fillButton.BackgroundImage = this.images[CategoryEnum.Level];
                        }
                        else if (a.Value.special)
                        {
                            fillButton.BackgroundImage = this.images[CategoryEnum.Special];
                        }
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

    public class Tile
    {
        //Coordinates on local map
        public int xCoord, yCoord;

        //Properties
        public bool damage, enemy, level, special;

        public int type;
        
        public Tile(int x, int y)
        {
            this.xCoord = x;
            this.yCoord = y;
        }
    }
}
