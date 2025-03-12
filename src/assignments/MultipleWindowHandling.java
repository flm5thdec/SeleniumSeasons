package assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleWindowHandling 
{
	
	WebDriver driver;
	String homeTab;
	String homeTabTitle;
	String homeTabUrl;
	List<String>  allList;
	Set<String> allWindows;

	@BeforeTest
	public void launchWebSite()
	{
		//launching irctc website
	driver=new ChromeDriver();
	driver.get("https://www.irctc.co.in/nget/train-search");
	driver.manage().window().maximize();
	
	
	//getting home tab id , url
	 homeTab=driver.getWindowHandle();
	 homeTabTitle=driver.getTitle();
	 homeTabUrl=driver.getCurrentUrl();
	 
	 
	 allList =new ArrayList<String>();
		allList.add(homeTab);       //adding hometab to ArrayList
		
	
	}
	
	@Test
	public void multipleWindowHandling() throws InterruptedException
	{
 
		driver.findElement(By.xpath("//a[contains(@href,'www.facebook.com')]")).click();   //facebook
		addArrayList();
		driver.findElement(By.xpath("//img[contains(@src,'./assets/images/irctc-whatsapp.png')]")).click();   //whatsapp
		addArrayList();
		driver.findElement(By.xpath("//a[contains(@href,'https://youtube.com/c/IRCTCOFFICIAL')]")).click();   //youtube
		addArrayList();
		driver.findElement(By.xpath("//a[contains(@href,'https://instagram.com/irctc.official?igshid=yyg5byow704l')]")).click(); //instagram
		addArrayList();
		driver.findElement(By.xpath("//a[contains(@href,'https://www.linkedin.com/company/irctcofficial')]")).click(); //linkedIn
		addArrayList();
		driver.findElement(By.xpath("//a[contains(@href,'https://t.me/IRCTC_Official')]")).click();   //telegram
		addArrayList();
		driver.findElement(By.xpath("//a[contains(@href,'https://in.pinterest.com/irctcofficial/')]")).click();  //pinterest
		addArrayList(); 
	  
		 /*driver.findElement(By.xpath("//a[contains(@href,'https://irctcofficial.tumblr.com/') and @alt='IRCTCofficial tumblr']")).click();
		addArrayList();
		driver.findElement(By.xpath("//a[contains(@href,'https://www.kooapp.com/profile/irctcofficial')]")).click();
		addArrayList();
		driver.findElement(By.xpath("//a[contains(@href,'https://twitter.com/IRCTCofficial')]")).click();
		addArrayList();  */
	 
		Thread.sleep(3000);
		
		 //printing Home Tab Details
		 System.out.println(homeTabTitle);
		 System.out.println(homeTabUrl);
		 System.out.println("-----------------------------------------------------------");
		 
		 //switching to other windows and getting ID , URL 
		 for(int i=1;i<allList.size();i++)                
		 {
			 driver.switchTo().window(allList.get(i));
			 Thread.sleep(2000);
			 System.out.println(driver.getTitle()); 
			 System.out.println(driver.getCurrentUrl());
			 System.out.println("-----------------------------------------------------------");
			 
		 }
		
		
	}
	
	@AfterTest
	public void endWebSite() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
	public void addArrayList()
	{
		allWindows=driver.getWindowHandles();
		for (String element : allWindows) 
		{
            if (!allList.contains(element)) 
             { 
            	allList.add(element);
             }
		}
		
	}
	

	
	
		
}
