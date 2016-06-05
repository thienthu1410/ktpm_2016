package languageSupport;

import algorithm.search.Algorithm;
import shape.triangle.TriangleType;
import shape.type.ShapeSample;

public class VietnameseTranslator {
	
	
	public static  String translateToThisLanguge(ShapeSample shapeSample)
	{
		switch (shapeSample)
		{
			case RECTANGLE:
				return "Hình chữ nhật";
			case TRIANGLE:
				return "Hình tam giác";
			case SQUARE:
				return "Hình vuông";
			
				
		}
		return null;
	}
	
	public static ShapeSample ShapeStr2Enum(String src)
	{
		switch (src)
		{
			case "Hình chữ nhật":
				return ShapeSample.RECTANGLE;
			case "Hình tam giác":
				return ShapeSample.TRIANGLE;
			case "Hình vuông":
				return ShapeSample.SQUARE;
		}
		return null;
	}
	
	public static Algorithm AlgorithmStr2Enum(String src)
	{
		switch (src)
		{
			case "Tìm số chẵn":
				return Algorithm.FIND_EVEN;
			case "Tìm số lẻ":
				return Algorithm.FIND_ODD;
			case "Tìm số dương":
				return Algorithm.FIND_POSITIVE;
			case "Tìm số âm":
				return Algorithm.FIND_NEGATIVE;				
			case "Tìm số nguyên":
				return Algorithm.FIND_INTEGER;
			case "Tìm số nguyên tố":
				return Algorithm.FIND_PRIME;
		}
		return null;
	}
	
	public static String translateToThisLangugage(TriangleType triangleType)
	{
		if (triangleType == null)
			return "Không là tam giác";
		switch (triangleType)
		{
			case NORMAL:
				return "Tam giác thường";
			case EQUILATERAL:
				return "Tam giác đều";
			case ISOSCELES:
				return "Tam giác cân";
			case RIGHT:
				return "Tam giác vuông";
			case RIGHT_ISOSELES:
				return "Tam giác vuông cân";	
			default:
					return null;
		}
		
		
	}
	
	public static String translateToThisLangugage(Algorithm algoType)
	{		
		switch (algoType)
		{
			case FIND_EVEN:
				return "Tìm số chẵn";
			case FIND_ODD:
				return "Tìm số lẻ";
			case FIND_INTEGER:
				return "Tìm số nguyên";
			case FIND_NEGATIVE:
				return "Tìm số âm";
			case FIND_POSITIVE:
				return "Tìm số dương";	
			case FIND_PRIME:
				return "Tìm số nguyên tố";
			default:
					return null;
		}
		
		
	}
	
}
