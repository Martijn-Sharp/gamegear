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
            this.pnlInfo = new System.Windows.Forms.GroupBox();
            this.pnlWallProps = new System.Windows.Forms.Panel();
            this.lblHealth = new System.Windows.Forms.Label();
            this.healthNumericUpDown = new System.Windows.Forms.NumericUpDown();
            this.ddlWallColor = new System.Windows.Forms.ComboBox();
            this.lblWallColor = new System.Windows.Forms.Label();
            this.pnlSpawnerProps = new System.Windows.Forms.Panel();
            this.chkMultiple = new System.Windows.Forms.CheckBox();
            this.intervalUpDown = new System.Windows.Forms.NumericUpDown();
            this.lblInterval = new System.Windows.Forms.Label();
            this.speedUpDown = new System.Windows.Forms.NumericUpDown();
            this.lblSpeed = new System.Windows.Forms.Label();
            this.ddlColors = new System.Windows.Forms.ComboBox();
            this.lblColors = new System.Windows.Forms.Label();
            this.tabPicker = new System.Windows.Forms.TabControl();
            this.Enemy = new System.Windows.Forms.TabPage();
            this.listEnemies = new System.Windows.Forms.ListView();
            this.nameEnemyColumnHeader = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Level = new System.Windows.Forms.TabPage();
            this.listLevels = new System.Windows.Forms.ListView();
            this.nameLevelColumnHeader = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.menuStrip = new System.Windows.Forms.MenuStrip();
            this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.importToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.exportToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.closeToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.clearToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.clearToolStripMenuItem2 = new System.Windows.Forms.ToolStripMenuItem();
            this.propertiesToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.contextMenuStrip = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.clearStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.propertiesStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator = new System.Windows.Forms.ToolStripSeparator();
            this.importStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.exportStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.chkDelete = new System.Windows.Forms.CheckBox();
            this.btnFasterForward = new System.Windows.Forms.Button();
            this.btnFastForward = new System.Windows.Forms.Button();
            this.btnForward = new System.Windows.Forms.Button();
            this.lblPageStretch = new System.Windows.Forms.Label();
            this.btnBackward = new System.Windows.Forms.Button();
            this.btnFastBackward = new System.Windows.Forms.Button();
            this.btnFasterBackward = new System.Windows.Forms.Button();
            this.pnlInfo.SuspendLayout();
            this.pnlWallProps.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.healthNumericUpDown)).BeginInit();
            this.pnlSpawnerProps.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.intervalUpDown)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.speedUpDown)).BeginInit();
            this.tabPicker.SuspendLayout();
            this.Enemy.SuspendLayout();
            this.Level.SuspendLayout();
            this.menuStrip.SuspendLayout();
            this.contextMenuStrip.SuspendLayout();
            this.SuspendLayout();
            // 
            // mapPanel
            // 
            this.mapPanel.AutoScroll = true;
            this.mapPanel.Location = new System.Drawing.Point(179, 59);
            this.mapPanel.Name = "mapPanel";
            this.mapPanel.Size = new System.Drawing.Size(760, 374);
            this.mapPanel.TabIndex = 0;
            // 
            // lblButtonValue
            // 
            this.lblButtonValue.AutoSize = true;
            this.lblButtonValue.Location = new System.Drawing.Point(6, 178);
            this.lblButtonValue.Name = "lblButtonValue";
            this.lblButtonValue.Size = new System.Drawing.Size(43, 13);
            this.lblButtonValue.TabIndex = 4;
            this.lblButtonValue.Text = "Type = ";
            // 
            // lblButtonY
            // 
            this.lblButtonY.AutoSize = true;
            this.lblButtonY.Location = new System.Drawing.Point(66, 165);
            this.lblButtonY.Name = "lblButtonY";
            this.lblButtonY.Size = new System.Drawing.Size(26, 13);
            this.lblButtonY.TabIndex = 3;
            this.lblButtonY.Text = "Y = ";
            // 
            // lblButtonX
            // 
            this.lblButtonX.AutoSize = true;
            this.lblButtonX.Location = new System.Drawing.Point(6, 165);
            this.lblButtonX.Name = "lblButtonX";
            this.lblButtonX.Size = new System.Drawing.Size(23, 13);
            this.lblButtonX.TabIndex = 2;
            this.lblButtonX.Text = "X =";
            // 
            // lblCurrentButton
            // 
            this.lblCurrentButton.AutoSize = true;
            this.lblCurrentButton.Location = new System.Drawing.Point(6, 152);
            this.lblCurrentButton.Name = "lblCurrentButton";
            this.lblCurrentButton.Size = new System.Drawing.Size(86, 13);
            this.lblCurrentButton.TabIndex = 1;
            this.lblCurrentButton.Text = "Selected Button:";
            // 
            // pnlInfo
            // 
            this.pnlInfo.Controls.Add(this.pnlWallProps);
            this.pnlInfo.Controls.Add(this.pnlSpawnerProps);
            this.pnlInfo.Controls.Add(this.lblButtonValue);
            this.pnlInfo.Controls.Add(this.lblButtonY);
            this.pnlInfo.Controls.Add(this.lblCurrentButton);
            this.pnlInfo.Controls.Add(this.lblButtonX);
            this.pnlInfo.Location = new System.Drawing.Point(0, 229);
            this.pnlInfo.Name = "pnlInfo";
            this.pnlInfo.Size = new System.Drawing.Size(173, 197);
            this.pnlInfo.TabIndex = 18;
            this.pnlInfo.TabStop = false;
            this.pnlInfo.Text = "Info";
            // 
            // pnlWallProps
            // 
            this.pnlWallProps.Controls.Add(this.lblHealth);
            this.pnlWallProps.Controls.Add(this.healthNumericUpDown);
            this.pnlWallProps.Controls.Add(this.ddlWallColor);
            this.pnlWallProps.Controls.Add(this.lblWallColor);
            this.pnlWallProps.Location = new System.Drawing.Point(7, 20);
            this.pnlWallProps.Name = "pnlWallProps";
            this.pnlWallProps.Size = new System.Drawing.Size(155, 51);
            this.pnlWallProps.TabIndex = 6;
            this.pnlWallProps.Visible = false;
            // 
            // lblHealth
            // 
            this.lblHealth.AutoSize = true;
            this.lblHealth.Location = new System.Drawing.Point(2, 30);
            this.lblHealth.Name = "lblHealth";
            this.lblHealth.Size = new System.Drawing.Size(38, 13);
            this.lblHealth.TabIndex = 3;
            this.lblHealth.Text = "Health";
            // 
            // healthNumericUpDown
            // 
            this.healthNumericUpDown.Location = new System.Drawing.Point(44, 28);
            this.healthNumericUpDown.Maximum = new decimal(new int[] {
            999,
            0,
            0,
            0});
            this.healthNumericUpDown.Name = "healthNumericUpDown";
            this.healthNumericUpDown.Size = new System.Drawing.Size(41, 20);
            this.healthNumericUpDown.TabIndex = 2;
            this.healthNumericUpDown.ValueChanged += new System.EventHandler(this.HealthNumericUpDownValueChanged);
            // 
            // ddlWallColor
            // 
            this.ddlWallColor.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.ddlWallColor.FormattingEnabled = true;
            this.ddlWallColor.Location = new System.Drawing.Point(44, 4);
            this.ddlWallColor.Name = "ddlWallColor";
            this.ddlWallColor.Size = new System.Drawing.Size(108, 21);
            this.ddlWallColor.TabIndex = 1;
            this.ddlWallColor.SelectedIndexChanged += new System.EventHandler(this.DllWallColorSelectedIndexChanged);
            // 
            // lblWallColor
            // 
            this.lblWallColor.AutoSize = true;
            this.lblWallColor.Location = new System.Drawing.Point(2, 7);
            this.lblWallColor.Name = "lblWallColor";
            this.lblWallColor.Size = new System.Drawing.Size(31, 13);
            this.lblWallColor.TabIndex = 0;
            this.lblWallColor.Text = "Color";
            // 
            // pnlSpawnerProps
            // 
            this.pnlSpawnerProps.Controls.Add(this.chkMultiple);
            this.pnlSpawnerProps.Controls.Add(this.intervalUpDown);
            this.pnlSpawnerProps.Controls.Add(this.lblInterval);
            this.pnlSpawnerProps.Controls.Add(this.speedUpDown);
            this.pnlSpawnerProps.Controls.Add(this.lblSpeed);
            this.pnlSpawnerProps.Controls.Add(this.ddlColors);
            this.pnlSpawnerProps.Controls.Add(this.lblColors);
            this.pnlSpawnerProps.Location = new System.Drawing.Point(7, 77);
            this.pnlSpawnerProps.Name = "pnlSpawnerProps";
            this.pnlSpawnerProps.Size = new System.Drawing.Size(155, 72);
            this.pnlSpawnerProps.TabIndex = 5;
            this.pnlSpawnerProps.Visible = false;
            // 
            // chkMultiple
            // 
            this.chkMultiple.AutoSize = true;
            this.chkMultiple.Location = new System.Drawing.Point(86, 27);
            this.chkMultiple.Name = "chkMultiple";
            this.chkMultiple.Size = new System.Drawing.Size(62, 17);
            this.chkMultiple.TabIndex = 6;
            this.chkMultiple.Text = "Multiple";
            this.chkMultiple.UseVisualStyleBackColor = true;
            this.chkMultiple.CheckedChanged += new System.EventHandler(this.ChkMultipleCheckedChanged);
            // 
            // intervalUpDown
            // 
            this.intervalUpDown.DecimalPlaces = 1;
            this.intervalUpDown.Increment = new decimal(new int[] {
            5,
            0,
            0,
            65536});
            this.intervalUpDown.Location = new System.Drawing.Point(44, 49);
            this.intervalUpDown.Maximum = new decimal(new int[] {
            2,
            0,
            0,
            0});
            this.intervalUpDown.Name = "intervalUpDown";
            this.intervalUpDown.Size = new System.Drawing.Size(39, 20);
            this.intervalUpDown.TabIndex = 5;
            this.intervalUpDown.ValueChanged += new System.EventHandler(this.IntervalUpDownValueChanged);
            // 
            // lblInterval
            // 
            this.lblInterval.AutoSize = true;
            this.lblInterval.Location = new System.Drawing.Point(2, 49);
            this.lblInterval.Name = "lblInterval";
            this.lblInterval.Size = new System.Drawing.Size(42, 13);
            this.lblInterval.TabIndex = 4;
            this.lblInterval.Text = "Interval";
            // 
            // speedUpDown
            // 
            this.speedUpDown.DecimalPlaces = 1;
            this.speedUpDown.Increment = new decimal(new int[] {
            5,
            0,
            0,
            65536});
            this.speedUpDown.Location = new System.Drawing.Point(44, 26);
            this.speedUpDown.Maximum = new decimal(new int[] {
            4,
            0,
            0,
            0});
            this.speedUpDown.Name = "speedUpDown";
            this.speedUpDown.Size = new System.Drawing.Size(39, 20);
            this.speedUpDown.TabIndex = 3;
            this.speedUpDown.ValueChanged += new System.EventHandler(this.SpeedUpDownValueChanged);
            // 
            // lblSpeed
            // 
            this.lblSpeed.AutoSize = true;
            this.lblSpeed.Location = new System.Drawing.Point(2, 28);
            this.lblSpeed.Name = "lblSpeed";
            this.lblSpeed.Size = new System.Drawing.Size(38, 13);
            this.lblSpeed.TabIndex = 2;
            this.lblSpeed.Text = "Speed";
            // 
            // ddlColors
            // 
            this.ddlColors.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.ddlColors.FormattingEnabled = true;
            this.ddlColors.Location = new System.Drawing.Point(44, 4);
            this.ddlColors.Name = "ddlColors";
            this.ddlColors.Size = new System.Drawing.Size(108, 21);
            this.ddlColors.TabIndex = 1;
            this.ddlColors.SelectedIndexChanged += new System.EventHandler(this.DdlColorsSelectedIndexChanged);
            // 
            // lblColors
            // 
            this.lblColors.AutoSize = true;
            this.lblColors.Location = new System.Drawing.Point(2, 7);
            this.lblColors.Name = "lblColors";
            this.lblColors.Size = new System.Drawing.Size(36, 13);
            this.lblColors.TabIndex = 0;
            this.lblColors.Text = "Colors";
            // 
            // tabPicker
            // 
            this.tabPicker.Controls.Add(this.Enemy);
            this.tabPicker.Controls.Add(this.Level);
            this.tabPicker.Location = new System.Drawing.Point(12, 27);
            this.tabPicker.Name = "tabPicker";
            this.tabPicker.SelectedIndex = 0;
            this.tabPicker.Size = new System.Drawing.Size(154, 196);
            this.tabPicker.TabIndex = 19;
            // 
            // Enemy
            // 
            this.Enemy.Controls.Add(this.listEnemies);
            this.Enemy.Location = new System.Drawing.Point(4, 22);
            this.Enemy.Name = "Enemy";
            this.Enemy.Padding = new System.Windows.Forms.Padding(3);
            this.Enemy.Size = new System.Drawing.Size(146, 170);
            this.Enemy.TabIndex = 1;
            this.Enemy.Text = "Enemy";
            this.Enemy.UseVisualStyleBackColor = true;
            // 
            // listEnemies
            // 
            this.listEnemies.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.nameEnemyColumnHeader});
            this.listEnemies.FullRowSelect = true;
            this.listEnemies.GridLines = true;
            this.listEnemies.Location = new System.Drawing.Point(0, 0);
            this.listEnemies.MultiSelect = false;
            this.listEnemies.Name = "listEnemies";
            this.listEnemies.Size = new System.Drawing.Size(150, 174);
            this.listEnemies.TabIndex = 0;
            this.listEnemies.UseCompatibleStateImageBehavior = false;
            this.listEnemies.View = System.Windows.Forms.View.Details;
            this.listEnemies.SelectedIndexChanged += new System.EventHandler(this.ListEnemiesSelectedIndexChanged);
            // 
            // nameEnemyColumnHeader
            // 
            this.nameEnemyColumnHeader.Text = "Name";
            this.nameEnemyColumnHeader.Width = 110;
            // 
            // Level
            // 
            this.Level.Controls.Add(this.listLevels);
            this.Level.Location = new System.Drawing.Point(4, 22);
            this.Level.Name = "Level";
            this.Level.Padding = new System.Windows.Forms.Padding(3);
            this.Level.Size = new System.Drawing.Size(146, 170);
            this.Level.TabIndex = 2;
            this.Level.Text = "Level";
            this.Level.UseVisualStyleBackColor = true;
            // 
            // listLevels
            // 
            this.listLevels.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.nameLevelColumnHeader});
            this.listLevels.FullRowSelect = true;
            this.listLevels.GridLines = true;
            this.listLevels.Location = new System.Drawing.Point(0, 0);
            this.listLevels.MultiSelect = false;
            this.listLevels.Name = "listLevels";
            this.listLevels.Size = new System.Drawing.Size(150, 174);
            this.listLevels.TabIndex = 0;
            this.listLevels.UseCompatibleStateImageBehavior = false;
            this.listLevels.View = System.Windows.Forms.View.Details;
            this.listLevels.SelectedIndexChanged += new System.EventHandler(this.ListLevelsSelectedIndexChanged);
            // 
            // nameLevelColumnHeader
            // 
            this.nameLevelColumnHeader.Text = "Name";
            this.nameLevelColumnHeader.Width = 110;
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
            // contextMenuStrip
            // 
            this.contextMenuStrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.clearStripMenuItem,
            this.propertiesStripMenuItem,
            this.toolStripSeparator,
            this.importStripMenuItem,
            this.exportStripMenuItem});
            this.contextMenuStrip.Name = "contextMenuStrip1";
            this.contextMenuStrip.ShowCheckMargin = true;
            this.contextMenuStrip.ShowImageMargin = false;
            this.contextMenuStrip.Size = new System.Drawing.Size(128, 98);
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
            this.propertiesStripMenuItem.Click += new System.EventHandler(this.PropertiesClick);
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
            // chkDelete
            // 
            this.chkDelete.AutoSize = true;
            this.chkDelete.Location = new System.Drawing.Point(179, 31);
            this.chkDelete.Name = "chkDelete";
            this.chkDelete.Size = new System.Drawing.Size(86, 17);
            this.chkDelete.TabIndex = 21;
            this.chkDelete.Text = "Delete mode";
            this.chkDelete.UseVisualStyleBackColor = true;
            // 
            // btnFasterForward
            // 
            this.btnFasterForward.Location = new System.Drawing.Point(897, 27);
            this.btnFasterForward.Name = "btnFasterForward";
            this.btnFasterForward.Size = new System.Drawing.Size(40, 23);
            this.btnFasterForward.TabIndex = 22;
            this.btnFasterForward.Text = ">>>";
            this.btnFasterForward.UseVisualStyleBackColor = true;
            this.btnFasterForward.Click += new System.EventHandler(this.BtnFasterForwardClick);
            // 
            // btnFastForward
            // 
            this.btnFastForward.Location = new System.Drawing.Point(851, 27);
            this.btnFastForward.Name = "btnFastForward";
            this.btnFastForward.Size = new System.Drawing.Size(40, 23);
            this.btnFastForward.TabIndex = 23;
            this.btnFastForward.Text = ">>";
            this.btnFastForward.UseVisualStyleBackColor = true;
            this.btnFastForward.Click += new System.EventHandler(this.BtnFastForwardClick);
            // 
            // btnForward
            // 
            this.btnForward.Location = new System.Drawing.Point(805, 27);
            this.btnForward.Name = "btnForward";
            this.btnForward.Size = new System.Drawing.Size(40, 23);
            this.btnForward.TabIndex = 24;
            this.btnForward.Text = ">";
            this.btnForward.UseVisualStyleBackColor = true;
            this.btnForward.Click += new System.EventHandler(this.BtnForwardClick);
            // 
            // lblPageStretch
            // 
            this.lblPageStretch.Location = new System.Drawing.Point(726, 32);
            this.lblPageStretch.Name = "lblPageStretch";
            this.lblPageStretch.Size = new System.Drawing.Size(73, 13);
            this.lblPageStretch.TabIndex = 25;
            this.lblPageStretch.Text = "0 - 24";
            this.lblPageStretch.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // btnBackward
            // 
            this.btnBackward.Location = new System.Drawing.Point(680, 27);
            this.btnBackward.Name = "btnBackward";
            this.btnBackward.Size = new System.Drawing.Size(40, 23);
            this.btnBackward.TabIndex = 26;
            this.btnBackward.Text = "<";
            this.btnBackward.UseVisualStyleBackColor = true;
            this.btnBackward.Click += new System.EventHandler(this.BtnBackwardClick);
            // 
            // btnFastBackward
            // 
            this.btnFastBackward.Location = new System.Drawing.Point(634, 27);
            this.btnFastBackward.Name = "btnFastBackward";
            this.btnFastBackward.Size = new System.Drawing.Size(40, 23);
            this.btnFastBackward.TabIndex = 27;
            this.btnFastBackward.Text = "<<";
            this.btnFastBackward.UseVisualStyleBackColor = true;
            this.btnFastBackward.Click += new System.EventHandler(this.BtnFastBackwardClick);
            // 
            // btnFasterBackward
            // 
            this.btnFasterBackward.Location = new System.Drawing.Point(588, 27);
            this.btnFasterBackward.Name = "btnFasterBackward";
            this.btnFasterBackward.Size = new System.Drawing.Size(40, 23);
            this.btnFasterBackward.TabIndex = 28;
            this.btnFasterBackward.Text = "<<<";
            this.btnFasterBackward.UseVisualStyleBackColor = true;
            this.btnFasterBackward.Click += new System.EventHandler(this.BtnFasterBackwardClick);
            // 
            // MapEditor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoScroll = true;
            this.ClientSize = new System.Drawing.Size(945, 438);
            this.ContextMenuStrip = this.contextMenuStrip;
            this.Controls.Add(this.btnFasterBackward);
            this.Controls.Add(this.btnFastBackward);
            this.Controls.Add(this.btnBackward);
            this.Controls.Add(this.lblPageStretch);
            this.Controls.Add(this.btnForward);
            this.Controls.Add(this.btnFastForward);
            this.Controls.Add(this.btnFasterForward);
            this.Controls.Add(this.chkDelete);
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
            this.pnlWallProps.ResumeLayout(false);
            this.pnlWallProps.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.healthNumericUpDown)).EndInit();
            this.pnlSpawnerProps.ResumeLayout(false);
            this.pnlSpawnerProps.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.intervalUpDown)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.speedUpDown)).EndInit();
            this.tabPicker.ResumeLayout(false);
            this.Enemy.ResumeLayout(false);
            this.Level.ResumeLayout(false);
            this.menuStrip.ResumeLayout(false);
            this.menuStrip.PerformLayout();
            this.contextMenuStrip.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Panel mapPanel;
        private System.Windows.Forms.Label lblCurrentButton;
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
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip;
        private System.Windows.Forms.ToolStripMenuItem clearStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem importStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem exportStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem clearToolStripMenuItem2;
        private System.Windows.Forms.ToolStripMenuItem propertiesToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem propertiesStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator;
        private System.Windows.Forms.ListView listEnemies;
        private System.Windows.Forms.ColumnHeader nameEnemyColumnHeader;
        private System.Windows.Forms.ListView listLevels;
        private System.Windows.Forms.ColumnHeader nameLevelColumnHeader;
        private System.Windows.Forms.Panel pnlSpawnerProps;
        private System.Windows.Forms.CheckBox chkMultiple;
        private System.Windows.Forms.NumericUpDown intervalUpDown;
        private System.Windows.Forms.Label lblInterval;
        private System.Windows.Forms.NumericUpDown speedUpDown;
        private System.Windows.Forms.Label lblSpeed;
        private System.Windows.Forms.ComboBox ddlColors;
        private System.Windows.Forms.Label lblColors;
        private System.Windows.Forms.CheckBox chkDelete;
        private System.Windows.Forms.Button btnFasterForward;
        private System.Windows.Forms.Button btnFastForward;
        private System.Windows.Forms.Button btnForward;
        private System.Windows.Forms.Label lblPageStretch;
        private System.Windows.Forms.Button btnBackward;
        private System.Windows.Forms.Button btnFastBackward;
        private System.Windows.Forms.Button btnFasterBackward;
        private System.Windows.Forms.Panel pnlWallProps;
        private System.Windows.Forms.Label lblHealth;
        private System.Windows.Forms.NumericUpDown healthNumericUpDown;
        private System.Windows.Forms.ComboBox ddlWallColor;
        private System.Windows.Forms.Label lblWallColor;
    }
}

