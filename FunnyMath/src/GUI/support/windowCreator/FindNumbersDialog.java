package GUI.support.windowCreator;

import javax.swing.JDialog;

import GUI.FindNumbersView;



public class FindNumbersDialog extends AbstractWindowCreator {

	@Override
	public JDialog createWindow() {
		// TODO Auto-generated method stub
		return new FindNumbersView();
	}

}
