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
        public Editor()
        {
            int ButtonWidth = 70;
            int ButtonHeight = 70;
            int Distance = 20;
            int start_x = 70;
            int start_y = 0;
            Button tmpButton;
            map = new Dictionary<string, Tile>();

            for (int x = 0; x < 10; x++)
            {
                for (int y = 0; y < 20; y++)
                {
                    tmpButton = new Button();
                    tmpButton.Top = start_x + (x * ButtonHeight + Distance);
                    tmpButton.Left = start_y + (y * ButtonWidth + Distance);
                    tmpButton.Width = ButtonWidth;
                    tmpButton.Height = ButtonHeight;
                    tmpButton.Name = x.ToString() + "," + y.ToString();
                    tmpButton.Text = "";
                    tmpButton.Click += new EventHandler(this.ChangeTile_Click);
                    this.Controls.Add(tmpButton);
                }
            }
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

            //Check if tile exists
            if (!map.ContainsKey(clickedButton.Name))
            {
                map.Add(clickedButton.Name, new Tile(coords[0], coords[1]));
                map[clickedButton.Name].damage = true;
                clickedButton.BackColor = Color.Aquamarine;
            }
            else
            {
                if (map[clickedButton.Name].damage == true)
                {
                    map[clickedButton.Name].damage = false;
                }
                else
                {
                    map[clickedButton.Name].damage = true;
                }
            }
            
            clickedButton.Text = Convert.ToString(map[clickedButton.Name].damage);

        }

        private void button2_Click(object sender, EventArgs e)
        {
            //Console.WriteLine(DictionaryToJson(map));
            Console.WriteLine(JsonConvert.SerializeObject(map));

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
            rebuildGUI();
        }

        private void rebuildGUI()
        {
            Button tempButton;
            foreach(KeyValuePair<string, Tile> a in map)
            {
                //Restore imported map here
                tempButton = (Button) this.Controls.Find(a.Key, false)[0];
                tempButton.Text = Convert.ToString(map[a.Key].damage);
                tempButton.BackColor = Color.Aquamarine;
            }
        }
    }

    public class Tile
    {
        //Coordinates on local map
        private int xCoord, yCoord;

        //Properties
        public bool damage, enemy, level, special;
        
        public Tile(int x, int y)
        {
            this.xCoord = x;
            this.yCoord = y;
        }
    }
}
