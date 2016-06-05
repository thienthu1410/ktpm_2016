package adapter;

import java.util.ArrayList;

public class ConvertArray {
	
	public ArrayList<String> FloatToString  (ArrayList<Float> numbers)
	{
		ArrayList<String> result = new ArrayList<String>();
		FloatToStr converter = new FloatToStr();
		
		for (Float number : numbers)
		{
			converter.setSrc(number);
			converter.convert();
			result.add(converter.getDes());
		}
		
		return result;
		
	}
	
	public ArrayList<String> IntegerToString  (ArrayList<Integer> numbers)
	{
		ArrayList<String> result = new ArrayList<String>();
		IntToStr converter = new IntToStr();
		
		for (Integer number : numbers)
		{
			converter.setSrc(number);
			converter.convert();
			result.add(converter.getDes());
		}
		
		return result;
		
	}
	
	public  ArrayList<Integer> convertToListInt(ArrayList<Float> numbers)
	{
		 	FloatToInt adapter = new FloatToInt();
			ArrayList<Integer> result = new ArrayList<Integer>();
			for (Float number:numbers)
			{
				adapter.setSrc(number);
				adapter.convert();
				result.add(adapter.getDes());
			}
			
			return result;
	 }
	
	public  ArrayList<Float> convertToListFloat(ArrayList numbers)
	 {
		 	IntToFloat adapter = new IntToFloat();
			ArrayList<Float> result = new ArrayList<Float>();
			ArrayList<Integer> temp = numbers;
			for (Integer number:temp)
			{
				adapter.setSrc(number);
				adapter.convert();
				result.add(adapter.getDes());
			}
			
			return result;
	 }




}
