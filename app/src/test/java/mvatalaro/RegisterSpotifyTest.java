package mvatalaro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

        inputEmail.getText();

        inputConfirmEmail.getText();

        inputPassword.sendKeys();

        inputUserName.getText();

        inputDiaNacimiento.getText();

        inputMesNacimiento.isDisplayed();

        inputAnioNacimiento.getText();

        selectorHombre.isSelected();

        selectorMujer.isSelected();

        selectorNobinario.isSelected();

        selectorOtro.isSelected();

        selectorNoresponder.isSelected();

        tildeNotificacion.isEnabled();

        tildeCompartirDatos.isEnabled();

        btnRegistrate.submit();





    }

    @AfterEach
    void posTests(){
        //driver.close();
    }





}
