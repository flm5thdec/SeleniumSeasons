package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdactinHotelApp {
	
	@Test(priority=2)
	public void loginTest()
	{
		System.out.println("Browser Started ..");
		System.out.println("App Launched ..");
		Assert.assertTrue(false);
		System.out.println("Login successfull..");
		System.out.println("Browser closed ..");
		
	}
	
	@Test(priority=0)
	public void registrationTest()
	{
		System.out.println("Browser Started ..");
		System.out.println("App Launched ..");
		System.out.println("Registration successfull..");
		System.out.println("Browser closed ..");
		
	}
	
	@Test(priority=3)
	public void forgotPasswordTest()
	{
		System.out.println("Browser Started ..");
		System.out.println("App Launched ..");
		System.out.println("Forgot Password successfull..");
		System.out.println("Browser closed ..");
		
	}
	
	@Test(priority=4,dependsOnMethods="loginTest")
	public void changePasswordTest()
	{
		System.out.println("Browser Started ..");
		System.out.println("App Launched ..");
		System.out.println("Change Password successfull..");
		System.out.println("Browser closed ..");
		
	}

}
