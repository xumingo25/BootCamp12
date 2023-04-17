package bpino;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TareaLocatorsSpotify {
    WebDriver driver;
    @FindBy(xpath = "//button[contains(text(),'Registrarte')]")
    WebElement btnRegistrase;
    @FindBy(xpath = "//*[@id=\'email\']")
    WebElement correo;
    @FindBy(xpath = "//*[@id=\'confirm\']")
    WebElement correoConfirmar;
    @FindBy(xpath = "//*[@id=\'password\']")
    WebElement contrasena;
    @FindBy(xpath = "//*[@id='displayname']")
    WebElement nombre;
    @FindBy(xpath = "//*[@id=\'day\']")
    WebElement dia;
    @FindBy(xpath = "//*[@id=\'month\']")
    WebElement mes;
    @FindBy(xpath = "//*[@id=\'year\']")
    WebElement anio;
    @FindBy(xpath = "//span[contains(text(),'Otro')]")
    WebElement genero;
    @FindBy(xpath = "//*[@id=\'__next\']/main/div/div/form/div[8]/div/button/span[1]")
    WebElement ingresar;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://open.spotify.com/");
        driver.manage().window().maximize();
    }


    @AfterEach
    void teardown() throws InterruptedException {
        //driver.close();
    }

    @Test
    void test() throws InterruptedException {


        btnRegistrase.click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        correo.sendKeys("pajaritos123@pio.com");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        boolean exists = driver.findElements(By.xpath("//*[@id=\'confirm\']")).size() != 0;

        if (exists) {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            correoConfirmar.sendKeys("pajaritos123@pio.com");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        }

        contrasena.sendKeys("PajaritoConChaleco12");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        nombre.sendKeys("Piopio");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        dia.sendKeys("22");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        mes.sendKeys("Agosto");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        anio.sendKeys("1993");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", genero);


        genero.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        ingresar.submit();
        //obtener boton
        /*
        String title = driver.get;
        System.out.println("Titulo de pagina: "+title);
        String titulo = "HOME - TSOFT - Make IT Real";
        assertEquals(titulo, driver.getTitle());*/

    }
}
