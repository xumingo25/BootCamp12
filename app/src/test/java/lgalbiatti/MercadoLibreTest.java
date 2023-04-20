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


class MercadoLibreTest {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='cb1-edit']")
    WebElement barradebusqueda;
    @FindBy(xpath = "//h2[contains(text(),'Bicicleta Mountain Mtb Firebird Rodado 29 21v Envi')]")
    WebElement producto;
    @FindBy(xpath = "//*[@id=\'variations\']/div/div[1]/div/a[2]/div")
    WebElement tamanodecuadro;
    @FindBy(xpath = "//*[@id=\'variations\']/div/div[2]/div/a[2]/div/img")
    WebElement color;
    @FindBy(xpath = "//body/main[@id='root-app']/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[9]/form[1]/div[1]/button[1]")
    WebElement comprar;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/button[1]")
    WebElement btncookies;
    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div/div/div[2]/button[2]")
    WebElement btnmastarde;
    @FindBy(xpath = "//*[@id=\'variations\']/div/div[1]/div/div/p")
    WebElement texto;
    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://www.mercadolibre.com.ar/");
        driver.manage().window().maximize();
    }


    @AfterEach
    void teardown() throws InterruptedException {
        // driver.quit();
    }

    @Test
    void test() throws InterruptedException {
// Exercise

        barradebusqueda.sendKeys("Bicicletas");
        barradebusqueda.submit();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", producto);


        producto.click();
        btncookies.click();
        btnmastarde.click();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", texto);
        tamanodecuadro.click();

        color.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        comprar.click();

// Verify
// assertThat(title).contains("Selenium WebDriver");
    }
}


