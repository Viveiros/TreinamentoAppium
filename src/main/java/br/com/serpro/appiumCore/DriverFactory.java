package br.com.serpro.appiumCore;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
	
	
	private static AndroidDriver driver;
	
	public static AndroidDriver getDriver(){
		if (driver == null) { 
			createDriver();
//			createDriverTestObject();
		}
		return driver;
	}
	
	//Destroi instancia de driver
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	private static void createDriver() {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "D:\\workspace\\TreinamentoAppium\\src\\main\\resources\\CTAppium-1-1.apk");
	    
	    try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	private static void createDriverTestObject() {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("testobject_api_key", "27D6EB58E69B458E9E0C831DEB885EAB");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appiumVersion", "1.13.0");
	    
	    try {
			driver = new AndroidDriver(new URL("https://us1.appium.testobject.com/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}	
}
