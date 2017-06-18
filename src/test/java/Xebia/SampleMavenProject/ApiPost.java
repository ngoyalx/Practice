package Xebia.SampleMavenProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.testng.annotations.Test;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.client.methods.HttpUriRequest;
import org.json.JSONObject;



public class ApiPost 
{
	String slug="";
	String posturl="https://content-api.p2p.tribstage.com/content_items.json";
	String geturl="https://content-api.p2p.tribstage.com/content_items/";
	String authentication="bearer"+' '+"11lh79o86gaekvc141mfojfjt3183llpiben";
	HttpClient client=new HttpClient();
	
  @Test
  public void postapi() 
  {
	  try{
	  
	  Scanner scanner=new Scanner(new File("C:\\Users\\ngoyal\\Desktop\\POST\\Input.json"));
	  String jsonasstring=scanner.useDelimiter("\\Z").next();
	  JSONObject completejsonobject=new JSONObject(jsonasstring);
	  System.out.println(completejsonobject);
	  completejsonobject.toString(4);
	  System.out.println(completejsonobject);
	  
	  PostMethod post=new PostMethod(posturl);
	  
	  post.setRequestHeader("Authorization",authentication);
	  post.setRequestHeader("Accept","application/json");
	  
	  post.setRequestEntity(new StringRequestEntity(completejsonobject.toString(),"application/json","utf8"));
	  
	  int statuscode=client.executeMethod(post);
	  System.out.println(statuscode);
	  
	  byte[] responsebody=post.getResponseBody();
	  String responsebodyasstring=new String(responsebody,StandardCharsets.UTF_8);
	  JSONObject responsebodyasjson= new JSONObject(responsebodyasstring);
	  System.out.println(responsebodyasjson);
	  
	  JSONObject jsonresponse=responsebodyasjson.getJSONObject("blurb");
	  System.out.println(jsonresponse);
	  slug= jsonresponse.get("slug").toString();
	  System.out.println(slug);
	  }
	  catch(FileNotFoundException e)
	  {
		  e.getMessage();
	  }
	  catch(Exception e)
	  {
		  e.getMessage();
	  }
  }
  
  public void getrequest()
  {
	  
	  
  }
}
