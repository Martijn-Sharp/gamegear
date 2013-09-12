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
            this.damageBox = new System.Windows.Forms.TextBox();
            this.enemyBox = new System.Windows.Forms.TextBox();
            this.levelBox = new System.Windows.Forms.TextBox();
            this.specialBox = new System.Windows.Forms.TextBox();
            this.exportButton = new System.Windows.Forms.Button();
            this.importButton = new System.Windows.Forms.Button();
            this.damageButton = new System.Windows.Forms.RadioButton();
            this.enemyButton = new System.Windows.Forms.RadioButton();
            this.levelButton = new System.Windows.Forms.RadioButton();
            this.specialButton = new System.Windows.Forms.RadioButton();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // clearButton
            // 
            this.clearButton.Location = new System.Drawing.Point(533, 12);
            this.clearButton.Name = "clearButton";
            this.clearButton.Size = new System.Drawing.Size(75, 33);
            this.clearButton.TabIndex = 4;
            this.clearButton.Text = "Clear";
            this.clearButton.UseVisualStyleBackColor = true;
            this.clearButton.Click += new System.EventHandler(this.clearButton_Click);
            // 
            // damageBox
            // 
            this.damageBox.Location = new System.Drawing.Point(0, 54);
            this.damageBox.Name = "damageBox";
            this.damageBox.Size = new System.Drawing.Size(74, 22);
            this.damageBox.TabIndex = 5;
            this.damageBox.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.intOnly_KeyPress);
            // 
            // enemyBox
            // 
            this.enemyBox.Location = new System.Drawing.Point(83, 54);
            this.enemyBox.Name = "enemyBox";
            this.enemyBox.Size = new System.Drawing.Size(74, 22);
            this.enemyBox.TabIndex = 6;
            this.enemyBox.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.intOnly_KeyPress);
            // 
            // levelBox
            // 
            this.levelBox.Location = new System.Drawing.Point(163, 54);
            this.levelBox.Name = "levelBox";
            this.levelBox.Size = new System.Drawing.Size(74, 22);
            this.levelBox.TabIndex = 7;
            this.levelBox.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.intOnly_KeyPress);
            // 
            // specialBox
            // 
            this.specialBox.Location = new System.Drawing.Point(243, 54);
            this.specialBox.Name = "specialBox";
            this.specialBox.Size = new System.Drawing.Size(74, 22);
            this.specialBox.TabIndex = 8;
            this.specialBox.Tag = "";
            this.specialBox.WordWrap = false;
            this.specialBox.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.intOnly_KeyPress);
            // 
            // exportButton
            // 
            this.exportButton.Location = new System.Drawing.Point(695, 12);
            this.exportButton.Name = "exportButton";
            this.exportButton.Size = new System.Drawing.Size(75, 33);
            this.exportButton.TabIndex = 9;
            this.exportButton.Text = "Export";
            this.exportButton.UseVisualStyleBackColor = true;
            this.exportButton.Click += new System.EventHandler(this.exportButton_Click);
            // 
            // importButton
            // 
            this.importButton.Location = new System.Drawing.Point(614, 12);
            this.importButton.Name = "importButton";
            this.importButton.Size = new System.Drawing.Size(75, 33);
            this.importButton.TabIndex = 10;
            this.importButton.Text = "Import";
            this.importButton.UseVisualStyleBackColor = true;
            this.importButton.Click += new System.EventHandler(this.importButton_Click);
            // 
            // damageButton
            // 
            this.damageButton.Appearance = System.Windows.Forms.Appearance.Button;
            this.damageButton.AutoSize = true;
            this.damageButton.Location = new System.Drawing.Point(0, 21);
            this.damageButton.Name = "damageButton";
            this.damageButton.Size = new System.Drawing.Size(71, 27);
            this.damageButton.TabIndex = 11;
            this.damageButton.TabStop = true;
            this.damageButton.Text = "Damage";
            this.damageButton.UseVisualStyleBackColor = true;
            this.damageButton.CheckedChanged += new System.EventHandler(this.radioButtons_CheckedChanged);
            // 
            // enemyButton
            // 
            this.enemyButton.Appearance = System.Windows.Forms.Appearance.Button;
            this.enemyButton.AutoSize = true;
            this.enemyButton.Location = new System.Drawing.Point(83, 21);
            this.enemyButton.Name = "enemyButton";
            this.enemyButton.Size = new System.Drawing.Size(61, 27);
            this.enemyButton.TabIndex = 12;
            this.enemyButton.TabStop = true;
            this.enemyButton.Text = "Enemy";
            this.enemyButton.UseVisualStyleBackColor = true;
            this.enemyButton.CheckedChanged += new System.EventHandler(this.radioButtons_CheckedChanged);
            // 
            // levelButton
            // 
            this.levelButton.Appearance = System.Windows.Forms.Appearance.Button;
            this.levelButton.AutoSize = true;
            this.levelButton.Location = new System.Drawing.Point(163, 21);
            this.levelButton.Name = "levelButton";
            this.levelButton.Size = new System.Drawing.Size(52, 27);
            this.levelButton.TabIndex = 13;
            this.levelButton.TabStop = true;
            this.levelButton.Text = "Level";
            this.levelButton.UseVisualStyleBackColor = true;
            this.levelButton.CheckedChanged += new System.EventHandler(this.radioButtons_CheckedChanged);
            // 
            // specialButton
            // 
            this.specialButton.Appearance = System.Windows.Forms.Appearance.Button;
            this.specialButton.AutoSize = true;
            this.specialButton.Location = new System.Drawing.Point(243, 21);
            this.specialButton.Name = "specialButton";
            this.specialButton.Size = new System.Drawing.Size(64, 27);
            this.specialButton.TabIndex = 14;
            this.specialButton.TabStop = true;
            this.specialButton.Text = "Special";
            this.specialButton.UseVisualStyleBackColor = true;
            this.specialButton.CheckedChanged += new System.EventHandler(this.radioButtons_CheckedChanged);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.damageButton);
            this.groupBox1.Controls.Add(this.specialButton);
            this.groupBox1.Controls.Add(this.damageBox);
            this.groupBox1.Controls.Add(this.levelButton);
            this.groupBox1.Controls.Add(this.enemyButton);
            this.groupBox1.Controls.Add(this.specialBox);
            this.groupBox1.Controls.Add(this.enemyBox);
            this.groupBox1.Controls.Add(this.levelBox);
            this.groupBox1.Location = new System.Drawing.Point(12, 3);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(326, 81);
            this.groupBox1.TabIndex = 15;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Tile properties";
            // 
            // Editor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoScroll = true;
            this.ClientSize = new System.Drawing.Size(782, 453);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.importButton);
            this.Controls.Add(this.exportButton);
            this.Controls.Add(this.clearButton);
            this.Name = "Editor";
            this.Text = "Map Editor";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button clearButton;
        private System.Windows.Forms.TextBox damageBox;
        private System.Windows.Forms.TextBox enemyBox;
        private System.Windows.Forms.TextBox levelBox;
        private System.Windows.Forms.TextBox specialBox;
        private System.Windows.Forms.Button exportButton;
        private System.Windows.Forms.Button importButton;
        private System.Windows.Forms.RadioButton damageButton;
        private System.Windows.Forms.RadioButton enemyButton;
        private System.Windows.Forms.RadioButton levelButton;
        private System.Windows.Forms.RadioButton specialButton;
        private System.Windows.Forms.GroupBox groupBox1;
    }
}

