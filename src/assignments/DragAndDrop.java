package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDrop {
	

	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
	  driver=	new ChromeDriver();
	  driver.get("https://emicalculator.net/");
	  driver.manage().window().maximize();
	  
	}
	
	@Test
	public void dragAndDropTest() throws InterruptedException
	{
		
		Actions action=new Actions(driver);
		
		//loan amount
		action.dragAndDropBy(driver.findElement(By.xpath("//div[@id='loanamountslider']/child::span[@tabindex='0']")), 80, 0).perform();
		
		Thread.sleep(2000);
		
		//interest rate
		
		action.dragAndDropBy(driver.findElement(By.xpath("//div[@id='loaninterestslider']/child::span[@tabindex='0']")), 150, 0).perform();
		
		Thread.sleep(2000);
		
		//scroll vertically down by 200 px 
		action.scrollByAmount(0, 200);
		
		//interest rate
		
		action.dragAndDropBy(driver.findElement(By.xpath("//div[@id='loantermslider']/child::span[@tabindex='0']")), -108, 0).perform();
				
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}


}
