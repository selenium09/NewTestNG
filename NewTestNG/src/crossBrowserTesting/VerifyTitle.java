package crossBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VerifyTitle 
{
	
	WebDriver driver;									//creating global variable to be used across all testcases
	
	@Test
	@Parameters("browser")								//parameters to be passed for multiple browsers, here you specify value(browser) which you will pass from xml file
	public void verifyPageTitle(String browserName)		//whatever you pass from xml will be stored in broswerName													
	{													//multiple parameters can also be passed-username, password, URL.
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\GeckoDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.get("http://www.learn-automation.com");
		
		System.out.println(driver.getTitle());
		
		driver.quit();	
		
		//Note : give different names for running cross browsers
		//for parallel running - put next to name="suite" parallel="tests"-it will create 3 threads and open 3 browsers parallely, no matter which testcase passes or fails
		
	
	}
	
	
	
	
	
	
}
