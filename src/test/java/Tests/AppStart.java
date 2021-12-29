package Tests;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.springframework.util.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AppStart extends BaseClass {

	@Test(priority = 1)
	public void SignIn() throws Exception {

		test = extent.createTest("SignIn Test", "SignIn Test");
		Thread.sleep(10000);

		MobileElement mobelement = (MobileElement) driver.findElementByAccessibilityId("LET'S GET STARTED");
		mobelement.click();
		Thread.sleep(1000);
		mobelement = null;

		mobelement = (MobileElement) driver.findElementByAccessibilityId("SIGN-IN");
		mobelement.click();
		Thread.sleep(1000);
		mobelement = null;

		driver.findElementByClassName("android.widget.EditText").click();
		Thread.sleep(500);

		driver.findElementByClassName("android.widget.EditText").sendKeys("14161267346");
		Thread.sleep(500);

		mobelement = (MobileElement) driver.findElementByAccessibilityId("NEXT");
		mobelement.click();
		Thread.sleep(3000);
		mobelement = null;

		List<MobileElement> numbers = driver.findElements(By.className("android.widget.EditText"));
		for (int i = 0; i < numbers.size(); i++) 
		{
			numbers.get(i).click();
			Thread.sleep(100);
			numbers.get(i).sendKeys("7");

		}

		mobelement = (MobileElement) driver.findElementByAccessibilityId("VERIFY");
		mobelement.click();
		Thread.sleep(5000);
		mobelement = null;

		mobelement = (MobileElement) driver
				.findElement(By.xpath("//android.widget.ImageView[@content-desc='Skip Walk Through']"));
		mobelement.click();
		Thread.sleep(2000);

	}
	
	
	@Test(priority = 2)
	public void DashboardLand() throws Exception {
		String resources = null;
		test = extent.createTest("DashBoard Data Test", "DashBoard Data Test");
		Thread.sleep(9000);
		
		MobileElement element = (MobileElement) driver
				.findElement(By.xpath("//android.view.View[contains(@content-desc,'$')]"));
		
		String text = element.getAttribute("content-desc");
		test.log(Status.INFO, text);
		
		MobileElement element2 = (MobileElement) driver
				.findElement(By.xpath("//android.view.View[starts-with(@content-desc,'Resources')]"));
		resources = element2.getAttribute("content-desc");
		Assert.hasText("Call", resources);
		test.log(Status.INFO, resources);

	}
	
	
	@Test(priority = 3 )
	public void Notification() throws Exception {
		test = extent.createTest("Notification Test", "Notification Test");
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[44,171][102,325]']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[0,171][154,325]']")).click();
		Thread.sleep(2000);
		
	}
	
	
	@Test(priority = 4 )
	public void Theme() throws Exception {
		test = extent.createTest("Change Theme Test", "Change Theme Test");
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[158,171][213,325]']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[158,171][221,325]']")).click();
		Thread.sleep(3000);
	
		
	}
	
	
	@Test(priority = 5)
	public void ProfileEdit() throws Exception {
		test = extent.createTest("Profile Edit Change Email Test Case", "Profile Edit Change Email Test Case");
		Thread.sleep(10000);
		
		MobileElement mob = driver.findElement(By.xpath("//android.view.View[@bounds='[969,214][1036,282]']"));
		mob.click();
		Thread.sleep(1000);
		mob = null;
		
		mob = driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[113,1178][968,1310]']"));
		mob.click();
		driver.hideKeyboard();
		mob.sendKeys("");
		mob.clear();
		mob.sendKeys("khan123@gmail.com");
		Thread.sleep(200);
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.RadioButton[@bounds='[113,1797][245,1929]']")).click();
		Thread.sleep(2000);
		while (getButton().size() == 0)
			swipe();

		if (getButton().size() > 0) {
			MobileElement mobile = getButton().get(0);
			mobile.click();
			Thread.sleep(1000);
			driver.findElementByAccessibilityId("Okay").click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[0,171][154,325]']")).click();
			Thread.sleep(2000);
		}
		
		
	}
	
	
	public List<MobileElement> getButton() {
		List<MobileElement> ElementsList = driver.findElements(By.xpath("//android.view.View[@content-desc='SAVE']"));
		return ElementsList;

	}
	
	public static void swipe() {

		Dimension dimension = driver.manage().window().getSize();
		Double ScrollHeightStart = dimension.getHeight() * 0.5;
		int scrollStart = ScrollHeightStart.intValue();
		Double ScrollHeightEnd = dimension.getHeight() * 0.3;

		Double ScrollWidthStart = dimension.getWidth() * 0.5;
		int width = ScrollWidthStart.intValue();
		int scrollEnd = ScrollHeightEnd.intValue();
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(width, scrollStart))
				.waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(width, scrollEnd)).release().perform();
	}
	
	
	@Test(priority = 6)
	public void Menu() throws Exception {
		test = extent.createTest("Menu Test", "Menu Test");
		Thread.sleep(10000);
		
		driver.findElementByAccessibilityId("Menu").click();
		Thread.sleep(2000);

		driver.findElementByAccessibilityId("Subscriptions").click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'VAS')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[0,171][154,325]']")).click();
		Thread.sleep(2000);
		driver.findElementByAccessibilityId("Menu").click();
		Thread.sleep(2000);
		driver.findElementByAccessibilityId("View History").click();
		Thread.sleep(2000);
		driver.findElementByAccessibilityId("Okay").click();
		Thread.sleep(2000);
		
		List<MobileElement> numbers = driver.findElements(By.className("android.widget.EditText"));
		int sizze = numbers.size();
		if(numbers.size() > 0) {
			Thread.sleep(500);
			numbers.get(0).click();
			Thread.sleep(500);
			numbers.get(0).sendKeys("7");
			Thread.sleep(200);
			numbers.get(1).click();
			Thread.sleep(200);
			numbers.get(1).sendKeys("7");
			Thread.sleep(200);
			numbers.get(2).click();
			Thread.sleep(200);
			numbers.get(2).sendKeys("7");
			Thread.sleep(200);
			numbers.get(3).click();
			Thread.sleep(200);
			numbers.get(3).sendKeys("7");
			Thread.sleep(200);
		}
		
		MobileElement mobelement = (MobileElement) driver.findElementByAccessibilityId("NEXT");
		mobelement.click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'CALL')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'SMS')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'DATA')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'Offers')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[0,171][154,325]']")).click();
		Thread.sleep(2000);
		
	}
	
	
	@Test(priority = 7)
	public void Settings() throws Exception {
		test = extent.createTest("Settings Test", "Settings Test");
		Thread.sleep(10000);
		
		MobileElement ele = (MobileElement) driver.findElementByAccessibilityId("Settings");
		ele.click();
		Thread.sleep(2000);
		ele = null;
		
		ele = (MobileElement) driver.findElementByAccessibilityId("TERMS & CONDITIONS");
		ele.click();
		Thread.sleep(2000);
		ele = null;
		
		driver.navigate().back();
		Thread.sleep(2000);
		
		ele = (MobileElement) driver.findElementByAccessibilityId("PRIVACY POLICY");
		ele.click();
		Thread.sleep(2000);
		ele = null;
		
		driver.navigate().back();
		Thread.sleep(2000);
		
		ele = (MobileElement) driver.findElementByAccessibilityId("LICENSES");
		ele.click();
		Thread.sleep(2000);
		ele = null;
		
		driver.navigate().back();
		Thread.sleep(2000);
		
		ele = (MobileElement) driver.findElementByAccessibilityId("ABOUT US");
		ele.click();
		Thread.sleep(2000);
		ele = null;
		
		driver.navigate().back();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[0,171][154,325]']")).click();
		Thread.sleep(2000);
		
	}
	
	
	
	@Test(priority = 8)
	public void LogOut() throws Exception {
		test = extent.createTest("LogOut Test", "LogOut Test");
		Thread.sleep(800);
		
		driver.findElementByAccessibilityId("Settings").click();
		Thread.sleep(500);
		driver.findElementByAccessibilityId("LOGOUT").click();
		Thread.sleep(500);
		driver.findElement(By.className("android.widget.CheckBox")).click();
		Thread.sleep(500);
		driver.findElementByAccessibilityId("YES").click();
		Thread.sleep(500);
	}
	
}
	