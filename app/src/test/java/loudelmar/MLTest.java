package loudelmar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.util.encoders.UTF8;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

class MLTest {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    @BeforeAll
    static void preparacion(){
        WebDriverManager.edgedriver().setup();
    }

    @BeforeEach
    void preTests(){
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver,7);
        js = (JavascriptExecutor) driver;

        PageFactory.initElements(driver,this);

        driver.get("https://www.mercadolibre.com.ar/");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(7, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);

    }

    @Test
    void test(){

        By locatorBuscador = null;
        WebElement buscador = null;

        locatorBuscador = By.xpath("//input[@name='as_word']");
        buscador = driver.findElement(locatorBuscador);
        buscador.sendKeys("camara sony a6400");

        By locatorLupa = null;
        WebElement lupa = null;

        locatorLupa = By.xpath("//div[@class='nav-icon-search']");
        lupa = driver.findElement(locatorLupa);
        lupa.click();

        //cerrar cartel de cod postal
        By locatorMasTarde = null;
        WebElement masTarde = null;

        locatorMasTarde = By.xpath("//button[@class='onboarding-cp-button andes-button andes-button--transparent andes-button--small']");
        masTarde = driver.findElement(locatorMasTarde);
        masTarde.click();

        //cerrar cartel cookies
        By locatorCookies = null;
        WebElement cookies = null;

        locatorCookies = By.xpath("/html/body/div[2]/div[1]/div[2]/button[1]");
        cookies = driver.findElement(locatorCookies);
        cookies.click();


        By locatorCamara = null;
        WebElement camara = null;

        locatorCamara = By.xpath("//a[.='Sony A6400 Alpha Camara Muy Cuidada']");
        camara = driver.findElement(locatorCamara);
        js.executeScript("arguments[0].scrollIntoView(true);", camara);
        camara.click();

        By locatorComprarAhora = null;
        WebElement comprarAhora = null;

        locatorComprarAhora = By.xpath("//*[@id=\"main_actions\"]/form/div/button[1]");
        comprarAhora = driver.findElement(locatorComprarAhora);
        js.executeScript("arguments[0].scrollIntoView(true);", comprarAhora);
        comprarAhora.click();

        String resultadoEsperado = "\u00A1Hola! Para comprar, ingres\u00E1 a tu cuenta";
        String resultadoActual = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root-app\"]/div/div[1]/div/div[2]/div[1]/h1"))).getText();

        Assertions.assertEquals(resultadoEsperado,resultadoActual);


    }

    @AfterEach
    void posTests() {
        //driver.close();
    }
}
