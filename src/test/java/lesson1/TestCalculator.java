package lesson1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class TestCalculator {
	public AppiumDriver driver;
	
	
	@BeforeClass
	public void initalAppiumSetting() throws MalformedURLException{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "test1");
		//oppo r9s
//		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
//		cap.setCapability("appPackage", "com.android.calculator2");
//		cap.setCapability("appWaitActivity","com.android.calculator2.Calculator");
//		cap.setCapability("appWaitPackage","com.android.calculator2");
		
		//vivo手机
		cap.setCapability("appActivity", "com.android.bbkcalculator.Calculator");
		cap.setCapability("appPackage", "com.android.bbkcalculator");
		cap.setCapability("appWaitActivity","com.android.bbkcalculator.Calculator");
		cap.setCapability("appWaitPackage","com.android.bbkcalculator");
		cap.setCapability("ignoreUnimportantViews", "true");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	}
	
	@Test
	public void plus() throws InterruptedException{
//		TouchAction ac = new TouchAction(driver);
		Thread.sleep(2000);

		//ac.tap(160, 1600).perform();坐标点击。开发者选项中开启指针位置来获得坐标值

		driver.findElement(By.id("com.android.bbkcalculator:id/digit1")).click();


		driver.findElement(By.id("com.android.bbkcalculator:id/plus")).click();

		driver.findElement(By.id("com.android.bbkcalculator:id/digit2")).click();

		driver.findElement(By.id("com.android.bbkcalculator:id/equal")).click();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void release(){
		driver.quit();
	}
}
