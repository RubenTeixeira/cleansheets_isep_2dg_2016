/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yur
 */
public class ExtenstionsActDeactUI extends JFrame {
    
    public static final String TITLE = "NAME";
    
    private UIController controller;
    private Panel panel;
    private JTable tableExtensions;
    private DefaultTableModel modelTableExtensions;
    private JButton btnApply, btnCancel;
    private final Object[] tablesNames = {"Extension Name", "Enable"};
    
    public ExtenstionsActDeactUI(UIController controller) {
        this.controller = controller;
        createUIObjects();
        configureUIObjects();
        positionUIObjects();
        fetchExtensions();
    }
    
    private void createUIObjects() {
        this.panel = new Panel();
        this.modelTableExtensions = new DefaultTableModel(0, tablesNames.length) {
            public Class<?> getColumnClass(int column) {
                switch(column) {
                    case 0: return String.class;
                    case 1: return Boolean.class;
                    default: return String.class;
                }
            }
        };
        this.tableExtensions = new JTable(this.modelTableExtensions);
        this.btnApply = new JButton();
        this.btnCancel = new JButton();
    }
    
    private void positionUIObjects() {
        Container pane = getContentPane();
        pane.add(tableExtensions, BorderLayout.CENTER);
        pane.add(panel, BorderLayout.SOUTH);
    }
    
    private void configureUIObjects() {
        confFrame();
        confTable();
        confPanel();
        confBtnApply();
        confBtnCancel();
    }
    
    private void confFrame() {
        Dimension defaultSize = new Dimension(400, 420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setEnabled(true);
        setPreferredSize(defaultSize);
        setSize(defaultSize);
        setTitle(TITLE);
        setVisible(true);
    }
    
    private void confTable() {
        tableExtensions.setEditingColumn(1);
    }
    
    private void confPanel() {
        this.panel.add(btnApply);
        this.panel.add(btnCancel);
    }
    
    private void confBtnApply() {
        btnApply.setText("Apply");
        btnApply.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < modelTableExtensions.getRowCount(); i++) {
                    Object extensionName = modelTableExtensions.getValueAt(i, 0);
                    Object extensionEnable = modelTableExtensions.getValueAt(i, 1);
                    controller.changeExtensionState((String)extensionName, (boolean)extensionEnable);
                }
                
            }
        });
    }
    
    private void confBtnCancel() {
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(e -> this.dispose());
    }
    
    private void fetchExtensions() {
        for (UIExtension uIExtension : controller.getExtensions()) {
            addExtensionToModel(uIExtension.getExtension());
        }
    }
    
    private void addExtensionToModel(Extension extension) {
        if (extension != null) {
            modelTableExtensions.addRow(new Object[]{extension.getName(), extension.isEnabled()});
        }
    }
}
