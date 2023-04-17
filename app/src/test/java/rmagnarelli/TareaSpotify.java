package rmagnarelli;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
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
        correo.sendKeys("callefalsa12345@gmail.com");

        boolean exists = driver.findElements( By.xpath("//*[@id=\'confirm\']") ).size() != 0;
        if(exists){
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            confirmarcorreo.sendKeys("callefalsa12345@gmail.com");
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        }
        

        contrasenia.sendKeys("callefalsa123");

        nombre.sendKeys("Ro");

        dia.sendKeys("11");

        Mes.sendKeys("febrero");

        anio.sendKeys("2003");


    }

    @AfterEach
    void posTests(){
        //driver.close();
    }
}