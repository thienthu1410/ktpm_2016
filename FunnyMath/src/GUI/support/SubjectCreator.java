package GUI.support;

import global.Global;
import java.util.Enumeration;
import java.util.Hashtable;

import shape.Shape;
import shape.type.ShapeSample;

import languageSupport.VietnameseTranslator;



public class SubjectCreator 
{
	private Hashtable<ShapeSample, String> shapeSample = new Hashtable<ShapeSample, String>();
	
	public Hashtable<ShapeSample, String> getList()
	{
		Hashtable<ShapeSample, Shape> sampleList = Global.shapeSampleCreator.getSampleList();
		Enumeration<ShapeSample> sample = sampleList.keys();

		while (sample.hasMoreElements())
		{
			ShapeSample shapeType = (ShapeSample) sample.nextElement();
			shapeSample.put(shapeType, VietnameseTranslator.translateToThisLanguge(shapeType));
		}
		
		return shapeSample;
	}

}
