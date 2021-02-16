package listernersDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listernersDemo.TestNGListeners.class)		//we need to keep listeners at class level not at test level-added package name and bounding with the class
public class MyTestCase 
{														//all done, but how do i use the listener class in this separate class
	@Test
	public void GoogleTitleVerify()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.learn-automation.com");
		System.out.println("Title of page is "+driver.getTitle());
		driver.quit();
	}
	
	//listeners will be applicable through out the class and all the tests will be using this listener
	
	public void TitleMatch()
	{
		System.out.println("Test 2 dummy");
		Assert.assertTrue(false);
	}
	
	//I have 1 listener and 2 class, its helful but if i have 10 classes its not helpful because I am binding this listener to the class name so if i ad 10 more classses i have
	//to add listener into every class, hence its not recommended - alternative solution : Suite level
	//for this delete the listener and convert the file to xml
	//in xml, it will apply that listener through out the test suite-no matter how many classes or testcases
	
}
