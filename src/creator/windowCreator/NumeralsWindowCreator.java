package creator.windowCreator;

import javax.swing.JDialog;

import numeralsChoices.Numerals;

import GUI.support.windowCreator.FindNumbersDialog;
import GUI.support.windowCreator.FindPrimesDialog;

public class NumeralsWindowCreator {
	
	public JDialog createWindow(int type)
	{
		switch(type)
		{
			case Numerals.FIND_PRIMES_OF:
			{
				return new FindPrimesDialog().createWindow();
			}
			
			case Numerals.FIND_NUMBERS_FROM_SERIES:
			{
				return new FindNumbersDialog().createWindow();
			}
								
		}
		
		return null;
	}

}


