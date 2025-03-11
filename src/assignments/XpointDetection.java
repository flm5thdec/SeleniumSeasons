package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpointDetection {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=	new ChromeDriver();
		  driver.get("https://emicalculator.net/");
		  driver.manage().window().maximize();
		  
		 // System.out.println(driver.findElement(By.xpath("//div[@id='loanamountslider']/child::span[@tabindex='0']")).getRect().getX());
		  
		//  System.out.println(driver.findElement(By.xpath("//div[@id='loaninterestslider']/child::span[@tabindex='0']")).getRect().getX());
		  
		  System.out.println(driver.findElement(By.xpath("//div[@id='loantermslider']/child::span[@tabindex='0']")).getRect().getX());
		  
		  Thread.sleep(10000);
		  
		 // System.out.println(driver.findElement(By.xpath("//div[@id='loanamountslider']/child::span[@tabindex='0']")).getRect().getX());
		  
		//  System.out.println(driver.findElement(By.xpath("//div[@id='loaninterestslider']/child::span[@tabindex='0']")).getRect().getX());
		  
		  System.out.println(driver.findElement(By.xpath("//div[@id='loantermslider']/child::span[@tabindex='0']")).getRect().getX());
		  
		  
		  driver.quit();
		  

	}

}
