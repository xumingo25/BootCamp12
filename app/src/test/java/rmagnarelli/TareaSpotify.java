package rmagnarelli;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class TareaSpotify {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Registra')]")
    WebElement btnRegistrase;
    @FindBy(xpath = "//*[@id=\'email\']")
    WebElement correo;

    @FindBy(xpath = "//*[@id=\'confirm\']")
    WebElement confirmarcorreo;

    @FindBy(xpath = "//*[@id=\'password\']")
    WebElement contrasenia;

    @FindBy(xpath = "//*[@id=\'displayname\']")
    WebElement nombre;

    @FindBy(xpath = "//*[@id=\'day\']")
    WebElement dia;

    @FindBy (xpath = "//*[@id=\'month\']")
    WebElement Mes;

    @FindBy(xpath = "//*[@id=\'year\']")
    WebElement anio;

    @FindBy(xpath = "//span[contains(text(),'Mujer')]")
    WebElement sexOption;

    @FindBy(xpath = "//span[contains(text(),'No quiero')]")
    WebElement publicityOption;

    @FindBy(xpath = "//*[@id=\'__next\']/main/div/div/form/div[7]/div/label/span[1]")
    WebElement infoShare;

    @FindBy(xpath = "//*[@id=\'__next\']/main/div/div/form/div[8]/div/button/span[1]")
    WebElement registerButton;




    @BeforeAll
    static void preparacionClase(){ WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void preTests(){
        driver = new ChromeDriver();
        PageFactory.initElements(driver,this);
        driver.get("https://open.spotify.com/");
        driver.manage().window().maximize();
    }

    @Test
    void testEjemploSpotify() throws InterruptedException {
        btnRegistrase.click();

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        correo.click();
        correo.sendKeys("callefalsaromag@gmail.com");


        if(driver.findElement(By.xpath("//*[@id=\'confirm\']")).isDisplayed()){
            confirmarcorreo.sendKeys("callefalsaromag@gmail.com");
        }




        contrasenia.sendKeys("callefalsa123");

        nombre.sendKeys("Ro");

        dia.sendKeys("11");

        Mes.sendKeys("febrero");

        anio.sendKeys("2003");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", sexOption);
        sexOption.click();
        publicityOption.click();
        infoShare.click();
        registerButton.click();


    }

    @AfterEach
    void posTests(){
        //driver.close();
    }
}