package fbenavides;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class TareaMeli {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @FindBy(xpath = "//button[contains(text(),'Entendido')]")
    WebElement btnAceptarCookies;

    @FindBy(xpath = "//button[@class= 'onboarding-cp-button andes-button andes-button--transparent andes-button--small']")
    WebElement btnNoCompartirUbicacion;

    @FindBy(xpath = "//button[@class= 'nav-search-btn']")
    WebElement btnBuscar;

    By locatorTxtEscribeProducto = By.xpath("//input[@id='cb1-edit']");
    By locatorProductoElegido = By.xpath("//h2[contains(text(),'Cd The Weeknd - After Hours Nuevo Y Sellado Obivinilos')]");
    By locatorComprar = By.xpath("//button[@class= 'andes-button andes-spinner__icon-base andes-button--loud']");


    @BeforeAll
    static void preparacionClase() {
        System.setProperty("file.encoding", "UTF-8");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void preTests() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://www.mercadolibre.cl/");
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    void CP001_BuscarProducto() {

        btnAceptarCookies.click();
        btnNoCompartirUbicacion.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(locatorTxtEscribeProducto));
        String producto = "cd starboy the weeknd";
        WebElement txtEscribeProducto;
        try {
            txtEscribeProducto = driver.findElement(locatorTxtEscribeProducto);
            txtEscribeProducto.sendKeys(producto);
            btnBuscar.click();
        } catch (Exception e) {
            System.out.println("ocurrio un error al obtener el elemento web con el locator " + locatorTxtEscribeProducto.toString());
        }

        WebElement seleccionarProducto;
        try {
            seleccionarProducto = wait.until(ExpectedConditions.elementToBeClickable(locatorProductoElegido));
            js.executeScript("arguments[0].scrollIntoView(true);", seleccionarProducto);
            seleccionarProducto.click();
        } catch (Exception e) {
            System.out.println("ocurrio un error al obtener el elemento web con el locator " + locatorProductoElegido.toString());
        }

        WebElement comprarAhora;
        try {
            comprarAhora = wait.until(ExpectedConditions.elementToBeClickable(locatorComprar));
            js.executeScript("arguments[0].scrollIntoView(true);", comprarAhora);
            comprarAhora.click();
        } catch (Exception e) {
            System.out.println("ocurrio un error al obtener el elemento web con el locator " + locatorComprar.toString());
        }

        String resultadoEsperado = "\u00A1Hola! Para comprar, ingresa a tu cuenta";
        String resultadoActual = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Hola! Para comprar, ingresa a tu cuenta')]"))).getText();
        Assertions.assertEquals(resultadoEsperado, resultadoActual);

    }

    @AfterEach
    void teardown() {
        // driver.quit();
    }
}