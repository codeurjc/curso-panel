package es.codeurjc.test.web;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WikipediaTest {

	private WebDriver driver;

	@BeforeMethod
	public void setupTest() throws MalformedURLException {
		/**
		 * In this section, we will configure our SauceLabs credentials in order to run
		 * our tests on saucelabs.com
		 */
		String sauceUserName = "micaelgallego";
		String sauceAccessKey = "dfa01623-1a68-4d7c-8cb4-43f555ed3c6f";

		/**
		 * In this section, we will configure our test to run on some specific
		 * browser/os combination in Sauce Labs
		 */
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// set your user name and access key to run tests in Sauce
		capabilities.setCapability("username", sauceUserName);

		// set your sauce labs access key
		capabilities.setCapability("accessKey", sauceAccessKey);

		// set browser to Safari
		capabilities.setCapability("browserName", "Safari");

		// set operating system to macOS version 10.13
		capabilities.setCapability("platform", "macOS 10.13");

		// set the browser version to 11.1
		capabilities.setCapability("version", "11.1");

		// set your test case name so that it shows up in Sauce Labs
		capabilities.setCapability("name", "WikipediaTest");

		driver = new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), capabilities);

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
		searchInput.submit();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement text = wait.until(presenceOfElementLocated(By.id("mw-content-text")));

		assertTrue(text.getText().contains("Richard Paul Astley"));
	}
}
