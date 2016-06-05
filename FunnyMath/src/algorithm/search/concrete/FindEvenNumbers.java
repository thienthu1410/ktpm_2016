package algorithm.search.concrete;


import java.util.ArrayList;

import adapter.FloatToInt;
import adapter.IntToStr;
import algorithm.search.AbstractAlgorithm;
import algorithm.search.Algorithm;

import algorithm.search.helper.IsEven;


public class FindEvenNumbers extends AbstractAlgorithm{

	private ArrayList<Integer> intList = new ArrayList<Integer>();
	public FindEvenNumbers() {
 		// TODO Auto-generated constructor stub
		searchHelper = new IsEven();
	}
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Integer> findNumber(ArrayList<Float> numberSeries) {
		
		// TODO Auto-generated method stub
		ArrayList<Float> numbers = super.findNumber(numberSeries);
		intList = arrayConverter.convertToListInt(numbers);
		return intList;
			
	}
	
	
	@Override
	public ArrayList convertResultToStr() {
		// TODO Auto-generated method stub
		return arrayConverter.IntegerToString(intList);
	}
	
	public Algorithm getID()
	{
		return Algorithm.FIND_EVEN;
	}
	
	
	

}
