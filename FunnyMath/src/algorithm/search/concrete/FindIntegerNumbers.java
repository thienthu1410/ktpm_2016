package algorithm.search.concrete;


import java.util.ArrayList;


import algorithm.search.AbstractAlgorithm;
import algorithm.search.Algorithm;
import algorithm.search.helper.IsInteger;


public class FindIntegerNumbers extends AbstractAlgorithm{

	private ArrayList<Integer> intList = new ArrayList<Integer>();
	public FindIntegerNumbers()
	{
		searchHelper = new IsInteger();
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
		return Algorithm.FIND_INTEGER;
	}
}
