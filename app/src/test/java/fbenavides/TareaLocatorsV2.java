package fbenavides;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class TareaLocatorsV2 {
    // Se crean variables para el driver, el wait y el tiempo limite de espera
    WebDriver driver;
    WebDriverWait wait;
    static final int TIMEOUT_SECONDS = 10;

    @FindBy(xpath = "//button[contains(text(),'Registra')]")
    WebElement btnEntrarARegistro;

    @FindBy(xpath = "//*[@id='email']")
    WebElement inputCorreo;

    @FindBy(xpath = "//input[@id='confirm']")
    WebElement inputConfirma;

    @FindBy(xpath = "//*[@id='password']")
    WebElement inputClave;

    @FindBy(xpath = "//*[@id='displayname']")
    WebElement inputNombre;

    @FindBy(xpath = "//*[@id='day']")
    WebElement inputDiaNacimiento;

    @FindBy(xpath = "//*[@id='month']")
    WebElement seleccionarMesNacimiento;

    @FindBy(xpath = "//*[@id='year']")
    WebElement inputAnioNacimiento;

    @FindBy(xpath = "//span[contains(text(),'Otro')]")
    WebElement inputGenero;

    @FindBy(xpath = "//button[contains(@type,'subm')]")
    WebElement btnRegistrase;


    @FindBy(xpath = "//*[contains(text(),'Este correo electrónico no es válido.')]")
    WebElement errorCorreoInvalido; // Se define la variable para el mensaje de error "Correo electrónico no válido"


    @BeforeAll
    static void preparacionClase() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void preTests() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://open.spotify.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, TIMEOUT_SECONDS);
    }

    @Test
    void testRegistrar() {
        btnEntrarARegistro.click();
        wait.until(ExpectedConditions.visibilityOf(inputCorreo)); // Se espera a que el input para correo sea visible

        //Se crea la variable email donde se almacena un mail que ya esta en el registro de spotify para probar
        String email = "pruebaSpotifyBootcamp12cl@yopmail.net";
        while (true) {
            inputCorreo.sendKeys(email); //En caso de que no existiera, se escribiria en el input de correo

            // Si se muestra el mensaje de error, se borra el contenido que este escrito y se prueba con otro correo
            if (errorCorreoInvalido.isDisplayed()) {
                inputCorreo.clear();
                email = "pruebaSpotifyBootcamp2023ts@yopmail.net";
            } else {
                break; //Si no hay error se sale
            }
        }
        inputConfirma.sendKeys(email); //Se re-utiliza la variabnle email
        //De aqui en adelante, se agregan todos los demas datos que funcionan bien :(
        inputClave.sendKeys("Estaesmiclave1");
        inputNombre.sendKeys("Fran Benavides");
        inputDiaNacimiento.sendKeys("08");
        seleccionarMesNacimiento.sendKeys("Enero");
        inputAnioNacimiento.sendKeys("1993");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", inputGenero); // Scrollea a la opcion de "genero"
        inputGenero.click();
        driver.manage().timeouts().implicitlyWait(TIMEOUT_SECONDS, TimeUnit.SECONDS);
        //btnRegistrase.click();
    }
    @AfterEach
    void teardown() throws InterruptedException {
        // driver.quit();
    }
}
