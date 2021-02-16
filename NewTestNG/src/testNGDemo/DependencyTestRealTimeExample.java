package testNGDemo;					//explicit wait and implicit wait

import java.util.concurrent.TimeUnit;

//Implicit wait : used to tell the web driver to wait for a certain amount of time before it throws a "No Such Element Exception".default time is 0.
//Explicit wait : used to tell the Web Driver to wait for certain conditions (Expected Conditions) or maximum time exceeded before throwing "ElementNotVisibleException" exception.
                 //It is an intelligent kind of wait, but it can be applied only for specified elements.

//Fluent wait : The Fluent Wait in Selenium is used to define maximum time for the web driver to wait for a condition, 
//as well as the frequency with which we want to check the condition before throwing an "ElementNotVisibleException" exception. 
//It checks for the web element at regular intervals until the object is found or timeout happens.
//check the syntax once


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DependencyTestRealTimeExample 
{
	
	WebDriver driver;
	
	@BeforeClass
	public void startBrowser()				//before starting of class, my browser should get started
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");		// declaration and instantiation of objects/variables 
		driver = new ChromeDriver();
		System.out.println("=====================Browser started=====================");
	}
	
	
	@Test
	public void StartApp()
	{	//have put instantiation and calling driver in before class							
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		//gives implicit wait of 30 sec-because i have to wait for certain webelement
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("orangehrmlive.com"));			//after every step we need to validate hence we use assert-compare expected with actual
		System.out.println("Application loaded");
	}
	
	@Test(dependsOnMethods="StartApp")				
	public void LoginApp()
	{
		driver.findElement(By.xpath(".//*[@id='txtUsername']")).sendKeys("Admin");			//try with wrong user, still browser should close
		driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath(".//*[@id='btnLogin']")).click();
		
		boolean status = driver.findElement(By.xpath(".//*[@id='menu_admin_viewAdminModule']/b")).isDisplayed();		//gets if admin is displayed on page
		Assert.assertTrue(status);												//if this status is true then the test case will pass
		System.out.println("Login successful");
		
	}
	
	@Test(dependsOnMethods="LoginApp")			
	public void LogoutApp() throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='welcome']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 20);						//explicit wait-gives better options than implicit wait as it waits for dynamically loaded Ajax elements.
		
		WebElement Logoutlink;
		
		Logoutlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Logout']")));		//explicit wait
		
		Logoutlink.click();
		
		//Thread.sleep(2000);														//forceful wait
		
		//driver.findElement(By.xpath("//a[text()='Logout']")).click();				//you can write custom xpath //search for custom anchor link - logout text
		
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='txtUsername']")).isDisplayed());		//verifies if user name editbox is displayed after logging out on login page
		
		System.out.println("Logout done");
		
		//driver.quit();
	}
	
	//Note : if in third step, wait doesn't work or logout is not click then in that case driver will not be closed and hence browser will remain open.
	//it will use some memory from your system and with more number of runs your system might get hanged, so closing driver is important after every run.
	//Solution : use a different annotation of testNG, after class-create a different method and put driver.close in that
	
	@AfterClass					//means once you are done with this class, we want to run this
	public void closeApp()
	{
		driver.quit();
		System.out.println("=====================Browser Closed=====================");
	}
	
	
	
	
	
	
	
	
	
	
}
