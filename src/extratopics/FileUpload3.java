package extratopics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload3 {
	
WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
	  driver=	new ChromeDriver();
	  driver.get("https://imgur.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  
	}
	
	@Test
	public void webTableTest() throws InterruptedException, AWTException
	{
	
		driver.findElement(By.xpath("//img[@alt='New post']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[text()='Choose Photo/Video']/img")).sendKeys("D:\\FLM5thDecWS\\SeleniumSeasons\\Frames handling.png");
		
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}


}
