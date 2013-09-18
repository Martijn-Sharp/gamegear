namespace MapEditor
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel;
    using System.Data;
    using System.Drawing;
    using System.IO;
    using System.Linq;
    using System.Text;
    using System.Threading.Tasks;
    using System.Windows.Forms;
    using Newtonsoft.Json;

    public partial class ActorEditor : Form
    {
        private Actor selectedActor;

        public ActorEditor()
        {
            this.InitializeComponent();
            foreach (var actor in MapEditor.actors.dynamicActors)
            {
                this.listEnemies.Items.Add(new ListViewItem(actor.Key));
            }

            foreach (var actor in MapEditor.actors.staticActors)
            {
                this.listLevels.Items.Add(new ListViewItem(actor.Key));
            }
        }

        public void FillProperties()
        {
            this.txtName.Text = this.selectedActor.name;
            this.txtScale.Text = this.selectedActor.scale.ToString();
            this.txtWidth.Text = this.selectedActor.width.ToString();
            this.txtHeight.Text = this.selectedActor.height.ToString();

            this.listPolygons.Clear();
            foreach (var polygon in this.selectedActor.polygons)
            {
                this.listPolygons.Items.Add(new ListViewItem(string.Format("X = {0} , Y = {1}", polygon.Key, polygon.Value)));
            }

            if (this.selectedActor is DynamicActor)
            {
                DynamicActor dynActor = (DynamicActor)this.selectedActor;
                /*
                 * Komt nog
                */
            }
        }

        public void SaveActors(object sender, EventArgs e)
        {
            MapEditor.actors.lastUpdated = DateTime.Now;
            string lines = JsonConvert.SerializeObject(MapEditor.actors);
            using (var f = new FileStream("actors.dat", FileMode.Create, FileAccess.ReadWrite))
            {
                using (var s = new StreamWriter(f))
                {
                    s.WriteLine(lines);
                }
            }
        }

        private void BtnAddEnemyClick(object sender, EventArgs e)
        {
            var dialog = new AddActorForm();
            if (dialog.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                string name = dialog.GetName();
                MapEditor.actors.dynamicActors.Add(name, new DynamicActor() { name = name });
                this.listEnemies.Items.Add(new ListViewItem(name));
            }
        }

        private void BtnAddLevelClick(object sender, EventArgs e)
        {

        }
    }
}
