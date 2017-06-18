package Xebia.SampleMavenProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Arraylisttostring 
{

	
	public static void main(String[] args) 
	{
		//arraytolist();
		//listtoarray();
		//arraytolistusingall();
		  listoarray();
	}
	
	public static void arraytolist()
	{
	Object[] arr={"A", "B","C"};
	ArrayList al=new ArrayList();
	
	for(int i=0;i<arr.length;i++)
	{
	al.add(arr[i]);
	}
	Iterator itr=al.iterator();
	while(itr.hasNext())
	{
	System.out.println(itr.next());
	}
	}
	
	public static void listtoarray()
	{
		ArrayList al=new ArrayList();
		al.add("sunday");
		al.add("monday");
		al.add("tuesday");
		
		Object[] arr=new Object[al.size()];
		for(int i=0;i<al.size();i++)
		{
		arr[i]=al.get(i);
		System.out.println(arr[i]);
		}
		
		/*for(int i=0;i<arr.length;i++)
		{
		System.out.println(arr[i]);
		}*/
		
	}
	
	public static void arraytolistusingall()
	{
		String[] arr = { "1", "4", "3", "5", "2", "7", "6" };
		ArrayList<String> al = new ArrayList<String>();
		Collections.addAll(al,arr);
		for(String s:al)
		{
			System.out.println(s);
		}
		Collections.sort(al);
		System.out.println("Sorted list");
		for(String s:al)
		{
		System.out.println(s);
		}
		al.set(2, "15");
		for(String s:al)
		{
		System.out.println(s);
		}
	}
	
	public static void listoarray()
	{
		ArrayList al=new ArrayList();
		al.add("sunday");
		al.add("monday");
		al.add("tuesday");
		
		Object[] arr=al.toArray(new Object[al.size()]);
		for(Object o:arr)
		{
			System.out.println(o);
		}
	
	}

}
