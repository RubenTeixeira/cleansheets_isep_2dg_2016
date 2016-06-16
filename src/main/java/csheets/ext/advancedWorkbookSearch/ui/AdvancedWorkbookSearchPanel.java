/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.advancedWorkbookSearch.ui;

import csheets.CleanSheets;
import csheets.core.Workbook;
import csheets.ext.advancedWorkbookSearch.AdvancedWorkbookSearchController;
import csheets.ext.advancedWorkbookSearch.AdvancedWorkbookSearchExtension;
import csheets.ui.DefaulListModel;
import csheets.ui.FileChooser;
import csheets.ui.ctrl.UIController;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public class AdvancedWorkbookSearchPanel extends JPanel {

	/**
	 * Default Search Pattern.
	 */
	private static final String EXTENSION = "\\.cls";
	private static final String DEFAULT = ".*\\.cls";

	/**
	 * UIController.
	 *
	 */
	private UIController uicontroller;

	/**
	 * AdvancedWorkbookSearchController.
	 */
	private AdvancedWorkbookSearchController controller = new AdvancedWorkbookSearchController();

	/**
	 * Current Search Directory.
	 */
	private File directory = new File("");

	/**
	 * Current Search Pattern. By default
	 */
	private String pattern = ".*\\.cls";

	/**
	 * Searched Files.
	 */
	private List<File> files = new ArrayList<>();

	/**
	 * Results List Model.
	 */
	private DefaulListModel list = new DefaulListModel();

	/**
	 * Preview Model table.
	 */
	private DefaultTableModel table;

	/**
	 * Workbook.
	 */
	private Workbook wb;

	/**
	 * Workbooks found counter.
	 */
	private int cont;

	/**
	 * Creates new form AdvancedWorkbookSearchPanel.
	 *
	 * @param uicontroller UIController.
	 */
	public AdvancedWorkbookSearchPanel(UIController uicontroller) {
		setName(AdvancedWorkbookSearchExtension.NAME);
		this.uicontroller = uicontroller;
		jResultList = new JList(list);

		jPreviewTable = new JTable(table);
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jResultList = new javax.swing.JList();
        jPatternField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPreviewTable = new javax.swing.JTable();
        jImagePanel = new javax.swing.JLabel();

        /**
        * Clears Field.
        */
        jTextField.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jTextField.setText("insert directory...");
        jTextField.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                jTextField.setText("");
                directory = new File("");
            }
        });
        jTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldActionPerformed(evt);
            }
        });

        jButton1.setText("...");
        jButton1.setSize(20, 50);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButton2.setText("Search");
        jButton2.setSize(20, 50);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jResultList.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jResultList.setModel(new DefaulListModel());
        jResultList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jResultsListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jResultList);

        jPatternField.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jPatternField.setText("search pattern");
        jPatternField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPatternFieldActionPerformed(evt);
            }
        });
        /**
        * Pressing Enter after Pattern starts Search Process.
        */
        jPatternField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    performSearch();
                }
            }
        });
        /**
        * Clears Field.
        */
        jPatternField.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                jPatternField.setText("");
                pattern = "";
            }
        });

        jPreviewTable.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 102, 255)));
        jPreviewTable.setEnabled(false);
        jPreviewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jPreviewTable);

        jImagePanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jImagePanel.setIcon(new ImageIcon(
            AdvancedWorkbookSearchExtension.class.getResource("res/img/spinning.gif")));
    jImagePanel.setVisible(false); //by default

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPatternField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButton2))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jPatternField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    }// </editor-fold>//GEN-END:initComponents

	/**
	 * Directory button retrieves the search directory as a File. A Dialog will
	 * retrieve the directory choosen by the user. The FileChooser is set up to
	 * be a directory only.
	 *
	 * @param evt evt.
	 */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		FileChooser dir = new FileChooser(null, null);
		dir.setFileSelectionMode(FileChooser.DIRECTORIES_ONLY);
		dir.showDialog(null, null);
		directory = dir.getSelectedFile();
		jTextField.setText(directory.toString());
    }//GEN-LAST:event_jButton1ActionPerformed

	/**
	 * The Search directory is displayed on this field.
	 *
	 * @param evt evt.
	 */
    private void jTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldActionPerformed

    }//GEN-LAST:event_jTextFieldActionPerformed

	/**
	 * Begins the Search Process. Search Button.
	 *
	 * @param evt evt.
	 */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
		performSearch();
    }//GEN-LAST:event_jButton2ActionPerformed

	/**
	 * Retrieves the Pattern text.
	 *
	 * @param evt evt
	 */
    private void jPatternFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPatternFieldActionPerformed
		pattern = "";
		pattern = jPatternField.getText();
    }//GEN-LAST:event_jPatternFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jImagePanel;
    private javax.swing.JTextField jPatternField;
    private javax.swing.JTable jPreviewTable;
    private javax.swing.JList jResultList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField;
    // End of variables declaration//GEN-END:variables

	/**
	 * Search Process occurs in a new Thread. The AWSController will handle the
	 * Search and return the list of Workbook found.
	 */
	private void performSearch() {
		jButton2.setEnabled(false);
		if (validateDirectory()) { //checks directory.
			if (validatePattern()) {//checks pattern.
				list.clear(); //clears previous results.

				Runnable newthread = new Runnable() {
					/**
					 * Thread Search method.
					 */
					@Override
					public void run() {
						cont = 0; //sets counter to 0 on each search.
						jImagePanel.setVisible(true);
						files = controller.search(directory, pattern);
						checkDuplicatedFiles(); //sets up a list without duplicated files.
						postSearchUIOperations(); //required operations after each Search.
					}
				};
				jImagePanel.setVisible(true); //enables search "indicator".
				new Thread(newthread).start(); //starts the new Thread.

			}
		} else {
			jTextField.setText("Invalid Directory.");
			jButton2.setEnabled(true);
		}
//		String fix = "";
//		list.addElement(fix);
//		jResultList.setModel(list);
	}

	/**
	 * This method handles different behaviour associated with mouse
	 * interaction. For one-click over the found Workbook the system shows a
	 * preview of that Workbook. If pressed twice the result is also loaded to
	 * the current workspace.
	 *
	 * @param evt mouse event.
	 */
	private void jResultsListMouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 1) { //clicked once.
			File file = (File) jResultList.getSelectedValue();
			CleanSheets instance = new CleanSheets(); //sets up a new instance of Cleansheets to load the information required.
			try {
				instance.load(file); //loads file.
			} catch (IOException | ClassCastException | ClassNotFoundException | ArrayIndexOutOfBoundsException ex) {
				JOptionPane.
					showMessageDialog(null, "This File is Corrupted!", "Error", JOptionPane.ERROR_MESSAGE);
			}//handling corrupted files.
			wb = instance.getWorkbook(file); //saves workbook.
			try {
				setUpPreview();
			} catch (NullPointerException | ArrayIndexOutOfBoundsException ex) {
				JOptionPane.
					showMessageDialog(null, "Couldn't load preview.", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} else if (evt.getClickCount() == 2) { //clicked twice.
			File file = (File) jResultList.getSelectedValue();
			try {
				uicontroller.getCleanSheets().load(file); //UIController loads selected Workbook to current workspace.
			} catch (IOException | ClassNotFoundException | ClassCastException | ArrayIndexOutOfBoundsException ex) {
				JOptionPane.
					showMessageDialog(null, "This File is Corrupted!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Sets up the Preview. Advanced Workbook Controller handles the preview
	 * information.
	 *
	 * @throws NullPointerException
	 */
	private void setUpPreview() throws NullPointerException {
		String[] previewTitles = new String[WorkbookPreview.COLUMNS];
		String[][] previewContent = new String[WorkbookPreview.COLUMNS][WorkbookPreview.ROWS];
		controller.setUpWorkbookPreview(wb, previewContent, previewTitles);
		table = new DefaultTableModel(previewContent, previewTitles);
		jPreviewTable.setModel(table); // sets the table for visualization.
		jPreviewTable.setEnabled(false);
		jPreviewTable.setVisible(true);
	}

	/**
	 * Sets up a Results List without duplicated Files.
	 */
	private void checkDuplicatedFiles() {
		for (File f : files) {
			if (!list.contains(f)) {
				cont++;
				list.addElement(f);
			}
		}
	}

	/**
	 * Sets up the UI for next Search.
	 */
	private void postSearchUIOperations() {
		String endSearch = "Search Completed! " + cont + " Results found.";
		jButton2.setEnabled(true);
		list.addElement(endSearch);
		jResultList.setModel(list);
		jResultList.
			setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Single File Selection.
		jImagePanel.setVisible(false);
		jPatternField.setEnabled(true);
	}

	/**
	 * Checks if pattern is valid.
	 *
	 * @return true for valid pattern.
	 */
	private boolean validatePattern() {
		jPatternField.setEnabled(false);

		if (pattern.equalsIgnoreCase("")) {
			pattern = DEFAULT;
		}
		if (!pattern.contains(EXTENSION)) {
			pattern += EXTENSION;
		}
		System.out.println(pattern);
		try {
			Pattern temp = Pattern.compile(pattern);
		} catch (PatternSyntaxException e) {
			jPatternField.setEnabled(true);
			jPatternField.setText("invalid pattern");
			return false;
		}
		return true;
	}

	/**
	 * Checks if Directory is valid.
	 *
	 * @return true for valid directory.
	 */
	private boolean validateDirectory() {
		if (!directory.exists()) { //checks if File exist.
			return false;
		}
		if (!directory.isDirectory()) { //checks if File is a Directory.
			return false;
		}
		if (directory.toString().equalsIgnoreCase("")) { //check if File is empty.
			return false;
		}
		return true;
	}
}
