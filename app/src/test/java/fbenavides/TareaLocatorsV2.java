package fbenavides;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TareaLocatorsV2 {
    WebDriver driver; //Creación de atributo WebDriver
    WebDriverWait wait;
    JavascriptExecutor js;

    @FindBy(xpath = "//button[contains(text(),'Registra')]")
    WebElement btnEntrarARegistro;
    By locatorTxtCorreo = By.xpath("//input[@id='email']");
    By locatorConfirmarCorreo = By.xpath("//input[@name='confirm']");
    By locatorPassword = By.xpath("//input[@type=\"password\"]");
    By locatorNombrePerfil = By.xpath("//input[@id='displayname']");
    By locatorDia = By.xpath("//input[@name='day']");
    By locatorMes = By.xpath("//select");
    By locatorAnnio = By.xpath("//input[@name='year']");
    By locatorGeneros = By.xpath("//label[contains(@for,'gender')]");
    By locatorChecks = By.xpath("//label[contains(@for,'checkbox')]");
    By locatorBtnConfirmar = By.xpath("//button[@type=\"submit\"]");


    @BeforeAll
    static void preparacionClase() {
        System.setProperty("file.encoding", "UTF-8");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void preTests() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://open.spotify.com/");
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    void CP001_CreacionCtaSpotify_NOOK_CorreoYaIngresado() throws InterruptedException {

        btnEntrarARegistro.click();

        WebElement txtCorreo = wait.until(ExpectedConditions.presenceOfElementLocated(locatorTxtCorreo));
        String correo = "pruebaSpotifyBootcamp12cl@yopmail.net";
        txtCorreo.sendKeys(correo);

        WebElement txtConfirmarCorreo = null;
        try {
            txtConfirmarCorreo = driver.findElement(locatorConfirmarCorreo);
            txtConfirmarCorreo.sendKeys(correo);
        } catch (Exception e) {
            System.out.println("ocurrio un error al obtener el elemento web con el locator " + locatorConfirmarCorreo.toString());
        }

        String contrasena = "Estaesmiclaveasies1";
        WebElement txtPassword = null;
        try {
            txtPassword = driver.findElement(locatorPassword);
            txtPassword.sendKeys(contrasena);
        } catch (Exception e) {
            System.out.println("ocurrio un error al obtener el elemento web con el locator " + locatorPassword.toString());
        }

        String nombrePerfil = "Mi nombre";
        WebElement txtNombrePerfil = null;
        try {
            txtNombrePerfil = wait.until(ExpectedConditions.presenceOfElementLocated(locatorNombrePerfil));
            txtNombrePerfil.sendKeys(nombrePerfil);
        } catch (Exception e) {
            System.out.println("ocurrio un error al obtener el elemento web con el locator " + locatorNombrePerfil.toString());
        }

        String dia = "08";
        WebElement txtDia = null;
        try {
            txtDia = wait.until(ExpectedConditions.presenceOfElementLocated(locatorDia));
            txtDia.sendKeys(dia);
        } catch (Exception e) {
            System.out.println("ocurrio un error al obtener el elemento web con el locator " + locatorDia.toString());
        }

        String mes = "01";
        WebElement ddlMes = null;
        try {
            ddlMes = wait.until(ExpectedConditions.presenceOfElementLocated(locatorMes));
            Select selectorMes = new Select(ddlMes);
            selectorMes.selectByValue(mes);
        } catch (Exception e) {
            System.out.println("ocurrio un error al obtener el elemento web con el locator " + locatorMes.toString());
        }

        String annio = "1993";
        WebElement txtAnnio = null;
        try {
            txtAnnio = wait.until(ExpectedConditions.presenceOfElementLocated(locatorAnnio));
            txtAnnio.sendKeys(annio);
        } catch (Exception e) {
            System.out.println("ocurrio un error al obtener el elemento web con el locator " + locatorAnnio.toString());
        }

        List<WebElement> generos = null;
        try {
            generos = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorGeneros));

            //Scroll a los generos
            js.executeScript("arguments[0].scrollIntoView(true);", generos.get(0));

            generos.get(0).click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ocurrio un error al obtener el elemento web con el locator " + locatorGeneros.toString());
        }

        List<WebElement> checks = null;
        try {
            checks = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorChecks));

            if (checks.size() == 2) {
                checks.get(0).click();
                checks.get(1).click();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ocurrio un error al obtener el elemento web con el locator " + locatorGeneros.toString());
        }


        WebElement btnConfirmar = null;

        try {
            btnConfirmar = wait.until(ExpectedConditions.presenceOfElementLocated(locatorBtnConfirmar));
            //Scroll
            js.executeScript("arguments[0].scrollIntoView(true);", btnConfirmar);

            //con wait
            btnConfirmar.click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ocurrio un error al obtener el elemento web con el locator " + locatorBtnConfirmar.toString());
        }

        String resultadoEsperado = "Este correo electr\u00f3nico ya est\u00e1 conectado a una cuenta. Inicia sesi\u00f3n.";

        String resultadoActual = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Este correo electr\u00f3nico ya est\u00e1 conectado a una cuenta. Inicia sesi\u00f3n.')]"))).getText();

        Assertions.assertEquals(resultadoEsperado, resultadoActual);


    }


    @AfterEach
    void teardown() throws InterruptedException {
        // driver.quit();
    }
}
