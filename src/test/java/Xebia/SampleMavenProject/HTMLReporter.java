package Xebia.SampleMavenProject;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.common.io.Files;

public class HTMLReporter {
	
	static List<String> result=new ArrayList<String>();
			
	static String testcasedetails1="POSt!user send a post request!Test Remarks1";
	static String testcasedetails2="PUT!user send a put request!Test Remarks2";
	static String testcasedetails3="GET!user send a get request!Test Remarks3";
	static String Html_Content_String="";
	static String HTML_Header_String="";
	static String File_Path=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\HTMLREPORT.html";
	
	public static void main(String[] args) {
		result.add(testcasedetails1);
		result.add(testcasedetails2);
		result.add(testcasedetails3);
		try{
		Scanner scanner = new Scanner(new File(File_Path));
		String str = scanner.useDelimiter("\\Z").next();
		scanner.close();
		HTML_Header_String=str;
		
		for(String testdetail: result){
			String[] item = testdetail.split("!");
			
			String step= item[0];
			String result1= item[1];
			String remarks= item[2];
			
			Html_Content_String = Html_Content_String + "<tr>";
			
			Html_Content_String = Html_Content_String + "<td>&nbsp;" + step + "</td>";
			Html_Content_String = Html_Content_String + "<td>&nbsp;" + result1 + "</td>";
			Html_Content_String = Html_Content_String + "<td>&nbsp;" + remarks + "</a>" + "</td>";
			
			Html_Content_String = Html_Content_String + "</tr>";
			
			String currenttime = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
			try
			{
				HTML_Header_String = HTML_Header_String.replace("$ExecutionStartTime", currenttime);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
		Html_Content_String = Html_Content_String + "</table></body></html>";
		
		
		File file = new File(System.getProperty("user.dir") + "\\test-output\\Nitin" + ".html");
		if (file.exists()) {
			file.delete();
		}
		file.getParentFile().mkdirs();
		file.createNewFile();

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		fw.write(HTML_Header_String);
		fw.write(Html_Content_String);
		fw.close();
		
		}
				
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
