package creator.algorithmMachine;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.TreeMap;

import languageSupport.EnglishTranslator;

import algorithm.search.AbstractAlgorithm;
import algorithm.search.Algorithm;

public class AlgorithmLoader {
	TreeMap<Algorithm, AbstractAlgorithm> algorithm = null;
	private static AlgorithmLoader instance = null;
	
	private AlgorithmLoader()
	{
		algorithm = new TreeMap<Algorithm, AbstractAlgorithm>();
		try {
			loadAlgorithm();
		} catch (MalformedURLException | ClassNotFoundException
				| InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static AlgorithmLoader init()
	{
		if (instance == null)
		{
			instance = new AlgorithmLoader();
		}
		
		return instance;
	}
	
	public TreeMap<Algorithm,  AbstractAlgorithm> getList()
	{
		return algorithm;
	}
	
	private void loadAlgorithm() throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		File folder = new File ("bin/algorithm/search/concrete");
		URL url = folder.toURI().toURL(); 
		URL[] urls = new URL[]{url}; 
			
        //load this folder into Class loader
		@SuppressWarnings("resource")
		ClassLoader cl = new URLClassLoader(urls); 
			
		File[] files = folder.listFiles();
		
		for (File classFile : files)
		{
			String className = classFile.getName();
			String s = className.substring(0, className.lastIndexOf("."));
			
			@SuppressWarnings("rawtypes")
			Class  cls = cl.loadClass("algorithm.search.concrete." + s);	
			Object object =  cls.newInstance();
			addAlgorithmSample(EnglishTranslator.AlgoStr2Enum(s), (AbstractAlgorithm) object);									
		}
	}
	
	private void addAlgorithmSample(Algorithm id, AbstractAlgorithm sample)
	{
		algorithm.put(id, sample);
	}
	
	public AbstractAlgorithm getAlgorithm(Algorithm id)
	{
		if (algorithm.containsKey(id))
			return algorithm.get(id);
		return null;
	}
	
	

}
