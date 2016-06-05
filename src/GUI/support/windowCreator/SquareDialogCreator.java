package GUI.support.windowCreator;

import javax.swing.JDialog;

import GUI.SquareView;

public class SquareDialogCreator extends AbstractWindowCreator {

	@Override
	public JDialog createWindow() {
		// TODO Auto-generated method stub
		return new SquareView();
	}

}
