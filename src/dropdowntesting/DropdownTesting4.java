package dropdowntesting;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownTesting4 {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(10000);
		
		WebElement drop=driver.findElement(By.id("searchDropdownBox"));
				
		List<WebElement> allItems=drop.findElements(By.tagName("option"));
		
		System.out.println("No  of items : "+allItems.size());
		
		for(WebElement item:allItems)
		{
			System.out.println(item.getText());
		}
		
		Iterator<WebElement> it=allItems.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next().getText());
		}
		
		driver.quit();
		
		
		
			

	}

}
