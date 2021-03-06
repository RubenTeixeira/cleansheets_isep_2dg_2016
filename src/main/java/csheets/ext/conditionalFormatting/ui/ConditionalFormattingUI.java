/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.conditionalFormatting.ui;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.conditionalFormatting.ConditionalFormattingExtension;
import csheets.ext.style.StylableCell;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Diogo Leite
 */
public class ConditionalFormattingUI extends JPanel {

	private final ConditionalFormattingController conditionalFormattingController;
	/**
	 * Cell tmp
	 */
	private Cell cell;

	private StylableCell trueStyle;
	private StylableCell falseStyle;

	private boolean result;

	/**
	 * Creates new form ConditionalFormattingUI
	 *
	 * @param uiController UIController
	 */
	public ConditionalFormattingUI(UIController uiController) {

		setName(ConditionalFormattingExtension.NAME);
		initComponents();
		this.conditionalFormattingController = new ConditionalFormattingController(uiController);
		cell = conditionalFormattingController.createConditionalCell();
		trueStyle = conditionalFormattingController.createStylableCells(0);
		falseStyle = conditionalFormattingController.createStylableCells(1);
		this.setVisible(true);

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelFont = new javax.swing.JLabel();
        labelForeground = new javax.swing.JLabel();
        labelBackground = new javax.swing.JLabel();
        labelBorder = new javax.swing.JLabel();
        labelAlign = new javax.swing.JLabel();
        trueLabel = new javax.swing.JLabel();
        falseLabel = new javax.swing.JLabel();
        labelExpression = new javax.swing.JLabel();
        textFieldFormula = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnTrueFont = new javax.swing.JButton();
        btnFalseFont = new javax.swing.JButton();
        btnTrueForeground = new javax.swing.JButton();
        btnFalseForeground = new javax.swing.JButton();
        btnTrueBackground = new javax.swing.JButton();
        btnFalseBackground = new javax.swing.JButton();
        btnTrueBorder = new javax.swing.JButton();
        btnFalseBorder = new javax.swing.JButton();
        comboBoxFalseHorizontalAlign = new javax.swing.JComboBox();
        comboBoxTrueHorizontalAlign = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        comboBoxTrueVerticalAlign = new javax.swing.JComboBox();
        comboBoxFalseVerticalAlign = new javax.swing.JComboBox();
        btnApply = new javax.swing.JButton();

        setAlignmentY(0.1F);

        labelFont.setText("Font");

        labelForeground.setText("Foreground");

        labelBackground.setText("Background");

        labelBorder.setText("Border");

        labelAlign.setText("Horizontal Align");

        trueLabel.setText("True");

        falseLabel.setText("False");

        labelExpression.setText("Expression");

        textFieldFormula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldFormulaKeyReleased(evt);
            }
        });

        btnTrueFont.setText("...");
        btnTrueFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrueFontActionPerformed(evt);
            }
        });

        btnFalseFont.setText("...");
        btnFalseFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFalseFontActionPerformed(evt);
            }
        });

        btnTrueForeground.setText("...");
        btnTrueForeground.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrueForegroundActionPerformed(evt);
            }
        });

        btnFalseForeground.setText("...");
        btnFalseForeground.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFalseForegroundActionPerformed(evt);
            }
        });

        btnTrueBackground.setText("...");
        btnTrueBackground.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrueBackgroundActionPerformed(evt);
            }
        });

        btnFalseBackground.setText("...");
        btnFalseBackground.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFalseBackgroundActionPerformed(evt);
            }
        });

        btnTrueBorder.setText("...");
        btnTrueBorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrueBorderActionPerformed(evt);
            }
        });

        btnFalseBorder.setText("...");
        btnFalseBorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFalseBorderActionPerformed(evt);
            }
        });

        comboBoxFalseHorizontalAlign.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Center", "Left", "Right" }));
        comboBoxFalseHorizontalAlign.setName(""); // NOI18N
        comboBoxFalseHorizontalAlign.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxFalseHorizontalAlignItemStateChanged(evt);
            }
        });

        comboBoxTrueHorizontalAlign.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Center", "Left", "Right" }));
        comboBoxTrueHorizontalAlign.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxTrueHorizontalAlignItemStateChanged(evt);
            }
        });

        jLabel1.setText("Vertical Align");

        comboBoxTrueVerticalAlign.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Top", "Center", "Bottom" }));
        comboBoxTrueVerticalAlign.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxTrueVerticalAlignItemStateChanged(evt);
            }
        });

        comboBoxFalseVerticalAlign.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Top", "Center", "Bottom" }));
        comboBoxFalseVerticalAlign.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxFalseVerticalAlignItemStateChanged(evt);
            }
        });

        btnApply.setText("Apply");
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelExpression)
                        .addGap(53, 53, 53)
                        .addComponent(textFieldFormula))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(trueLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(falseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelBackground)
                                    .addComponent(labelBorder)
                                    .addComponent(labelAlign)
                                    .addComponent(labelForeground)
                                    .addComponent(labelFont)
                                    .addComponent(jLabel1))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboBoxTrueHorizontalAlign, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnTrueFont)
                                        .addComponent(btnTrueForeground)
                                        .addComponent(btnTrueBackground)
                                        .addComponent(btnTrueBorder))
                                    .addComponent(comboBoxTrueVerticalAlign, 0, 1, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnFalseFont, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnFalseForeground, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnFalseBackground, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnFalseBorder, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboBoxFalseHorizontalAlign, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboBoxFalseVerticalAlign, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelExpression)
                    .addComponent(textFieldFormula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trueLabel)
                    .addComponent(falseLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTrueFont)
                    .addComponent(btnFalseFont)
                    .addComponent(labelFont))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTrueForeground)
                    .addComponent(labelForeground)
                    .addComponent(btnFalseForeground))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTrueBackground)
                    .addComponent(labelBackground)
                    .addComponent(btnFalseBackground))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTrueBorder)
                        .addComponent(labelBorder))
                    .addComponent(btnFalseBorder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAlign, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxTrueHorizontalAlign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxFalseHorizontalAlign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxFalseVerticalAlign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxTrueVerticalAlign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
		if (!this.textFieldFormula.getText().trim().isEmpty()) {
			//conditionalFormattingController.apply((result ? trueStyle : falseStyle));
			conditionalFormattingController.apply(this.textFieldFormula.
				getText(), trueStyle, falseStyle);
		}
    }//GEN-LAST:event_btnApplyActionPerformed

    private void btnTrueFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrueFontActionPerformed
		conditionalFormattingController.changeFont(trueStyle);
    }//GEN-LAST:event_btnTrueFontActionPerformed

    private void btnFalseFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFalseFontActionPerformed
		conditionalFormattingController.changeFont(falseStyle);
    }//GEN-LAST:event_btnFalseFontActionPerformed

    private void btnTrueForegroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrueForegroundActionPerformed
		conditionalFormattingController.changeForeground(trueStyle);
    }//GEN-LAST:event_btnTrueForegroundActionPerformed

    private void btnFalseForegroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFalseForegroundActionPerformed
		conditionalFormattingController.changeForeground(falseStyle);
    }//GEN-LAST:event_btnFalseForegroundActionPerformed

    private void btnTrueBackgroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrueBackgroundActionPerformed
		conditionalFormattingController.changeBackground(trueStyle);
    }//GEN-LAST:event_btnTrueBackgroundActionPerformed

    private void btnFalseBackgroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFalseBackgroundActionPerformed
		conditionalFormattingController.changeBackground(falseStyle);
    }//GEN-LAST:event_btnFalseBackgroundActionPerformed

    private void btnTrueBorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrueBorderActionPerformed
		conditionalFormattingController.changeBorder(trueStyle);
    }//GEN-LAST:event_btnTrueBorderActionPerformed

    private void btnFalseBorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFalseBorderActionPerformed
		conditionalFormattingController.changeBorder(falseStyle);
    }//GEN-LAST:event_btnFalseBorderActionPerformed

    private void textFieldFormulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldFormulaKeyReleased
		if (!textFieldFormula.getText().isEmpty()) {

			try {
				cell.setContent(textFieldFormula.getText());
			} catch (FormulaCompilationException ex) {
				defaultLabelColor();
			}

			try {

				if (conditionalFormattingController.isExpressionComparison(cell)) {
					if (conditionalFormattingController.evaluateExpression(cell)) {
						trueLabel.setForeground(Color.red);
						falseLabel.setForeground(Color.black);
						result = true;
					} else {
						trueLabel.setForeground(Color.black);
						falseLabel.setForeground(Color.red);
						result = false;
					}
				} else {
					defaultLabelColor();
				}

			} catch (IllegalValueTypeException ex) {
				Logger.getLogger(ConditionalFormattingUI.class.getName()).
					log(Level.SEVERE, null, ex);
			}
		} else {
			defaultLabelColor();
		}
    }//GEN-LAST:event_textFieldFormulaKeyReleased

    private void comboBoxTrueHorizontalAlignItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxTrueHorizontalAlignItemStateChanged
		if (this.comboBoxTrueHorizontalAlign.getModel().getSelectedItem().
			equals("Center")) {
			conditionalFormattingController.
				changeHorizontalAlign(falseStyle, SwingConstants.CENTER);
		} else if (this.comboBoxTrueHorizontalAlign.getModel().
			getSelectedItem().
			equals("Left")) {
			conditionalFormattingController.
				changeHorizontalAlign(falseStyle, SwingConstants.LEFT);
		} else if (this.comboBoxTrueHorizontalAlign.getModel().
			getSelectedItem().
			equals("Right")) {
			conditionalFormattingController.
				changeHorizontalAlign(falseStyle, SwingConstants.RIGHT);

		}
    }//GEN-LAST:event_comboBoxTrueHorizontalAlignItemStateChanged

    private void comboBoxFalseHorizontalAlignItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxFalseHorizontalAlignItemStateChanged
		if (this.comboBoxFalseHorizontalAlign.getModel().getSelectedItem().
			equals("Center")) {
			conditionalFormattingController.
				changeHorizontalAlign(trueStyle, SwingConstants.CENTER);
		} else if (this.comboBoxFalseHorizontalAlign.getModel().
			getSelectedItem().
			equals("Left")) {
			conditionalFormattingController.
				changeHorizontalAlign(trueStyle, SwingConstants.LEFT);
		} else if (this.comboBoxFalseHorizontalAlign.getModel().
			getSelectedItem().
			equals("Right")) {
			conditionalFormattingController.
				changeHorizontalAlign(trueStyle, SwingConstants.RIGHT);

		}
    }//GEN-LAST:event_comboBoxFalseHorizontalAlignItemStateChanged

    private void comboBoxTrueVerticalAlignItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxTrueVerticalAlignItemStateChanged
		if (this.comboBoxTrueVerticalAlign.getModel().getSelectedItem().
			equals("Bottom")) {
			conditionalFormattingController.
				changeVerticalAlign(trueStyle, SwingConstants.BOTTOM);
		} else if (this.comboBoxTrueVerticalAlign.getModel().getSelectedItem().
			equals("Middle")) {
			conditionalFormattingController.
				changeVerticalAlign(trueStyle, SwingConstants.CENTER);
		} else if (this.comboBoxTrueVerticalAlign.getModel().getSelectedItem().
			equals("Top")) {
			conditionalFormattingController.
				changeVerticalAlign(trueStyle, SwingConstants.TOP);
		}
    }//GEN-LAST:event_comboBoxTrueVerticalAlignItemStateChanged

    private void comboBoxFalseVerticalAlignItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxFalseVerticalAlignItemStateChanged
		if (this.comboBoxFalseVerticalAlign.getModel().getSelectedItem().
			equals("Bottom")) {
			conditionalFormattingController.
				changeVerticalAlign(falseStyle, SwingConstants.BOTTOM);
		} else if (this.comboBoxFalseVerticalAlign.getModel().getSelectedItem().
			equals("Middle")) {
			conditionalFormattingController.
				changeVerticalAlign(falseStyle, SwingConstants.CENTER);
		} else if (this.comboBoxFalseVerticalAlign.getModel().getSelectedItem().
			equals("Top")) {
			conditionalFormattingController.
				changeVerticalAlign(falseStyle, SwingConstants.TOP);
		}
    }//GEN-LAST:event_comboBoxFalseVerticalAlignItemStateChanged

	private void defaultLabelColor() {
		trueLabel.setForeground(new JLabel().getForeground());
		falseLabel.setForeground(new JLabel().getForeground());
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnFalseBackground;
    private javax.swing.JButton btnFalseBorder;
    private javax.swing.JButton btnFalseFont;
    private javax.swing.JButton btnFalseForeground;
    private javax.swing.JButton btnTrueBackground;
    private javax.swing.JButton btnTrueBorder;
    private javax.swing.JButton btnTrueFont;
    private javax.swing.JButton btnTrueForeground;
    private javax.swing.JComboBox comboBoxFalseHorizontalAlign;
    private javax.swing.JComboBox comboBoxFalseVerticalAlign;
    private javax.swing.JComboBox comboBoxTrueHorizontalAlign;
    private javax.swing.JComboBox comboBoxTrueVerticalAlign;
    private javax.swing.JLabel falseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelAlign;
    private javax.swing.JLabel labelBackground;
    private javax.swing.JLabel labelBorder;
    private javax.swing.JLabel labelExpression;
    private javax.swing.JLabel labelFont;
    private javax.swing.JLabel labelForeground;
    private javax.swing.JTextField textFieldFormula;
    private javax.swing.JLabel trueLabel;
    // End of variables declaration//GEN-END:variables

}
