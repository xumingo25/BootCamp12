package bpino;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestMercadoLibre {
    WebDriver driver;
    WebDriverWait wait;

    JavascriptExecutor js;

    @BeforeAll
    static void preparacionClase() {
        System.setProperty("file.encoding", "UTF-8");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void preTests() {
        driver = new ChromeDriver(); //Instanciamos el chromeDriver
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;

        PageFactory.initElements(driver, this);
        driver.get("https://www.mercadolibre.cl/");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    void CP001_BusquedaMELI_OK() throws InterruptedException {
        By locatorTxtCookies = null;
        WebElement txtCookies = null;
        try {
            locatorTxtCookies = By.xpath("//button[contains(text(),'Entendido')]");
            txtCookies = wait.until(ExpectedConditions.presenceOfElementLocated(locatorTxtCookies));
            txtCookies.click();
        } catch (Exception e) {
            System.out.println("ha ocurrido un error al obtener el elemento web con el locator "+ locatorTxtCookies.toString());
        }

        By locatorTxtUbicacion = null;
        WebElement txtUbicacion = null;
        try {
            locatorTxtUbicacion = By.xpath("//span[contains(text(),'M\u00e1s tarde')]");
            txtUbicacion = wait.until(ExpectedConditions.presenceOfElementLocated(locatorTxtUbicacion));
            txtUbicacion.click();
        } catch (Exception e) {
            System.out.println("ha ocurrido un error al obtener el elemento web con el locator "+ locatorTxtUbicacion.toString());
        }

        By locatorTxtCategorias = null;
        WebElement txtCategorias = null;
        try {
            locatorTxtCategorias = By.xpath("//a[contains(text(),'Categor\u00edas')]");
            txtCategorias = wait.until(ExpectedConditions.presenceOfElementLocated(locatorTxtCategorias));
            txtCategorias.click();
        } catch (Exception e) {
            System.out.println("ha ocurrido un error al obtener el elemento web con el locator "+ locatorTxtCategorias.toString());
        }

        By locatorTxtMasCategorias = null;
        WebElement txtMasCategorias = null;
        try {
            locatorTxtMasCategorias = By.xpath("//a[contains(text(),'Ver m\u00e1s categor\u00edas')]");
            txtMasCategorias= wait.until(ExpectedConditions.presenceOfElementLocated(locatorTxtMasCategorias));
            txtMasCategorias.click();
        } catch (Exception e) {
            System.out.println("ha ocurrido un error al obtener el elemento web con el locator "+ locatorTxtMasCategorias.toString());
        }

        By locatorTxtMusica = null;
        WebElement txtMusica = null;
        try {
            locatorTxtMusica = By.xpath("//h3[contains(text(),'M\u00fasica')]");
            txtMusica= wait.until(ExpectedConditions.presenceOfElementLocated(locatorTxtMusica));
            js.executeScript("arguments[0].scrollIntoView(true);", txtMusica);
            txtMusica.click();
        } catch (Exception e) {
            System.out.println("ha ocurrido un error al obtener el elemento web con el locator "+ locatorTxtMusica.toString());
        }



    }

    @AfterEach
    void posTests() {
        //driver.close();
    }
}
