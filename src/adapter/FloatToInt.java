package adapter;

public class FloatToInt extends AbstractAdapter {

	private Float src;
	private int des;

	public void setSrc(float value)
	{
		src = value;
	}
	
	public int getDes()
	{
		return des;
	}
	@Override
	public	void convert() {
		// TODO Auto-generated method stub
		des = src.intValue();
		
		
	}

}
