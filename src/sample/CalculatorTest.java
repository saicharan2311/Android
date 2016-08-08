package sample;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.*;

public class CalculatorTest {

	
	CalculatorScreen screen;
@BeforeClass
public void setUp() {
	screen = new CalculatorScreen();
	
	System.out.println(screen.getDriver().hashCode());
	System.out.println("@BeforeClass");

}

@Test
public void testCal() throws Exception {
   //locate the Text on the calculator by using By.name()
	
   WebElement two=screen.getDriver().findElement(By.name("2"));
   two.click();
   WebElement plus=screen.getDriver().findElement(By.name("+"));
   plus.click();
   WebElement four=screen.getDriver().findElement(By.name("4"));
   four.click();
   WebElement equalTo=screen.getDriver().findElement(By.name("="));
   equalTo.click();
   //locate the edit box of the calculator by using By.tagName()
   String result = screen.getDriver().findElement(By.className("android.widget.EditText")).getText();
	//Check the calculated value on the edit box
   Assert.assertEquals("6", result);

}

//@Test()
public void allContactsTest(){
	
	// Click on dialer
	//WebElement phone= driver.findElement(By.name("Phone"));
	//phone.click();
	
	// Click on Contacts
	
	WebElement contacts=screen.getDriver().findElement(By.xpath("//android.view.View[@content-desc='Contacts']"));
	
	contacts.click();
	
	// Get all  contact names
	
	List<WebElement> contactNames=screen.getDriver().findElements(By.id("com.android.dialer:id/cliv_name_textview"));
	
	for(WebElement element : contactNames){
		System.out.println(element.getText());
	}
}

	//@Test()
	public void createNewContact() {
		

		WebElement contactName = screen.getDriver().findElement(By.name(("Name")));

		WebElement contactPhone = screen.getDriver().findElement(By.name(("Phone")));

		WebElement contactMail = screen.getDriver().findElement(By.name("Email"));

		WebElement saveButton = screen.getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc='Save']"));

		String name = "Charan";

		String phone = "9642840940";

		contactName.sendKeys(name);

		contactPhone.sendKeys(phone);

		contactMail.sendKeys("charansai77@gmail.com");

		saveButton.click();

	}

@AfterClass
public void teardown(){
	//close the app
	System.out.println("@AfterClass");
	System.out.println(screen.getDriver().hashCode());
	screen.getDriver().quit();
}
}

