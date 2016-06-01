/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import csheets.CleanSheets;
import csheets.ui.ExtensionsActivateDeactivateUI;
import javax.swing.JOptionPane;

/**
 *
 * @author hichampt
 */
@SuppressWarnings("serial")
public class ExtensionsActivateDesactivateAction extends FocusOwnerAction {

    protected UIController uiController;

    public ExtensionsActivateDesactivateAction(UIController uIController) {
        this.uiController = uIController;
    }

    protected void defineProperties() {
        putValue(MNEMONIC_KEY, KeyEvent.VK_A);
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, new ImageIcon(CleanSheets.class.getResource("res/img/select_all.gif")));
    }

    @Override
    protected String getName() {
        return "ExtensionActivateDesactivateAction";
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (focusOwner == null) {
            return;
        }
        ExtensionsActivateDeactivateUI ui = new ExtensionsActivateDeactivateUI(uiController);
    }

}
