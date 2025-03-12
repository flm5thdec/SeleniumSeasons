package handlings;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertHandling {
	

	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
	  driver=	new ChromeDriver();
	  driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	  driver.manage().window().maximize();
	  
	}
	
	@Test
	public void alertHandleTest() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		
		Alert al=driver.switchTo().alert();
		
		System.out.println(al.getText());
		
		Assert.assertEquals(al.getText(), "Please enter a valid user name");
		
		Thread.sleep(3000);
		
		al.accept();
		
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}


}
