package webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StaticWebTable1 {
	
WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
	  driver=	new ChromeDriver();
	  driver.get("https://www.timeanddate.com/worldclock/");
	  driver.manage().window().maximize();
	  
	}
	
	@Test
	public void webTableTest() throws InterruptedException
	{
		String part1="//table/tbody/tr[";
		String part2="]/td[1]/a";
		
		for(int i=1;i<=36;i++)
		{
		  System.out.println(driver.findElement(By.xpath(part1+i+part2)).getText());
		}
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}


}
