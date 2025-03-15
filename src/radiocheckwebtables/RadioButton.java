package radiocheckwebtables;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButton {
	
	
WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
	  driver=	new ChromeDriver();
	  driver.get("https://echoecho.com/htmlforms10.htm");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 
	}
	
	@Test
	public void radioButtonTest1() throws InterruptedException, IOException
	{
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Milk']")).isSelected());
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Butter']")).isSelected());
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Cheese']")).isSelected());
		
		
	}
	
	@Test
	public void radioButtonTest2() throws InterruptedException, IOException
	{
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//input[@value='Milk']")));
		
		Thread.sleep(3000);
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@value='Milk']")));
		
		
		Thread.sleep(3000);
				
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Milk']")).isSelected());
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Butter']")).isSelected());
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Cheese']")).isSelected());
		
		
	}
	
	@Test
	public void radioButtonTest3() throws InterruptedException, IOException
	{
		

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//input[@value='Cheese']")));
		
		Thread.sleep(3000);
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@value='Cheese']")));
		
					
		Thread.sleep(3000);
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Milk']")).isSelected());
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Butter']")).isSelected());
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Cheese']")).isSelected());
		
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}

}
