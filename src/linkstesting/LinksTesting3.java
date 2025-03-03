package linkstesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksTesting3 {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
		
		driver.manage().window().maximize();
		
		//to collect all links  
		
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		
		System.out.println("no of links "+allLinks.size());
		
		for(int i=0;i<allLinks.size();i++)
		{
			System.out.println(allLinks.get(i).getText());
			allLinks.get(i).click();
			Thread.sleep(2000);
			System.out.println(driver.getCurrentUrl());
			System.out.println("------------------------------------------------");
			driver.navigate().back();
			
		}
		
		driver.quit();

	}

}
