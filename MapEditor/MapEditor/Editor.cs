using Newtonsoft.Json;
using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MapEditor
{
    public partial class Editor : Form
    {
        Dictionary<String, Tile> map;
        ToolTip toolTip = new ToolTip();
        Panel mapPanel;

        int propertySelected = -1;

        int xButtonCount = 10;
        int yButtonCount = 100;

        public Editor()
        {
            int ButtonWidth = 30;
            int ButtonHeight = 30;
            int Distance = 10;
            int start_x = 0;
            int start_y = 0;
            Button tmpButton;
            map = new Dictionary<string, Tile>();

            mapPanel = new Panel();
            mapPanel.Location = new System.Drawing.Point(13, 81);
            mapPanel.Width = 760;
            mapPanel.Height = 350;
            mapPanel.AutoScroll = true;
            mapPanel.Name = "Map";
            mapPanel.TabIndex = 0;

            for (int x = 0; x < xButtonCount; x++)
            {
                for (int y = 0; y < yButtonCount; y++)
                {
                    tmpButton = new Button();
                    tmpButton.Top = start_x + (x * ButtonHeight + Distance);
                    tmpButton.Left = start_y + (y * ButtonWidth + Distance);
                    tmpButton.Width = ButtonWidth;
                    tmpButton.Height = ButtonHeight;
                    tmpButton.Name = x.ToString() + "," + y.ToString();
                    tmpButton.Text = "";
                    tmpButton.MouseHover += currentButton_MouseHover;
                    tmpButton.BackColor = Color.Empty;
                    tmpButton.Click += new EventHandler(this.ChangeTile_Click);
                    mapPanel.Controls.Add(tmpButton);
                }
            }
            this.Controls.Add(mapPanel);
            InitializeComponent();
        }

        public static int[] getCoordsFromString(string coordinates)
        {
            string[] coords = coordinates.Split(',');
            int[] temp = new int[2];
            for (int i = 0; i < 2; i++)
            {
                Convert.ToInt32(coords[i]);
            }
            return temp;
        }

        void ChangeTile_Click(Object sender, EventArgs e)
        {
            // When the button is clicked,
            // change the button text, and disable it.

            Button clickedButton = (Button)sender;
            int[] coords = getCoordsFromString(clickedButton.Name);

            string tmpName = clickedButton.Name;

            //Check if tile exists
            if (!map.ContainsKey(tmpName))
            {
                map.Add(tmpName, new Tile(coords[0], coords[1]));
                switch(propertySelected)
                {
                    case (int)RadioEnum.Damage: map[tmpName].damage = true;
                        clickedButton.BackColor = Color.Red;
                        clickedButton.Text = "D";
                        if (damageBox.Text != "") map[tmpName].type = Convert.ToInt32(damageBox.Text);
                        break;
                    case (int)RadioEnum.Enemy: map[tmpName].enemy = true;
                        clickedButton.BackColor = Color.Blue;
                        clickedButton.Text = "E";
                        if (enemyBox.Text != "") map[tmpName].type = Convert.ToInt32(enemyBox.Text);
                        break;
                    case (int)RadioEnum.Level: map[tmpName].level = true;
                        clickedButton.BackColor = Color.Brown;
                        clickedButton.Text = "L";
                        if (levelBox.Text != "") map[tmpName].type = Convert.ToInt32(levelBox.Text);
                        break;
                    case (int)RadioEnum.Special: map[tmpName].special = true;
                        clickedButton.BackColor = Color.Green;
                        clickedButton.Text = "S";
                        if (specialBox.Text != "") map[tmpName].type = Convert.ToInt32(specialBox.Text);
                        break;
                }
            }
            else
            {
                map.Remove(tmpName);
                clickedButton.BackColor = Color.Empty;
                clickedButton.Text = "";
            }
        }

        void currentButton_MouseHover(object sender, EventArgs e)
        {
            toolTip.RemoveAll();
            toolTip.ToolTipIcon = ToolTipIcon.None;

            toolTip.IsBalloon = false;
            toolTip.ShowAlways = false;

            try
            {
                toolTip.SetToolTip((Button)sender, "Value: " + map[((Button)sender).Name].type);
            }
            catch (Exception)
            {
                toolTip.SetToolTip((Button)sender, "Empty");
            }

        }

        private void radioButtons_CheckedChanged(object sender, EventArgs e)
        {
            RadioButton radioButton = sender as RadioButton;

            if (damageButton.Checked)
            {
                propertySelected = (int)RadioEnum.Damage;
            }
            else if (enemyButton.Checked)
            {
                propertySelected = (int)RadioEnum.Enemy;
            }
            else if (levelButton.Checked)
            {
                propertySelected = (int)RadioEnum.Level;
            }
            else if (specialButton.Checked)
            {
                propertySelected = (int)RadioEnum.Special;
            }
        }

        private void exportButton_Click(object sender, EventArgs e)
        {
            string lines = JsonConvert.SerializeObject(map);
            System.IO.StreamWriter file = new System.IO.StreamWriter("d:\\map.dat");
            file.WriteLine(lines);

            file.Close();
        }

        private void importButton_Click(object sender, EventArgs e)
        {
            // Read the file as one string.
            System.IO.StreamReader file = new System.IO.StreamReader("d:\\map.dat");
            string lines = file.ReadToEnd();
            file.Close();

            //map = (Dictionary<String, Tile>) JsonConvert.DeserializeObject(lines);
            map = JsonConvert.DeserializeObject<Dictionary<String, Tile>>(lines);
            rebuildGUI(true);
        }

        private void rebuildGUI(bool force)
        {
            Button tmpButton;
            //Clear all buttons
            for (int x = 0; force && x < xButtonCount; x++)
            {
                for (int y = 0; y < yButtonCount; y++)
                {
                    tmpButton = (Button) mapPanel.Controls.Find(x + "," + y, true)[0];
                    tmpButton.Text = "";
                    tmpButton.BackColor = Color.Empty;
                    //this.Controls.Add(tmpButton);
                }
            }

            foreach (KeyValuePair<string, Tile> a in map)
            {
                //Restore imported map here
                tmpButton = (Button)mapPanel.Controls.Find(a.Key, false)[0];
                tmpButton.Text = Convert.ToString(map[a.Key].damage);
                tmpButton.BackColor = Color.Aquamarine;
            }
        }

        private void clearButton_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("Clear map?", "Confirm delete", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                //Clear map
                map = new Dictionary<string, Tile>();
                rebuildGUI(true);
            }
        }

        private void intOnly_KeyPress(object sender, KeyPressEventArgs e)
        {
            //This does NOT guarantee safe output, but atleast prevents the accidental mistake

            //Filter all but numeric characters
            if (!char.IsControl(e.KeyChar)
                && !char.IsDigit(e.KeyChar))
            {
                e.Handled = true;
            }


            //Prevent too big numbers
            if (((TextBox)sender).Text.Count() > 9)
            {
                e.Handled = true;
            }

            //For floating numbers

            //if (!char.IsControl(e.KeyChar)
            //    && !char.IsDigit(e.KeyChar)
            //    && e.KeyChar != '.')
            //{
            //    e.Handled = true;
            //}

            //if (e.KeyChar == '.'
            //    && (sender as TextBox).Text.IndexOf('.') > -1)
            //{
            //    e.Handled = true;
            //}
        }
    }

    public class Tile
    {
        //Coordinates on local map
        private int xCoord, yCoord;

        //Properties
        public bool damage, enemy, level, special;

        public int type;
        
        public Tile(int x, int y)
        {
            this.xCoord = x;
            this.yCoord = y;
        }
    }

    public enum RadioEnum
    {
        Damage = 1,
        Enemy = 2,
        Level = 3,
        Special = 4,
    }
}
