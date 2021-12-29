package Tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	public static ExtentReports extent;
	public static ExtentSparkReporter spark ;
	public static ExtentTest test;
	DesiredCapabilities caps;
	static AppiumDriver<MobileElement> driver;
	
	
	@BeforeSuite
	public void reportSetUp() {
		// start reporters
		spark = new ExtentSparkReporter("Spark.html");
		// create ExtentReports and attach reporter(s)
	    extent = new ExtentReports();
		extent.attachReporter(spark);
		
	}
	
	@BeforeTest
	public void SetUp() {
		caps= new DesiredCapabilities();
	    
		//set capabilities
	
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 0);
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		caps.setCapability(MobileCapabilityType.FULL_RESET, false);
	
		//set app package name and activity

		caps.setCapability("appPackage", "com.evampsaanga.tec");
		caps.setCapability("appActivity", "com.evampsaanga.prod_div_tec.MainActivity");
		URL url = null;
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
			driver=new AppiumDriver<MobileElement>(url, caps);
			
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			
		
		} 
	}
	
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
	    if(result.getStatus() == ITestResult.FAILURE)
	    {
	        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
	        test.fail(result.getThrowable());
	    }
	    else if(result.getStatus() == ITestResult.SUCCESS)
	    {
	        test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	    }
	    else
	    {
	        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
	        test.skip(result.getThrowable());
	    }
	}

	@AfterSuite
	public void reportTearDown(){
	    extent.flush();
	    
	   }
}
