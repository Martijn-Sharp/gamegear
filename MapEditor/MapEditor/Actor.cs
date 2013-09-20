namespace MapEditor
{
    using System;
    using System.Collections.Generic;

    public enum Animation
    {
        Left,
        Up, 
        Down
    }

    public enum Weapon
    {
        None = 0,
        FodderGun = 1,
        MissileLauncher = 2,
        EnergyballGun = 3
    }

    public class ActorFile
    {
        public DateTime LastUpdated { get; set; }

        public Dictionary<string, DynamicActor> DynamicActors { get; set; }

        public Dictionary<string, StaticActor> StaticActors { get; set; }
    }

    public class Actor
    {
        public string Name { get; set; }

        public float Scale { get; set; }

        public float Width { get; set; }

        public float Height { get; set; }

        public List<Polygon> Polygons { get; set; }
    }

    public class DynamicActor : Actor
    {
        public float Speed { get; set; }

        public float Health { get; set; }

        public Weapon PrimaryWeapon { get; set; }

        public Weapon SecondaryWeapon { get; set; }

        public Dictionary<Animation, int> Animations { get; set; }
    }

    public class StaticActor : Actor
    {
    }

    public class Polygon
    {
        public float X { get; set; }

        public float Y { get; set; }
    }
}