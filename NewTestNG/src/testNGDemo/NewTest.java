package testNGDemo;

import org.testng.Assert;
import org.testng.annotations.Test;


public class NewTest {				//instead on JVM, now runner-TestNG will run our testcase 
									//if you dont mention the order for running, testNG will run it in alphabetical order
	
	
  @Test(priority=1,description="This testcase performs login functionality")		//you can provide description to print in HTML report and standard output
  public void loginApplication() 
  {
	  
	  System.out.println("Hello, this is my first testNG test");
	  Assert.assertEquals(12, 13); 			//assert is used to compare actual vs expected-using it to fail test case for now but even if it fails testNG will continue with next two testcases
  }
  
  @Test(priority=2,description="The testcase selects items from the list")
  public void selectItem() 
  {
	  
	  System.out.println("Item Selected");
  }
  
  @Test(priority=3,description="This testcase does the checkout")		//does testNG support negative priority=-3, yes since its less than 1 so it will be run first
  public void checkOut() 
  {
	  
	  System.out.println("Checkout completed");
	  
	  //three types of reports are generated
	  //Default suite-default test.html
	  //emailable-report.html
	  //index.html
	  
	  //extent reports can be used to add screenshots as well, because for screens in TestNG we need to add many lines of codes
	  
  }
  
  
  
  
  
  
  
}
