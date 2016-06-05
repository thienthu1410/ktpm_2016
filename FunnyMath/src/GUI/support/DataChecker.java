package GUI.support;

import java.awt.event.KeyEvent;

public class DataChecker 
{
	public boolean canAddMore(String value, KeyEvent key)
	{
		if (value.equals("."))
			return false;
		if (value.indexOf(".") != value.lastIndexOf("."))
		{
			if (IsPointer.isValid(key))
				return false;
			if (IsNumber.isValid(key))
				return true;
		}
		
		else 
		{
			if (IsPointer.isValid(key) || IsNumber.isValid(key))
				return true;			
		}
		
		return false;
	}
	
	public boolean canAddNegativeSignal(String value, KeyEvent key)
	{
		if (value.equals("-"))
			return true;
		if (value.indexOf("-") != value.lastIndexOf("-"))
		{
			return false;
		}
		
		else 
		{
			if (IsPointer.isValid(key) || IsNumber.isValid(key))
				return true;			
		}
		
		return false;
	}
	
	public boolean isNumber (KeyEvent key)
	{
		return IsNumber.isValid(key);
	}

}



class IsNumber
{


	public static  boolean isValid(KeyEvent key) {
		// TODO Auto-generated method stub
		if (key.getKeyChar() == '1' || key.getKeyChar() == '2' 
			|| key.getKeyChar() == '3' || key.getKeyChar() == '4'
			|| key.getKeyChar() == '5' || key.getKeyChar() == '6' 
			|| key.getKeyChar() == '7' || key.getKeyChar() == '8'
			|| key.getKeyChar() == '9' || key.getKeyChar() == '0')
		return true;
		
		return false;
	}
}

class IsPointer
{
	public static  boolean isValid(KeyEvent key) {
		// TODO Auto-generated method stub
		if (key.getKeyChar() == '.')
			return true;
		
		return false;
	}
}


