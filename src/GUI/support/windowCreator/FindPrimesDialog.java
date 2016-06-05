package GUI.support.windowCreator;

import javax.swing.JDialog;


import GUI.FindPrimesView;



public class FindPrimesDialog extends AbstractWindowCreator {

	@Override
	public JDialog createWindow() {
		// TODO Auto-generated method stub
		return new FindPrimesView();
	}

}
