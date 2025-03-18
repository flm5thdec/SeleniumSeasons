package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPriceFilter {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Open Amazon search results (Example: Laptops)

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		Thread.sleep(2000);

		// Locate the Minimum Price Field and Enter Value
		WebElement minPrice = driver.findElement(By.id("low-price"));
		minPrice.sendKeys("100");

		// Locate the Maximum Price Field and Enter Value
		WebElement maxPrice = driver.findElement(By.id("high-price"));
		maxPrice.sendKeys("500");

		// Click the "Go" Button
		WebElement goButton = driver.findElement(By.xpath("//input[@aria-labelledby='a-autoid-1-announce']"));
		goButton.click();

		// Wait for results (Optional - Replace with WebDriverWait for stability)
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Print Page Title (for verification)
		System.out.println("Filtered Page Title: " + driver.getTitle());

		// Close Browser
		driver.quit();
	}
}
