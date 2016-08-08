package sample;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.remote.MobileCapabilityType;

public class MobileDeviceTest {
	
	WebDriver driver;
	@Test()
	public void installDropBoxTest(){
		File appDir= new File("E:\\sampleapps");
		File app= new File(appDir,"com.dropbox.android_12.2.2-1220200_minAPI16(armeabi-v7a,x86)(nodpi)_apkmirror.com.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APP, app);
		capabilities.setCapability("deviceName","#ZY223B6MQX");
		capabilities.setCapability("platformName","Android");
		
		
		capabilities.setCapability("appPackage", "com.dropbox.android");
		capabilities.setCapability("appActivity","com.dropbox.android.camerauploads.SnoozeCUActivity");
		try {
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
		driver.findElement(By.name("Dropbox")).click();
	}

}
