package Xebia.SampleMavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Set;


public class HashMapConcepts 
{
	
	
	static HashMap<Integer, String> hm=new HashMap<>();
	static HashMap<String, ArrayList<Object>> hm1=new HashMap<>();
	static ArrayList al=new ArrayList();
	static ArrayList a2=new ArrayList();
	static HashMap<ArrayList<Object>,ArrayList<Object>> hm2=new HashMap<>();
	static Hashtable<Integer, String> ht=new Hashtable<>();
	static TreeMap<Integer, String> tm=new TreeMap<Integer,String>();
	static HashMap<String, String> hms=new HashMap<>();
	

	
	public static void main(String[] args) throws IOException 
	{
		hm.put(1, "nitin");
		hm.put(5, "Goyal");
		hm.put(10, "Shail");
		hm.put(12, "Goyal");
		
		File file =new File("C:\\Users\\ngoyal\\git\\Localtestrepository\\SampleMavenProject\\src\\main\\java\\uiautomation.properties");
		FileInputStream fs=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fs);
		Enumeration em1=prop.keys();
		Set keyset1=prop.keySet();
		Object[] allkeys=keyset1.toArray();
		int i=0;
	/*	for(int j=0;j<allkeys.length;j++)
		{
			String element1=prop.getProperty((String) allkeys[j]);
			hms.put(allkeys[j].toString().toLowerCase(),element1);
		}*/
		
		
		while (em1.hasMoreElements()) 
		{
			String element=(String) em1.nextElement();
			hms.put(allkeys[i].toString().toLowerCase(),prop.getProperty(element));
			i++;
		}
		
		Set hmskeysset=hms.keySet();
		for(Map.Entry mapentry:hms.entrySet())
		{
			System.out.println(mapentry.getKey()+":"+mapentry.getValue());
		}
		
		for(Map.Entry<Integer,String> entry:hm.entrySet())
		{
			int key=entry.getKey();
			String value=entry.getValue();
			System.out.println(key+" : "+ value);
		}
		
		Set<Integer> keys=hm.keySet();
		for(Integer k:keys)
		{
			System.out.println(hm.get(k));
			System.out.println("Key is"+k+"Value is : "+hm.get(k));
		}
		
		System.out.println(hm.containsKey(12));
		
		Iterator itr=hm.entrySet().iterator();
		while(itr.hasNext())
		{
			Map.Entry<Integer, String> pair=(Entry<Integer, String>) itr.next();
			System.out.println(pair.getKey()+":" +pair.getValue());
		}

		al.add("test1");
		al.add("test2");
		al.add("test3");
		al.add("test4");
		
		a2.add("test11");
		a2.add("test12");
		a2.add("test13");
		a2.add("test14");
		
		hm1.put("Nitin",al);
		hm1.put("Goyal", a2);
		
		Set keyset=hm1.keySet();
		for(Object key:keyset)
		{
			List keyelements=hm1.get(key);
			for(Object c:keyelements)
			{
				System.out.print(c);
			}
			System.out.println();
		}
		
		hm2.put(al, a2);
		
		Set keysnew=hm2.keySet();
		for(Object k:keysnew)
		{
			System.out.println(k);
		}
		
		ht.put(1, "Nitin");
		ht.put(5, "Nitin");
		ht.put(10, "Aaru");
		ht.put(15, "Shefi");
		
		Enumeration em=ht.elements();
		Set<Integer> keysht=ht.keySet();
		for(Integer k:keysht)
		{
			System.out.println(k+":"+ht.get(k));
		}
		while(em.hasMoreElements())
		{
			System.out.println(em.nextElement());
		}
		
		tm.put(11, "Nitin");
		tm.put(5, "Nitin");
		tm.put(10, "Aaru");
		tm.put(15, "Shefi");
		
		Set keystm=tm.keySet();
		for(Object k1:keystm)
		{
			System.out.println(k1+":"+tm.get(k1));

		}

}
}