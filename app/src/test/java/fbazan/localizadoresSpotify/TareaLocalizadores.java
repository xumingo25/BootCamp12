package fbazan.localizadoresSpotify;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TareaLocalizadores {

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
        driver.get("https://open.spotify.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //le indicamos un tiempo limite a la pagina para que cargue
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //le indicamos los tiempos de respuestas que tiene que tener la pagina al cargar un elemento web
    }

    @Test
    void CP001_CreacionCtaSpify_OK() throws InterruptedException {

        By locatorBtnRegistrar = By.xpath("//button[contains(text(), 'Regis')]");
        WebElement buttonRegistrar = wait.until(ExpectedConditions.elementToBeClickable(locatorBtnRegistrar)); //verifica si existe el elemento web (boton registrar)

        if (buttonRegistrar.isDisplayed()) {
            buttonRegistrar.click();
        } else {
            System.out.println("No aparece el elemento web" + buttonRegistrar.toString());

        }

        By locatorCorreo = null;
        WebElement txtCorreo = null;
        try {
            locatorCorreo = By.xpath("//input[@id = 'email']");
            txtCorreo = driver.findElement(locatorCorreo);
            txtCorreo.sendKeys("usuario@gmail.com");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al obtener el elemento web" + locatorCorreo.toString());
        }

        By locatorConfirmCorreo = null;
        WebElement txtConfirmCorreo = null;
        try {
            locatorConfirmCorreo = By.xpath("//input[@id = 'confirm']");
            txtConfirmCorreo = driver.findElement(locatorConfirmCorreo);
            txtConfirmCorreo.sendKeys("usuario@gmail.com");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al obtener el elemento web" + locatorConfirmCorreo.toString());
        }

        By locatorPassword = null;
        WebElement txtPassword = null;
        try {
            locatorPassword = By.xpath("//input[@name = 'password']");
            txtPassword = driver.findElement(locatorPassword); //creo el elemento web sin espera
            txtPassword.sendKeys("0123456789");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al obtener el elemento web" + locatorPassword.toString());
        }

        By locatorNombre = null;
        WebElement txtNombre = null;
        try {
            locatorNombre = By.xpath("//input[@id = 'displayname']");
            txtNombre = wait.until(ExpectedConditions.presenceOfElementLocated(locatorNombre)); //crea elemento con espera
            txtNombre.sendKeys("Usuario 1");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al obtener el elemento web" + locatorNombre.toString());
        }

        By locatorDay = null;
        WebElement txtDay = null;
        try {
            locatorDay = By.xpath("//input[@id = 'day']");
            txtDay = wait.until(ExpectedConditions.presenceOfElementLocated(locatorDay)); //crea elemento con espera
            txtDay.sendKeys("19");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al obtener el elemento web" + locatorDay.toString());
        }

        By locatorMonth = null;
        WebElement ddlMonth = null;
        try {
            locatorMonth = By.xpath("//select [@id = 'month']");
            ddlMonth = wait.until(ExpectedConditions.presenceOfElementLocated(locatorMonth)); //crea elemento con espera
            Select selectorMonth = new Select(ddlMonth);

            selectorMonth.selectByIndex(04);
        } catch (Exception e) {
            System.out.println("Ocurrio un error al obtener el elemento web" + locatorMonth.toString());
        }

        By locatorYear = null;
        WebElement txtYear = null;
        try {
            locatorYear = By.xpath("//input [@id = 'year']");
            txtYear = wait.until(ExpectedConditions.presenceOfElementLocated(locatorYear)); //crea elemento con espera
            txtYear.sendKeys("2023");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al obtener el elemento web" + locatorYear.toString());
        }

        List<WebElement> generos = null;
        By locatorGeneros = null;
        try {
            locatorGeneros = By.xpath("//label[contains(@for, 'gender')]");
            generos = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorGeneros)); //crea elemento con espera
            generos.get(0).click();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al obtener el elemento web" + locatorGeneros.toString());
        }

        List<WebElement> checks = null;
        By locatorChecks = null;
        try {
            locatorChecks = By.xpath("//label[contains(@for, 'checkbox')]");
            checks = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorChecks)); //crea elemento con espera

            if (checks.size() == 2) {
                checks.get(0).click();
                checks.get(1).click();
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al obtener el elemento web" + locatorGeneros.toString());
        }

        By locatorBtnConfirmarRegistro = null;
        WebElement buttonConfirmarRegistro = null;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            locatorBtnConfirmarRegistro = By.xpath("//span[contains(text(),'Regístrate')]");
            buttonConfirmarRegistro = wait.until(ExpectedConditions.presenceOfElementLocated(locatorBtnConfirmarRegistro)); //crea elemento con espera

            js.executeScript("arguments[0].scrollIntoView(true);", buttonConfirmarRegistro);
            buttonConfirmarRegistro.click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocurrio un error al obtener el elemento web" + locatorBtnConfirmarRegistro.toString());
        }
    }

        /*

        By locatorButtonRegistrar = By.xpath("//button[contains(text(), 'Regis')]");
        WebElement buttonRegistrar = driver.findElement(locatorButtonRegistrar);
        buttonRegistrar.click();

        WebElement campoCorreo = driver.findElement(By.xpath("//input[@id = 'email']"));
        campoCorreo.sendKeys("vanesaflorenciabazan@gmail.com");

        WebElement campoConfirmaCorreo = driver.findElement(By.xpath("//input[@id = 'confirm']"));
        campoConfirmaCorreo.sendKeys("vanesaflorenciabazan@gmail.com");

        WebElement campoPass = driver.findElement(By.xpath("//input[@name = 'password']"));
        campoPass.sendKeys("1234567890");

        WebElement campoNombre = driver.findElement(By.xpath(" //input[@id = 'displayname']"));
        campoNombre.sendKeys("Florencia");

        WebElement campoDay = driver.findElement(By.xpath("//input[@id = 'day']"));
        campoDay.sendKeys("10");

        WebElement campoMonth= driver.findElement(By.xpath("//select [@id = 'month']"));
        campoMonth.sendKeys("Abril");

        WebElement campoYear= driver.findElement(By.xpath("//input [@id = 'year']"));
        campoYear.sendKeys("1993");
*/

        @AfterEach
        void posTests () {
            driver.close();
        }
    }



