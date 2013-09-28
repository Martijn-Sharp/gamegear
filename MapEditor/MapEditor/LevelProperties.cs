namespace MapEditor
{
    using System.Collections.Generic;

    public class LevelProperties
    {
        public enum ColorEnum
        {
            Blue,
            Green,
            LightBlue,
            Orange,
            Purple,
            Red,
            Yellow
        }

        public float FinishX { get; set; }

        public float SpawnX { get; set; }

        public float SpawnY { get; set; }

        public string BackgroundName { get; set; }

        public List<SpeedPoint> SpeedPoints { get; set; } 

        public List<ColorEnum> Colors { get; set; } 

        public List<Node> Tiles { get; set; }

        public List<Spawner> Spawners { get; set; }
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
            Spawner,
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

    public class Spawner : Node
    {
        public List<LevelProperties.ColorEnum> SpawnColor { get; set; }

        public float SpawnedActorSpeed { get; set; }

        public bool Multiple { get; set; }

        public float SpawnInterval { get; set; }

        public Spawner(int x, int y) : base(x, y)
        {
        }
    }
}