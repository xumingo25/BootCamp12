package fbazan.localizadoresMeli;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class localizadoresMeli {
    WebDriver driver; //creacion del atributo para el webDriver
    WebDriverWait wait; //permite definir una espera

    @BeforeAll
    static void preparacionClase() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void preTests() {
        driver = new ChromeDriver(); //instanciamos el chromeDriver
        wait = new WebDriverWait(driver, 10); //instanciamos el webDriverWait
        driver.get("https://www.mercadolibre.com.ar/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); //le indicamos un tiempo limite a la pagina para que cargue
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //le indicamos los tiempos de respuestas que tiene que tener la pagina al cargar un elemento web
    }

    @Test
    void CP002_BusquedaProducto_OK() throws InterruptedException {

        By locatorBuscarProducto = null;
        WebElement txtBuscarProducto = null;
        try {
            locatorBuscarProducto = By.xpath("//input[@id='cb1-edit']");
            txtBuscarProducto = driver.findElement(locatorBuscarProducto);
            txtBuscarProducto.sendKeys("cascos moto");
            Thread.sleep(5000);
            txtBuscarProducto.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Ocurrio un error al obtener el elemento web" + locatorBuscarProducto.toString());
        }


        By locatorSeleccionarProducto = null;
        WebElement txtSeleccionarProducto = null;
        try {
            locatorSeleccionarProducto = By.xpath("//ol[@class='ui-search-layout ui-search-layout--stack shops__layout']/li[1]//div[@class='carousel-container arrow-visible']");
            txtSeleccionarProducto = driver.findElement(locatorSeleccionarProducto);
            txtSeleccionarProducto.click();
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Ocurrio un error al obtener el elemento web" + locatorSeleccionarProducto.toString());
        }

        By locatorBtnComprarAhora = null;
        WebElement buttonComprarAhora = null; //verifica si existe el elemento web (boton registrar)
        try {
            locatorBtnComprarAhora = By.xpath("//span[contains(text(),'Comprar ahora')]");
            buttonComprarAhora = driver.findElement(locatorBtnComprarAhora);
            buttonComprarAhora.click();
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println("Ocurrio un error al obtener el elemento web" + locatorBtnComprarAhora.toString());
        }

    }
        @AfterEach
    void posTests () {
        driver.close();
    }
}

