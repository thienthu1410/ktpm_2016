package shapeSupport;

import algorithm.search.helper.compareFloat.CompareFloatHelper;





public class IsTriangle
{

	public boolean check (float a, float b, float c)
	{			
		Float sum_ab = a + b, sum_ac = a + c, sum_bc = b + c;
		
		CompareFloatHelper compareHelper = new CompareFloatHelper();
		if (compareHelper.compare(sum_ab, c) <= 0 
			||compareHelper.compare(sum_bc, a) <= 0  
			|| compareHelper.compare(sum_ac, b) <= 0 )
			return false;
		
		return true;
			
		
		
	}

}






