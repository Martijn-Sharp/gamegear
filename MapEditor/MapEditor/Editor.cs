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

        public long getX()
        {
            return xCoord;
        }

        public long getY()
        {
            return yCoord;
        }
    }
}
