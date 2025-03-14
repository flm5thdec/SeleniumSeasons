package javascriptexecutorandscreenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenShot1 {
	
WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
	  driver=	new ChromeDriver();
	  driver.get("https://adactinhotelapp.com/");
	  driver.manage().window().maximize();
	 
	}
	
	@Test
	public void screnshotTest() throws InterruptedException, IOException
	{
		
		//Down casting 
		
		//TakesScreenshot ts= (TakesScreenshot) driver;
		
		File srcFile=( (TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(srcFile, new File("D:\\FLM5thDec\\Adactin1.png"));
		
		
	
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}

}
