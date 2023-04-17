package fbenavides;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static java.util.concurrent.TimeUnit.SECONDS;


public class TareaLocators {
    WebDriver driver;

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
    WebElement inputAlien;
    @FindBy(xpath = "//button[contains(@type,'subm')]")
    WebElement btnRegistrase;
    int tiempoEspera = 8;

    @BeforeAll
    static void preparacionClase(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void preTests(){
        driver = new ChromeDriver();
        PageFactory.initElements(driver,this);
        driver.get("https://www.spotify.com/");
        driver.manage().window().maximize();
    }

    @Test
    void testRegistrar() throws InterruptedException{

        btnEntrarARegistro.click(); driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
        inputCorreo.sendKeys("pruebaSpotifyBootcamp12cl@yopmail.net"); driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
        boolean existeError = driver.findElements(By.xpath("//*[contains(text(),'Este correo electrónico ya está conectado a una cuenta.')]")).size() != 0;
        if (!existeError) {
            driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
            inputCorreo.sendKeys("pruebaSpotifyBootcamp2023@yopmail.net"); driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
            inputConfirma.sendKeys("pruebaSpotifyBootcamp2023@yopmail.net"); driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS); }
        inputConfirma.sendKeys("pruebaSpotifyBootcamp12cl@yopmail.net"); driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
        inputClave.sendKeys("Estaesmiclave1"); driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
        inputNombre.sendKeys("Fran Benavides"); driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
        inputDiaNacimiento.sendKeys("08"); driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
        seleccionarMesNacimiento.sendKeys("Enero"); driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
        inputAnioNacimiento.sendKeys("1993"); driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", inputAlien);
        inputAlien.click(); driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
        //btnRegistrase.click();

    }

    @AfterEach
    void teardown() throws InterruptedException {
        // driver.quit();
    }
}