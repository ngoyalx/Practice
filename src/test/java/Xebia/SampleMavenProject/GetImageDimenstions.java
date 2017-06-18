package Xebia.SampleMavenProject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class GetImageDimenstions {
 // String imageurl =  "https://wallpaperscraft.com/image/nature_waterfall_summer_lake_trees_90400_3840x2160.jpg";
  BufferedImage readImage = null;
  JSONObject expectedJSON;
  String thumbnailurl="";
  String altthumbnailurl="";
  List<String> urls = new ArrayList<>();
  HashMap<String,Integer> imageDimensions = new HashMap<>();
  
  public HashMap<String,Integer> getimagedimensions() throws IOException, JSONException {
	expectedJSON = new JSONObject(new Scanner(new File("C:\\Users\\ngoyal\\Desktop\\test1.json")).useDelimiter("\\Z").next());
	//expectedJSON = (JSONObject) expectedJSON.get("content_item");
	expectedJSON = (JSONObject) expectedJSON.get("content_item");
	JSONObject photo_upload = (JSONObject) expectedJSON.get("photo_upload");
	String[] thumbnailAttributes = photo_upload.getNames(photo_upload);
	try{
	for(int i=0; i<thumbnailAttributes.length;i++){
		if(thumbnailAttributes[i]!=null && thumbnailAttributes[i].equalsIgnoreCase("thumbnail")){
			JSONObject thumbnail=(JSONObject) photo_upload.get(thumbnailAttributes[i]);
			thumbnailurl=thumbnail.getString("url").toString();
			//System.out.println(thumbnailurl.substring(thumbnailurl.lastIndexOf("/")+1,thumbnailurl.length()));
			//readimage(thumbnailurl,"thmheight","thmwidth");
			getrequest(thumbnailurl,"altthmheight","altthmwidth");
		}else if(thumbnailAttributes[i]!=null && thumbnailAttributes[i].equalsIgnoreCase("alt_thumbnail")){
			JSONObject altthumbnail=(JSONObject) photo_upload.get(thumbnailAttributes[i]);
			altthumbnailurl=altthumbnail.getString("url").toString();
			//System.out.println(altthumbnailurl.substring(altthumbnailurl.lastIndexOf("/")+1,altthumbnailurl.length()));
			//readimage(altthumbnailurl,"altthmheight","altthmwidth");
			getrequest(altthumbnailurl,"altthmheight","altthmwidth");
		}
	}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return imageDimensions;
  }
	
	public HashMap<String,Integer> readimage(String imageurl,String height,String width) throws IOException, JSONException{
	
    URL url = new URL(imageurl);
   
    HttpURLConnection connection= (HttpURLConnection) url.openConnection();
    connection.addRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
    connection.connect();
    File file = new File("E:\\nitin\\nitin.jpg");
    
	try {
		FileUtils.copyURLToFile(url, file);
		//InputStream stream = connection.getInputStream();
	//	readImage = ImageIO.read(url.openStream());
		readImage = ImageIO.read(file);
	    int heightval = readImage.getHeight();
	    int widthval  = readImage.getWidth();
	    connection.disconnect();
	    System.out.println(heightval);
	    System.out.println(widthval);
	    imageDimensions.put(height,heightval);
	    imageDimensions.put(width, widthval);
	    
	} catch (Exception e) {
	    readImage = null;
	}
	return imageDimensions;
	
  }
	
	@Test
	public void test() throws IOException, JSONException{
		getimagedimensions();
		//getrequest(url);
	}
	
	public void getrequest(String url, String height,String width) throws UnsupportedOperationException, IOException{
	    RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(20000).setConnectTimeout(20000).setSocketTimeout(20000).build();
	    HttpClientBuilder builder = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig);
	    HttpUriRequest request = new HttpGet(url);
	    // Set headers
	    request.setHeader("Authorization", "bearer" + ' ' + "11lh79o86gaekvc141mfojfjt3183llpiben");
	    request.setHeader("Accept", "application/json");
	    request.setHeader("Accept-Encoding", "gzip, deflate");
	    HttpResponse httpResponse_Get = builder.build().execute(request);
	    int statusCode = httpResponse_Get.getStatusLine().getStatusCode();
	    
	    InputStream stream = httpResponse_Get.getEntity().getContent();
	    BufferedImage readimage = ImageIO.read(stream);
	    int heightval = readimage.getHeight();
	    int widthval  = readimage.getWidth();
	    System.out.println(heightval);
	    System.out.println(widthval);
	  
	}
	
	
 
  
  
}
