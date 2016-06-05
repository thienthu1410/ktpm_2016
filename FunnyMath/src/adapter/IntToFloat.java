package adapter;

public class IntToFloat extends AbstractAdapter {

	private Integer src;
	private float des;

	public void setSrc(int value)
	{
		src = value;
	}
	
	public float getDes()
	{
		return des;
	}
	@Override
	public	void convert() {
		// TODO Auto-generated method stub
		des = src.floatValue();
		
		
	}

}
