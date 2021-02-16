package assertionDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

//Assert is a class in testNG which will help you validate certain outcomes
//when assertion-comapring is failed it throws assertion error not exception

public class AssertionScript {
	
	@Test
	public void test1()
	{
		System.out.println("Test case 1 started");
		Assert.assertEquals(12, 13);		//this is called hard assertion
		System.out.println("Test case 1 completed");
	}
	
	@Test
	public void test12()
	{
		System.out.println("Test case 2 started");
		Assert.assertEquals(12, 13,"Drop down values dont match, please check");		//shows description only if failed//use this approach
		System.out.println("Test case 2 completed");									//Hard assert means if assert command fails, it will not go to next print statement and come out of the testcase
																						//it will immediately terminate your program and come out of the TC
	}

	
	@Test
	public void test13()
	{
		System.out.println("Test case 3 started");
		Assert.assertEquals("Hello", "Hello", "Words do not match, please raise a bug");		//this is called hard assertion
		System.out.println("Test case 3 completed");
	}
	
	
	
}
