package es.codeurjc.test.web;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode;
import org.testcontainers.lifecycle.TestDescription;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WikipediaTest {

	public static BrowserWebDriverContainer<?> chrome = new BrowserWebDriverContainer<>()
			.withCapabilities(DesiredCapabilities.chrome())
			.withRecordingMode(VncRecordingMode.RECORD_ALL, new File("./target"));

	private RemoteWebDriver driver;

	@BeforeMethod
	public void setupTest() {
		chrome.start();
		driver = chrome.getWebDriver();
	}

	@AfterMethod
	public void teardown(ITestResult info) {

		recordVideoIfNeeded(info);

		if (driver != null) {
			driver.quit();
		}
		chrome.stop();
	}

	@Test
	public void test() throws InterruptedException {

		// 2 - Abrir una página web
		driver.get("https://wikipedia.org");

		// 3 - Localizar elementos en la página
		WebElement searchInput = driver.findElement(By.name("search"));

		// 4 - Interactuar con los elementos
		searchInput.sendKeys("Rick Astley");
		searchInput.submit();

		// 5 - Esperar a que ciertos elementos estén disponibles

		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement text = wait.until(presenceOfElementLocated(By.id("mw-content-text")));

		// 6 - Verificar que la web bajo pruebas cumple las condiciones esperadas

		assertTrue(text.getText().contains("Richard Paul Astley"));
	}

	//Hack para grabar el vídeo debido a que TestContainers no está 
	//diseñado para TestNG
	private void recordVideoIfNeeded(ITestResult info) {

		TestDescription td = new TestDescription() {
			@Override
			public String getTestId() {
				return info.getMethod().getMethodName();
			}

			@Override
			public String getFilesystemFriendlyName() {
				return info.getTestClass().getClass().getName() + "-" +
					info.getMethod().getMethodName();
			}
		};

		chrome.afterTest(td, Optional.empty());
	}

}
