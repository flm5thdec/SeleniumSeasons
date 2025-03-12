package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameHandling {
	

	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
	  driver=	new ChromeDriver();
	  driver.get("https://jqueryui.com/droppable/");
	  driver.manage().window().maximize();
	  
	}
	
	@Test
	public void dragAndDropTest() throws InterruptedException
	{
		Actions action=new Actions(driver);
		
		//to switch to frame 
		
		
		//frame(int):here int is the index of frame starts from zero (from top of html)
		//driver.switchTo().frame(0);
		
		
		//frame(String):here String is id or name attribute of frame or iframe 
		//driver.switchTo().frame("demo-frame");
		
		//frame(WebElement):here WebElement is the iframe element
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		
		action.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")),
				 driver.findElement(By.xpath("//div[@id='droppable']")))
				.build().perform();
		
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}

}
