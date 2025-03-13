package javascriptexecutorandscreenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Highlight {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
	  driver=	new ChromeDriver();
	  driver.get("https://adactinhotelapp.com/");
	  driver.manage().window().maximize();
	 
	}
	
	@Test
	public void dragAndDropTest() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reyaz0806");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("reyaz123");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		Thread.sleep(3000);
		
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Search Hotel");
		
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}

}
