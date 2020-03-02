package es.codeurjc.test.web;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class WikipediaTest {

	public AndroidDriver<WebElement> driver;

	@BeforeMethod
	public void setupTest() throws MalformedURLException {
	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.15.1");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0.0");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
		capabilities.setCapability("newCommandTimeout", 2000);
		
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);		
	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void test() throws InterruptedException {

		driver.get("https://wikipedia.org");
		
		WebElement searchInput = driver.findElement(By.name("search"));

		searchInput.sendKeys("Rick Astley");
		
		//Different way to send search as Android Chrome doesn't support submit
		WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		button.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement text = wait.until(presenceOfElementLocated(By.id("mw-content-text")));

		assertTrue(text.getText().contains("Richard Paul Astley"));
	}

}






