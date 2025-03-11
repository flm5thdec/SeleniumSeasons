package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class A10 {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		driver.manage().window().maximize();
	}

	
	@Test
	public void a10Test() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='email_field']")).sendKeys("admin123@gmail.com");
		driver.findElement(By.xpath("//input[@id='password_field']")).sendKeys("admin123");
		driver.findElement(By.xpath("//div[@id='login_div']/button")).click();
		Thread.sleep(2000);
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[@class='dropdown'][2]"))).click(driver.findElement(By.xpath("//a[text()='Double Click']"))).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//div[@class='dropdown'][2]"))).click(driver.findElement(By.xpath("//a[text()='Double Click']"))).build().perform();
	
		String s=null;
		
		while(true) {
			a.doubleClick(driver.findElement(By.xpath("//button[text()='Double Click']"))).build().perform();
			s=driver.findElement(By.xpath("//p[@id='Selenium']")).getText();
			System.out.println(s);
			if(s.contains("5"))
			{
				break;
			}
		}
	
	}

	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}


}
