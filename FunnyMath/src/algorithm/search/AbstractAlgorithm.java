package algorithm.search;

import java.util.ArrayList;

import adapter.ConvertArray;
import algorithm.search.helper.SearchHelper;




public class AbstractAlgorithm {
	
	protected SearchHelper searchHelper = null;
	protected ConvertArray arrayConverter = new ConvertArray();
	
	public ArrayList findNumber (ArrayList<Float> numberSeries)
	{
		ArrayList<Float> result = new ArrayList<>();
		for (Float number : numberSeries)
		{
			if (searchHelper.isOK(number))
				result.add(number);
		}
		
		
		return result;
		
		
	}
	
	public ArrayList convertResultToStr ()
	{
		return null;
	}

}
