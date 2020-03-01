package es.codeurjc.test.web;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WikipediaTest {

	@Test
	public void test() throws InterruptedException {
		
		// 0 - Configurar el driver del navegador
		System.setProperty("webdriver.chrome.driver", 
				"/home/mica/chromedriver_linux64/chromedriver");

		// 1 - Abrir el navegador web
		WebDriver driver = new ChromeDriver();

		// 2 - Abrir una página web
		driver.get("https://wikipedia.org");

		// 3 - Localizar elementos en la página
		WebElement searchInput = driver.findElement(By.name("search"));

		// 4 - Interactuar con los elementos
		searchInput.sendKeys("Rick Astley");
		searchInput.submit();

		// 5 - Esperar a que ciertos elementos estén disponibles

		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement text = wait.until(
				presenceOfElementLocated(By.id("mw-content-text")));

		// 6 - Verificar que la web bajo pruebas cumple las condiciones esperadas

		assertTrue(text.getText().contains("Richard Paul Astley"));

		// 7 - Cerrar el navegador
		driver.quit();
	}

}







