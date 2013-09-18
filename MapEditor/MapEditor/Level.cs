namespace MapEditor
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text;
    using System.Threading.Tasks;

    public class Level
    {
        // Spawnpoint
        public int spawnX, spawnY;

        public List<Tile> tiles;
        public List<Enemy> enemies;
    }

    public class Node
    {
        // Coordinates on local map
        public int xCoord, yCoord;

        // Properties
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
        public Tile(int x, int y)
            : base(x, y)
        {
        }
    }

    public class Enemy : Node
    {
        // Properties
        public bool boss;
        public int additionalHealth;
        public int type;

        public Enemy(int x, int y)
            : base(x, y)
        {
        }
    }

}