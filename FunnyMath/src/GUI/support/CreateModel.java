package GUI.support;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class CreateModel {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void initData(Map containerTree, DefaultListModel model)
	{				
			
		Set set = containerTree.entrySet();
	     // Get an iterator
	     Iterator i = set.iterator();
	     // Display elements
	     while(i.hasNext()) {
	   	  Map.Entry me = (Map.Entry)i.next();
	   	  model.addElement(me.getValue().toString());
	   	  
	     } 
	}
	
	public static void initData(Map containerTree, DefaultComboBoxModel model)
	{				
			
		Set set = containerTree.entrySet();
	     // Get an iterator
	     Iterator i = set.iterator();
	     // Display elements
	     while(i.hasNext()) {
	   	  Map.Entry me = (Map.Entry)i.next();
	   	  model.addElement(me.getValue().toString());
	   	  
	     } 
	}
	
	
	
	

}
