package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class emiCalculator {

	WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@Test
	public void emiCalculatorTest() throws InterruptedException {
		Actions action = new Actions(driver);
		action.dragAndDropBy(driver.findElement(By.xpath(
				"//span[@class='ui-slider-handle ui-corner-all ui-state-default']/parent::div[@id='loanamountslider']")),5, 0)
				.build()
				.perform();
		Thread.sleep(1000);
		action.dragAndDropBy(driver.findElement(By.xpath(
				"//span[@class='ui-slider-handle ui-corner-all ui-state-default']/parent::div[@id='loaninterestslider']")),50, 0)
				.build()
				.perform();
		Thread.sleep(1000);
		action.dragAndDropBy(driver.findElement(By.xpath(
				"//span[@class='ui-slider-handle ui-corner-all ui-state-default']/parent::div[@id='loantermslider']")),-90, 0)
				.build()
				.perform();
		Thread.sleep(1000);

	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}