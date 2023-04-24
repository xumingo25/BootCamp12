package abracamonte;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class TsoftTest {

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void test() {
        // Exercise
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println("Este es el titulo de la pagina: " + title);

        driver.manage().window().maximize();

        // Encontrar el campo de búsqueda y escribir el término de búsqueda
        WebElement campoBusqueda = driver.findElement(By.name("q"));
        campoBusqueda.sendKeys("tsoft");

        // Presionar Enter en el teclado para hacer la búsqueda
        campoBusqueda.sendKeys(Keys.ENTER);

        // Esperar a que se cargue la página de resultados
        try {
            Thread.sleep(5000); // Esperar 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Seleccionar el primer link que aparece en la página de resultados
        WebElement primerLink = driver.findElement(By.cssSelector("div#search div.g a"));
        primerLink.click();

        // Esperar a que se cargue la página del primer link
        try {
            Thread.sleep(5000); // Esperar 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        title = driver.getTitle();
        System.out.println("Titulo de pagina de TSoft: "+ title);



    }

}

