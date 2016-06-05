package GUI.support.windowCreator;

import javax.swing.JDialog;
import GUI.TriangleView;

public class TriangleDialogCreator extends AbstractWindowCreator {

	@Override
	public JDialog createWindow() {
		// TODO Auto-generated method stub
		return new TriangleView();
	}

}
