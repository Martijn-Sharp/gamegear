namespace MapEditor
{
    using System.Collections.Generic;

    public class LevelProperties
    {
        public int FinishX { get; set; }

        public List<SpeedPoint> SpeedPoints { get; set; } 

        public int SpawnX { get; set; }
            
        public int SpawnY { get; set; }

        public List<Node> Tiles { get; set; }

        public List<Node> Enemies { get; set; }
    }

    public class SpeedPoint
    {
        public int X;

        public float Speed;
    }

    public class Node
    {
        public enum NodeType
        {
            Enemy,
            Tile
        }

        // Coordinates on local map
        public int X { get; set; }

        public int Y { get; set; }

        // Properties
        public int Id { get; set; }

        public string Name { get; set; }

        public NodeType Type { get; set; }

        public Node(int x, int y)
        {
            this.X = x;
            this.Y = y;
        }
    }
}