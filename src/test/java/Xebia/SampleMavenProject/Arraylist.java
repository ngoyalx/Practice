package Xebia.SampleMavenProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Arraylist {

	
	public static void main(String[] args) 
	{

		ArrayList al=new ArrayList();
		ArrayList al1=new ArrayList();
		al.add("Geeta");
		al.add("Maggo");
		al.add("1");
		al.add("Nitin");
		al.add("1");
		al.add(2, "test at particular index");
		al1.add("Geeta1");
		al1.add("Nitin1");
		//adding list 1 to list
		al.addAll(al1);
		
		//iterating list elements
		Iterator itr=al.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		
		//Adding array elements to a list
		Object[] arr={"Sunday","Monday","Tuesday"};
		for(int i=0;i<arr.length;i++)
		{
		al.add(arr[i]);
		}
	
		//creating a list using Arraysaslist method
		ArrayList al2= new ArrayList(Arrays.asList("Sunday","Monday","Tuesday"));
		Iterator itr1=al2.iterator();
		while(itr1.hasNext())
		{
			System.out.println(itr1.next());
		}
		
		
		//al.retainAll(al1);
		/*for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i));
		}*/
		
		
		ArrayList<String[]> elementasarray=new ArrayList<String[]>();
		
		String[] s1={"1","2","3"};
		String[] s2={"ID","test","testcase"};
		String[] s3={"pqr","xyz","abc"};
		
		
		
		elementasarray.add(s1);
		elementasarray.add(s2);
		elementasarray.add(s3);
		
		for(int i=0;i<elementasarray.size();i++)
		{
		String[] output=elementasarray.get(i);
		for(int j=0;j<output.length;j++)
		{
			System.out.println(output[j]);
		}
		}
		
		
		
	}

}
