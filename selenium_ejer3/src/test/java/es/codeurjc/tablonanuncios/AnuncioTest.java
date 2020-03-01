package es.codeurjc.tablonanuncios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import es.codeurjc.tablonanuncios.pages.TablonPage;
import es.codeurjc.test.tablonanuncios.Application;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AnuncioTest extends AbstractTestNGSpringContextTests {

	@LocalServerPort
    int port;
	
	WebDriver driver;
	
	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
	}
	
	@AfterMethod
	public void teardown() {
		if(driver != null) {
			driver.quit();
		}
	}
	
	@Test
	public void createAnuncio() throws InterruptedException {
		TablonPage tablon = new TablonPage(driver, port);
		
		String name = "Michel";
		String asunto = "Vendo coche";
		String comentario = "Vendo Opel Corsa";
		
		tablon.get() // -> Go to TablonPage
			.nuevoAnuncio() // -> Go to AnuncioFormPage
				.rellenarNuevoAnuncio(name, asunto, comentario)
			.enviarNuevoAnuncio() // -> Go to AnuncioResult
			.volverAlTablon() // -> Go to TablonPage
				.comprobarNuevoAnuncio(name, asunto);
	}
	
	@Test
	public void deleteAnuncio() throws InterruptedException {
		TablonPage tablon = new TablonPage(driver, port);
		
		String nombre = "Pepe";
		String asunto = "Hola caracola";		
		
		tablon.get() // -> Go to TablonPage
			.verAnuncio(nombre, asunto) // -> Go to AnuncioPage
				.borrarAnuncio() // -> Go to AnuncioResult
			.volverAlTablon() // -> Go to TablonPage
				.comprobarAnuncioBorrado(nombre, asunto);
	}

}
