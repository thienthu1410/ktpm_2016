package languageSupport;

import shape.type.ShapeSample;
import algorithm.search.Algorithm;

public class EnglishTranslator {
	
	
	
	public static ShapeSample ShapeStr2Enum(String src)
	{
		switch (src)
		{
			case "Rectangle":
				return ShapeSample.RECTANGLE;
			case "Triangle":
				return ShapeSample.TRIANGLE;
			case "Square":
				return ShapeSample.SQUARE;
		}
		return null;
	}
	
	public static Algorithm AlgoStr2Enum(String src)
	{
		switch (src)
		{
			case "FindEvenNumbers":
				return Algorithm.FIND_EVEN;
			case "FindIntegerNumbers":
				return Algorithm.FIND_INTEGER;
			case "FindNegativeNumbers":
				return Algorithm.FIND_NEGATIVE;
			case "FindOddNumbers":
				return Algorithm.FIND_ODD;
			case "FindPositiveNumbers":
				return Algorithm.FIND_POSITIVE;
			case "FindPrimes":
				return Algorithm.FIND_PRIME;
		}
		return null;
	}
}
