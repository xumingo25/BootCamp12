package lgalbiatti;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


class SpotifyTest {

    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Registra')]")
    WebElement btnRegistrase;
    @FindBy(xpath = "//*[@id=\'email\']")
    WebElement correo;
    @FindBy(xpath = "//*[@id=\'confirm\']")
    WebElement confirmarcorreo;
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
    @FindBy(xpath = "//span[contains(text(),'Prefiero no responder')]")
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
       // driver.quit();
    }

    @Test
    void test() throws InterruptedException {
// Exercise





        btnRegistrase.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        correo.sendKeys("lunalola@larioja.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        boolean exists = driver.findElements( By.xpath("//*[@id=\'confirm\']") ).size() != 0;

        if(exists){
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            confirmarcorreo.sendKeys("lunalola@larioja.com");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

        contrasena.sendKeys("AbCdafef1323");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        nombre.sendKeys("Lucia");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        dia.sendKeys("04");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mes.sendKeys("Noviembre");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        anio.sendKeys("2000");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", genero);


        genero.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       ingresar.submit();


// Verify
// assertThat(title).contains("Selenium WebDriver");
    }
}
