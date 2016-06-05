package creator.algorithmMachine;

import java.util.ArrayList;

import global.Global;
import algorithm.search.AbstractAlgorithm;
import algorithm.search.Algorithm;
import algorithm.search.concrete.FindEvenNumbers;
import algorithm.search.concrete.FindIntegerNumbers;
import algorithm.search.concrete.FindNegativeNumbers;
import algorithm.search.concrete.FindOddNumbers;
import algorithm.search.concrete.FindPositiveNumbers;
import algorithm.search.concrete.FindPrimes;

public class AlgorithmCreator {
	
	public void createAlgorithm(ArrayList<AbstractAlgorithm> list, Algorithm algoType)
	{
		switch (algoType)
		{
		case FIND_EVEN:
			list.add((FindEvenNumbers)Global.algorithmCreator.getAlgorithm(algoType));
			break;
		case FIND_ODD:
			list.add((FindOddNumbers)Global.algorithmCreator.getAlgorithm(algoType));
			break;
		case FIND_POSITIVE:
			list.add((FindPositiveNumbers)Global.algorithmCreator.getAlgorithm(algoType));
			break;
		case FIND_NEGATIVE:
			list.add((FindNegativeNumbers)Global.algorithmCreator.getAlgorithm(algoType));
			break;
		case FIND_INTEGER:
			list.add((FindIntegerNumbers)Global.algorithmCreator.getAlgorithm(algoType));
			break;
		case FIND_PRIME:
			list.add((FindPrimes)Global.algorithmCreator.getAlgorithm(algoType));
			break;
		}
		
	}

}
