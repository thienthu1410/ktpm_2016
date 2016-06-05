package shapeMachine;

import shape.Shape;
import shape.shapes.Rectangle;
import shape.shapes.Square;
import shape.shapes.Triangle;
import shape.type.ShapeSample;
import global.Global;

public class Pencil 
{
	
	
	public Shape draw(ShapeSample shapeSample)
	{
		switch (shapeSample)
		{
			case RECTANGLE:			
				return (Rectangle)Global.shapeSampleCreator.getShape(shapeSample);						
			case TRIANGLE:
				return (Triangle)Global.shapeSampleCreator.getShape(shapeSample);
			case SQUARE:
				return (Square)Global.shapeSampleCreator.getShape(shapeSample);
			default:
				return null;
		}
	}
	
}
