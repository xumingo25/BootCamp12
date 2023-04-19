package bpino;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
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
            js.executeScript("arguments[0].scrollIntoView(true);", txtMasCategorias);
            txtMasCategorias.click();
        } catch (Exception e) {
            System.out.println("ha ocurrido un error al obtener el elemento web con el locator "+ locatorTxtMasCategorias.toString());
        }

        By locatorTxtTrekking = null;
        WebElement txtTrekking = null;
        try {
            locatorTxtTrekking = By.xpath("//h3[contains(text(),'Trekking y Monta\u00f1ismo')]");
            txtTrekking= wait.until(ExpectedConditions.presenceOfElementLocated(locatorTxtTrekking));
            js.executeScript("arguments[0].scrollIntoView(true);", txtTrekking);
            txtTrekking.click();
        } catch (Exception e) {
            System.out.println("ha ocurrido un error al obtener el elemento web con el locator "+ locatorTxtTrekking.toString());
        }
        By locatorCheckCategoria = null;
        WebElement checkCategoria = null;
        try {
            locatorCheckCategoria = By.xpath("//input[@id='categorySearch']");
            checkCategoria= wait.until(ExpectedConditions.presenceOfElementLocated(locatorCheckCategoria));
            checkCategoria.click();
        } catch (Exception e) {
            System.out.println("ha ocurrido un error al obtener el elemento web con el locator "+ checkCategoria.toString());
        }

        By locatorInputBuscar = null;
        WebElement inputBuscar = null;
        try {
            locatorInputBuscar = By.xpath("//input[@id='cb1-edit']");
            inputBuscar= wait.until(ExpectedConditions.presenceOfElementLocated(locatorInputBuscar));
            inputBuscar.sendKeys("Bastones",(Keys.RETURN));

        } catch (Exception e) {
            System.out.println("ha ocurrido un error al obtener el elemento web con el locator "+ locatorInputBuscar.toString());
        }

        By locatorTxtProducto = null;
        WebElement txtProducto = null;
        try {
            locatorTxtProducto = By.xpath("//h2[contains(text(),'Bastones De Trekking 2 Unidades Par Ajustable Aluminio 7075')]");
            txtProducto= wait.until(ExpectedConditions.elementToBeClickable(locatorTxtProducto));
            js.executeScript("arguments[0].scrollIntoView(true);", txtProducto);
            txtProducto.click();

        } catch (Exception e) {
            System.out.println("ha ocurrido un error al obtener el elemento web con el locator "+ locatorTxtProducto.toString());
        }

        By locatorTxtComprar= null;
        WebElement txtComprar = null;
        try {
            locatorTxtComprar = By.xpath("//span[contains(text(),'Comprar ahora')]");
            txtComprar= wait.until(ExpectedConditions.elementToBeClickable(locatorTxtComprar));
            js.executeScript("arguments[0].scrollIntoView(true);", txtComprar);
            txtComprar.click();

        } catch (Exception e) {
            System.out.println("ha ocurrido un error al obtener el elemento web con el locator "+ locatorTxtComprar.toString());
        }
        String resultadoEsperado = null;
        WebElement texto = null;
        try {
            resultadoEsperado= "\u00A1Hola! Para comprar, ingresa a tu cuenta";

            texto = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'\u00A1Hola! Para comprar, ingresa a tu cuenta')]")));

            Assertions.assertEquals(resultadoEsperado,texto.getText());

            System.out.println("Test finalizado");

        }catch (Exception e){
            System.out.println("No se ha encontrado el texto esperado");
        }


    }

    @AfterEach
    void posTests() {
        //driver.close();
    }
}
