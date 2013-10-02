namespace MapEditor
{
    using System;
    using System.Collections.Generic;
    using System.Drawing;
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
            this.pnlStaticProperties.Visible = false;

            foreach (var actor in MapEditor.Actors.DynamicActors)
            {
                this.listEnemies.Items.Add(new ListViewItem(actor.Key));
            }

            foreach (var actor in MapEditor.Actors.StaticActors)
            {
                this.listLevels.Items.Add(new ListViewItem(actor.Key));
            }

            this.FillLevelProperties();
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
                if (dynActor.Animations != null)
                {
                    foreach (var animation in dynActor.Animations)
                    {
                        this.listAnimations.Items.Add(new ListViewItem(new[] { animation.Key.ToString(), animation.Value.ToString() }));
                    }
                }
            } 
            else if (this.selectedActor is StaticActor)
            {
                this.pnlStaticProperties.Visible = true;
                var statActor = (StaticActor)this.selectedActor;
                this.chkBreakable.Checked = statActor.Breakable;
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

        private void ChkBreakableCheckedChanged(object sender, EventArgs e)
        {
            if (this.selectedActor is StaticActor)
            {
                ((StaticActor)this.selectedActor).Breakable = this.chkBreakable.Checked;
            }
        }
        #endregion Events

        private void FillLevelProperties()
        {
            this.txtBackground.Text = MapEditor.LevelProps.BackgroundName;
            this.TxtBackgroundTextChanged(this, new EventArgs());
            this.spawnXUpDown.Text = MapEditor.LevelProps.SpawnX.ToString();
            this.spawnYUpDown.Text = MapEditor.LevelProps.SpawnY.ToString();
            this.finishXUpDown.Text = MapEditor.LevelProps.FinishX.ToString();
            if (MapEditor.LevelProps.SpeedPoints != null)
            {
                foreach (var speedPoint in MapEditor.LevelProps.SpeedPoints)
                {
                    this.listSpeedPoints.Items.Add(new ListViewItem(new[] { speedPoint.X.ToString(), speedPoint.Speed.ToString() }));
                }
            }

            if (MapEditor.LevelProps.Colors != null)
            {
                foreach (var color in MapEditor.LevelProps.Colors)
                {
                    this.listColours.Items.Add(new ListViewItem(color.ToString()));
                }
            }
        }

        private void TxtBackgroundTextChanged(object sender, EventArgs e)
        {
            MapEditor.LevelProps.BackgroundName = this.txtBackground.Text;
            if (File.Exists("assets/images/" + this.txtBackground.Text + ".png"))
            {
                this.picboxPreview.BackgroundImage = new Bitmap("assets/images/" + this.txtBackground.Text + ".png");
            }
        }

        private void SpawnXUpDownValueChanged(object sender, EventArgs e)
        {
            MapEditor.LevelProps.SpawnX = Convert.ToSingle(this.spawnXUpDown.Value);
        }

        private void SpawnYUpDownValueChanged(object sender, EventArgs e)
        {
            MapEditor.LevelProps.SpawnY = Convert.ToSingle(this.spawnYUpDown.Value);
        }

        private void FinishXUpDownValueChanged(object sender, EventArgs e)
        {
            MapEditor.LevelProps.FinishX = Convert.ToSingle(this.finishXUpDown.Value);
        }

        #region SpeedPoint
        private void BtnAddSpeedPointClick(object sender, EventArgs e)
        {
            var dialog = new AddSpeedPointDialog();
            if (dialog.ShowDialog() == DialogResult.OK)
            {
                float x = dialog.GetX();
                float speed = dialog.GetSpeed();
                if (MapEditor.LevelProps.SpeedPoints == null)
                {
                    MapEditor.LevelProps.SpeedPoints = new List<SpeedPoint>();
                }

                MapEditor.LevelProps.SpeedPoints.Add(new SpeedPoint { X = x, Speed = speed });
                this.listSpeedPoints.Items.Add(new ListViewItem(new[] { x.ToString(), speed.ToString() }));
            }
        }

        private void BtnRemoveSpeedPointClick(object sender, EventArgs e)
        {
            if (this.listSpeedPoints.SelectedItems.Count == 1)
            {
                MapEditor.LevelProps.SpeedPoints.Remove(MapEditor.LevelProps.SpeedPoints[this.listSpeedPoints.SelectedIndices[0]]);
                this.listSpeedPoints.Items.Remove(this.listSpeedPoints.SelectedItems[0]);
            }
        }
        #endregion

        #region Color
        private void BtnAddColorClick(object sender, EventArgs e)
        {
            var availableColors = Enum.GetValues(typeof(LevelProperties.ColorEnum)).Cast<LevelProperties.ColorEnum>().ToList();
            if (MapEditor.LevelProps.Colors != null)
            {
                foreach (var color in MapEditor.LevelProps.Colors)
                {
                    availableColors.Remove(color);
                }
            }

            var dialog = new AddColorDialog(availableColors);
            if (dialog.ShowDialog() == DialogResult.OK)
            {
                LevelProperties.ColorEnum color = dialog.GetColor();
                if (MapEditor.LevelProps.Colors == null)
                {
                    MapEditor.LevelProps.Colors = new List<LevelProperties.ColorEnum>();
                }

                MapEditor.LevelProps.Colors.Add(color);
                this.listColours.Items.Add(new ListViewItem(color.ToString()));
            }

        }

        private void BtnRemoveColorClick(object sender, EventArgs e)
        {
            if (this.listColours.SelectedItems.Count == 1)
            {
                MapEditor.LevelProps.Colors.Remove((LevelProperties.ColorEnum)Enum.Parse(typeof(LevelProperties.ColorEnum), this.listColours.SelectedItems[0].Text));
                this.listColours.Items.Remove(this.listColours.SelectedItems[0]);
            }
        }
        #endregion Color
    }
}
