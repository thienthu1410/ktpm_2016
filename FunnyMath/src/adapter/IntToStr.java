package adapter;

public class IntToStr extends AbstractAdapter {

	private Integer src;
	private String des;

	public void setSrc(int value)
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
		des = Integer.toString(src);
		
		
	}

}
