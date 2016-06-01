/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.cellsSharing.ui;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.ext.cellsSharing.ShareExtension;
import csheets.ext.comments.ui.CommentPanel;
import csheets.ui.DefaulListModel;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.awt.BorderLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * A panel for share a cell
 *
 * @author José Barros
 */
public class SharePanel extends javax.swing.JPanel implements SelectionListener, Observer {

    private final UIController uiController;

    /**
     * The assertion controller
     */
    private ShareCellsController controller;

    /**
     * Default instance list
     */
    private DefaultListModel instanceListModel;

    /**
     * Default receive list
     */
    private DefaultListModel receiveListModel;

    /**
     * Hostname
     */
    private String host;

    /**
     * Cell selected
     */
    private Cell cell;

    private boolean hostSelected;

    /**
     * Creates new form SharePanel
     *
     * @param uiController a ui controller
     */
    public SharePanel(UIController uiController) {
        super(new BorderLayout());
        this.uiController = uiController;
        this.controller = new ShareCellsController(uiController, this, 8000);

        setName(ShareExtension.NAME);

        // Create default lists
        instanceListModel = new DefaultListModel();
        instanceListModel.addElement("test");
        receiveListModel = new DefaulListModel();
        //TODO

        initComponents();

        uiController.addSelectionListener(this);

        instancesList.setModel(instanceListModel);
        receiveList.setModel(receiveListModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        sendPanel = new javax.swing.JPanel();
        instancesLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        instancesList = new javax.swing.JList<>();
        sendButton = new javax.swing.JButton();
        receivePanel = new javax.swing.JPanel();
        hostsLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        receiveList = new javax.swing.JList<>();
        receiveButton = new javax.swing.JButton();

        instancesLabel.setText("Available Instances in local network:");

        instancesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                instancesListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(instancesList);

        sendButton.setText("SEND");
        sendButton.setEnabled(false);
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sendPanelLayout = new javax.swing.GroupLayout(sendPanel);
        sendPanel.setLayout(sendPanelLayout);
        sendPanelLayout.setHorizontalGroup(
            sendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sendPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sendPanelLayout.createSequentialGroup()
                        .addComponent(instancesLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(sendPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sendButton)))
                .addContainerGap())
        );
        sendPanelLayout.setVerticalGroup(
            sendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sendPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instancesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sendButton)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Send Cells", sendPanel);

        hostsLabel.setText("Hosts Received:");

        jScrollPane2.setViewportView(receiveList);

        receiveButton.setText("RECEIVE");
        receiveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout receivePanelLayout = new javax.swing.GroupLayout(receivePanel);
        receivePanel.setLayout(receivePanelLayout);
        receivePanelLayout.setHorizontalGroup(
            receivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receivePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(receivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(receivePanelLayout.createSequentialGroup()
                        .addComponent(hostsLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receivePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(receiveButton)))
                .addContainerGap())
        );
        receivePanelLayout.setVerticalGroup(
            receivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receivePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hostsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(receiveButton)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Receive Cells", receivePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed

        int reply = JOptionPane.showConfirmDialog(this, "::. Send information .::\n"
                + "Host: " + host
                + "\nCell: " + cell.getAddress()
                + "\nValue: " + cell.getValue());

        if (reply == JOptionPane.YES_OPTION) {
            // option 1
        } else if (reply == JOptionPane.NO_OPTION) {
            // option 2
        }
    }//GEN-LAST:event_sendButtonActionPerformed

    private void instancesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_instancesListValueChanged
        if (evt.getValueIsAdjusting() == false) {
            if (instancesList.getSelectedIndex() == -1) {
                //No selection.
                sendButton.setEnabled(false);
            } else {
                //Selection.
                sendButton.setEnabled(true);
                host = instancesList.getSelectedValue();
            }
        }
    }//GEN-LAST:event_instancesListValueChanged

    public void updateInstanceList(List<String> addresses) {
        for (String address : addresses) {
            instanceListModel.addElement(address);
        }

        instancesList.setModel(instanceListModel);
        repaint();
    }

    public void updateReceiveList(Map<String, String> cells) {
        for (Map.Entry<String, String> entry : cells.entrySet()) {
            String cell = entry.getKey() + "=" + entry.getValue();
            instanceListModel.addElement(cell);
        }
        receiveList.setModel(receiveListModel);
        repaint();
    }

    private void receiveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiveButtonActionPerformed

        int reply = JOptionPane.showConfirmDialog(this, "::. Receive information .::\n"
                + "TODO");

        if (reply == JOptionPane.YES_OPTION) {
            // option 1
        } else if (reply == JOptionPane.NO_OPTION) {
            // option 2
        }
    }//GEN-LAST:event_receiveButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hostsLabel;
    private javax.swing.JLabel instancesLabel;
    private javax.swing.JList<String> instancesList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton receiveButton;
    private javax.swing.JList<String> receiveList;
    private javax.swing.JPanel receivePanel;
    private javax.swing.JButton sendButton;
    private javax.swing.JPanel sendPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void selectionChanged(SelectionEvent event) {
        try {
            cell = event.getCell();

        } catch (Exception e) {
        }
    }

    @Override
    public void update(Observable o, Object object) {
        if (object instanceof Map) {
            Map<String,String> mapCells=(Map<String,String>)object;
            updateReceiveList(mapCells);
        }
        if (object instanceof List) {
            List<String> addresses = (List<String>) object;
            updateInstanceList(addresses);
        }
    }
}
