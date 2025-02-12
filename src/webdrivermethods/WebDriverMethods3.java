package webdrivermethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods3 {

	public static void main(String[] args) throws InterruptedException {
		
		//browser start
		
		WebDriver driver=new ChromeDriver();
		
		Thread.sleep(3000);
		
		driver.get("https://adactinhotelapp.com/");
		
		Thread.sleep(3000);
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		
		//getTitle():String  
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		
		//System.out.println(driver.getPageSource());
		
		System.out.println(driver.getWindowHandle());
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[contains(@src,'google-play')]")).click();
		
		Thread.sleep(3000);
		
		System.out.println(driver.getWindowHandles());
		
		driver.quit();
		
		

	}

}
