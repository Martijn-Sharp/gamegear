namespace MapEditor
{
    partial class AddPolygonDialog
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.lblX = new System.Windows.Forms.Label();
            this.xUpDown = new System.Windows.Forms.NumericUpDown();
            this.lblY = new System.Windows.Forms.Label();
            this.yUpDown = new System.Windows.Forms.NumericUpDown();
            this.pnlContainer = new System.Windows.Forms.Panel();
            this.btnCancel = new System.Windows.Forms.Button();
            this.btnSave = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.xUpDown)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.yUpDown)).BeginInit();
            this.pnlContainer.SuspendLayout();
            this.SuspendLayout();
            // 
            // lblX
            // 
            this.lblX.AutoSize = true;
            this.lblX.Location = new System.Drawing.Point(3, 5);
            this.lblX.Name = "lblX";
            this.lblX.Size = new System.Drawing.Size(44, 13);
            this.lblX.TabIndex = 0;
            this.lblX.Text = "X-coord";
            // 
            // xUpDown
            // 
            this.xUpDown.DecimalPlaces = 2;
            this.xUpDown.Increment = new decimal(new int[] {
            1,
            0,
            0,
            65536});
            this.xUpDown.Location = new System.Drawing.Point(53, 3);
            this.xUpDown.Maximum = new decimal(new int[] {
            256,
            0,
            0,
            0});
            this.xUpDown.Minimum = new decimal(new int[] {
            256,
            0,
            0,
            -2147483648});
            this.xUpDown.Name = "xUpDown";
            this.xUpDown.Size = new System.Drawing.Size(43, 20);
            this.xUpDown.TabIndex = 1;
            this.xUpDown.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.xUpDown.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            // 
            // lblY
            // 
            this.lblY.AutoSize = true;
            this.lblY.Location = new System.Drawing.Point(102, 5);
            this.lblY.Name = "lblY";
            this.lblY.Size = new System.Drawing.Size(44, 13);
            this.lblY.TabIndex = 2;
            this.lblY.Text = "Y-coord";
            // 
            // yUpDown
            // 
            this.yUpDown.DecimalPlaces = 2;
            this.yUpDown.Increment = new decimal(new int[] {
            1,
            0,
            0,
            65536});
            this.yUpDown.Location = new System.Drawing.Point(152, 3);
            this.yUpDown.Maximum = new decimal(new int[] {
            256,
            0,
            0,
            0});
            this.yUpDown.Minimum = new decimal(new int[] {
            256,
            0,
            0,
            -2147483648});
            this.yUpDown.Name = "yUpDown";
            this.yUpDown.Size = new System.Drawing.Size(43, 20);
            this.yUpDown.TabIndex = 3;
            this.yUpDown.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.yUpDown.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            // 
            // pnlContainer
            // 
            this.pnlContainer.Controls.Add(this.btnCancel);
            this.pnlContainer.Controls.Add(this.btnSave);
            this.pnlContainer.Controls.Add(this.lblX);
            this.pnlContainer.Controls.Add(this.yUpDown);
            this.pnlContainer.Controls.Add(this.xUpDown);
            this.pnlContainer.Controls.Add(this.lblY);
            this.pnlContainer.Location = new System.Drawing.Point(12, 12);
            this.pnlContainer.Name = "pnlContainer";
            this.pnlContainer.Size = new System.Drawing.Size(200, 59);
            this.pnlContainer.TabIndex = 4;
            // 
            // btnCancel
            // 
            this.btnCancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.btnCancel.Location = new System.Drawing.Point(139, 29);
            this.btnCancel.Name = "btnCancel";
            this.btnCancel.Size = new System.Drawing.Size(56, 23);
            this.btnCancel.TabIndex = 5;
            this.btnCancel.Text = "Cancel";
            this.btnCancel.UseVisualStyleBackColor = true;
            // 
            // btnSave
            // 
            this.btnSave.Location = new System.Drawing.Point(78, 29);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(55, 23);
            this.btnSave.TabIndex = 4;
            this.btnSave.Text = "Save";
            this.btnSave.UseVisualStyleBackColor = true;
            this.btnSave.Click += new System.EventHandler(this.BtnSaveClick);
            // 
            // AddPolygonDialog
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.btnCancel;
            this.ClientSize = new System.Drawing.Size(220, 78);
            this.Controls.Add(this.pnlContainer);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "AddPolygonDialog";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Add Polygon";
            ((System.ComponentModel.ISupportInitialize)(this.xUpDown)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.yUpDown)).EndInit();
            this.pnlContainer.ResumeLayout(false);
            this.pnlContainer.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Label lblX;
        private System.Windows.Forms.NumericUpDown xUpDown;
        private System.Windows.Forms.Label lblY;
        private System.Windows.Forms.NumericUpDown yUpDown;
        private System.Windows.Forms.Panel pnlContainer;
        private System.Windows.Forms.Button btnCancel;
        private System.Windows.Forms.Button btnSave;
    }
}