package es.codeurjc.test.web;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WikipediaTest {

	private WebDriver driver;

	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeMethod
	public void setupTest() {
		driver = new ChromeDriver();
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
		        
		WebElement text = wait.until(
			presenceOfElementLocated(By.id("mw-content-text")));
		        
		assertTrue(text.getText().contains("Richard Paul Astley"));
	}

}







