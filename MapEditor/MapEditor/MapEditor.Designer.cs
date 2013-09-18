namespace MapEditor
{
    partial class MapEditor
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
            this.components = new System.ComponentModel.Container();
            this.mapPanel = new System.Windows.Forms.Panel();
            this.lblButtonValue = new System.Windows.Forms.Label();
            this.lblButtonY = new System.Windows.Forms.Label();
            this.lblButtonX = new System.Windows.Forms.Label();
            this.lblCurrentButton = new System.Windows.Forms.Label();
            this.lblSelectedType = new System.Windows.Forms.Label();
            this.pnlInfo = new System.Windows.Forms.GroupBox();
            this.tabPicker = new System.Windows.Forms.TabControl();
            this.Enemy = new System.Windows.Forms.TabPage();
            this.Level = new System.Windows.Forms.TabPage();
            this.menuStrip = new System.Windows.Forms.MenuStrip();
            this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.importToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.exportToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.closeToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.clearToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.clearToolStripMenuItem2 = new System.Windows.Forms.ToolStripMenuItem();
            this.propertiesToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.clearStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.propertiesStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator = new System.Windows.Forms.ToolStripSeparator();
            this.importStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.exportStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.pnlInfo.SuspendLayout();
            this.tabPicker.SuspendLayout();
            this.menuStrip.SuspendLayout();
            this.contextMenuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // mapPanel
            // 
            this.mapPanel.AutoScroll = true;
            this.mapPanel.Location = new System.Drawing.Point(172, 27);
            this.mapPanel.Name = "mapPanel";
            this.mapPanel.Size = new System.Drawing.Size(760, 334);
            this.mapPanel.TabIndex = 0;
            this.mapPanel.TabIndexChanged += new System.EventHandler(this.TabPickerIndexChanged);
            // 
            // lblButtonValue
            // 
            this.lblButtonValue.AutoSize = true;
            this.lblButtonValue.Location = new System.Drawing.Point(6, 79);
            this.lblButtonValue.Name = "lblButtonValue";
            this.lblButtonValue.Size = new System.Drawing.Size(43, 13);
            this.lblButtonValue.TabIndex = 4;
            this.lblButtonValue.Text = "Type = ";
            // 
            // lblButtonY
            // 
            this.lblButtonY.AutoSize = true;
            this.lblButtonY.Location = new System.Drawing.Point(6, 66);
            this.lblButtonY.Name = "lblButtonY";
            this.lblButtonY.Size = new System.Drawing.Size(26, 13);
            this.lblButtonY.TabIndex = 3;
            this.lblButtonY.Text = "Y = ";
            // 
            // lblButtonX
            // 
            this.lblButtonX.AutoSize = true;
            this.lblButtonX.Location = new System.Drawing.Point(6, 53);
            this.lblButtonX.Name = "lblButtonX";
            this.lblButtonX.Size = new System.Drawing.Size(23, 13);
            this.lblButtonX.TabIndex = 2;
            this.lblButtonX.Text = "X =";
            // 
            // lblCurrentButton
            // 
            this.lblCurrentButton.AutoSize = true;
            this.lblCurrentButton.Location = new System.Drawing.Point(6, 40);
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
            this.pnlInfo.Location = new System.Drawing.Point(11, 260);
            this.pnlInfo.Name = "pnlInfo";
            this.pnlInfo.Size = new System.Drawing.Size(151, 101);
            this.pnlInfo.TabIndex = 18;
            this.pnlInfo.TabStop = false;
            this.pnlInfo.Text = "Info";
            // 
            // tabPicker
            // 
            this.tabPicker.Controls.Add(this.Enemy);
            this.tabPicker.Controls.Add(this.Level);
            this.tabPicker.Location = new System.Drawing.Point(12, 27);
            this.tabPicker.Name = "tabPicker";
            this.tabPicker.SelectedIndex = 0;
            this.tabPicker.Size = new System.Drawing.Size(154, 227);
            this.tabPicker.TabIndex = 19;
            this.tabPicker.SelectedIndexChanged += new System.EventHandler(this.TabPickerIndexChanged);
            // 
            // Enemy
            // 
            this.Enemy.Location = new System.Drawing.Point(4, 22);
            this.Enemy.Name = "Enemy";
            this.Enemy.Padding = new System.Windows.Forms.Padding(3);
            this.Enemy.Size = new System.Drawing.Size(146, 201);
            this.Enemy.TabIndex = 1;
            this.Enemy.Text = "Enemy";
            this.Enemy.UseVisualStyleBackColor = true;
            // 
            // Level
            // 
            this.Level.Location = new System.Drawing.Point(4, 22);
            this.Level.Name = "Level";
            this.Level.Padding = new System.Windows.Forms.Padding(3);
            this.Level.Size = new System.Drawing.Size(146, 201);
            this.Level.TabIndex = 2;
            this.Level.Text = "Level";
            this.Level.UseVisualStyleBackColor = true;
            // 
            // menuStrip
            // 
            this.menuStrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem,
            this.clearToolStripMenuItem});
            this.menuStrip.Location = new System.Drawing.Point(0, 0);
            this.menuStrip.Name = "menuStrip";
            this.menuStrip.Size = new System.Drawing.Size(945, 24);
            this.menuStrip.TabIndex = 20;
            this.menuStrip.Text = "menuStrip1";
            // 
            // fileToolStripMenuItem
            // 
            this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.importToolStripMenuItem,
            this.exportToolStripMenuItem,
            this.closeToolStripMenuItem});
            this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
            this.fileToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
            this.fileToolStripMenuItem.Text = "File";
            // 
            // importToolStripMenuItem
            // 
            this.importToolStripMenuItem.Name = "importToolStripMenuItem";
            this.importToolStripMenuItem.Size = new System.Drawing.Size(110, 22);
            this.importToolStripMenuItem.Text = "Import";
            this.importToolStripMenuItem.Click += new System.EventHandler(this.ImportClick);
            // 
            // exportToolStripMenuItem
            // 
            this.exportToolStripMenuItem.Name = "exportToolStripMenuItem";
            this.exportToolStripMenuItem.Size = new System.Drawing.Size(110, 22);
            this.exportToolStripMenuItem.Text = "Export";
            this.exportToolStripMenuItem.Click += new System.EventHandler(this.ExportClick);
            // 
            // closeToolStripMenuItem
            // 
            this.closeToolStripMenuItem.Name = "closeToolStripMenuItem";
            this.closeToolStripMenuItem.Size = new System.Drawing.Size(110, 22);
            this.closeToolStripMenuItem.Text = "Close";
            this.closeToolStripMenuItem.Click += new System.EventHandler(this.CloseClick);
            // 
            // clearToolStripMenuItem
            // 
            this.clearToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.clearToolStripMenuItem2,
            this.propertiesToolStripMenuItem});
            this.clearToolStripMenuItem.Name = "clearToolStripMenuItem";
            this.clearToolStripMenuItem.Size = new System.Drawing.Size(39, 20);
            this.clearToolStripMenuItem.Text = "Edit";
            // 
            // clearToolStripMenuItem2
            // 
            this.clearToolStripMenuItem2.Name = "clearToolStripMenuItem2";
            this.clearToolStripMenuItem2.Size = new System.Drawing.Size(127, 22);
            this.clearToolStripMenuItem2.Text = "Clear";
            this.clearToolStripMenuItem2.Click += new System.EventHandler(this.ClearClick);
            // 
            // propertiesToolStripMenuItem
            // 
            this.propertiesToolStripMenuItem.Name = "propertiesToolStripMenuItem";
            this.propertiesToolStripMenuItem.Size = new System.Drawing.Size(127, 22);
            this.propertiesToolStripMenuItem.Text = "Properties";
            this.propertiesToolStripMenuItem.Click += new System.EventHandler(this.PropertiesClick);
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.clearStripMenuItem,
            this.propertiesStripMenuItem,
            this.toolStripSeparator,
            this.importStripMenuItem,
            this.exportStripMenuItem});
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.ShowCheckMargin = true;
            this.contextMenuStrip1.ShowImageMargin = false;
            this.contextMenuStrip1.Size = new System.Drawing.Size(128, 98);
            // 
            // clearStripMenuItem
            // 
            this.clearStripMenuItem.Name = "clearStripMenuItem";
            this.clearStripMenuItem.Size = new System.Drawing.Size(127, 22);
            this.clearStripMenuItem.Text = "Clear";
            this.clearStripMenuItem.Click += new System.EventHandler(this.ClearClick);
            // 
            // propertiesStripMenuItem
            // 
            this.propertiesStripMenuItem.Name = "propertiesStripMenuItem";
            this.propertiesStripMenuItem.Size = new System.Drawing.Size(127, 22);
            this.propertiesStripMenuItem.Text = "Properties";
            // 
            // toolStripSeparator
            // 
            this.toolStripSeparator.Name = "toolStripSeparator";
            this.toolStripSeparator.Size = new System.Drawing.Size(124, 6);
            // 
            // importStripMenuItem
            // 
            this.importStripMenuItem.Name = "importStripMenuItem";
            this.importStripMenuItem.Size = new System.Drawing.Size(127, 22);
            this.importStripMenuItem.Text = "Import";
            this.importStripMenuItem.Click += new System.EventHandler(this.ImportClick);
            // 
            // exportStripMenuItem
            // 
            this.exportStripMenuItem.Name = "exportStripMenuItem";
            this.exportStripMenuItem.Size = new System.Drawing.Size(127, 22);
            this.exportStripMenuItem.Text = "Export";
            this.exportStripMenuItem.Click += new System.EventHandler(this.ExportClick);
            // 
            // MapEditor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoScroll = true;
            this.ClientSize = new System.Drawing.Size(945, 369);
            this.ContextMenuStrip = this.contextMenuStrip1;
            this.Controls.Add(this.tabPicker);
            this.Controls.Add(this.pnlInfo);
            this.Controls.Add(this.mapPanel);
            this.Controls.Add(this.menuStrip);
            this.DoubleBuffered = true;
            this.MainMenuStrip = this.menuStrip;
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "MapEditor";
            this.Text = "Map Editor";
            this.pnlInfo.ResumeLayout(false);
            this.pnlInfo.PerformLayout();
            this.tabPicker.ResumeLayout(false);
            this.menuStrip.ResumeLayout(false);
            this.menuStrip.PerformLayout();
            this.contextMenuStrip1.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Panel mapPanel;
        private System.Windows.Forms.Label lblCurrentButton;
        private System.Windows.Forms.Label lblSelectedType;
        private System.Windows.Forms.Label lblButtonValue;
        private System.Windows.Forms.Label lblButtonY;
        private System.Windows.Forms.Label lblButtonX;
        private System.Windows.Forms.GroupBox pnlInfo;
        private System.Windows.Forms.TabControl tabPicker;
        private System.Windows.Forms.TabPage Enemy;
        private System.Windows.Forms.TabPage Level;
        private System.Windows.Forms.MenuStrip menuStrip;
        private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem importToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem exportToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem closeToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem clearToolStripMenuItem;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.ToolStripMenuItem clearStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem importStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem exportStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem clearToolStripMenuItem2;
        private System.Windows.Forms.ToolStripMenuItem propertiesToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem propertiesStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator;
    }
}

