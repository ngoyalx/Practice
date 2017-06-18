package Xebia.SampleMavenProject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class ImageComparison {
	WebDriver driver;
	String viewPort;
	WebDriverWait mywait;
	
	@Test(enabled=false)
	 public void compareImages() throws Exception {

			Boolean isImageverify = false;
			File imageDir = null;
			File diffimageDir = null;
			String diffImage = "";
			String expectedImage = null;
			String actualImage = null;
			/*String viewPort = getviewport();
			viewPort = viewPort.replace("(", "").replace(")", "");
			int w = Integer.parseInt(viewPort.split(",")[0].trim());
			int h = Integer.parseInt(viewPort.split(",")[1].trim());
			*/
			diffimageDir = new File(System.getProperty("user.dir") + "src\\main\\java\\resources\\diffimage");

			expectedImage =System.getProperty("user.dir") + "src\\main\\java\\resources\\" + "Possession_letter_exp.jpeg";
			actualImage = System.getProperty("user.dir") + "src\\main\\java\\resources\\" + "Possession_letter_act.jpeg";
			diffImage = diffimageDir + "diff.jpeg";
			    

			
			Dimension expImgDim, actImgDim;
			try {
			    File expImgFile = new File(expectedImage);
			    File actImgFile = new File(actualImage);
			    File diffImgFile = new File(diffImage);

			    int sample = 0;

			    if (expImgFile.exists()) {

				expImgDim = getImageDim(expImgFile);
				actImgDim = getImageDim(actImgFile);

				BufferedImage expBuffImg = ImageIO.read(expImgFile);
				BufferedImage actBuffImg = ImageIO.read(actImgFile);

				if (expBuffImg.getHeight() != actBuffImg.getHeight() || expBuffImg.getWidth() > actBuffImg.getWidth()) {
				    if (expBuffImg.getHeight() > actBuffImg.getHeight()) {
					FileUtils.copyFile(expImgFile, diffImgFile);
				    } else {
					FileUtils.copyFile(actImgFile, diffImgFile);
				    }
				    int loopwidth = expBuffImg.getWidth();
				    int loopheight = expBuffImg.getHeight();
				    if (expBuffImg.getWidth() > actBuffImg.getWidth()) {
					loopwidth = actBuffImg.getWidth();
				    }
				    if (expBuffImg.getHeight() > actBuffImg.getHeight()) {
					loopheight = actBuffImg.getHeight();
				    }
				  

				    BufferedImage diffBuffImg = ImageIO.read(diffImgFile);

				   
				    for (int i = 0; i < loopwidth; i++) {
					for (int j = 100; j < loopheight; j++) {
					    if (!(expBuffImg.getRGB(i, j) == actBuffImg.getRGB(i, j))) {
						diffBuffImg.setRGB(i, j, -147220175);
						diffBuffImg.flush();
						sample++;
					    }
					    if (j == loopheight - 1) {
						diffBuffImg.setRGB(i, j, -147220175);
					    }
					}
				    }
				    FileOutputStream strm = new FileOutputStream(diffImgFile);
				    ImageIO.write(diffBuffImg, "png", strm);
				    strm.close();
				    // }
				} else {
				    FileUtils.copyFile(expImgFile, diffImgFile);

				    BufferedImage diffBuffImg = ImageIO.read(diffImgFile);

				    if (!diffimageDir.exists()) {
					diffimageDir.mkdir();
				    }

				  
				    for (int i = 0; i < expBuffImg.getWidth(); i++) {
					for (int j = 100; j < expBuffImg.getHeight(); j++) {
					    if (!(expBuffImg.getRGB(i, j) == actBuffImg.getRGB(i, j))) {
						diffBuffImg.setRGB(i, j, -147220175);
						diffBuffImg.flush();
						sample++;
					    }
					}
				    }
				    FileOutputStream strm = new FileOutputStream(diffImgFile);
				    ImageIO.write(diffBuffImg, "png", strm);
				    strm.close();
				}
				// }
			    } else {
				System.out.println("Expected Image is not present at location:-  " + imageDir);
				System.out.println("Expected Image is not present at location:-  " + imageDir);
			    }
			    if (sample != 0) {
				if (diffImgFile.exists()) {
					System.out.println("There is diff in actual and expected images.");
					System.out.println("Mismatch in the Actual and Expected Image: ");
				} else {
				    isImageverify = true;
				}
			    } else {
				isImageverify = true;
				diffImgFile.delete();
			    }
			    if (actImgFile.exists() && !expImgFile.exists()) {
				actImgFile.renameTo(expImgFile);
				System.out.println("Expected screenshot not found.\n New expected screenshot created: " + expImgFile);
				System.out.println("Expected screenshot not found.\n New expected screenshot created: ");
				isImageverify = true;
			    }

			} catch (Exception e) {
			    e.printStackTrace();
			}
			System.out.println("The image comparison is done");
		    }
	
	
public String getviewport(){
	return driver.manage().window().getSize().toString(); 
}

public Dimension getImageDim(File expImgFile) throws IOException {
	ImageInputStream in;
	ImageReader reader = null;
	try {
	    in = ImageIO.createImageInputStream(expImgFile);
	    final Iterator<ImageReader> readers = ImageIO.getImageReaders(in);
	    if (readers.hasNext()) {
		reader = readers.next();
		reader.setInput(in);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    reader.dispose();
	}
	return new Dimension(reader.getWidth(0), reader.getHeight(0));
    }
	
	@Test(enabled=true)
	public void getviewportfirefox(){
		File screen = null;
		BufferedImage img = null;
		BufferedImage dest = null;
		String path = "C:\\Users\\ngoyal\\Desktop\\Images\\";
		
		
		String inputImage = "input_image" + ".png";
		String expectedImage = "expected_image" + ".png";
		
		File imagePath1 = new File(path+inputImage);
		File imagePath2 = new File(path+expectedImage);
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		viewPort = getviewport();
		viewPort = viewPort.replace("(", "").replace(")", "");
		try{
		int w = Integer.parseInt(viewPort.split(",")[0].trim());
		int h = Integer.parseInt(viewPort.split(",")[1].trim());
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		WebElement testobject = driver.findElement(By.xpath("//input[@value='Google Search']"));
		
		Point P = testobject.getLocation();
		
		int width = testobject.getSize().getWidth();
		int height = testobject.getSize().getHeight();
		
		img = ImageIO.read(screen);
		ImageIO.write(img, "png", imagePath1);
		
		dest = img.getSubimage(P.getX(),P.getY(), width, height);
		ImageIO.write(dest, "png", imagePath2);
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		@Test(enabled=false)
		public void scroll(){
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://paytm.com/shop/h/women");
			EventFiringWebDriver evwd = new EventFiringWebDriver(driver);
			mywait = new WebDriverWait(driver, 30);
			WebElement scrollable = driver.findElement(By.xpath("//a[@href='/shop/h/women/eyewear']"));
			int height = scrollable.getSize().height;
			int width = scrollable.getSize().width;
			System.out.println(height);
			
			mywait.until(ExpectedConditions.visibilityOf(scrollable));
			try{
			evwd.executeScript("document.getElementsByClassName('leftmenu style-3')[0].scrollTop=400");
			//scrollable.click();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		
		/*Dimension dim = new Dimension(500,500);
		driver.manage().window().setSize(dim);
		System.out.println(driver.manage().window().getSize().toString());*/
	
	
/*	
  @Test
  public void getviewportchrome() {
	  	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println(driver.manage().window().getSize().toString());
		driver.manage().window().maximize();
		System.out.println(driver.manage().window().getSize().toString());
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  }*/
}
