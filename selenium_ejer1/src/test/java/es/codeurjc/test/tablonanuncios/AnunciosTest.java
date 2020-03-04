package es.codeurjc.test.tablonanuncios;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnunciosTest {

	private WebDriver driver;
	
	private String userName = "User_"+Double.toString(Math.random());
	
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
	
	@Test(priority = 1)
	public void createAnuncio() {
		
		driver.get("http://localhost:8080/");
		
	    driver.findElement(By.linkText("Nuevo anuncio")).click();
	    
	    driver.findElement(By.name("nombre")).sendKeys(userName);
	    driver.findElement(By.name("asunto")).sendKeys("Subject");
	    driver.findElement(By.name("comentario")).sendKeys("Comment");
	    
	    driver.findElement(By.xpath("//input[@value='Enviar']")).click();
	    
	    driver.findElement(By.linkText("Volver al tablón")).click();
	    
	    driver.findElement(By.linkText(userName+" Subject"));
		
	}
	
	@Test(priority = 2)
	public void borrarAnuncio() {
		
		driver.get("http://localhost:8080/");
		
	    driver.findElement(By.linkText(userName+" Subject")).click();
	    
	    driver.findElement(By.linkText("Borrar anuncio")).click();
	    
	    driver.findElement(By.linkText("Volver al tablón")).click();
	    	    
	    assertEquals(driver.findElements(By.linkText(userName+" Subject")).size(), 0);	    
		
	}
	
}
