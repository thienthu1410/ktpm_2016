package adapter;

public class FloatToStr extends AbstractAdapter {

	private Float src;
	private String des;

	public void setSrc(float value)
	{
		src = value;
	}
	
	public String getDes()
	{
		return des;
	}
	@Override
	public	void convert() {
		// TODO Auto-generated method stub
		des = Float.toString(src);
		
		
	}

}
