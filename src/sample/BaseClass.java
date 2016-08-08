package sample;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	
	BaseClass(){
		initializeDriver();
	}
	private WebDriver driver;
	
	public WebDriver getDriver() {
		
		if(driver==null){
			initializeDriver();
			return driver;
		}
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	private DesiredCapabilities capabilities=null;
	InputStream in = this.getClass().getClassLoader().getResourceAsStream("android.properties");
	
	 private final Properties configProp = new Properties();
	
	 public void setUp(){
		capabilities = new DesiredCapabilities();
		  try {
	          configProp.load(in);
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
		capabilities.setCapability("deviceName", configProp.getProperty("deviceName"));
		capabilities.setCapability("platformName",configProp.getProperty("platformName"));
		capabilities.setCapability("appPackage", configProp.getProperty("appPackage"));
		capabilities.setCapability("appActivity",configProp.getProperty("appActivity"));
	}
	
	public void initializeDriver(){
		if(driver==null){
			try {
				setUp();
				driver= new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				setDriver(driver);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
