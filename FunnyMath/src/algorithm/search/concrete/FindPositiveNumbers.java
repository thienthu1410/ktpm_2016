package algorithm.search.concrete;

import java.util.ArrayList;

import adapter.FloatToStr;
import algorithm.search.AbstractAlgorithm;
import algorithm.search.Algorithm;
import algorithm.search.helper.IsNumberNegative;
import algorithm.search.helper.IsNumberPositive;

public class FindPositiveNumbers extends AbstractAlgorithm{

	

	private ArrayList<Float> floatList = new ArrayList<Float>();
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Float> findNumber(ArrayList<Float> numberSeries) {
		// TODO Auto-generated method stub
		
		try
		{
			floatList = super.findNumber(numberSeries);
		}
		
		catch (ClassCastException ex)
		{
			floatList = super.findNumber(arrayConverter.convertToListFloat(numberSeries));
		}
		return floatList;
	}
	
	public FindPositiveNumbers()
	{
		searchHelper = new IsNumberPositive();
	}

	public Algorithm getID()
	{
		return Algorithm.FIND_POSITIVE;
	}
	

	@Override
	public ArrayList convertResultToStr() {
		// TODO Auto-generated method stub
		return arrayConverter.FloatToString(floatList);
	}
}

