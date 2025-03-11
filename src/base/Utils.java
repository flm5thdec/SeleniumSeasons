package base;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Utils {
	
public  static void switchToWindow(WebDriver driver,String title) {
		
		Set<String> allWindowIds=driver.getWindowHandles();
		
		//switch to google play store tab 
		
		Iterator<String> it=allWindowIds.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			
			if(driver.getTitle().equals(title))
			{
				break;
			}
			
		}
		
	}

}
