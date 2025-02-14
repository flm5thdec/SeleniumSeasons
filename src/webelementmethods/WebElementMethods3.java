package webelementmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethods3 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://adactinhotelapp.com/");
		
		driver.manage().window().maximize();
		
		System.out.println(driver.findElement(By.id("username")).getLocation().getX());
		
		System.out.println(driver.findElement(By.id("username")).getLocation().getY());
		
		System.out.println(driver.findElement(By.id("username")).getSize().getHeight());
		
		System.out.println(driver.findElement(By.id("username")).getSize().getWidth());
		
		System.out.println(driver.findElement(By.id("username")).getRect().getX());
		
		System.out.println(driver.findElement(By.id("username")).getRect().getY());
		
		System.out.println(driver.findElement(By.id("username")).getRect().getHeight());
		
		System.out.println(driver.findElement(By.id("username")).getRect().getWidth());
		
		
				
		driver.quit();

	}

}
