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

import es.codeurjc.test.web.page.ArticlePage;
import es.codeurjc.test.web.page.MainPage;
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
		
		MainPage wikipedia = new MainPage(driver);
		
		ArticlePage article = wikipedia.get().search("Rick Astley");
		
		String content = article.getContextText();
		
		assertTrue(content.contains("Richard Paul Astley"));
	}
}







