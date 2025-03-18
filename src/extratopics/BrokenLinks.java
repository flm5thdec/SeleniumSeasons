package extratopics;

import java.awt.AWTException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinks {
WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
	  driver=	new ChromeDriver();
	  driver.get("https://automationexercise.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  
	}
	
	@Test
	public void brokenLinksTest() throws InterruptedException, AWTException, IOException
	{
	     
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		
		URL url=null;
		HttpURLConnection httpURLConnection=null;
		
		for(WebElement link:allLinks)
		{
			String path=link.getAttribute("href");
			
			url=new URL(path);
			
			 httpURLConnection=(HttpURLConnection)url.openConnection();
			 
			 httpURLConnection.setRequestMethod("HEAD");
			 
			httpURLConnection.connect();
			
			int responseCode=httpURLConnection.getResponseCode();
			
			if(responseCode>=400)
			{
				System.out.println("Broken link "+link.getText()+" Status code is "+responseCode);
			}
			else
			{
				System.out.println("Valid link "+link.getText()+" Status code is "+responseCode);
			}
			
		}
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}

}
