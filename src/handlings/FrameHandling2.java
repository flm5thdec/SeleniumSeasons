package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameHandling2 {
	

	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
	  driver=	new ChromeDriver();
	  driver.get("https://www.angelfire.com/super/badwebs/");
	  driver.manage().window().maximize();
	  
	}
	
	@Test
	public void dragAndDropTest() throws InterruptedException
	{
		
		driver.switchTo().frame("main");
		
		driver.findElement(By.xpath("//a[contains(@href,'monkeyspaw')]")).click();
		
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("contents");
		
		driver.findElement(By.xpath("(//font[contains(text(),'I Hate Frames')]/parent::a)[1]")).click();
		
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}

}
