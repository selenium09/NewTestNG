package verifyErrorMessage;			//by get attribute method and void main

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//getText() - captures text which is displayed on the page and it will return text in string format
//getAttribute() - captures the complete innerHTML which is displayed in inspect and will return the innertext and return string message

//another way - we can capture the text from DOM itself


public class VerifyErrorMessageByGetAttributes 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");		// declaration and instantiation of objects/variables
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		
		driver.findElement(By.xpath(".//*[@id='identifierNext']")).click();			
		
		Thread.sleep(2000);
		
		String actual_error = driver.findElement(By.className("o6cuMc")).getAttribute("innerHTML");		//using get attribute with InnerHTML-not working maybe innerHTML is not there 
				
		String expected_error = "Enter an email or phone number";										//get attribute is used to get text of a button, or get anything from field itself				
		
		Assert.assertEquals(actual_error, expected_error);			//type 1
		
		System.out.println("Message verified by assert equals");
		
		Assert.assertTrue(actual_error.contains("Enter an email"));		//type 2
		
		System.out.println("Message verified by assert true conatins");
		
		driver.quit();
	}
	
}

