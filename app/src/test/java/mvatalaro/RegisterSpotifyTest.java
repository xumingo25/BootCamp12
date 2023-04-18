package mvatalaro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class RegisterSpotifyTest {

    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Registra')]")
    WebElement btnRegistrarse;

    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement inputEmail;

    @FindBy(xpath = "//*[@id=\"confirm\"]")
    WebElement inputConfirmEmail;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement inputPassword;

    @FindBy(xpath = "//*[@id=\"displayname\"]")
    WebElement inputUserName;

    @FindBy(xpath = "//*[@id=\"day\"]")
    WebElement inputDiaNacimiento;

    @FindBy(xpath = "//*[@id=\"month\"]")
    WebElement inputMesNacimiento;

    @FindBy(xpath = "//*[@id=\"year\"]")
    WebElement inputAnioNacimiento;

    @FindBy(xpath = "//span[contains(text(),\"Hombre\")]")
    WebElement selectorHombre;

    @FindBy(xpath = "//span[contains(text(),\"Mujer\")]")
    WebElement selectorMujer;

    @FindBy(xpath = "//span[contains(text(),\"No binario\")]")
    WebElement selectorNobinario;

    @FindBy(xpath = "//span[contains(text(),\"Otro\")]")
    WebElement selectorOtro;

    @FindBy(xpath = "//span[contains(text(),\"Prefiero no responder\")]")
    WebElement selectorNoresponder;

    @FindBy(xpath = "//span[contains(text(),\"No quiero\")]")
    WebElement tildeNotificacion;

    @FindBy(xpath = "//span[contains(text(),\"Compartir\")]")
    WebElement tildeCompartirDatos;

    @FindBy(xpath = "//span[contains(text(),\"Regístrate\")]")
    WebElement btnRegistrate;



    @BeforeAll
    static void preparacionClase(){
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void preTests(){
        driver = new ChromeDriver();
        PageFactory.initElements(driver,this);
        driver.get("https://open.spotify.com/");

        //Maximizar page
        driver.manage().window().maximize();
    }

    @Test
    void testEjemploSpotify(){
        //Aqui crearemos el test
        btnRegistrarse.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        inputEmail.sendKeys("musicalizate_on@gmail.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        inputConfirmEmail.sendKeys("musicalizate_on@gmail.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        inputPassword.sendKeys("Musica2023");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        inputUserName.sendKeys("Eleven18");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        inputDiaNacimiento.sendKeys("18");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        inputMesNacimiento.sendKeys("Abril");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        inputAnioNacimiento.sendKeys("1999");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        selectorHombre.isSelected();

        selectorMujer.isSelected();

        selectorNobinario.isSelected();

        selectorOtro.isSelected();

        selectorNoresponder.isSelected();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        tildeNotificacion.isEnabled();

        tildeCompartirDatos.isEnabled();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        btnRegistrate.submit();





    }

    @AfterEach
    void posTests(){
        //driver.close();
    }





}
