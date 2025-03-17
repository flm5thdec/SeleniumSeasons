package webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicWebTable1 {
	
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
		
		WebElement table=driver.findElement(By.xpath("//table[@class='zebra fw tb-theme']/tbody"));
		
		List<WebElement> allRows=table.findElements(By.tagName("tr"));
		
		for(WebElement row:allRows)
		{
			List<WebElement> allCols=row.findElements(By.tagName("td"));
			for(WebElement col:allCols)
			{
				System.out.print(col.getText()+"\t");
			}
			System.out.println();
		}
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}


}
