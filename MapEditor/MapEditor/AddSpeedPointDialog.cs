namespace MapEditor
{
    using System;
    using System.Windows.Forms;
    
    public partial class AddSpeedPointDialog : Form
    {
        public AddSpeedPointDialog()
        {
            InitializeComponent();
        }

        public float GetX()
        {
            return Convert.ToSingle(this.xUpDown.Value);
        }

        public float GetSpeed()
        {
            return Convert.ToSingle(this.speedUpDown.Value);
        }

        private void BtnSaveClick(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.OK;
            this.Close();
        }
    }
}
