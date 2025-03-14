package assignments;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Irctc2 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.irctc.co.in/nget/train-search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(3000);
    }
    
    @Test
    public void IRCTC_AssignmentTest() throws InterruptedException {
    	
    	String homeWindowId=driver.getWindowHandle();
    	
    	Set<String>  allWindowIds=null;
    	
    	Iterator<String> it=null;
    	
    	List<WebElement> allLinks=driver.findElements(By.xpath("//span[text()='Get Connected with us on social networks']/parent::div/descendant::a"));
    	
    	JavascriptExecutor js= (JavascriptExecutor) driver;
    	
    	for(int i=0;i<allLinks.size();i++)
    	{
    		//FAILED: IRCTC_AssignmentTest
    		//org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element <a _ngcontent-njh-c49="" target="_blank" rel="noopener noreferrer" href="https://www.kooapp.com/profile/irctcofficial" alt="IRCTCofficial Koo" aria-label="I.R.C.T.C. Official Koo page. opens a new windows" style="background: #F7BB19;">...</a> is not clickable at point (1145, 654). Other element would receive the click: <iframe id="chatbot" src="https://askdisha.irctc.co.in/?support=true" width="100%" height="310px" frameborder="0" allowfullscreen="" allow="microphone; camera; autoplay" style="position: absolute; top: 0; left: 0; z-index: 1;">...</iframe>

    		//allLinks.get(i).click();
    		
    		js.executeScript("arguments[0].click();", allLinks.get(i));
    		
    		allWindowIds=driver.getWindowHandles();
    		
    		it=allWindowIds.iterator();
    		
    		while(it.hasNext())
    		{
    			driver.switchTo().window(it.next());
    			
    			if(!driver.getWindowHandle().equals(homeWindowId))
    			{
    				Thread.sleep(2000);
    				driver.close();
    				driver.switchTo().window(homeWindowId);
    				Thread.sleep(2000);
    			}
    		}
    			
    		    		
    	}
        
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}