package rmagnarelli;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


    class MeLiTest {

        WebDriver driver;

        @FindBy(xpath = "//html/body/div[2]/div[1]/div[2]/button[1]")
        WebElement entendidocookies;
        @FindBy(xpath = "//*[@id=\'cb1-edit\']")
        WebElement buscar;
        @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div/div[2]/button[2]/span")
        WebElement mastarde;
        @FindBy(xpath = "//*[@id='root-app']/div/div[2]/section/ol/li[1]/div/div/div[1]/a")
        WebElement seleccionelemento;
        @FindBy(xpath = "//*[@id='main_actions']/form/div/button/span")
        WebElement comprar;
        //@FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/button[1]")
        //WebElement btncookies;
        //@FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div/div/div[2]/button[2]")
        //WebElement btnmastarde;
        //@FindBy(xpath = "//*[@id=\'variations\']/div/div[1]/div/div/p")
        //WebElement texto;
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

// Ejercicio

            entendidocookies.click();
            buscar.sendKeys("trapecio de circo");
            buscar.submit();
            mastarde.click();
            seleccionelemento.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",comprar );
            comprar.click();



        }
    }


