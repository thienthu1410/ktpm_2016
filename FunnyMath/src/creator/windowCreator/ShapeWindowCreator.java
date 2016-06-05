package creator.windowCreator;

import javax.swing.JDialog;

import shape.type.ShapeSample;


import GUI.support.windowCreator.RectangleDialogCreator;
import GUI.support.windowCreator.SquareDialogCreator;
import GUI.support.windowCreator.TriangleDialogCreator;

public class ShapeWindowCreator {
	
	public JDialog createWindow(ShapeSample shapeSample)
	{
		switch(shapeSample)
		{
			case RECTANGLE:
			{
				return new RectangleDialogCreator().createWindow();
			}
			
			case SQUARE:
			{
				return new SquareDialogCreator().createWindow();
			}
			
			case TRIANGLE:
			{
				return new TriangleDialogCreator().createWindow();
			}
								
		}
		
		return null;
	}

}
