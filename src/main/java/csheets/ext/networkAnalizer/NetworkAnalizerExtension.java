/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.networkAnalizer;

import csheets.ext.Extension;
import csheets.ext.networkAnalizer.ui.UIExtensionNetworkAnalizer;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author Diogo Leite
 */
public class NetworkAnalizerExtension extends Extension {

	/**
	 * The name of the extension
	 */
	public static final String NAME = "Network Analizer";

	/**
	 * Creates a new assertion extension.
	 */
	public NetworkAnalizerExtension() {
		super(NAME);
	}

	/**
	 * Returns a user interface extension for dependency trees.
	 *
	 * @param uiController the user interface controller
	 * @return a user interface extension for dependency trees
	 */
	@Override
	public UIExtension getUIExtension(UIController uiController) {
		return new UIExtensionNetworkAnalizer(this, uiController);
	}

}
