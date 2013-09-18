namespace MapEditor
{
    using System;
    using System.Windows.Forms;

    public partial class AddActorDialog : Form
    {
        public AddActorDialog()
        {
            this.InitializeComponent();
        }

        public string GetName()
        {
            return this.txtName.Text;
        }

        private void BtnSaveClick(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.OK;
            this.Close();
        }
    }
}
