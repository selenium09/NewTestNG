package testNGDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTestCase 
{
	@Test
	public void StartApp()
	{
		Assert.assertEquals(12, 13); 				//first time it will run OK, lets fail this test case now by assert(compare expected with actual)-rest all TC will not run
		System.out.println("Starting application");
	}
	
	@Test(dependsOnMethods="StartApp")				//add dependency by mentioning the method name/test case name, so if it fails next method will go in skip mode
	public void LoginApp()
	{
		System.out.println("Log into application");
	}
	
	@Test(dependsOnMethods="{LoginApp,StartApp}")			//we can give multiple level dependencies as well by adding 2 in the curly brackets
	public void LogoutApp()
	{
		System.out.println("Logout application");
	}
	
	
	
	
}
