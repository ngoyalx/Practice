package Xebia.SampleMavenProject;

import java.awt.List;
import java.util.ArrayList;

public class Kannu {
	
	String globalvariable = "ABC";
	
	
	public static void main(String[] args) {
		Kannu newkannu = new Kannu();
		newkannu.nitin();
		newkannu.testMethod();
	}
	
	private static void testMethod(){	
		String str="Kanta";
		int i=5;
		System.out.println(str);
	}
	
	public void nitin(){
		/*for(int i=5;i<=10;i++){
		System.out.println(i);
		}
		*/
		ArrayList<String> list = new ArrayList<String>();
		list.add("Nitin");
		list.add("Kanta");
		list.add("abc");
		list.add("Nitin");
		//System.out.println(list.get(3));
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	

}
