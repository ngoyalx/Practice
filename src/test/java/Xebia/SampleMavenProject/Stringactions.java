package Xebia.SampleMavenProject;

import java.io.File;

public class Stringactions {

	static String str="15/01/1987";
	static String newstr="test@abc.4554545";
	static String var="a";
	static String str1="ABC"+var+"JKL";
	static String str2="-87.62980";
	static String url="http://p1.pichost.me/i/29/1523885.jpg";
	public static void main(String[] args) 
	{
	
		//stringsplit(str);
		//getmethodname();
		/*int index=str1.indexOf(var);
		System.out.println(index);
		String st=str1.substring(0,3)+"newvalue"+str1.substring(3+1);
		System.out.println(st);*/
		/*System.out.println(str2.substring(str.length()-1,1));
		System.out.println(str2.substring(0,str2.length()-1));
		*/
		/*char[] f = str2.toCharArray();
		System.out.println(f);*/
		
		System.out.println(url.lastIndexOf("/"));
		System.out.println(url.length());
		System.out.println(url.substring(26,37));
	
	
		
	}
	
	/*public static void getmethodname()
	{
		int posi=newstr.indexOf(".");
		String value=newstr.substring(0,posi);
		int posi1=value.indexOf("@");
		value=value.substring(posi1+1);
		System.out.println(value);
	}*/
	
	/*public static Object[] stringsplit(String value)
	{
		String[] newvalue=value.split("/");
		for(int i=0;i<newvalue.length;i++)
		{
			System.out.println(newvalue[i]);
		}
		String date=newvalue[0];
		System.out.println(date);
		String month=newvalue[1];
		System.out.println(month);
		String year=newvalue[2];
		System.out.println(year);
		return newvalue;
	}
*/
}
