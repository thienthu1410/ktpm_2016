package algorithm.search.concrete;


import java.util.ArrayList;


import adapter.FloatToStr;
import adapter.IntToStr;
import algorithm.search.AbstractAlgorithm;
import algorithm.search.Algorithm;

import algorithm.search.helper.IsEven;
import algorithm.search.helper.IsPrime;


public class FindPrimes extends AbstractAlgorithm{

	
	private ArrayList<Integer> intList = new ArrayList<Integer>();
	public FindPrimes() {
 		// TODO Auto-generated constructor stub
		searchHelper = new IsPrime();
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
		return Algorithm.FIND_PRIME;
	}


}