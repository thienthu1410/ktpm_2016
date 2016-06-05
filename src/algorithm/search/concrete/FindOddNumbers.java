package algorithm.search.concrete;

import java.util.ArrayList;

import algorithm.search.AbstractAlgorithm;
import algorithm.search.Algorithm;

import algorithm.search.helper.IsOdd;

public class FindOddNumbers extends AbstractAlgorithm{

	private ArrayList<Integer> intList = new ArrayList<Integer>();
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Integer> findNumber(ArrayList<Float> numberSeries) {
		
		// TODO Auto-generated method stub
		ArrayList<Float> numbers =  super.findNumber(numberSeries);
		intList = arrayConverter.convertToListInt(numbers);
		return intList;
		
		
	}
	
	public FindOddNumbers()
	{
		searchHelper = new IsOdd();
	}

	public Algorithm getID()
	{
		return Algorithm.FIND_ODD;
	}
	
	@Override
	public ArrayList convertResultToStr() {
		// TODO Auto-generated method stub
		return arrayConverter.IntegerToString(intList);
	}
}
