package GUI.support.windowCreator;

import javax.swing.JDialog;

import GUI.RectangleView;

public class RectangleDialogCreator extends AbstractWindowCreator {

	@Override
	public JDialog createWindow() {
		// TODO Auto-generated method stub
		return new RectangleView();
	}

}
