package fbenavides.MisPrimerosTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static java.util.concurrent.TimeUnit.SECONDS;


public class TareaLocators {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Registra')]")
    WebElement btnEntrarARegistro;
    @FindBy(xpath = "//*[@id='email']")
    WebElement inputCorreo;
    @FindBy(xpath = "//*[@id='confirm']")
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
    WebElement inputOtro;
    @FindBy(xpath = "//button[contains(@type,'subm')]")
    WebElement btnRegistrase;
    int tiempoEspera = 8;

    @BeforeAll
    static void preparacionClase(){
        WebDriverManager.edgedriver().setup();
    }

    @BeforeEach
    void preTests(){
        driver = new EdgeDriver();
        PageFactory.initElements(driver,this);
        driver.get("https://open.spotify.com/");
        driver.manage().window().maximize();
    }

    @Test
    void testRegistrar() {
        try {
            btnEntrarARegistro.click(); driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
            inputCorreo.sendKeys("pruebaBTautomatizacionTsoft1@yopmail.net"); driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
            boolean pideConfirmarMail = driver.findElements(By.xpath("//*[@id='confirm']")).size() !=0;
            if (pideConfirmarMail) {
                inputConfirma.sendKeys("pruebaBTautomatizacionTsoft1@yopmail.net"); driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
            }
            inputClave.sendKeys("Estaesmiclave1"); driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
            inputNombre.sendKeys("juanita"); driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
            inputDiaNacimiento.sendKeys("08"); driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
            seleccionarMesNacimiento.sendKeys("Enero");driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
            inputAnioNacimiento.sendKeys("1993");driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", inputOtro);
            inputOtro.click();driver.manage().timeouts().implicitlyWait(tiempoEspera, SECONDS);
            //btnRegistrase.click();

        } catch (Exception e) {
            System.out.println("Error en el test: " + e.getMessage());
        }
    }

    @AfterEach
    void teardown() throws InterruptedException {
        // driver.quit();
    }
}