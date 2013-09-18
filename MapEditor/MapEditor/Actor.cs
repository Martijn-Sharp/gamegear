namespace MapEditor
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text;
    using System.Threading.Tasks;

    public enum Animation
    {
        Left, 
        Up, 
        Down
    }

    public class ActorFile
    {
        public DateTime lastUpdated;
        public Dictionary<string, DynamicActor> dynamicActors;
        public Dictionary<string, StaticActor> staticActors;
    }

    public class Actor
    {
        public string name;
        public float scale;
        public float width;
        public float height;
        public Dictionary<float, float> polygons;
    }

    public class DynamicActor : Actor
    {
        public enum Bullet
        {
            None,
            Fodder, 
            Missile, 
            Energyball
        }

        public float speed;
        public float health;
        public Bullet primaryWeapon;
        public Bullet secondaryWeapon;
        public Dictionary<Animation, int> Animations;
    }

    public class StaticActor : Actor
    {
    }
}
