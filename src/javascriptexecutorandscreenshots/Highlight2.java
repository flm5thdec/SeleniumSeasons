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

public class Highlight2 {
	
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
		WebElement usernameTextbox=driver.findElement(By.xpath("//input[@name='username']"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", usernameTextbox);
		usernameTextbox.sendKeys("reyaz0806");
		
		Thread.sleep(3000);
		
		
		WebElement passwordTextbox=driver.findElement(By.xpath("//input[@name='password']"));
		js.executeScript("arguments[0].style.border='3px solid red'", passwordTextbox);
		passwordTextbox.sendKeys("reyaz123");
		Thread.sleep(3000);
		
		
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
