namespace MapEditor
{
    partial class ActorEditor
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
            this.tabControl = new System.Windows.Forms.TabControl();
            this.tabEnemy = new System.Windows.Forms.TabPage();
            this.btnRemoveEnemy = new System.Windows.Forms.Button();
            this.btnAddEnemy = new System.Windows.Forms.Button();
            this.listEnemies = new System.Windows.Forms.ListView();
            this.tabLevel = new System.Windows.Forms.TabPage();
            this.btnRemoveLevel = new System.Windows.Forms.Button();
            this.btnAddLevel = new System.Windows.Forms.Button();
            this.listLevels = new System.Windows.Forms.ListView();
            this.pnlProperties = new System.Windows.Forms.GroupBox();
            this.button1 = new System.Windows.Forms.Button();
            this.btnAddPolygon = new System.Windows.Forms.Button();
            this.listPolygons = new System.Windows.Forms.ListView();
            this.lblPolygons = new System.Windows.Forms.Label();
            this.txtHeight = new System.Windows.Forms.TextBox();
            this.lblHeight = new System.Windows.Forms.Label();
            this.txtWidth = new System.Windows.Forms.TextBox();
            this.lblWidth = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.txtScale = new System.Windows.Forms.TextBox();
            this.txtName = new System.Windows.Forms.TextBox();
            this.lblName = new System.Windows.Forms.Label();
            this.pnlDynProperties = new System.Windows.Forms.GroupBox();
            this.btnSave = new System.Windows.Forms.Button();
            this.tabControl.SuspendLayout();
            this.tabEnemy.SuspendLayout();
            this.tabLevel.SuspendLayout();
            this.pnlProperties.SuspendLayout();
            this.SuspendLayout();
            // 
            // tabControl
            // 
            this.tabControl.Controls.Add(this.tabEnemy);
            this.tabControl.Controls.Add(this.tabLevel);
            this.tabControl.Location = new System.Drawing.Point(13, 13);
            this.tabControl.Name = "tabControl";
            this.tabControl.SelectedIndex = 0;
            this.tabControl.Size = new System.Drawing.Size(200, 293);
            this.tabControl.TabIndex = 0;
            // 
            // tabEnemy
            // 
            this.tabEnemy.Controls.Add(this.btnRemoveEnemy);
            this.tabEnemy.Controls.Add(this.btnAddEnemy);
            this.tabEnemy.Controls.Add(this.listEnemies);
            this.tabEnemy.Location = new System.Drawing.Point(4, 22);
            this.tabEnemy.Name = "tabEnemy";
            this.tabEnemy.Padding = new System.Windows.Forms.Padding(3);
            this.tabEnemy.Size = new System.Drawing.Size(192, 267);
            this.tabEnemy.TabIndex = 0;
            this.tabEnemy.Text = "Enemy";
            this.tabEnemy.UseVisualStyleBackColor = true;
            // 
            // btnRemoveEnemy
            // 
            this.btnRemoveEnemy.Location = new System.Drawing.Point(111, 241);
            this.btnRemoveEnemy.Name = "btnRemoveEnemy";
            this.btnRemoveEnemy.Size = new System.Drawing.Size(75, 23);
            this.btnRemoveEnemy.TabIndex = 2;
            this.btnRemoveEnemy.Text = "Remove";
            this.btnRemoveEnemy.UseVisualStyleBackColor = true;
            // 
            // btnAddEnemy
            // 
            this.btnAddEnemy.Location = new System.Drawing.Point(6, 241);
            this.btnAddEnemy.Name = "btnAddEnemy";
            this.btnAddEnemy.Size = new System.Drawing.Size(75, 23);
            this.btnAddEnemy.TabIndex = 1;
            this.btnAddEnemy.Text = "Add";
            this.btnAddEnemy.UseVisualStyleBackColor = true;
            this.btnAddEnemy.Click += new System.EventHandler(this.BtnAddEnemyClick);
            // 
            // listEnemies
            // 
            this.listEnemies.Location = new System.Drawing.Point(0, 0);
            this.listEnemies.MultiSelect = false;
            this.listEnemies.Name = "listEnemies";
            this.listEnemies.Size = new System.Drawing.Size(189, 235);
            this.listEnemies.TabIndex = 0;
            this.listEnemies.UseCompatibleStateImageBehavior = false;
            this.listEnemies.View = System.Windows.Forms.View.List;
            // 
            // tabLevel
            // 
            this.tabLevel.Controls.Add(this.btnRemoveLevel);
            this.tabLevel.Controls.Add(this.btnAddLevel);
            this.tabLevel.Controls.Add(this.listLevels);
            this.tabLevel.Location = new System.Drawing.Point(4, 22);
            this.tabLevel.Name = "tabLevel";
            this.tabLevel.Padding = new System.Windows.Forms.Padding(3);
            this.tabLevel.Size = new System.Drawing.Size(192, 267);
            this.tabLevel.TabIndex = 1;
            this.tabLevel.Text = "Level";
            this.tabLevel.UseVisualStyleBackColor = true;
            // 
            // btnRemoveLevel
            // 
            this.btnRemoveLevel.Location = new System.Drawing.Point(111, 241);
            this.btnRemoveLevel.Name = "btnRemoveLevel";
            this.btnRemoveLevel.Size = new System.Drawing.Size(75, 23);
            this.btnRemoveLevel.TabIndex = 2;
            this.btnRemoveLevel.Text = "Remove";
            this.btnRemoveLevel.UseVisualStyleBackColor = true;
            // 
            // btnAddLevel
            // 
            this.btnAddLevel.Location = new System.Drawing.Point(6, 241);
            this.btnAddLevel.Name = "btnAddLevel";
            this.btnAddLevel.Size = new System.Drawing.Size(75, 23);
            this.btnAddLevel.TabIndex = 1;
            this.btnAddLevel.Text = "Add";
            this.btnAddLevel.UseVisualStyleBackColor = true;
            this.btnAddLevel.Click += new System.EventHandler(this.BtnAddLevelClick);
            // 
            // listLevels
            // 
            this.listLevels.Location = new System.Drawing.Point(0, 0);
            this.listLevels.Name = "listLevels";
            this.listLevels.Size = new System.Drawing.Size(192, 235);
            this.listLevels.TabIndex = 0;
            this.listLevels.UseCompatibleStateImageBehavior = false;
            // 
            // pnlProperties
            // 
            this.pnlProperties.Controls.Add(this.button1);
            this.pnlProperties.Controls.Add(this.btnAddPolygon);
            this.pnlProperties.Controls.Add(this.listPolygons);
            this.pnlProperties.Controls.Add(this.lblPolygons);
            this.pnlProperties.Controls.Add(this.txtHeight);
            this.pnlProperties.Controls.Add(this.lblHeight);
            this.pnlProperties.Controls.Add(this.txtWidth);
            this.pnlProperties.Controls.Add(this.lblWidth);
            this.pnlProperties.Controls.Add(this.label1);
            this.pnlProperties.Controls.Add(this.txtScale);
            this.pnlProperties.Controls.Add(this.txtName);
            this.pnlProperties.Controls.Add(this.lblName);
            this.pnlProperties.Location = new System.Drawing.Point(220, 13);
            this.pnlProperties.Name = "pnlProperties";
            this.pnlProperties.Size = new System.Drawing.Size(252, 133);
            this.pnlProperties.TabIndex = 1;
            this.pnlProperties.TabStop = false;
            this.pnlProperties.Text = "Properties";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(218, 103);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(23, 23);
            this.button1.TabIndex = 11;
            this.button1.Text = "-";
            this.button1.UseVisualStyleBackColor = true;
            // 
            // btnAddPolygon
            // 
            this.btnAddPolygon.Location = new System.Drawing.Point(218, 74);
            this.btnAddPolygon.Name = "btnAddPolygon";
            this.btnAddPolygon.Size = new System.Drawing.Size(23, 23);
            this.btnAddPolygon.TabIndex = 10;
            this.btnAddPolygon.Text = "+";
            this.btnAddPolygon.UseVisualStyleBackColor = true;
            // 
            // listPolygons
            // 
            this.listPolygons.Location = new System.Drawing.Point(63, 74);
            this.listPolygons.Name = "listPolygons";
            this.listPolygons.Size = new System.Drawing.Size(149, 52);
            this.listPolygons.TabIndex = 9;
            this.listPolygons.UseCompatibleStateImageBehavior = false;
            // 
            // lblPolygons
            // 
            this.lblPolygons.AutoSize = true;
            this.lblPolygons.Location = new System.Drawing.Point(7, 74);
            this.lblPolygons.Name = "lblPolygons";
            this.lblPolygons.Size = new System.Drawing.Size(50, 13);
            this.lblPolygons.TabIndex = 8;
            this.lblPolygons.Text = "Polygons";
            // 
            // txtHeight
            // 
            this.txtHeight.Location = new System.Drawing.Point(209, 44);
            this.txtHeight.Name = "txtHeight";
            this.txtHeight.Size = new System.Drawing.Size(32, 20);
            this.txtHeight.TabIndex = 7;
            // 
            // lblHeight
            // 
            this.lblHeight.AutoSize = true;
            this.lblHeight.Location = new System.Drawing.Point(165, 47);
            this.lblHeight.Name = "lblHeight";
            this.lblHeight.Size = new System.Drawing.Size(38, 13);
            this.lblHeight.TabIndex = 6;
            this.lblHeight.Text = "Height";
            // 
            // txtWidth
            // 
            this.txtWidth.Location = new System.Drawing.Point(127, 44);
            this.txtWidth.Name = "txtWidth";
            this.txtWidth.Size = new System.Drawing.Size(32, 20);
            this.txtWidth.TabIndex = 5;
            // 
            // lblWidth
            // 
            this.lblWidth.AutoSize = true;
            this.lblWidth.Location = new System.Drawing.Point(86, 47);
            this.lblWidth.Name = "lblWidth";
            this.lblWidth.Size = new System.Drawing.Size(35, 13);
            this.lblWidth.TabIndex = 4;
            this.lblWidth.Text = "Width";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(7, 47);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(34, 13);
            this.label1.TabIndex = 3;
            this.label1.Text = "Scale";
            // 
            // txtScale
            // 
            this.txtScale.Location = new System.Drawing.Point(48, 44);
            this.txtScale.Name = "txtScale";
            this.txtScale.Size = new System.Drawing.Size(32, 20);
            this.txtScale.TabIndex = 2;
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(48, 17);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(193, 20);
            this.txtName.TabIndex = 1;
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
            this.pnlDynProperties.Location = new System.Drawing.Point(220, 152);
            this.pnlDynProperties.Name = "pnlDynProperties";
            this.pnlDynProperties.Size = new System.Drawing.Size(252, 183);
            this.pnlDynProperties.TabIndex = 2;
            this.pnlDynProperties.TabStop = false;
            this.pnlDynProperties.Text = "Dynamic Properties";
            // 
            // btnSave
            // 
            this.btnSave.Location = new System.Drawing.Point(13, 312);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(75, 23);
            this.btnSave.TabIndex = 3;
            this.btnSave.Text = "Save";
            this.btnSave.UseVisualStyleBackColor = true;
            this.btnSave.Click += new System.EventHandler(this.SaveActors);
            // 
            // ActorEditor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(484, 347);
            this.Controls.Add(this.btnSave);
            this.Controls.Add(this.pnlDynProperties);
            this.Controls.Add(this.pnlProperties);
            this.Controls.Add(this.tabControl);
            this.Name = "ActorEditor";
            this.Text = "ActorEditor";
            this.tabControl.ResumeLayout(false);
            this.tabEnemy.ResumeLayout(false);
            this.tabLevel.ResumeLayout(false);
            this.pnlProperties.ResumeLayout(false);
            this.pnlProperties.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl tabControl;
        private System.Windows.Forms.TabPage tabEnemy;
        private System.Windows.Forms.TabPage tabLevel;
        private System.Windows.Forms.GroupBox pnlProperties;
        private System.Windows.Forms.GroupBox pnlDynProperties;
        private System.Windows.Forms.TextBox txtScale;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.Label lblName;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lblWidth;
        private System.Windows.Forms.TextBox txtHeight;
        private System.Windows.Forms.Label lblHeight;
        private System.Windows.Forms.TextBox txtWidth;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button btnAddPolygon;
        private System.Windows.Forms.ListView listPolygons;
        private System.Windows.Forms.Label lblPolygons;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.ListView listEnemies;
        private System.Windows.Forms.ListView listLevels;
        private System.Windows.Forms.Button btnRemoveEnemy;
        private System.Windows.Forms.Button btnAddEnemy;
        private System.Windows.Forms.Button btnRemoveLevel;
        private System.Windows.Forms.Button btnAddLevel;
    }
}