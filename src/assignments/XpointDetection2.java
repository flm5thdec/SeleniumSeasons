package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpointDetection2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=	new ChromeDriver();
		  driver.get("https://fitpeo.com/revenue-calculator");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  
		  driver.navigate().refresh();
		 
		  System.out.println(driver.findElement(By.xpath("//span[@data-index='0']")).getRect().getX());
		  
		  Thread.sleep(10000);
		  
		 // System.out.println(driver.findElement(By.xpath("//div[@id='loanamountslider']/child::span[@tabindex='0']")).getRect().getX());
		  
		//  System.out.println(driver.findElement(By.xpath("//div[@id='loaninterestslider']/child::span[@tabindex='0']")).getRect().getX());
		  
		  driver.navigate().refresh();
		  
		  Thread.sleep(10000);
		  
		  System.out.println(driver.findElement(By.xpath("//span[@data-index='0']")).getRect().getX());
		  
		  
		  driver.quit();
		  

	}

}
