package lgalbiatti;
import dsaavedra.pom.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import lgalbiatti.pages.Homepage;
import lgalbiatti.pages.Productpage;
import lgalbiatti.pages.Searchpage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


class MercadoLibreTest  {

    WebDriver driver;
    Homepage homepage;
    Searchpage searchpage;
    Productpage productpage;
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
        homepage = new Homepage(driver);
        searchpage = new Searchpage(driver);
        productpage = new Productpage(driver);

       homepage.buscarProducto();
      searchpage.producto();
      productpage.btncookies();
      productpage.comprar();



// Verify
// assertThat(title).contains("Selenium WebDriver");
    }
}


