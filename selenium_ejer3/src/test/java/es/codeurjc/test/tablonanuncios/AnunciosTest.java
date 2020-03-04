package es.codeurjc.test.tablonanuncios;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import es.codeurjc.test.tablonanuncios.page.AnuncioPage;
import es.codeurjc.test.tablonanuncios.page.MensajePage;
import es.codeurjc.test.tablonanuncios.page.NuevoAnuncioPage;
import es.codeurjc.test.tablonanuncios.page.TablonPage;
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
		
		TablonPage tablon = new TablonPage(driver);
		
		NuevoAnuncioPage nuevoAnuncio = tablon.get().nuevoAnuncio();
		
		MensajePage creado = nuevoAnuncio.crear(userName, "Subject", "Comment");
		
		tablon = creado.volverAlTablon();
		
		assertTrue(tablon.estaAnuncio(userName, "Subject"));
		
	}
	
	@Test(priority = 2)
	public void borrarAnuncio() {
		
		TablonPage tablon = new TablonPage(driver);
		
		AnuncioPage anuncio = tablon.get().verAnuncio(userName, "Subject");
		
		MensajePage borrado = anuncio.borrar();
		
		tablon = borrado.volverAlTablon();
		
		assertFalse(tablon.estaAnuncio(userName, "Subject"));
	}
	
}
