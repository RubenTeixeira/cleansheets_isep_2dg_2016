/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.macro_beanshell.ui;

import csheets.CleanSheets;
import csheets.ext.Extension;
import csheets.ext.wizard.ui.WizardMenu;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JMenu;

/**
 *
 * @author yur
 */
public class UIExtensionMacroBeanShell extends UIExtension {

    /**
     * A side bar that provides contact edition
     */
    private JComponent sideBar;

    public UIExtensionMacroBeanShell(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    /**
     * Returns an icon to display with the extension's name.
     *
     * @return an icon with style
     */
    @Override
    public Icon getIcon() {
        return new ImageIcon(CleanSheets.class.
                getResource("ext/macro_beanshell/script_small.png"));
    }

    /**
     * Returns a side bar that gives access to extension-specific functionality.
     *
     * @return a component, or null if the extension does not provide one
     */
    @Override
    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new MacroBeanShellPanel(uiController);
        }
        return sideBar;
    }
}
