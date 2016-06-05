package shapeMachine;



import java.util.Hashtable;

import shape.Shape;
import shape.shapes.*;
import shape.type.ShapeSample;

public class ShapeSampleCreator 
{
	private Hashtable<ShapeSample, Shape> shapeSample  = new Hashtable<ShapeSample, Shape>();
	
	private static ShapeSampleCreator instance = null;
	
	public static ShapeSampleCreator init() 
	{
		if (instance == null)
		{
			instance = new ShapeSampleCreator();
		}
		return instance;
			
	}
	
	private ShapeSampleCreator()
	{
		shapeSample  = new Hashtable<ShapeSample, Shape>();
		loadSample();
	}
	
	public Hashtable<ShapeSample, Shape> getSampleList()
	{
		return shapeSample;
	}
	
	private void loadSample()
	{				
		Rectangle rectangle = Rectangle.newInstance();
		addSample(Rectangle.getType(), rectangle);
		
		Square square = Square.newInstance();
		addSample(Square.getType(), square);
		
		Triangle triangle = Triangle.newInstance();
		addSample(Triangle.getType(), triangle);
	}
	
	private void addSample(ShapeSample id, Shape sample)
	{
		shapeSample.put(id, sample);
	}
	
	public Shape getShape(ShapeSample ID)
	{
		if (shapeSample.containsKey(ID))
		{
			return shapeSample.get(ID);
		}
		
		return null;
	}
	
	

}
