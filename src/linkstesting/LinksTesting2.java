package linkstesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksTesting2 {

	public static void main(String[] args) {
		
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://adactinhotelapp.com/");
		
		driver.manage().window().maximize();
		
		//to collect all links  
		
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		
		System.out.println("no of links "+allLinks.size());
		
		for(int i=0;i<allLinks.size();i++)
		{
			System.out.println(allLinks.get(i).getText());
		}
		
		driver.quit();

	}

}
