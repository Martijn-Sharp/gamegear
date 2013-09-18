namespace MapEditor
{
    using System;
    using System.Collections.Generic;
    using System.IO;
    using System.Windows.Forms;
    using Newtonsoft.Json;

    public static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        public static void Main()
        {
            HandleActorFile(MapEditor.actors);
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new MapEditor());
        }

        public static void HandleActorFile(ActorFile actorFile)
        {
            string lines;
            using (var f = new FileStream("actors.dat", FileMode.OpenOrCreate, FileAccess.ReadWrite))
            {
                using (var s = new StreamReader(f))
                {
                    lines = s.ReadToEnd();
                }
            }

            if (lines != string.Empty)
            {
                actorFile = JsonConvert.DeserializeObject<ActorFile>(lines);
            }
            else
            {
                ActorFile file = new ActorFile()
                {
                    staticActors = new Dictionary<string, StaticActor>(),
                    dynamicActors = new Dictionary<string, DynamicActor>(),
                    lastUpdated = DateTime.Now
                };

                actorFile = file;
                string newLines = JsonConvert.SerializeObject(file);
                using (var f = new FileStream("actors.dat", FileMode.Create, FileAccess.ReadWrite))
                {
                    using (var s = new StreamWriter(f))
                    {
                        s.WriteLine(newLines);
                    }
                }
            }
        }
    }
}
