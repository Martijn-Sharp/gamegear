﻿namespace MapEditor
{
    using System;
    using System.Collections.Generic;
    using System.Windows.Forms;

    public partial class AddColorDialog : Form
    {
        public AddColorDialog(List<ColorEnum> availableColors)
        {
            this.InitializeComponent();
            availableColors.ForEach(x => this.ddlColors.Items.Add(x));
        }

        public ColorEnum GetColor()
        {
            return (ColorEnum)this.ddlColors.SelectedItem;
        }

        private void BtnSaveClick(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.OK;
            this.Close();
        }
    }
}
