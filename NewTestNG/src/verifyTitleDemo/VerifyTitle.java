package verifyTitleDemo;				//from get title and page source

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTitle 
{
	@Test
	public void verifyApplicationTitle()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");		// declaration and instantiation of objects/variables
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://learn-automation.com/");
		
		//actual title
		String my_title = driver.getTitle();
		String page_source = driver.getPageSource();
		
		System.out.println("Title is "+my_title);
		
		//String expected_title = "Automation - Selenium WebDriver tutorial Step by Step";
		
		//Assert.assertEquals(my_title, expected_title);		//if validation passes we print//it checks the exact content-first way
		
		Assert.assertTrue(my_title.contains("Selenium WebDriver tutorial"));			//second way-efficient
		
		System.out.println("Title verified from get title");
		
		Assert.assertTrue(page_source.contains("Step by Step"));						//verifying content from page source
		
		System.out.println("Title verified from page source");
		
		System.out.println("Test completed");
		
		driver.close();
		
	}
	
	
	
}
