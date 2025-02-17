package dropdowntesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownTesting3 {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(10000);
		
		//selectByIndex(int) ==> here int means index which starts from zero (not prefered)
		
		//WebElement drop=driver.findElement(By.id("searchDropdownBox"));
		
		//Select s1=new Select(drop);
		
	    // s1.selectByIndex(12);
		
		//new Select(driver.findElement(By.id("searchDropdownBox"))).selectByIndex(12);
		
		//new Select(driver.findElement(By.id("searchDropdownBox"))).selectByValue("search-alias=stripbooks");
		
		new Select(driver.findElement(By.id("searchDropdownBox"))).selectByVisibleText("Books");
		
		
		Thread.sleep(5000);
		
				
		
		driver.quit();
		
		
		
			

	}

}
