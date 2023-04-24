package abracamonte;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MercadoLibreTest {
    WebDriver driver; //Creación de atributo WebDriver
    WebDriverWait wait;
    JavascriptExecutor js;
    WebElement inputBuscar;
    WebElement btnBuscar;
    WebElement producto;

    WebElement btnComprarAhora;

    @BeforeAll
    static void preparacionClase() {
        System.setProperty("file.encoding", "UTF-8");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void preTests() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;

        PageFactory.initElements(driver, this);
        driver.get("https://mercadolibre.com.ar/");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    void CP001_BusquedaArticuloMELI_Comprar() {

        By locatorInputBuscar=null;
        By locatorBtnBuscar=null;
        By locatorProducto=null;
        By locatorComprarAhora=null;
        try {
            locatorInputBuscar=By.xpath("//input[contains(@class, 'nav-search-input')]");
            inputBuscar=wait.until(ExpectedConditions.presenceOfElementLocated(locatorInputBuscar));
            inputBuscar.sendKeys("calefaccion magiclick blanco");

        }catch (Exception e){
            System.out.println("No se ha podido encontrar el elemento con el locator: " + locatorInputBuscar.toString());
        }

        try {
            locatorBtnBuscar=By.xpath("//button[contains(@class, 'nav-search-btn')]");
            btnBuscar=wait.until(ExpectedConditions.elementToBeClickable(locatorBtnBuscar));
            btnBuscar.click();
        }catch (Exception e){
            System.out.println("No se ha podido encontrar el elemento con el locator: " + locatorBtnBuscar.toString());
        }

        try {
            locatorProducto=By.xpath("//h2[contains(text(), 'Calefactor el\u00e9ctrico Magiclick C1009 blanco 220V')]");
            producto=wait.until(ExpectedConditions.elementToBeClickable(locatorProducto));
            producto.click();
        }catch (Exception e){
            System.out.println("No se ha podido encontrar el elemento con el locator: " + locatorProducto.toString());
        }

        try {
            locatorComprarAhora=By.xpath("//button[@class='andes-button andes-spinner__icon-base andes-button--loud']");
            btnComprarAhora=wait.until(ExpectedConditions.elementToBeClickable(locatorComprarAhora));
            js.executeScript("arguments[0].scrollIntoView(true);", btnComprarAhora);
            btnComprarAhora.click();
        }catch (Exception e){
            System.out.println("No se ha podido encontrar el elemento con el locator: " + locatorComprarAhora.toString());
        }
        try {
            String resultadoEsperado= "\u00A1Hola! Para comprar, ingres\u00e1 a tu cuenta";

            String resultadoActual = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), '\u00A1Hola! Para comprar, ingres\u00e1 a tu cuenta')]"))).getText();

            Assertions.assertEquals(resultadoEsperado,resultadoActual);

            System.out.println("Finaliza el test con \u00e9xito!");

        }catch (Exception e){
            System.out.println("Ha ocurrido un problema, no se encuentra el texto o algo más falló");
        }


    }

    @AfterEach
    void posTests(){
        driver.close();
    }
}
