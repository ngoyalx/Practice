package Xebia.SampleMavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.Set;

public class Hashmap 
{


	public static void main(String[] args) throws IOException 
	{

		HashMap<Object, Object> hm1=new HashMap<Object, Object>();
		hm1.put(1, "Nitin");
		hm1.put(2, "Goyal");
		hm1.put(10, "Test");
		
		
		Set<Object> set=hm1.keySet();
		for(Object key:set)
		{
			System.out.println(key+"---------"+hm1.get(key));
		}
	
		
		HashMap<Object, Object> hm2=new HashMap<Object, Object>();
		hm2.put(1, "Nitin");
		hm2.put(2, "Goyal");
		hm2.put(10, "Test1");
		
		Hashmap hashmap=new Hashmap();
		//hashmap.comparehashmap(hm1, hm2);
		hashmap.populatehashmap();
		
		
	
	/*	for(Map.Entry m:hm.entrySet())
		{
			System.out.println(m.getKey()+"-------"+m.getValue());
			System.out.println(m.getValue());
		}*/
		
	}
	
	public void populatehashmap() throws IOException
	{
		HashMap<Object, Object> hm3=new HashMap<Object, Object>();
		File file=new File("E:\\Nitin\\Workspace\\CheapoairAndroid\\uiautomation.properties");
		FileInputStream fs=new FileInputStream(file);
		//Properties prop=System.getProperties();
		Properties prop=new Properties();
		prop.load(fs);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		prop.getProperty("RemoteUrl");
		
	    Enumeration em = prop.keys();
	    Set keySet = prop.keySet();
	    Object[] keys = keySet.toArray();
	    int i = 0;
	    while (em.hasMoreElements()) 
	    {
		String element = (String) em.nextElement();
		hm3.put(keys[i].toString().toLowerCase(), prop.getProperty(element));
		i++;
		}
	}
	
	
		public boolean comparehashmap(Map<Object,Object> map1,Map<Object,Object> map2)
		{
		if(map1.size()==map2.size())
		{
			Set<Object> set=map1.keySet();
			for(Object key:set)
			{
				String mapvalue1=String.valueOf(((map1.get(key)==null)? "": map1.get(key))).trim();
				String mapvalue2=String.valueOf(((map2.get(key)==null)? "": map2.get(key))).trim();
				if(!mapvalue1.equalsIgnoreCase(mapvalue2))
				{
					System.out.println("Values in the hashmap are not macthing" + mapvalue1+"----"+ mapvalue2);
					return false;
				}
			}
			System.out.println("Hashmaps are same");
			return true;
		}
		return false;
		}

}
