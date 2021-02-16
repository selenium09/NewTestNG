package listernersDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//listeners are features of testNG which allows you to customize logs or reports of NG.
//It listens to certain events and behave accordingly-listens to testNG events 
//We can either extend 'TestListenerAdapter' class
//or we can implement interface(in interfaces methods are not implemented) 'ITestlisterner' which has certain methods-which we have to implement.
//we can implement on class level or Suite level

public class TestNGListeners implements ITestListener		//implements interface and adds unimplemented methods below
{

	@Override
	public void onTestStart(ITestResult result)				//it has parameter 'ITestResult', so whatever result comes it will be stored in result object 
	{
		System.out.println("Testcase started and details are"+result.getName());													//this listener gives testcase name of the one failed among 15 testcases
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("Testcase passed and details are"+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Testcase failed and details are"+result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		
		System.out.println("Testcase skipped and details are"+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
	}		
	
}
