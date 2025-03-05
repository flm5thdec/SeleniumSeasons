package testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdactinHotelApp {
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("Browser Started ..");
		System.out.println("App Launched ..");
	}
	
	@AfterMethod
	public void teardown()
	{
		System.out.println("Browser closed ..");
	}
	
	@Test(priority=2)
	public void loginTest()
	{
		
		Assert.assertTrue(true);
		System.out.println("Login successfull..");
		
		
	}
	
	@Test(priority=0)
	public void registrationTest()
	{
		
		System.out.println("Registration successfull..");
		
		
	}
	
	@Test(priority=3)
	public void forgotPasswordTest()
	{
		
		System.out.println("Forgot Password successfull..");
			
	}
	
	@Test(priority=4,dependsOnMethods="loginTest")
	public void changePasswordTest()
	{
		
		System.out.println("Change Password successfull..");
		
		
	}
	
	

}
