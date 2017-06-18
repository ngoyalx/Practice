package Xebia.SampleMavenProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.TreeMap;

import org.testng.annotations.Test;
import org.apache.bcel.generic.NEWARRAY;
import org.json.simple.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;





public class Json
{
	Properties prop=System.getProperties();
	String fileseperator=File.separator;
	String inputjsonpath=System.getProperty("user.dir")+fileseperator
			+"src"+fileseperator+"main"+fileseperator+"java"+fileseperator+"resources"+fileseperator+"input1.json";
	
	
	/*String txt = new Scanner(new File(path)).useDelimiter("\\Z").next();
	This will read an entire file into the String.

	Let me break that down for you:

	String txt = // the resulting String is stored here
	new Scanner( // Create a scanner to read the file
	new File( "pathToFile" ) ) // pass a new file to the scanner to read
	.useDelimiter("\\Z") // set the delimiter to the end of the file
	.next(); // read the scanner until the next delimiter, 
	         // in this case it is the end of the file.
			*/
	
  @Test(enabled=false)
  public void writejsonobject() throws JSONException, IOException 
  {
	  
	  JSONObject obj=new JSONObject();
	  obj.put("Name", "Nitin");
	  obj.put("Empidd","12345");
	  
	  JSONArray list = new JSONArray();
	  list.add("test1");
	  list.add("test2");
	  list.add("test3");
	  
	  obj.put("messages",list);
	  FileWriter writer=new FileWriter("C:\\Users\\ngoyal\\Desktop\\test.json");
	  writer.write(obj.toString());
	  writer.flush();
	  writer.close();  
	  
	  Scanner scanner=new Scanner(new File("C:\\Users\\ngoyal\\Desktop\\test.json"));
	  String jsonstring=scanner.useDelimiter("\\Z").next();
	  JSONObject jsonobject=new JSONObject(jsonstring);
	  JSONArray msg = (JSONArray) jsonobject.get("messages");
	  Iterator itr=msg.iterator();
	  while(itr.hasNext())
	  {
		  
		 System.out.println(itr.next());
	  }
	  
  }
  
  
  @Test(enabled=true)
  public void addKey() throws JSONException, FileNotFoundException{
	  Scanner scanner=new Scanner(new File(inputjsonpath));
	  String next=scanner.useDelimiter("\\Z").next();
	  JSONObject completejsonobject=new JSONObject(next);
	  System.out.println(next);
	  
	  Object contentitem=completejsonobject.get("items");
	  System.out.println(contentitem);
	  org.json.JSONArray newarray = new org.json.JSONArray();
	  
	  if(contentitem instanceof org.json.JSONArray){
		  org.json.JSONArray array = (org.json.JSONArray)completejsonobject.getJSONArray("items");
		  for(int i=0;i<array.length();i++){
			  HashMap<String, String> hm  = new HashMap<>();
			  String value = array.get(i).toString();
			  hm.put("id",value);
			  newarray.put(hm);
		  }
	  }
	  completejsonobject.put("items",newarray);
	  System.out.println(completejsonobject);
  }
	  
  
  @Test(enabled=false)
  public void readjsonfile() throws JSONException, IOException
  {
	  
	  List<Object> objects = new ArrayList<>();
	  List<Integer> positionvalues = new ArrayList<>();
	  try{
	  Scanner scanner=new Scanner(new File(inputjsonpath));
	  String next=scanner.useDelimiter("\\Z").next();
	  JSONObject completejsonobject=new JSONObject(next);
	  System.out.println(next);
	  
	  Object contentitem=completejsonobject.get("items");
	  System.out.println(contentitem);
	  if(contentitem instanceof org.json.JSONArray){
		  org.json.JSONArray array = (org.json.JSONArray)completejsonobject.getJSONArray("items");
		  for(int i=0;i<array.length();i++){
			  JSONObject arrobj = (JSONObject)array.get(i);
			  String [] keys = arrobj.getNames(arrobj);
			  for(String key:keys){
				  if(key.equalsIgnoreCase("position")){
					int positionvalue = Integer.parseInt(arrobj.get(key).toString()); 
					positionvalues.add(positionvalue);
				  }
			  }
		  }
		  Collections.sort(positionvalues);
		  org.json.JSONArray newarray = new org.json.JSONArray();
		  for(int i=0;i<array.length();i++){
			  int j=0;
			  while(j<array.length()){
			  JSONObject arrobj = (JSONObject)array.get(j);
			  Object value = arrobj.get("position");
			  Object objPositionValue = positionvalues.get(i);
			  
			  if(value.equals(objPositionValue)){
				  newarray.put(arrobj);
				  break;
			  }else{
					  j++;
				  }
			  }
		  }
		  System.out.println(completejsonobject.put("items",newarray).toString());
	  }
	  
	  
	 /* String title=contentitem.get("source_code").toString();
	  System.out.println("The title is"+title);
	  String newtitle="ABC"+title;
	  completejsonobject.put("source_code",newtitle);
	  System.out.println(completejsonobject.get("source_code").toString());
	  
	  //objects.add(contentitem);
	  completejsonobject.remove("items");
	  completejsonobject.put("related_items", contentitem);
	  System.out.println(completejsonobject);
	 */ 
	  
	/* if(contentitem instanceof org.json.JSONArray){
		 org.json.JSONArray newarr = (org.json.JSONArray)contentitem;
		 for(int i=0;i<newarr.length();i++){
			 JSONObject ob = (JSONObject)newarr.get(i);
			 Object slug = ob.get("slug");
			 System.out.println(ob.get("slug"));
			 System.out.println(slug);
		 }
	 }
	 
	 
	 /*completejsonobject.remove("content_item"); 
	  
	  Object relateditems = contentitem.get("related_items");
	  if(relateditems instanceof org.json.JSONArray){
		  
		  org.json.JSONArray relateditemarray = (org.json.JSONArray) relateditems;
		  JSONObject relateditemasJSONObject = new JSONObject();
		  org.json.JSONArray jsonarray = new org.json.JSONArray();
		  
		  //relateditemasJSONObject = (JSONObject)relateditemarray.toJSONObject(relateditemarray);
		  
		  
		  for(int i=0;i<relateditemarray.length();i++){
			  JSONObject obj = relateditemarray.getJSONObject(i);
			  jsonobjects.add(obj);
		  }
		  relateditemasJSONObject.put("related_items", jsonobjects);
		  
		//  relateditemasJSONObject.put("related_items", relateditemarray);
		 	  
		 
		  System.out.println(relateditemasJSONObject);
		  FileWriter writer=new FileWriter("C:\\Users\\ngoyal\\Desktop\\test.json");
		  writer.write(relateditemasJSONObject.toString());*/
	  }catch(Exception e)
	  {
		  e.getMessage();
	  }
  }
  
  
  @Test(enabled=false)
  public void readjson1()
  {
	  try
	  {
		 //reading the json file as a string
	  Scanner scan=new Scanner(new File("C:\\Users\\ngoyal\\Desktop\\POST\\Output.json"));
	  String jsonasstring=scan.useDelimiter("\\Z").next();
	  
	  //Getting the json object from the jsonasstring
	  JSONObject completejsonobject=new JSONObject(jsonasstring);
	  System.out.println(completejsonobject);
	  
	  //Getting the names of all objects and their values from JSON file.
	 /* String[] completenames=completejsonobject.getNames(completejsonobject);
	  for(String s:completenames)
	  {
		  System.out.println("The key for the object is"+ s+"=="+"the value of the key is"+ completejsonobject.get(s));
	  }*/
	  
	  //getting a particular object from complete JSON object
	  
	 /* JSONObject objnitin=completejsonobject.getJSONObject("Nitin");
	  System.out.println(objnitin);
	  
	  String[] parobjnames=objnitin.getNames(objnitin);
	  for(String s1:parobjnames)
	  {
		  System.out.println(s1);
		  if(s1.equalsIgnoreCase("location"))
		  {
			  Object value=objnitin.get(s1);
			  System.out.println(value);
			  break;
		  }

	  }*/
	  
	  //Getting a JSON array from complete JSON object
	  
	  org.json.JSONArray jarr=completejsonobject.getJSONArray("new books");
	  for(int i=0;i<jarr.length();i++)
	  {
		  JSONObject jarrobj=jarr.getJSONObject(i);
		  //System.out.println(jarrobj);
		  String[] jarrobjnames=jarrobj.getNames(jarrobj);
		  for(String s2:jarrobjnames)
		  {
			  System.out.println(s2+"::::"+jarrobj.get(s2));
		  }
	  }
	  
	  
	  
	  //Getting any key from JSON object and updating the value corresponding to that key
	  
	  JSONObject ob=completejsonobject.getJSONObject("Nitin");
	  String location=ob.get("Location").toString();
	  System.out.println(location);
	  String location1="new"+location;
	  ob.put("Location",location1);
	  completejsonobject.put("Nitin",ob);
	  System.out.println(completejsonobject);
	  }
	  catch(FileNotFoundException e)
	  {
		  System.out.println(e.getMessage());
	  }
	  catch(JSONException e)
	  {
		  System.out.println(e.getMessage());
	  }
}
	  
  
  
  @Test(enabled=false)
  public void getjsonkeys()
  {
	  try{
	  Scanner scanner=new Scanner(new File("C:\\Users\\ngoyal\\Desktop\\POST\\Input.json"));
	  String jsonasstring=scanner.useDelimiter("\\Z").next();
	  JSONObject completejsonobject=new JSONObject(jsonasstring);
	  JSONObject content_item=completejsonobject.getJSONObject("content_item");
	  
	  String[] contentkeys=content_item.getNames(content_item);
	  
	  
	  TreeMap<String, Object> tm=new TreeMap<>();
	  for(String s:contentkeys)
	  {
		  tm.put(s,content_item.get(s));
	  }
	  
	  for(Map.Entry<String,Object> mapentry:tm.entrySet())
	  {
		 System.out.println(mapentry.getKey()+"===="+mapentry.getValue());
	  }
	  
	  }
	  catch(FileNotFoundException e)
	  {
		  System.out.println(e.getMessage());
	  }
	  catch(JSONException e)
	  {
		  System.out.println(e.getMessage());
	  }
  }
  
  //Reading JSON array out of JSON Object and getting the key value pair.
  @Test(enabled=false)
  public void readjsonarray() throws FileNotFoundException, JSONException
  {
	  Map<String, String> mp=new HashMap<String, String>();
	  mp.put("slug", "ABC");

	  try{
	  Scanner scanner=new Scanner(new File("C:\\Users\\ngoyal\\Desktop\\POST\\Input.json"));
	  String next=scanner.useDelimiter("\\Z").next();
	  
	  JSONObject jobj=new JSONObject(next);
	  System.out.println("Jsonobject======="+  jobj.toString());
	  
	  org.json.JSONArray arr = jobj.getJSONArray("items");
	  System.out.println("Jsonarray========"+  arr);
	  
	  try{
		 ArrayList<String> list=new ArrayList<>();
		  
		 if(arr!=null){
			 for(int i=0;i<arr.length();i++){
				 list.add(arr.get(i).toString());
			 }
		 }
		 list.remove(0);
		 org.json.JSONArray newarr=new org.json.JSONArray(list);
		 newarr.put(mp);
		 
		 System.out.println("After adding the map" + newarr);
		 
	  JSONObject expectedJSON=(JSONObject)arr.get(0);
//	  System.out.println("Expected JSON is"+expectedJSON);
	  }
	  catch(Exception e){
		  System.out.println(e.getMessage());
	  }
	  
	  Object rawobj=arr.get(0).toString();
	  System.out.println("Jsonarrayobj======"+ rawobj);
	  
	  System.out.println(arr.get(0).toString().replaceAll(rawobj.toString(),"xyz"));
	  
	  String newvalue=arr.get(0).toString().replaceAll(rawobj.toString(),"xyz");
	  
	  
	  System.out.println("Array after replacing the slug======"+arr);
	  
	  arr.put(0,newvalue);
	  
	  System.out.println(arr);
	  
	  System.out.println(jobj);
	  
	/*  String names[]=jobj.getNames(jobj);
	  for(String name:names)
	  {
		 JSONObject newobj= jobj.getJSONObject(name);
		 System.out.println(newobj.toString());
		 String[] newnames=newobj.getNames(newobj);
		 for(String newname:newnames){
			 System.out.println(newname);
			 if(newname.equalsIgnoreCase("embedded_items")){
				Object actualvalue=newobj.get("embedded_items");
				System.out.println("The actual value is"+actualvalue);
				
				org.json.JSONArray requiredarray=(org.json.JSONArray) actualvalue;
				jobj.remove(name);
				System.out.println("After removing the content item"+jobj);
				jobj.put("embedded_items",requiredarray);
				System.out.println(jobj);
			 
		 }
		 }
	  }*/
	  }
  catch(Exception e)
  {
	  e.getMessage();
  }
}
}