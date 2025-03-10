package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowHandle {
	
WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
	  driver=	new ChromeDriver();
	  driver.get("https://adactinhotelapp.com/");
	  driver.manage().window().maximize();
	  
	}
	
	@Test
	public void multipleWindowHandleTest() throws InterruptedException
	{
		
		
		driver.findElement(By.xpath("//img[contains(@src,'google-play')]")).click();
		
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
		
		
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}


}
