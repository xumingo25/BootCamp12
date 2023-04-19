package rquezada.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MercadoLibre {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @FindBy(xpath = "//button[@class='nav-search-btn']")  // []
    WebElement btnBuscar;

    @BeforeAll
    static void setupClass() {
        System.setProperty("file.encoding","UTF-8");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        js = (JavascriptExecutor) driver;

        PageFactory.initElements(driver, this);
        driver.get("https://www.mercadolibre.cl/");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    void CP001_MercadoLibre_BuscarProducto() throws InterruptedException{
        By locatorTxtBuscador = By.xpath("//input[@id='cb1-edit']");
        WebElement txtBuscador = wait.until(ExpectedConditions.presenceOfElementLocated(locatorTxtBuscador));

        txtBuscador.sendKeys("Pokemon arceus nintendo switch");

        btnBuscar.click();

        By locatorClickearProducto = null;
        WebElement txtClickearProducto = null;
        try {
            locatorClickearProducto = By.xpath("//h2[@class='ui-search-item__title shops__item-title']");
            txtClickearProducto = driver.findElement(locatorClickearProducto);
            txtClickearProducto.click();
        }catch (Exception e){
            System.out.println("Ocurrio un error al obtener el elemento web con el locator "+ locatorClickearProducto.toString());
        }

        By locatorBotonComprar = null;
        WebElement txtBotonComprar = null;
        try {
            locatorBotonComprar = By.xpath("//button[@class='andes-button andes-spinner__icon-base andes-button--loud']");
            txtBotonComprar = driver.findElement(locatorBotonComprar);
            txtBotonComprar.click();
        }catch (Exception e){
            System.out.println("Ocurrio un error al obtener el elemento web con el locator "+ locatorBotonComprar);
        }
    }

    @AfterEach
    void posTests(){
        driver.close();
    }
}