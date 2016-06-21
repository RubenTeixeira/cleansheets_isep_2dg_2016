/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.wizard.ui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.antlr.runtime.tree.TreeIterator;

/**
 *
 * @author Rafa
 */
public class WizardTreeFrame extends javax.swing.JFrame {

    /**
     * Creates new form WizardTreeFrame
     *
     * @param ast
     */
    public WizardTreeFrame(CommonTree ast) {
        initComponents();
        fillTree(ast);
    }

    private void fillTree(CommonTree ast) {
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) wizardTree.getModel().getRoot();
        List<DefaultMutableTreeNode> parents = new ArrayList<>();
        boolean up = false;
        boolean newPrevNode = false;
        TreeIterator it = new TreeIterator(ast);

        Tree node = (Tree) it.next();
        Tree prevNode = node;

        OUTER:
        while (it.hasNext()) {
            node = (Tree) it.next();
            switch (node.getText()) {
                case "DOWN":
                    parents.add(new DefaultMutableTreeNode(prevNode.getText()));
                    newPrevNode = false;
                    break;
                case "UP":
                    if (up == false) {
                        parents.get(parents.size() - 1).add(new DefaultMutableTreeNode(prevNode.getText()));
                        newPrevNode = false;
                        up = true;
                        break;
                    }

                    if (newPrevNode == true) {
                        parents.get(parents.size() - 1).add(new DefaultMutableTreeNode(prevNode.getText()));
                        newPrevNode = false;
                    }
                    
                    parents.get(parents.size() - 2).add(parents.get(parents.size() - 1));
                    parents.remove(parents.size() - 1);
                    break;
                case "EOF":
                    break OUTER;
                default:
                    prevNode = node;
                    newPrevNode = true;
                    break;
            }
        }
        root.add(parents.get(0));
        wizardTree.revalidate();
        wizardTree.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        wizardTree = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formula Tree");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Formula");
        wizardTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(wizardTree);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree wizardTree;
    // End of variables declaration//GEN-END:variables
}
