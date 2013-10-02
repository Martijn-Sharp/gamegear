namespace MapEditor
{
    partial class PropertiesForm
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
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tabProperties = new System.Windows.Forms.TabPage();
            this.btnRemoveColor = new System.Windows.Forms.Button();
            this.btnAddColor = new System.Windows.Forms.Button();
            this.listColours = new System.Windows.Forms.ListView();
            this.colorColorHeader = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.lblColors = new System.Windows.Forms.Label();
            this.gboxBackground = new System.Windows.Forms.GroupBox();
            this.picboxPreview = new System.Windows.Forms.PictureBox();
            this.btnRemoveSpeedPoint = new System.Windows.Forms.Button();
            this.btnAddSpeedPoint = new System.Windows.Forms.Button();
            this.listSpeedPoints = new System.Windows.Forms.ListView();
            this.xHeaderSpeedPoints = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.speedHeaderSpeedPoints = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.lblSpeedpoints = new System.Windows.Forms.Label();
            this.finishXUpDown = new System.Windows.Forms.NumericUpDown();
            this.lblFinishX = new System.Windows.Forms.Label();
            this.spawnYUpDown = new System.Windows.Forms.NumericUpDown();
            this.lblSpawnY = new System.Windows.Forms.Label();
            this.spawnXUpDown = new System.Windows.Forms.NumericUpDown();
            this.lblSpawnX = new System.Windows.Forms.Label();
            this.lblSpawn = new System.Windows.Forms.Label();
            this.txtBackground = new System.Windows.Forms.TextBox();
            this.lblBackground = new System.Windows.Forms.Label();
            this.tabActors = new System.Windows.Forms.TabPage();
            this.pnlStaticProperties = new System.Windows.Forms.GroupBox();
            this.chkBreakable = new System.Windows.Forms.CheckBox();
            this.tabControl = new System.Windows.Forms.TabControl();
            this.tabEnemy = new System.Windows.Forms.TabPage();
            this.btnRemoveEnemy = new System.Windows.Forms.Button();
            this.btnAddEnemy = new System.Windows.Forms.Button();
            this.listEnemies = new System.Windows.Forms.ListView();
            this.nameEnemyColumnHeader = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.tabLevel = new System.Windows.Forms.TabPage();
            this.btnRemoveLevel = new System.Windows.Forms.Button();
            this.btnAddLevel = new System.Windows.Forms.Button();
            this.listLevels = new System.Windows.Forms.ListView();
            this.nameLevelColumnHeader = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.pnlProperties = new System.Windows.Forms.GroupBox();
            this.heightUpDown = new System.Windows.Forms.NumericUpDown();
            this.btnRemovePolygon = new System.Windows.Forms.Button();
            this.lblHeight = new System.Windows.Forms.Label();
            this.widthUpDown = new System.Windows.Forms.NumericUpDown();
            this.label1 = new System.Windows.Forms.Label();
            this.lblWidth = new System.Windows.Forms.Label();
            this.btnAddPolygon = new System.Windows.Forms.Button();
            this.listPolygons = new System.Windows.Forms.ListView();
            this.polyXColumnHeader = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.polyYColumnHeader = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.scaleUpDown = new System.Windows.Forms.NumericUpDown();
            this.lblPolygons = new System.Windows.Forms.Label();
            this.txtName = new System.Windows.Forms.TextBox();
            this.lblName = new System.Windows.Forms.Label();
            this.pnlDynProperties = new System.Windows.Forms.GroupBox();
            this.listAnimations = new System.Windows.Forms.ListView();
            this.typeAnimationColumnHeader = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.lengthAnimationColumnHeader = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.btnRemoveAnimation = new System.Windows.Forms.Button();
            this.btnAddAnimation = new System.Windows.Forms.Button();
            this.lblAnimations = new System.Windows.Forms.Label();
            this.healthUpDown = new System.Windows.Forms.NumericUpDown();
            this.lblHealth = new System.Windows.Forms.Label();
            this.speedUpDown = new System.Windows.Forms.NumericUpDown();
            this.lblSpeed = new System.Windows.Forms.Label();
            this.bulletBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.btnSave = new System.Windows.Forms.Button();
            this.tabControl1.SuspendLayout();
            this.tabProperties.SuspendLayout();
            this.gboxBackground.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.picboxPreview)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.finishXUpDown)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.spawnYUpDown)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.spawnXUpDown)).BeginInit();
            this.tabActors.SuspendLayout();
            this.pnlStaticProperties.SuspendLayout();
            this.tabControl.SuspendLayout();
            this.tabEnemy.SuspendLayout();
            this.tabLevel.SuspendLayout();
            this.pnlProperties.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.heightUpDown)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.widthUpDown)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.scaleUpDown)).BeginInit();
            this.pnlDynProperties.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.healthUpDown)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.speedUpDown)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bulletBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.tabProperties);
            this.tabControl1.Controls.Add(this.tabActors);
            this.tabControl1.Location = new System.Drawing.Point(12, 12);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(496, 371);
            this.tabControl1.TabIndex = 4;
            // 
            // tabProperties
            // 
            this.tabProperties.Controls.Add(this.btnRemoveColor);
            this.tabProperties.Controls.Add(this.btnAddColor);
            this.tabProperties.Controls.Add(this.listColours);
            this.tabProperties.Controls.Add(this.lblColors);
            this.tabProperties.Controls.Add(this.gboxBackground);
            this.tabProperties.Controls.Add(this.btnRemoveSpeedPoint);
            this.tabProperties.Controls.Add(this.btnAddSpeedPoint);
            this.tabProperties.Controls.Add(this.listSpeedPoints);
            this.tabProperties.Controls.Add(this.lblSpeedpoints);
            this.tabProperties.Controls.Add(this.finishXUpDown);
            this.tabProperties.Controls.Add(this.lblFinishX);
            this.tabProperties.Controls.Add(this.spawnYUpDown);
            this.tabProperties.Controls.Add(this.lblSpawnY);
            this.tabProperties.Controls.Add(this.spawnXUpDown);
            this.tabProperties.Controls.Add(this.lblSpawnX);
            this.tabProperties.Controls.Add(this.lblSpawn);
            this.tabProperties.Controls.Add(this.txtBackground);
            this.tabProperties.Controls.Add(this.lblBackground);
            this.tabProperties.Location = new System.Drawing.Point(4, 22);
            this.tabProperties.Name = "tabProperties";
            this.tabProperties.Padding = new System.Windows.Forms.Padding(3);
            this.tabProperties.Size = new System.Drawing.Size(488, 345);
            this.tabProperties.TabIndex = 0;
            this.tabProperties.Text = "Properties";
            this.tabProperties.UseVisualStyleBackColor = true;
            // 
            // btnRemoveColor
            // 
            this.btnRemoveColor.Location = new System.Drawing.Point(9, 242);
            this.btnRemoveColor.Name = "btnRemoveColor";
            this.btnRemoveColor.Size = new System.Drawing.Size(23, 23);
            this.btnRemoveColor.TabIndex = 19;
            this.btnRemoveColor.Text = "-";
            this.btnRemoveColor.UseVisualStyleBackColor = true;
            this.btnRemoveColor.Click += new System.EventHandler(this.BtnRemoveColorClick);
            // 
            // btnAddColor
            // 
            this.btnAddColor.Location = new System.Drawing.Point(9, 212);
            this.btnAddColor.Name = "btnAddColor";
            this.btnAddColor.Size = new System.Drawing.Size(23, 23);
            this.btnAddColor.TabIndex = 18;
            this.btnAddColor.Text = "+";
            this.btnAddColor.UseVisualStyleBackColor = true;
            this.btnAddColor.Click += new System.EventHandler(this.BtnAddColorClick);
            // 
            // listColours
            // 
            this.listColours.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.colorColorHeader});
            this.listColours.FullRowSelect = true;
            this.listColours.GridLines = true;
            this.listColours.Location = new System.Drawing.Point(100, 190);
            this.listColours.MultiSelect = false;
            this.listColours.Name = "listColours";
            this.listColours.Size = new System.Drawing.Size(136, 97);
            this.listColours.TabIndex = 17;
            this.listColours.UseCompatibleStateImageBehavior = false;
            this.listColours.View = System.Windows.Forms.View.Details;
            // 
            // colorColorHeader
            // 
            this.colorColorHeader.Text = "Color";
            this.colorColorHeader.Width = 101;
            // 
            // lblColors
            // 
            this.lblColors.AutoSize = true;
            this.lblColors.Location = new System.Drawing.Point(6, 196);
            this.lblColors.Name = "lblColors";
            this.lblColors.Size = new System.Drawing.Size(36, 13);
            this.lblColors.TabIndex = 16;
            this.lblColors.Text = "Colors";
            // 
            // gboxBackground
            // 
            this.gboxBackground.Controls.Add(this.picboxPreview);
            this.gboxBackground.Location = new System.Drawing.Point(243, 7);
            this.gboxBackground.Name = "gboxBackground";
            this.gboxBackground.Size = new System.Drawing.Size(239, 177);
            this.gboxBackground.TabIndex = 14;
            this.gboxBackground.TabStop = false;
            this.gboxBackground.Text = "Background Preview";
            // 
            // picboxPreview
            // 
            this.picboxPreview.Location = new System.Drawing.Point(6, 19);
            this.picboxPreview.Name = "picboxPreview";
            this.picboxPreview.Size = new System.Drawing.Size(227, 152);
            this.picboxPreview.TabIndex = 1;
            this.picboxPreview.TabStop = false;
            // 
            // btnRemoveSpeedPoint
            // 
            this.btnRemoveSpeedPoint.Location = new System.Drawing.Point(9, 133);
            this.btnRemoveSpeedPoint.Name = "btnRemoveSpeedPoint";
            this.btnRemoveSpeedPoint.Size = new System.Drawing.Size(23, 23);
            this.btnRemoveSpeedPoint.TabIndex = 13;
            this.btnRemoveSpeedPoint.Text = "-";
            this.btnRemoveSpeedPoint.UseVisualStyleBackColor = true;
            this.btnRemoveSpeedPoint.Click += new System.EventHandler(this.BtnRemoveSpeedPointClick);
            // 
            // btnAddSpeedPoint
            // 
            this.btnAddSpeedPoint.Location = new System.Drawing.Point(9, 103);
            this.btnAddSpeedPoint.Name = "btnAddSpeedPoint";
            this.btnAddSpeedPoint.Size = new System.Drawing.Size(23, 23);
            this.btnAddSpeedPoint.TabIndex = 12;
            this.btnAddSpeedPoint.Text = "+";
            this.btnAddSpeedPoint.UseVisualStyleBackColor = true;
            this.btnAddSpeedPoint.Click += new System.EventHandler(this.BtnAddSpeedPointClick);
            // 
            // listSpeedPoints
            // 
            this.listSpeedPoints.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.xHeaderSpeedPoints,
            this.speedHeaderSpeedPoints});
            this.listSpeedPoints.FullRowSelect = true;
            this.listSpeedPoints.GridLines = true;
            this.listSpeedPoints.Location = new System.Drawing.Point(100, 87);
            this.listSpeedPoints.MultiSelect = false;
            this.listSpeedPoints.Name = "listSpeedPoints";
            this.listSpeedPoints.Size = new System.Drawing.Size(136, 97);
            this.listSpeedPoints.TabIndex = 11;
            this.listSpeedPoints.UseCompatibleStateImageBehavior = false;
            this.listSpeedPoints.View = System.Windows.Forms.View.Details;
            // 
            // xHeaderSpeedPoints
            // 
            this.xHeaderSpeedPoints.Text = "X";
            this.xHeaderSpeedPoints.Width = 50;
            // 
            // speedHeaderSpeedPoints
            // 
            this.speedHeaderSpeedPoints.Text = "Speed";
            this.speedHeaderSpeedPoints.Width = 50;
            // 
            // lblSpeedpoints
            // 
            this.lblSpeedpoints.AutoSize = true;
            this.lblSpeedpoints.Location = new System.Drawing.Point(6, 87);
            this.lblSpeedpoints.Name = "lblSpeedpoints";
            this.lblSpeedpoints.Size = new System.Drawing.Size(60, 13);
            this.lblSpeedpoints.TabIndex = 10;
            this.lblSpeedpoints.Text = "Speed at X";
            // 
            // finishXUpDown
            // 
            this.finishXUpDown.Location = new System.Drawing.Point(100, 61);
            this.finishXUpDown.Name = "finishXUpDown";
            this.finishXUpDown.Size = new System.Drawing.Size(42, 20);
            this.finishXUpDown.TabIndex = 9;
            this.finishXUpDown.ValueChanged += new System.EventHandler(this.FinishXUpDownValueChanged);
            // 
            // lblFinishX
            // 
            this.lblFinishX.AutoSize = true;
            this.lblFinishX.Location = new System.Drawing.Point(6, 63);
            this.lblFinishX.Name = "lblFinishX";
            this.lblFinishX.Size = new System.Drawing.Size(50, 13);
            this.lblFinishX.TabIndex = 8;
            this.lblFinishX.Text = "Finishline";
            // 
            // spawnYUpDown
            // 
            this.spawnYUpDown.Location = new System.Drawing.Point(191, 34);
            this.spawnYUpDown.Maximum = new decimal(new int[] {
            10,
            0,
            0,
            0});
            this.spawnYUpDown.Name = "spawnYUpDown";
            this.spawnYUpDown.Size = new System.Drawing.Size(45, 20);
            this.spawnYUpDown.TabIndex = 7;
            this.spawnYUpDown.ValueChanged += new System.EventHandler(this.SpawnYUpDownValueChanged);
            // 
            // lblSpawnY
            // 
            this.lblSpawnY.AutoSize = true;
            this.lblSpawnY.Location = new System.Drawing.Point(168, 36);
            this.lblSpawnY.Name = "lblSpawnY";
            this.lblSpawnY.Size = new System.Drawing.Size(17, 13);
            this.lblSpawnY.TabIndex = 6;
            this.lblSpawnY.Text = "Y:";
            // 
            // spawnXUpDown
            // 
            this.spawnXUpDown.Location = new System.Drawing.Point(120, 34);
            this.spawnXUpDown.Name = "spawnXUpDown";
            this.spawnXUpDown.Size = new System.Drawing.Size(42, 20);
            this.spawnXUpDown.TabIndex = 5;
            this.spawnXUpDown.ValueChanged += new System.EventHandler(this.SpawnXUpDownValueChanged);
            // 
            // lblSpawnX
            // 
            this.lblSpawnX.AutoSize = true;
            this.lblSpawnX.Location = new System.Drawing.Point(97, 36);
            this.lblSpawnX.Name = "lblSpawnX";
            this.lblSpawnX.Size = new System.Drawing.Size(17, 13);
            this.lblSpawnX.TabIndex = 4;
            this.lblSpawnX.Text = "X:";
            // 
            // lblSpawn
            // 
            this.lblSpawn.AutoSize = true;
            this.lblSpawn.Location = new System.Drawing.Point(6, 36);
            this.lblSpawn.Name = "lblSpawn";
            this.lblSpawn.Size = new System.Drawing.Size(40, 13);
            this.lblSpawn.TabIndex = 2;
            this.lblSpawn.Text = "Spawn";
            // 
            // txtBackground
            // 
            this.txtBackground.Location = new System.Drawing.Point(100, 6);
            this.txtBackground.Name = "txtBackground";
            this.txtBackground.Size = new System.Drawing.Size(136, 20);
            this.txtBackground.TabIndex = 1;
            this.txtBackground.TextChanged += new System.EventHandler(this.TxtBackgroundTextChanged);
            // 
            // lblBackground
            // 
            this.lblBackground.AutoSize = true;
            this.lblBackground.Location = new System.Drawing.Point(6, 9);
            this.lblBackground.Name = "lblBackground";
            this.lblBackground.Size = new System.Drawing.Size(65, 13);
            this.lblBackground.TabIndex = 0;
            this.lblBackground.Text = "Background";
            // 
            // tabActors
            // 
            this.tabActors.Controls.Add(this.pnlStaticProperties);
            this.tabActors.Controls.Add(this.tabControl);
            this.tabActors.Controls.Add(this.pnlProperties);
            this.tabActors.Controls.Add(this.pnlDynProperties);
            this.tabActors.Location = new System.Drawing.Point(4, 22);
            this.tabActors.Name = "tabActors";
            this.tabActors.Padding = new System.Windows.Forms.Padding(3);
            this.tabActors.Size = new System.Drawing.Size(488, 345);
            this.tabActors.TabIndex = 1;
            this.tabActors.Text = "Actors";
            this.tabActors.UseVisualStyleBackColor = true;
            // 
            // pnlStaticProperties
            // 
            this.pnlStaticProperties.Controls.Add(this.chkBreakable);
            this.pnlStaticProperties.Location = new System.Drawing.Point(213, 169);
            this.pnlStaticProperties.Name = "pnlStaticProperties";
            this.pnlStaticProperties.Size = new System.Drawing.Size(257, 51);
            this.pnlStaticProperties.TabIndex = 11;
            this.pnlStaticProperties.TabStop = false;
            this.pnlStaticProperties.Text = "Static Properties";
            // 
            // chkBreakable
            // 
            this.chkBreakable.AutoSize = true;
            this.chkBreakable.Location = new System.Drawing.Point(7, 20);
            this.chkBreakable.Name = "chkBreakable";
            this.chkBreakable.Size = new System.Drawing.Size(74, 17);
            this.chkBreakable.TabIndex = 0;
            this.chkBreakable.Text = "Breakable";
            this.chkBreakable.UseVisualStyleBackColor = true;
            this.chkBreakable.CheckedChanged += new System.EventHandler(this.ChkBreakableCheckedChanged);
            // 
            // tabControl
            // 
            this.tabControl.Controls.Add(this.tabEnemy);
            this.tabControl.Controls.Add(this.tabLevel);
            this.tabControl.Location = new System.Drawing.Point(6, 6);
            this.tabControl.Name = "tabControl";
            this.tabControl.SelectedIndex = 0;
            this.tabControl.Size = new System.Drawing.Size(200, 333);
            this.tabControl.TabIndex = 8;
            // 
            // tabEnemy
            // 
            this.tabEnemy.Controls.Add(this.btnRemoveEnemy);
            this.tabEnemy.Controls.Add(this.btnAddEnemy);
            this.tabEnemy.Controls.Add(this.listEnemies);
            this.tabEnemy.Location = new System.Drawing.Point(4, 22);
            this.tabEnemy.Name = "tabEnemy";
            this.tabEnemy.Padding = new System.Windows.Forms.Padding(3);
            this.tabEnemy.Size = new System.Drawing.Size(192, 307);
            this.tabEnemy.TabIndex = 0;
            this.tabEnemy.Text = "Enemy";
            this.tabEnemy.UseVisualStyleBackColor = true;
            // 
            // btnRemoveEnemy
            // 
            this.btnRemoveEnemy.Location = new System.Drawing.Point(114, 278);
            this.btnRemoveEnemy.Name = "btnRemoveEnemy";
            this.btnRemoveEnemy.Size = new System.Drawing.Size(75, 23);
            this.btnRemoveEnemy.TabIndex = 2;
            this.btnRemoveEnemy.Text = "Remove";
            this.btnRemoveEnemy.UseVisualStyleBackColor = true;
            this.btnRemoveEnemy.Click += new System.EventHandler(this.BtnRemoveEnemyClick);
            // 
            // btnAddEnemy
            // 
            this.btnAddEnemy.Location = new System.Drawing.Point(6, 278);
            this.btnAddEnemy.Name = "btnAddEnemy";
            this.btnAddEnemy.Size = new System.Drawing.Size(75, 23);
            this.btnAddEnemy.TabIndex = 1;
            this.btnAddEnemy.Text = "Add";
            this.btnAddEnemy.UseVisualStyleBackColor = true;
            this.btnAddEnemy.Click += new System.EventHandler(this.BtnAddEnemyClick);
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
            this.listEnemies.Size = new System.Drawing.Size(192, 272);
            this.listEnemies.TabIndex = 0;
            this.listEnemies.TileSize = new System.Drawing.Size(189, 20);
            this.listEnemies.UseCompatibleStateImageBehavior = false;
            this.listEnemies.View = System.Windows.Forms.View.Details;
            this.listEnemies.SelectedIndexChanged += new System.EventHandler(this.ListEnemiesSelectedIndexChanged);
            // 
            // nameEnemyColumnHeader
            // 
            this.nameEnemyColumnHeader.Text = "Name";
            this.nameEnemyColumnHeader.Width = 150;
            // 
            // tabLevel
            // 
            this.tabLevel.Controls.Add(this.btnRemoveLevel);
            this.tabLevel.Controls.Add(this.btnAddLevel);
            this.tabLevel.Controls.Add(this.listLevels);
            this.tabLevel.Location = new System.Drawing.Point(4, 22);
            this.tabLevel.Name = "tabLevel";
            this.tabLevel.Padding = new System.Windows.Forms.Padding(3);
            this.tabLevel.Size = new System.Drawing.Size(192, 307);
            this.tabLevel.TabIndex = 1;
            this.tabLevel.Text = "Level";
            this.tabLevel.UseVisualStyleBackColor = true;
            // 
            // btnRemoveLevel
            // 
            this.btnRemoveLevel.Location = new System.Drawing.Point(111, 278);
            this.btnRemoveLevel.Name = "btnRemoveLevel";
            this.btnRemoveLevel.Size = new System.Drawing.Size(75, 23);
            this.btnRemoveLevel.TabIndex = 2;
            this.btnRemoveLevel.Text = "Remove";
            this.btnRemoveLevel.UseVisualStyleBackColor = true;
            this.btnRemoveLevel.Click += new System.EventHandler(this.BtnRemoveLevelClick);
            // 
            // btnAddLevel
            // 
            this.btnAddLevel.Location = new System.Drawing.Point(6, 278);
            this.btnAddLevel.Name = "btnAddLevel";
            this.btnAddLevel.Size = new System.Drawing.Size(75, 23);
            this.btnAddLevel.TabIndex = 1;
            this.btnAddLevel.Text = "Add";
            this.btnAddLevel.UseVisualStyleBackColor = true;
            this.btnAddLevel.Click += new System.EventHandler(this.BtnAddLevelClick);
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
            this.listLevels.Size = new System.Drawing.Size(192, 272);
            this.listLevels.TabIndex = 0;
            this.listLevels.UseCompatibleStateImageBehavior = false;
            this.listLevels.View = System.Windows.Forms.View.Details;
            this.listLevels.SelectedIndexChanged += new System.EventHandler(this.ListLevelsSelectedIndexChanged);
            // 
            // nameLevelColumnHeader
            // 
            this.nameLevelColumnHeader.Text = "Name";
            this.nameLevelColumnHeader.Width = 150;
            // 
            // pnlProperties
            // 
            this.pnlProperties.Controls.Add(this.heightUpDown);
            this.pnlProperties.Controls.Add(this.btnRemovePolygon);
            this.pnlProperties.Controls.Add(this.lblHeight);
            this.pnlProperties.Controls.Add(this.widthUpDown);
            this.pnlProperties.Controls.Add(this.label1);
            this.pnlProperties.Controls.Add(this.lblWidth);
            this.pnlProperties.Controls.Add(this.btnAddPolygon);
            this.pnlProperties.Controls.Add(this.listPolygons);
            this.pnlProperties.Controls.Add(this.scaleUpDown);
            this.pnlProperties.Controls.Add(this.lblPolygons);
            this.pnlProperties.Controls.Add(this.txtName);
            this.pnlProperties.Controls.Add(this.lblName);
            this.pnlProperties.Location = new System.Drawing.Point(213, 6);
            this.pnlProperties.Name = "pnlProperties";
            this.pnlProperties.Size = new System.Drawing.Size(266, 156);
            this.pnlProperties.TabIndex = 9;
            this.pnlProperties.TabStop = false;
            this.pnlProperties.Text = "Properties";
            // 
            // heightUpDown
            // 
            this.heightUpDown.DecimalPlaces = 1;
            this.heightUpDown.Location = new System.Drawing.Point(210, 126);
            this.heightUpDown.Maximum = new decimal(new int[] {
            256,
            0,
            0,
            0});
            this.heightUpDown.Name = "heightUpDown";
            this.heightUpDown.Size = new System.Drawing.Size(47, 20);
            this.heightUpDown.TabIndex = 14;
            this.heightUpDown.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.heightUpDown.ValueChanged += new System.EventHandler(this.HeightUpDownValueChanged);
            // 
            // btnRemovePolygon
            // 
            this.btnRemovePolygon.Location = new System.Drawing.Point(92, 46);
            this.btnRemovePolygon.Name = "btnRemovePolygon";
            this.btnRemovePolygon.Size = new System.Drawing.Size(23, 23);
            this.btnRemovePolygon.TabIndex = 11;
            this.btnRemovePolygon.Text = "-";
            this.btnRemovePolygon.UseVisualStyleBackColor = true;
            this.btnRemovePolygon.Click += new System.EventHandler(this.BtnRemovePolygonClick);
            // 
            // lblHeight
            // 
            this.lblHeight.AutoSize = true;
            this.lblHeight.Location = new System.Drawing.Point(165, 126);
            this.lblHeight.Name = "lblHeight";
            this.lblHeight.Size = new System.Drawing.Size(38, 13);
            this.lblHeight.TabIndex = 6;
            this.lblHeight.Text = "Height";
            // 
            // widthUpDown
            // 
            this.widthUpDown.DecimalPlaces = 1;
            this.widthUpDown.Location = new System.Drawing.Point(210, 97);
            this.widthUpDown.Maximum = new decimal(new int[] {
            256,
            0,
            0,
            0});
            this.widthUpDown.Name = "widthUpDown";
            this.widthUpDown.Size = new System.Drawing.Size(47, 20);
            this.widthUpDown.TabIndex = 13;
            this.widthUpDown.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.widthUpDown.ValueChanged += new System.EventHandler(this.WidthUpDownValueChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(166, 74);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(34, 13);
            this.label1.TabIndex = 3;
            this.label1.Text = "Scale";
            // 
            // lblWidth
            // 
            this.lblWidth.AutoSize = true;
            this.lblWidth.Location = new System.Drawing.Point(165, 99);
            this.lblWidth.Name = "lblWidth";
            this.lblWidth.Size = new System.Drawing.Size(35, 13);
            this.lblWidth.TabIndex = 4;
            this.lblWidth.Text = "Width";
            // 
            // btnAddPolygon
            // 
            this.btnAddPolygon.Location = new System.Drawing.Point(63, 46);
            this.btnAddPolygon.Name = "btnAddPolygon";
            this.btnAddPolygon.Size = new System.Drawing.Size(23, 23);
            this.btnAddPolygon.TabIndex = 10;
            this.btnAddPolygon.Text = "+";
            this.btnAddPolygon.UseVisualStyleBackColor = true;
            this.btnAddPolygon.Click += new System.EventHandler(this.BtnAddPolygonClick);
            // 
            // listPolygons
            // 
            this.listPolygons.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.polyXColumnHeader,
            this.polyYColumnHeader});
            this.listPolygons.FullRowSelect = true;
            this.listPolygons.GridLines = true;
            this.listPolygons.Location = new System.Drawing.Point(10, 74);
            this.listPolygons.MultiSelect = false;
            this.listPolygons.Name = "listPolygons";
            this.listPolygons.Size = new System.Drawing.Size(149, 76);
            this.listPolygons.TabIndex = 9;
            this.listPolygons.UseCompatibleStateImageBehavior = false;
            this.listPolygons.View = System.Windows.Forms.View.Details;
            // 
            // polyXColumnHeader
            // 
            this.polyXColumnHeader.Text = "X-coord";
            this.polyXColumnHeader.Width = 50;
            // 
            // polyYColumnHeader
            // 
            this.polyYColumnHeader.Text = "Y-coord";
            this.polyYColumnHeader.Width = 50;
            // 
            // scaleUpDown
            // 
            this.scaleUpDown.DecimalPlaces = 2;
            this.scaleUpDown.Increment = new decimal(new int[] {
            25,
            0,
            0,
            131072});
            this.scaleUpDown.Location = new System.Drawing.Point(210, 72);
            this.scaleUpDown.Name = "scaleUpDown";
            this.scaleUpDown.Size = new System.Drawing.Size(47, 20);
            this.scaleUpDown.TabIndex = 12;
            this.scaleUpDown.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.scaleUpDown.ValueChanged += new System.EventHandler(this.ScaleUpDownValueChanged);
            // 
            // lblPolygons
            // 
            this.lblPolygons.AutoSize = true;
            this.lblPolygons.Location = new System.Drawing.Point(7, 51);
            this.lblPolygons.Name = "lblPolygons";
            this.lblPolygons.Size = new System.Drawing.Size(50, 13);
            this.lblPolygons.TabIndex = 8;
            this.lblPolygons.Text = "Polygons";
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(48, 17);
            this.txtName.MaxLength = 128;
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(209, 20);
            this.txtName.TabIndex = 1;
            this.txtName.TextChanged += new System.EventHandler(this.TxtNameTextChanged);
            // 
            // lblName
            // 
            this.lblName.AutoSize = true;
            this.lblName.Location = new System.Drawing.Point(7, 20);
            this.lblName.Name = "lblName";
            this.lblName.Size = new System.Drawing.Size(35, 13);
            this.lblName.TabIndex = 0;
            this.lblName.Text = "Name";
            // 
            // pnlDynProperties
            // 
            this.pnlDynProperties.Controls.Add(this.listAnimations);
            this.pnlDynProperties.Controls.Add(this.btnRemoveAnimation);
            this.pnlDynProperties.Controls.Add(this.btnAddAnimation);
            this.pnlDynProperties.Controls.Add(this.lblAnimations);
            this.pnlDynProperties.Controls.Add(this.healthUpDown);
            this.pnlDynProperties.Controls.Add(this.lblHealth);
            this.pnlDynProperties.Controls.Add(this.speedUpDown);
            this.pnlDynProperties.Controls.Add(this.lblSpeed);
            this.pnlDynProperties.Location = new System.Drawing.Point(213, 226);
            this.pnlDynProperties.Name = "pnlDynProperties";
            this.pnlDynProperties.Size = new System.Drawing.Size(266, 113);
            this.pnlDynProperties.TabIndex = 10;
            this.pnlDynProperties.TabStop = false;
            this.pnlDynProperties.Text = "Dynamic Properties";
            // 
            // listAnimations
            // 
            this.listAnimations.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.typeAnimationColumnHeader,
            this.lengthAnimationColumnHeader});
            this.listAnimations.FullRowSelect = true;
            this.listAnimations.GridLines = true;
            this.listAnimations.Location = new System.Drawing.Point(92, 14);
            this.listAnimations.MultiSelect = false;
            this.listAnimations.Name = "listAnimations";
            this.listAnimations.Size = new System.Drawing.Size(165, 92);
            this.listAnimations.TabIndex = 11;
            this.listAnimations.UseCompatibleStateImageBehavior = false;
            this.listAnimations.View = System.Windows.Forms.View.Details;
            // 
            // typeAnimationColumnHeader
            // 
            this.typeAnimationColumnHeader.Text = "Type";
            this.typeAnimationColumnHeader.Width = 76;
            // 
            // lengthAnimationColumnHeader
            // 
            this.lengthAnimationColumnHeader.Text = "Length";
            this.lengthAnimationColumnHeader.Width = 50;
            // 
            // btnRemoveAnimation
            // 
            this.btnRemoveAnimation.Location = new System.Drawing.Point(41, 82);
            this.btnRemoveAnimation.Name = "btnRemoveAnimation";
            this.btnRemoveAnimation.Size = new System.Drawing.Size(23, 23);
            this.btnRemoveAnimation.TabIndex = 10;
            this.btnRemoveAnimation.Text = "-";
            this.btnRemoveAnimation.UseVisualStyleBackColor = true;
            this.btnRemoveAnimation.Click += new System.EventHandler(this.BtnRemoveAnimationClick);
            // 
            // btnAddAnimation
            // 
            this.btnAddAnimation.Location = new System.Drawing.Point(6, 82);
            this.btnAddAnimation.Name = "btnAddAnimation";
            this.btnAddAnimation.Size = new System.Drawing.Size(23, 23);
            this.btnAddAnimation.TabIndex = 9;
            this.btnAddAnimation.Text = "+";
            this.btnAddAnimation.UseVisualStyleBackColor = true;
            this.btnAddAnimation.Click += new System.EventHandler(this.BtnAddAnimationClick);
            // 
            // lblAnimations
            // 
            this.lblAnimations.AutoSize = true;
            this.lblAnimations.Location = new System.Drawing.Point(6, 63);
            this.lblAnimations.Name = "lblAnimations";
            this.lblAnimations.Size = new System.Drawing.Size(58, 13);
            this.lblAnimations.TabIndex = 8;
            this.lblAnimations.Text = "Animations";
            // 
            // healthUpDown
            // 
            this.healthUpDown.Location = new System.Drawing.Point(51, 14);
            this.healthUpDown.Maximum = new decimal(new int[] {
            999,
            0,
            0,
            0});
            this.healthUpDown.Name = "healthUpDown";
            this.healthUpDown.Size = new System.Drawing.Size(35, 20);
            this.healthUpDown.TabIndex = 3;
            this.healthUpDown.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.healthUpDown.ValueChanged += new System.EventHandler(this.HealthUpDownValueChanged);
            // 
            // lblHealth
            // 
            this.lblHealth.AutoSize = true;
            this.lblHealth.Location = new System.Drawing.Point(7, 16);
            this.lblHealth.Name = "lblHealth";
            this.lblHealth.Size = new System.Drawing.Size(38, 13);
            this.lblHealth.TabIndex = 2;
            this.lblHealth.Text = "Health";
            // 
            // speedUpDown
            // 
            this.speedUpDown.DecimalPlaces = 1;
            this.speedUpDown.Increment = new decimal(new int[] {
            5,
            0,
            0,
            65536});
            this.speedUpDown.Location = new System.Drawing.Point(51, 40);
            this.speedUpDown.Maximum = new decimal(new int[] {
            20,
            0,
            0,
            0});
            this.speedUpDown.Name = "speedUpDown";
            this.speedUpDown.Size = new System.Drawing.Size(35, 20);
            this.speedUpDown.TabIndex = 1;
            this.speedUpDown.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.speedUpDown.ValueChanged += new System.EventHandler(this.SpeedUpDownValueChanged);
            // 
            // lblSpeed
            // 
            this.lblSpeed.AutoSize = true;
            this.lblSpeed.Location = new System.Drawing.Point(7, 42);
            this.lblSpeed.Name = "lblSpeed";
            this.lblSpeed.Size = new System.Drawing.Size(38, 13);
            this.lblSpeed.TabIndex = 0;
            this.lblSpeed.Text = "Speed";
            // 
            // btnSave
            // 
            this.btnSave.Location = new System.Drawing.Point(439, 389);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(75, 23);
            this.btnSave.TabIndex = 11;
            this.btnSave.Text = "Save";
            this.btnSave.UseVisualStyleBackColor = true;
            this.btnSave.Click += new System.EventHandler(this.BtnSave);
            // 
            // PropertiesForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(517, 415);
            this.Controls.Add(this.tabControl1);
            this.Controls.Add(this.btnSave);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "PropertiesForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Properties";
            this.tabControl1.ResumeLayout(false);
            this.tabProperties.ResumeLayout(false);
            this.tabProperties.PerformLayout();
            this.gboxBackground.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.picboxPreview)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.finishXUpDown)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.spawnYUpDown)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.spawnXUpDown)).EndInit();
            this.tabActors.ResumeLayout(false);
            this.pnlStaticProperties.ResumeLayout(false);
            this.pnlStaticProperties.PerformLayout();
            this.tabControl.ResumeLayout(false);
            this.tabEnemy.ResumeLayout(false);
            this.tabLevel.ResumeLayout(false);
            this.pnlProperties.ResumeLayout(false);
            this.pnlProperties.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.heightUpDown)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.widthUpDown)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.scaleUpDown)).EndInit();
            this.pnlDynProperties.ResumeLayout(false);
            this.pnlDynProperties.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.healthUpDown)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.speedUpDown)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bulletBindingSource)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tabProperties;
        private System.Windows.Forms.TabPage tabActors;
        private System.Windows.Forms.TabControl tabControl;
        private System.Windows.Forms.TabPage tabEnemy;
        private System.Windows.Forms.Button btnRemoveEnemy;
        private System.Windows.Forms.Button btnAddEnemy;
        private System.Windows.Forms.ListView listEnemies;
        private System.Windows.Forms.ColumnHeader nameEnemyColumnHeader;
        private System.Windows.Forms.TabPage tabLevel;
        private System.Windows.Forms.Button btnRemoveLevel;
        private System.Windows.Forms.Button btnAddLevel;
        private System.Windows.Forms.ListView listLevels;
        private System.Windows.Forms.ColumnHeader nameLevelColumnHeader;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.GroupBox pnlProperties;
        private System.Windows.Forms.Button btnRemovePolygon;
        private System.Windows.Forms.Button btnAddPolygon;
        private System.Windows.Forms.ListView listPolygons;
        private System.Windows.Forms.ColumnHeader polyXColumnHeader;
        private System.Windows.Forms.ColumnHeader polyYColumnHeader;
        private System.Windows.Forms.Label lblPolygons;
        private System.Windows.Forms.Label lblHeight;
        private System.Windows.Forms.Label lblWidth;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.Label lblName;
        private System.Windows.Forms.GroupBox pnlDynProperties;
        private System.Windows.Forms.NumericUpDown heightUpDown;
        private System.Windows.Forms.NumericUpDown widthUpDown;
        private System.Windows.Forms.NumericUpDown scaleUpDown;
        private System.Windows.Forms.NumericUpDown healthUpDown;
        private System.Windows.Forms.Label lblHealth;
        private System.Windows.Forms.NumericUpDown speedUpDown;
        private System.Windows.Forms.Label lblSpeed;
        private System.Windows.Forms.BindingSource bulletBindingSource;
        private System.Windows.Forms.Button btnAddAnimation;
        private System.Windows.Forms.Label lblAnimations;
        private System.Windows.Forms.ListView listAnimations;
        private System.Windows.Forms.ColumnHeader typeAnimationColumnHeader;
        private System.Windows.Forms.ColumnHeader lengthAnimationColumnHeader;
        private System.Windows.Forms.Button btnRemoveAnimation;
        private System.Windows.Forms.TextBox txtBackground;
        private System.Windows.Forms.Label lblBackground;
        private System.Windows.Forms.NumericUpDown spawnYUpDown;
        private System.Windows.Forms.Label lblSpawnY;
        private System.Windows.Forms.NumericUpDown spawnXUpDown;
        private System.Windows.Forms.Label lblSpawnX;
        private System.Windows.Forms.Label lblSpawn;
        private System.Windows.Forms.NumericUpDown finishXUpDown;
        private System.Windows.Forms.Label lblFinishX;
        private System.Windows.Forms.GroupBox gboxBackground;
        private System.Windows.Forms.Button btnRemoveSpeedPoint;
        private System.Windows.Forms.Button btnAddSpeedPoint;
        private System.Windows.Forms.ListView listSpeedPoints;
        private System.Windows.Forms.ColumnHeader xHeaderSpeedPoints;
        private System.Windows.Forms.ColumnHeader speedHeaderSpeedPoints;
        private System.Windows.Forms.Label lblSpeedpoints;
        private System.Windows.Forms.PictureBox picboxPreview;
        private System.Windows.Forms.ListView listColours;
        private System.Windows.Forms.ColumnHeader colorColorHeader;
        private System.Windows.Forms.Label lblColors;
        private System.Windows.Forms.Button btnRemoveColor;
        private System.Windows.Forms.Button btnAddColor;
        private System.Windows.Forms.GroupBox pnlStaticProperties;
        private System.Windows.Forms.CheckBox chkBreakable;

    }
}