package es.codeurjc.test.web;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.LoggerFactory;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.lifecycle.TestDescription;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;

import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;

import java.io.File;
import java.util.Optional;

@Testcontainers
public class WikipediaTest {

	public static BrowserWebDriverContainer<?> chrome = new BrowserWebDriverContainer<>()
			.withCapabilities(DesiredCapabilities.chrome()).withRecordingMode(RECORD_ALL, new File("./target"))
			.withLogConsumer(new Slf4jLogConsumer(LoggerFactory.getLogger("chrome")));

	private RemoteWebDriver driver;

	@BeforeClass
	public static void startContainer() {
		chrome.start();
	}

	@AfterClass
	public static void stopContainer() {
		chrome.stop();
	}

	@BeforeMethod
	public void setupTest() {
		driver = chrome.getWebDriver();
	}

	@AfterMethod
	public void teardown(ITestResult info) {

		recordVideoIfNeeded(info);

		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void test() throws InterruptedException {

		driver.get("https://wikipedia.org");
		WebElement searchInput = driver.findElement(By.name("search"));

		Thread.sleep(2000);

		searchInput.sendKeys("Rick Astley");
		searchInput.submit();

		Thread.sleep(2000);

		WebElement link = driver.findElement(By.linkText("Rickrolling"));
		link.click();

		Thread.sleep(2000);

		boolean memeFound = driver.findElements(By.cssSelector("p")).stream()
				.anyMatch(element -> element.getText().contains("meme"));

		assertTrue(memeFound, "Rickrolling page should contain meme word");
	}

	private void recordVideoIfNeeded(ITestResult info) {

		TestDescription td = new TestDescription() {
			@Override
			public String getTestId() {
				return info.getMethod().getMethodName();
			}

			@Override
			public String getFilesystemFriendlyName() {
				return info.getTestClass().getClass().getName() + "-" + info.getMethod().getMethodName();
			}
		};

		chrome.afterTest(td, Optional.empty());
	}

}
