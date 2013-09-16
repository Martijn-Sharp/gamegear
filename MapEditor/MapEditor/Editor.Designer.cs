namespace MapEditor
{
    partial class Editor
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
            this.clearButton = new System.Windows.Forms.Button();
            this.exportButton = new System.Windows.Forms.Button();
            this.importButton = new System.Windows.Forms.Button();
            this.mapPanel = new System.Windows.Forms.Panel();
            this.lblButtonValue = new System.Windows.Forms.Label();
            this.lblButtonY = new System.Windows.Forms.Label();
            this.lblButtonX = new System.Windows.Forms.Label();
            this.lblCurrentButton = new System.Windows.Forms.Label();
            this.lblSelectedType = new System.Windows.Forms.Label();
            this.pnlInfo = new System.Windows.Forms.GroupBox();
            this.tabPicker = new System.Windows.Forms.TabControl();
            this.Damage = new System.Windows.Forms.TabPage();
            this.Enemy = new System.Windows.Forms.TabPage();
            this.Level = new System.Windows.Forms.TabPage();
            this.Special = new System.Windows.Forms.TabPage();
            this.pnlInfo.SuspendLayout();
            this.tabPicker.SuspendLayout();
            this.SuspendLayout();
            // 
            // clearButton
            // 
            this.clearButton.Location = new System.Drawing.Point(755, 351);
            this.clearButton.Margin = new System.Windows.Forms.Padding(2);
            this.clearButton.Name = "clearButton";
            this.clearButton.Size = new System.Drawing.Size(56, 27);
            this.clearButton.TabIndex = 4;
            this.clearButton.Text = "Clear";
            this.clearButton.UseVisualStyleBackColor = true;
            this.clearButton.Click += new System.EventHandler(this.ClearButtonClick);
            // 
            // exportButton
            // 
            this.exportButton.Location = new System.Drawing.Point(875, 351);
            this.exportButton.Margin = new System.Windows.Forms.Padding(2);
            this.exportButton.Name = "exportButton";
            this.exportButton.Size = new System.Drawing.Size(56, 27);
            this.exportButton.TabIndex = 9;
            this.exportButton.Text = "Export";
            this.exportButton.UseVisualStyleBackColor = true;
            this.exportButton.Click += new System.EventHandler(this.ExportButtonClick);
            // 
            // importButton
            // 
            this.importButton.Location = new System.Drawing.Point(815, 351);
            this.importButton.Margin = new System.Windows.Forms.Padding(2);
            this.importButton.Name = "importButton";
            this.importButton.Size = new System.Drawing.Size(56, 27);
            this.importButton.TabIndex = 10;
            this.importButton.Text = "Import";
            this.importButton.UseVisualStyleBackColor = true;
            this.importButton.Click += new System.EventHandler(this.ImportButtonClick);
            // 
            // mapPanel
            // 
            this.mapPanel.AutoScroll = true;
            this.mapPanel.Location = new System.Drawing.Point(173, 12);
            this.mapPanel.Name = "mapPanel";
            this.mapPanel.Size = new System.Drawing.Size(760, 334);
            this.mapPanel.TabIndex = 0;
            this.mapPanel.TabIndexChanged += new System.EventHandler(this.TabPickerIndexChanged);
            // 
            // lblButtonValue
            // 
            this.lblButtonValue.AutoSize = true;
            this.lblButtonValue.Location = new System.Drawing.Point(6, 85);
            this.lblButtonValue.Name = "lblButtonValue";
            this.lblButtonValue.Size = new System.Drawing.Size(43, 13);
            this.lblButtonValue.TabIndex = 4;
            this.lblButtonValue.Text = "Type = ";
            // 
            // lblButtonY
            // 
            this.lblButtonY.AutoSize = true;
            this.lblButtonY.Location = new System.Drawing.Point(7, 72);
            this.lblButtonY.Name = "lblButtonY";
            this.lblButtonY.Size = new System.Drawing.Size(24, 13);
            this.lblButtonY.TabIndex = 3;
            this.lblButtonY.Text = "y = ";
            // 
            // lblButtonX
            // 
            this.lblButtonX.AutoSize = true;
            this.lblButtonX.Location = new System.Drawing.Point(6, 59);
            this.lblButtonX.Name = "lblButtonX";
            this.lblButtonX.Size = new System.Drawing.Size(21, 13);
            this.lblButtonX.TabIndex = 2;
            this.lblButtonX.Text = "x =";
            // 
            // lblCurrentButton
            // 
            this.lblCurrentButton.AutoSize = true;
            this.lblCurrentButton.Location = new System.Drawing.Point(6, 46);
            this.lblCurrentButton.Name = "lblCurrentButton";
            this.lblCurrentButton.Size = new System.Drawing.Size(86, 13);
            this.lblCurrentButton.TabIndex = 1;
            this.lblCurrentButton.Text = "Selected Button:";
            // 
            // lblSelectedType
            // 
            this.lblSelectedType.AutoSize = true;
            this.lblSelectedType.Cursor = System.Windows.Forms.Cursors.Default;
            this.lblSelectedType.Location = new System.Drawing.Point(6, 16);
            this.lblSelectedType.Name = "lblSelectedType";
            this.lblSelectedType.Size = new System.Drawing.Size(87, 13);
            this.lblSelectedType.TabIndex = 0;
            this.lblSelectedType.Text = "No type selected";
            // 
            // pnlInfo
            // 
            this.pnlInfo.Controls.Add(this.lblButtonValue);
            this.pnlInfo.Controls.Add(this.lblSelectedType);
            this.pnlInfo.Controls.Add(this.lblButtonY);
            this.pnlInfo.Controls.Add(this.lblCurrentButton);
            this.pnlInfo.Controls.Add(this.lblButtonX);
            this.pnlInfo.Location = new System.Drawing.Point(12, 245);
            this.pnlInfo.Name = "pnlInfo";
            this.pnlInfo.Size = new System.Drawing.Size(151, 101);
            this.pnlInfo.TabIndex = 18;
            this.pnlInfo.TabStop = false;
            this.pnlInfo.Text = "Info";
            // 
            // tabPicker
            // 
            this.tabPicker.Controls.Add(this.Damage);
            this.tabPicker.Controls.Add(this.Enemy);
            this.tabPicker.Controls.Add(this.Level);
            this.tabPicker.Controls.Add(this.Special);
            this.tabPicker.Location = new System.Drawing.Point(13, 12);
            this.tabPicker.Name = "tabPicker";
            this.tabPicker.SelectedIndex = 0;
            this.tabPicker.Size = new System.Drawing.Size(154, 227);
            this.tabPicker.TabIndex = 19;
            this.tabPicker.SelectedIndexChanged += new System.EventHandler(this.TabPickerIndexChanged);
            // 
            // Damage
            // 
            this.Damage.Location = new System.Drawing.Point(4, 22);
            this.Damage.Name = "Damage";
            this.Damage.Padding = new System.Windows.Forms.Padding(3);
            this.Damage.Size = new System.Drawing.Size(146, 201);
            this.Damage.TabIndex = 0;
            this.Damage.Text = "Damage";
            this.Damage.UseVisualStyleBackColor = true;
            // 
            // Enemy
            // 
            this.Enemy.Location = new System.Drawing.Point(4, 22);
            this.Enemy.Name = "Enemy";
            this.Enemy.Padding = new System.Windows.Forms.Padding(3);
            this.Enemy.Size = new System.Drawing.Size(109, 201);
            this.Enemy.TabIndex = 1;
            this.Enemy.Text = "Enemy";
            this.Enemy.UseVisualStyleBackColor = true;
            // 
            // Level
            // 
            this.Level.Location = new System.Drawing.Point(4, 22);
            this.Level.Name = "Level";
            this.Level.Padding = new System.Windows.Forms.Padding(3);
            this.Level.Size = new System.Drawing.Size(109, 201);
            this.Level.TabIndex = 2;
            this.Level.Text = "Level";
            this.Level.UseVisualStyleBackColor = true;
            // 
            // Special
            // 
            this.Special.Location = new System.Drawing.Point(4, 22);
            this.Special.Name = "Special";
            this.Special.Padding = new System.Windows.Forms.Padding(3);
            this.Special.Size = new System.Drawing.Size(109, 201);
            this.Special.TabIndex = 3;
            this.Special.Text = "Special";
            this.Special.UseVisualStyleBackColor = true;
            // 
            // Editor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoScroll = true;
            this.ClientSize = new System.Drawing.Size(945, 384);
            this.Controls.Add(this.tabPicker);
            this.Controls.Add(this.pnlInfo);
            this.Controls.Add(this.mapPanel);
            this.Controls.Add(this.importButton);
            this.Controls.Add(this.exportButton);
            this.Controls.Add(this.clearButton);
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "Editor";
            this.Text = "Map Editor";
            this.pnlInfo.ResumeLayout(false);
            this.pnlInfo.PerformLayout();
            this.tabPicker.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button clearButton;
        private System.Windows.Forms.Button exportButton;
        private System.Windows.Forms.Button importButton;
        private System.Windows.Forms.Panel mapPanel;
        private System.Windows.Forms.Label lblCurrentButton;
        private System.Windows.Forms.Label lblSelectedType;
        private System.Windows.Forms.Label lblButtonValue;
        private System.Windows.Forms.Label lblButtonY;
        private System.Windows.Forms.Label lblButtonX;
        private System.Windows.Forms.GroupBox pnlInfo;
        private System.Windows.Forms.TabControl tabPicker;
        private System.Windows.Forms.TabPage Damage;
        private System.Windows.Forms.TabPage Enemy;
        private System.Windows.Forms.TabPage Level;
        private System.Windows.Forms.TabPage Special;
    }
}

