﻿namespace MapEditor
{
    using System;
    using System.Windows.Forms;

    public partial class AddPolygonDialog : Form
    {
        public AddPolygonDialog()
        {
            this.InitializeComponent();
        }

        public float GetXCoord()
        {
            return Convert.ToSingle(this.xUpDown.Text);
        }

        public float GetYCoord()
        {
            return Convert.ToSingle(this.yUpDown.Text);
        }

        private void BtnSaveClick(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.OK;
            this.Close();
        }
    }
}
