namespace MapEditor
{
    using System;
    using System.Collections.Generic;
    using System.IO;
    using System.Linq;
    using System.Windows.Forms;
    using Newtonsoft.Json;

    public partial class PropertiesForm : Form
    {
        private ActorProperties selectedActor;

        public PropertiesForm()
        {
            this.InitializeComponent();
            this.pnlDynProperties.Visible = false;
            foreach (var bullet in Enum.GetValues(typeof(Weapon)))
            {
                this.ddlPrimaryWeapon.Items.Add(bullet);
                this.ddlSecondaryWeapon.Items.Add(bullet);
            }

            foreach (var actor in MapEditor.Actors.DynamicActors)
            {
                this.listEnemies.Items.Add(new ListViewItem(actor.Key));
            }

            foreach (var actor in MapEditor.Actors.StaticActors)
            {
                this.listLevels.Items.Add(new ListViewItem(actor.Key));
            }
        }

        public void FillActorProperties()
        {
            this.pnlDynProperties.Visible = false;
            this.txtName.Text = this.selectedActor.Name;
            this.scaleUpDown.Text = this.selectedActor.Scale.ToString();
            this.widthUpDown.Text = this.selectedActor.Width.ToString();
            this.heightUpDown.Text = this.selectedActor.Height.ToString();

            this.listPolygons.Items.Clear();
            if (this.selectedActor.Polygons != null)
            {
                foreach (var polygon in this.selectedActor.Polygons)
                {
                    this.listPolygons.Items.Add(new ListViewItem(new[] { polygon.X.ToString(), polygon.Y.ToString() }));
                }
            }

            if (this.selectedActor is DynamicActor)
            {
                this.pnlDynProperties.Visible = true;
                var dynActor = (DynamicActor)this.selectedActor;

                this.speedUpDown.Text = dynActor.Speed.ToString();
                this.healthUpDown.Text = dynActor.Health.ToString();
                this.ddlPrimaryWeapon.SelectedItem = dynActor.PrimaryWeapon;
                this.ddlSecondaryWeapon.SelectedItem = dynActor.SecondaryWeapon;
                if (dynActor.Animations != null)
                {
                    foreach (var animation in dynActor.Animations)
                    {
                        this.listAnimations.Items.Add(new ListViewItem(new[] { animation.Key.ToString(), animation.Value.ToString() }));
                    }
                }
            }
        }

        public void ClearActorProperties()
        {
            this.pnlDynProperties.Visible = false;
            this.txtName.Text = string.Empty;
            this.scaleUpDown.Text = "0";
            this.widthUpDown.Text = "0";
            this.heightUpDown.Text = "0";
            this.listPolygons.Items.Clear();
            this.speedUpDown.Text = "0";
            this.healthUpDown.Text = "0";
            this.ddlPrimaryWeapon.SelectedItem = null;
            this.ddlSecondaryWeapon.SelectedItem = null;
            this.listAnimations.Items.Clear();
        }

        public void BtnSave(object sender, EventArgs e)
        {
            string lines = JsonConvert.SerializeObject(MapEditor.Actors);
            using (var f = new FileStream("actors.dat", FileMode.Create, FileAccess.ReadWrite))
            {
                using (var s = new StreamWriter(f))
                {
                    s.WriteLine(lines);
                }
            }
        }

        #region Enemy
        private void BtnAddEnemyClick(object sender, EventArgs e)
        {
            var dialog = new AddActorDialog();
            if (dialog.ShowDialog() == DialogResult.OK)
            {
                string name = dialog.GetName();
                MapEditor.Actors.DynamicActors.Add(name, new DynamicActor { Name = name });
                var item = new ListViewItem(name);
                this.listEnemies.Items.Add(item);
                item.Selected = true;
            }
        }

        private void BtnRemoveEnemyClick(object sender, EventArgs e)
        {
            if (this.listEnemies.SelectedItems.Count == 1)
            {
                MapEditor.Actors.DynamicActors.Remove(this.listEnemies.SelectedItems[0].Text);
                this.listEnemies.Items.Remove(this.listEnemies.SelectedItems[0]);
                this.selectedActor = null;
                this.ClearActorProperties();
            }
        }
        #endregion Enemy

        #region Level
        private void BtnAddLevelClick(object sender, EventArgs e)
        {
            var dialog = new AddActorDialog();
            if (dialog.ShowDialog() == DialogResult.OK)
            {
                string name = dialog.GetName();
                MapEditor.Actors.StaticActors.Add(name, new StaticActor { Name = name });
                var item = new ListViewItem(name);
                this.listLevels.Items.Add(item);
                item.Selected = true;
            }
        }

        private void BtnRemoveLevelClick(object sender, EventArgs e)
        {
            if (this.listLevels.SelectedItems.Count == 1)
            {
                MapEditor.Actors.StaticActors.Remove(this.listLevels.SelectedItems[0].Text);
                this.listLevels.Items.Remove(this.listLevels.SelectedItems[0]);
                this.selectedActor = null;
                this.ClearActorProperties();
            }
        }
        #endregion Level

        #region Polygon
        private void BtnAddPolygonClick(object sender, EventArgs e)
        {
            if (this.selectedActor != null)
            {
                var dialog = new AddPolygonDialog();
                if (dialog.ShowDialog() == DialogResult.OK)
                {
                    float x = dialog.GetXCoord();
                    float y = dialog.GetYCoord();
                    if (this.selectedActor.Polygons == null)
                    {
                        this.selectedActor.Polygons = new List<Polygon>();
                    }

                    this.selectedActor.Polygons.Add(new Polygon { X = x, Y = y });
                    this.listPolygons.Items.Add(new ListViewItem(new[] { x.ToString(), y.ToString() }));
                }
            }
        }

        // TODO: Test deze!
        private void BtnRemovePolygonClick(object sender, EventArgs e)
        {
            if (this.listPolygons.SelectedItems.Count == 1)
            {
                this.selectedActor.Polygons.RemoveAt(this.listPolygons.SelectedIndices[0]);
                /*this.selectedActor.Polygons.Remove(this.selectedActor.Polygons.FirstOrDefault(x => 
                    (x.X == Convert.ToSingle(this.listPolygons.SelectedItems[0].SubItems[0].Text)
                    && (x.Y == Convert.ToSingle(this.listPolygons.SelectedItems[0].SubItems[1].Text)))));*/
                this.listPolygons.Items.Remove(this.listPolygons.SelectedItems[0]);
            }
        }
        #endregion

        #region Animation
        private void BtnAddAnimationClick(object sender, EventArgs e)
        {
            if (this.selectedActor != null)
            {
                var dynActor = (DynamicActor)this.selectedActor;
                var animations = Enum.GetValues(typeof(Animation)).Cast<Animation>().ToList();
                if (dynActor.Animations != null)
                {
                    foreach (var animation in dynActor.Animations)
                    {
                        animations.Remove(animation.Key);
                    }
                }

                if (animations.Count > 0)
                {
                    var dialog = new AddAnimationDialog(animations);
                    if (dialog.ShowDialog() == DialogResult.OK)
                    {
                        Animation animation = dialog.GetAnimation();
                        int length = dialog.GetLength();
                        if (dynActor.Animations == null)
                        {
                            dynActor.Animations = new Dictionary<Animation, int>();
                        }

                        dynActor.Animations.Add(animation, length);
                        this.selectedActor = dynActor;
                        this.listAnimations.Items.Add(new ListViewItem(new[] { animation.ToString(), length.ToString() }));
                    }
                }
            }
        }

        private void BtnRemoveAnimationClick(object sender, EventArgs e)
        {
            if (this.listAnimations.SelectedItems.Count == 1)
            {
                MapEditor.Actors.StaticActors.Remove(this.listLevels.SelectedItems[0].Text);
                Animation result;
                if (Enum.TryParse(this.listAnimations.SelectedItems[0].Text, out result))
                {
                    ((DynamicActor)this.selectedActor).Animations.Remove(result);
                }
                
                this.listAnimations.Items.Remove(this.listAnimations.SelectedItems[0]);
            }
        }
        #endregion Animation

        #region Events
        private void ListEnemiesSelectedIndexChanged(object sender, EventArgs e)
        {
            if (this.listEnemies.SelectedItems.Count == 1)
            {
                this.selectedActor = MapEditor.Actors.DynamicActors[this.listEnemies.SelectedItems[0].Text];
                this.FillActorProperties();
            }
            else
            {
                this.selectedActor = null;
                this.ClearActorProperties();
            }
        }

        private void ListLevelsSelectedIndexChanged(object sender, EventArgs e)
        {
            if (this.listLevels.SelectedItems.Count == 1)
            {
                this.selectedActor = MapEditor.Actors.StaticActors[this.listLevels.SelectedItems[0].Text];
                this.FillActorProperties();
            }
            else
            {
                this.selectedActor = null;
                this.ClearActorProperties();
            }
        }

        private void TxtNameTextChanged(object sender, EventArgs e)
        {
            if (this.selectedActor != null)
            {
                this.selectedActor.Name = this.txtName.Text;
            }
        }

        private void ScaleUpDownValueChanged(object sender, EventArgs e)
        {
            if (this.selectedActor != null)
            {
                this.selectedActor.Scale = Convert.ToSingle(this.scaleUpDown.Value);
            }
        }

        private void WidthUpDownValueChanged(object sender, EventArgs e)
        {
            if (this.selectedActor != null)
            {
                this.selectedActor.Width = Convert.ToSingle(this.widthUpDown.Value);
            }
        }

        private void HeightUpDownValueChanged(object sender, EventArgs e)
        {
            if (this.selectedActor != null)
            {
                this.selectedActor.Height = Convert.ToSingle(this.heightUpDown.Value);
            }
        }

        private void SpeedUpDownValueChanged(object sender, EventArgs e)
        {
            if (this.selectedActor is DynamicActor)
            {
                ((DynamicActor)this.selectedActor).Speed = Convert.ToSingle(this.speedUpDown.Value);
            }
        }

        private void HealthUpDownValueChanged(object sender, EventArgs e)
        {
            if (this.selectedActor is DynamicActor)
            {
                ((DynamicActor)this.selectedActor).Health = Convert.ToSingle(this.healthUpDown.Value);
            }
        }

        private void DdlPrimaryWeaponSelectedIndexChanged(object sender, EventArgs e)
        {
            if (this.selectedActor is DynamicActor)
            {
                ((DynamicActor)this.selectedActor).PrimaryWeapon = (Weapon)this.ddlPrimaryWeapon.SelectedItem;
            }
        }

        private void DdlSecondaryWeaponSelectedIndexChanged(object sender, EventArgs e)
        {
            if (this.selectedActor is DynamicActor)
            {
                ((DynamicActor)this.selectedActor).SecondaryWeapon = (Weapon)this.ddlSecondaryWeapon.SelectedItem;
            }
        }
        #endregion Events
    }
}
