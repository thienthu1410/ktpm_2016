package algorithm.calculate;

public  class Div extends AbstractCalculate 
{

	private int result = 0;
	@Override
	public void calculate(float value1, float value2) {
		// TODO Auto-generated method stub
		result = (int) (value1) / (int) (value2);
	}
	
	public int getResult()
	{
		return result;
	}

	
	
	

}
