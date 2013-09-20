namespace MapEditor
{
    using System;
    using System.Collections.Generic;
    using System.Windows.Forms;

    public partial class AddAnimationDialog : Form
    {
        public AddAnimationDialog(IEnumerable<Animation> animations)
        {
            this.InitializeComponent();
            foreach (var animation in animations)
            {
                this.ddlType.Items.Add(animation);
            }
        }

        public Animation GetAnimation()
        {
            return (Animation)this.ddlType.SelectedItem;
        }

        public int GetLength()
        {
            return Convert.ToInt32(this.lengthUpDown.Value);
        }

        private void BtnSaveClick(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.OK;
            this.Close();
        }
    }
}
