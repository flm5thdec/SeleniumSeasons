package assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TakingScreenShots 
{
      WebDriver driver;
      String homeTab;
      List<String>  allLinks;
      Set<String> allWindowIds;
      List<String>  attributeName;
	
@BeforeMethod
public void launchApp()
{
	driver=new ChromeDriver();
	driver.get("https://www.irctc.co.in/nget/train-search");
	driver.manage().window().maximize();
	homeTab=driver.getWindowHandle();
	allLinks=new ArrayList<String>();
	attributeName=new ArrayList<String>();
	allLinks.add(homeTab);
	
	
	
}

@Test(priority = 1)
public void takingScreenShots()
{
	List<WebElement>  socialBlock=driver.findElements(By.xpath("//div[@class='text-center hidden-xs footer-icons']/descendant::a"));
	
	for(int i=0;i<socialBlock.size();i++)
	{
	  attributeName.add( socialBlock.get(i).getAttribute("alt"));
	}
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	for(int i=0;i<socialBlock.size();i++)
	{
		js.executeScript("arguments[0].click()", socialBlock.get(i));
		windowList();
	}

}

@Test(priority = 2,dependsOnMethods = {"takingScreenShots"})
public void switchToWindow() throws IOException, InterruptedException 
{

	TakesScreenshot sc = (TakesScreenshot) driver;
	File source;
	File finalName;
	String path = System.getProperty("user.dir");

	for (int i = 1; i < allLinks.size(); i++) 
	{
		driver.switchTo().window(allLinks.get(i));
		Thread.sleep(2000);
		source = sc.getScreenshotAs(OutputType.FILE);
		int temp = (i - 1);
		for (int j = temp; j < i; j++) 
		{
			finalName = new File(path + "\\" + attributeName.get(j) + ".png");
			FileUtils.copyFile(source, finalName);
		
		}

	}
}


@AfterMethod
public void endApp() throws InterruptedException
{
	Thread.sleep(5000);
	driver.quit();
}

public void windowList()
{
	 allWindowIds=driver.getWindowHandles();
	 for(String element:allWindowIds)
	 {
		 if(!allLinks.contains(element))
		 {
			 allLinks.add(element);
		 }
	 }
	
}
}
