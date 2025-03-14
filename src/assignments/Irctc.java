package assignments;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


//public class Irctc {
//    WebDriver driver;
//
//    @BeforeMethod
//    public void setUp() throws InterruptedException {
//        driver = new ChromeDriver();
//        driver.get("https://www.irctc.co.in/nget/train-search");
//        driver.manage().window().maximize();
//        Thread.sleep(3000);
//    }
//
//    @Test
//    public void IRCTC_AssignmentTest() throws InterruptedException {
//        WebElement block = driver.findElement(By.xpath("//div[@class='text-center hidden-xs footer-icons']"));
//        List<WebElement> allElements = block.findElements(By.tagName("a"));
//        String homeWindowID = driver.getWindowHandle();
//
//        for (WebElement element : allElements) {
//            String href = element.getAttribute("href");
//
//            // Check if the link is valid (not the specific invalid link)
//            if (href != null && href.equals("https://www.kooapp.com/profile/irctcofficial")) { // Replace with your condition
//                System.out.println("Skipping invalid link: " + href);
//                continue; // Skip to the next iteration of the loop
//            }
//
//            try {
//                element.click();
//                Thread.sleep(3000); // Wait for the new window to open
//
//                Set<String> allWindows = driver.getWindowHandles();
//                for (String newWindow : allWindows) {
//                    if (!newWindow.equals(homeWindowID)) {
//                        driver.switchTo().window(newWindow);
//                        System.out.println(driver.getTitle());
//                        System.out.println(driver.getCurrentUrl());
//                        System.out.println("------------------------");
//                        driver.close(); // Close the new window after processing
//                        driver.switchTo().window(homeWindowID); // Switch back to the home window
//                        Thread.sleep(2000); // Wait before the next iteration
//                        break; // Exit the inner loop after processing the new window
//                    }
//                }
//            } catch (Exception e) {
//                System.out.println("Error clicking on element: " + e.getMessage());
//                // Optionally, you can log the error or take further action
//            }
//        }
//    }
//
//    @AfterMethod
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}

public class Irctc {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.irctc.co.in/nget/train-search");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    
    @Test
    public void IRCTC_AssignmentTest() throws InterruptedException {
        WebElement block = driver.findElement(By.xpath("//div[@class='text-center hidden-xs footer-icons']"));
        List<WebElement> allElements = block.findElements(By.tagName("a"));
        String homeWindowID = driver.getWindowHandle();
        
        for (WebElement element : allElements) {
            String href = element.getAttribute("href");
            
            // Check if the link is valid (not a placeholder or broken link)
            if (href == null || href.equals("https://www.kooapp.com/profile/irctcofficial")) { // Replace with your condition
                System.out.println("Skipping element: " + href);
                continue; // Skip to the next iteration of the loop
            }
            
            try {
                element.click();
                Thread.sleep(1000); // Wait for the new window to open

                Set<String> allWindows = driver.getWindowHandles();
                for (String newWindow : allWindows) {
                    if (!newWindow.equals(homeWindowID)) {
                        driver.switchTo().window(newWindow);
                        System.out.println(driver.getTitle());
                        System.out.println(driver.getCurrentUrl());
                        System.out.println("------------------------");
                        driver.close(); // Close the new window after processing
                        driver.switchTo().window(homeWindowID); // Switch back to the home window
                        Thread.sleep(1000); // Wait before the next iteration
                        break; // Exit the inner loop after processing the new window
                    }
                }
            } catch (Exception e) {
                System.out.println("Failed to click on element: " + href + " due to " + e.getMessage());
                // Optionally, you can log the exception or take further action
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