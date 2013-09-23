namespace MapEditor
{
    using System.Collections.Generic;

    public class LevelProperties
    {
        public float FinishX { get; set; }

        public List<SpeedPoint> SpeedPoints { get; set; } 

        public float SpawnX { get; set; }

        public float SpawnY { get; set; }

        public List<Node> Tiles { get; set; }

        public List<Node> Enemies { get; set; }

        public string BackgroundName { get; set; }
    }

    public class SpeedPoint
    {
        public float X;

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