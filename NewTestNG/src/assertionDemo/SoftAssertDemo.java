package assertionDemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//if validation fails , it will continue the rest of the scripts and once scripts are completed then it fails the test.
//even if a single validation fails, the script will be failed but execution will not stop
//do not forget to call assertAll() method at last
//all the asserts that are present in hard assert are present in soft assert as well

public class SoftAssertDemo 
{
	@Test
	public void testSoft()
	{
		SoftAssert assertion = new SoftAssert();			//we need to create object of soft assert class
		System.out.println("Test 1 started");
		assertion.assertEquals(12, 13,"Count doesn't match");
		System.out.println("Test 1 completed");				//in soft assertion, this will be run and printed
		assertion.assertAll();								//mandatory
	}
	
	@Test
	public void testHardAssert()
	{
		System.out.println("Test 2 started");
		Assert.assertEquals(12, 13);
		System.out.println("Test 2 completed");				//in hard assertion, this will not be run and printed
		
	}
	
	
	
}
