package assertionDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

//Assert is a class in testNG which will help you validate certain outcomes
//when assertion-comparing is failed it throws assertion error not exception

public class AssertionScript2 {
	
	@Test
	public void test1()
	{
		Assert.assertTrue(true); 			//assert will pass if it gets true, if you pass (false) it will fail your test
											//if a particular element is disabled/not visible, please fail my test
	}
											
	@Test
	public void test2()
	{
		String mystr = "Sumit Rajhans";
		Assert.assertTrue(mystr.contains("mit")); 			//if my string contains mit , pass the testcase else fail
															//contains function returns true/false
											
	}
	
	@Test
	public void test3()
	{
		String mystr = "Sumit Rajhans";
		Assert.assertTrue(mystr.contains("sachin"),"names are not matching"); 			//if my string contains sachin , pass the testcase else fail
																						//contains function returns false here, and if assert true is false, then TC fails
	}
	
	
}
