package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SalesForceLogin {

	@Test
	public void salesForceLoginTest() throws InterruptedException
	{
		WebDriver driver=new  ChromeDriver();
		
		driver.get("https://www.salesforce.com/in/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		SearchContext shadow0 = driver.findElement(By.cssSelector("hgf-c360nav[locale='in']")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("hgf-c360login[aria-haspopup='true']")).getShadowRoot();
		Thread.sleep(1000);
		//SearchContext shadow2=shadow1.findElement(By.cssSelector("hgf-popover")).getShadowRoot();
		Thread.sleep(1000);
		//SearchContext shadow3=shadow1.findElement(By.cssSelector("hgf-button.utility-button")).getShadowRoot();
		//shadow3.findElement(By.cssSelector("a[href='https://login.salesforce.com/?locale=in']")).click();
		shadow1.findElement(By.cssSelector("hgf-popover:nth-child(1) > hgf-button:nth-child(1) > span:nth-child(2)")).click();
		Thread.sleep(6000);
	}
	

	public void m1() throws InterruptedException
	{
		//This Element is inside 2 nested shadow DOM.
		String cssSelectorForHost1 = "hgf-c360nav[locale='in']";
		String cssSelectorForHost2 = "hgf-c360regionselector[aria-haspopup='true']";
		Thread.sleep(1000);
		//SearchContext shadow0 = driver.findElement(By.cssSelector("hgf-c360nav[locale='in']")).getShadowRoot();
		Thread.sleep(1000);
		//SearchContext shadow1 = shadow0.findElement(By.cssSelector("hgf-c360regionselector[aria-haspopup='true']")).getShadowRoot();
		Thread.sleep(1000);
		//shadow1.findElement(By.cssSelector(".utility-button"));
	}
	
}
