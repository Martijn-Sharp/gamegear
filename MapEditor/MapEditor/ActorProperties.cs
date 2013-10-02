namespace MapEditor
{
    using System.Collections.Generic;

    public enum Animation
    {
        Left,
        Up, 
        Down
    }

    public class ActorFile
    {
        public Dictionary<string, DynamicActor> DynamicActors { get; set; }

        public Dictionary<string, StaticActor> StaticActors { get; set; }
    }

    public class ActorProperties
    {
        public string Name { get; set; }

        public float Scale { get; set; }

        public float Width { get; set; }

        public float Height { get; set; }

        public List<Polygon> Polygons { get; set; }
    }

    public class DynamicActor : ActorProperties
    {
        public float Speed { get; set; }

        public float Health { get; set; }

        public Dictionary<Animation, int> Animations { get; set; }
    }

    public class StaticActor : ActorProperties
    {
        public bool Breakable { get; set; }
    }

    public class Polygon
    {
        public float X { get; set; }

        public float Y { get; set; }
    }
}