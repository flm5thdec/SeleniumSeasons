package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
public class RightClickPractice2 {
	
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void rightClickPra() {
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.xpath("//span[contains(text(), 'right click me')]")))
		.pause(2000)
		.keyDown(Keys.DOWN)
		.pause(2000)
		.keyDown(Keys.DOWN)
		.pause(2000)
		.keyDown(Keys.DOWN)
		.pause(2000)
		.keyDown(Keys.ARROW_UP)
		.pause(2000)
		.keyDown(Keys.ENTER)
		.pause(2000)
		.build().perform();	
	}

	@AfterTest
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}
