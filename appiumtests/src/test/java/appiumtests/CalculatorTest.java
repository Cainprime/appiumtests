package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest {

	static AppiumDriver<MobileElement> driver;


	public static void main(String[] args) {
		try {
			openCalculator();
		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}

	}

	public static void openCalculator() throws Exception {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "device");
		cap.setCapability("udid", "127.0.0.1:62001");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.1.2");

		cap.setCapability("appPackage", "com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);

		System.out.println("Application Started...");

		MobileElement twoButton = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
		MobileElement plusButton = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
		MobileElement threeButton = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
		MobileElement equalsButton = driver.findElement(By.id("com.google.android.calculator:id/eq"));
		

		twoButton.click();
		plusButton.click();
		threeButton.click();
		equalsButton.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		MobileElement result = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
		
		String res = result.getText();
		System.out.println("\n Result is :"+res);
		System.out.println("Completed");
		
		driver.quit();


	}
}
