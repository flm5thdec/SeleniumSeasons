package linkstesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementLinksTesting {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(10000);
		
		//focus on "Make money with us"
		
		WebElement block=driver.findElement(By.xpath("//span[text()='Most searched for on Flipkart']/parent::div"));
		
		List<WebElement> allLinks=block.findElements(By.tagName("a"));
		
		for(int i=0;i<allLinks.size();i++)
		{
			System.out.println(allLinks.get(i).getText());
			allLinks.get(i).click();
			Thread.sleep(2000);
			System.out.println(driver.getCurrentUrl());
			System.out.println("--------------------------------");
			driver.navigate().back();
			
			block=driver.findElement(By.xpath("//span[text()='Most searched for on Flipkart']/parent::div"));
			
			allLinks=block.findElements(By.tagName("a"));
		}
		
		
		driver.quit();

	}

}
