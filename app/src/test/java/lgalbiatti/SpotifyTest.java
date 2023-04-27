package lgalbiatti;
import io.github.bonigarcia.wdm.WebDriverManager;
import lgalbiatti.pages.HomeSpotify;
import lgalbiatti.pages.RegisterSpotifypage;
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
    HomeSpotify homeSpotify;
    RegisterSpotifypage registerSpotifypage;
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

        homeSpotify= new HomeSpotify(driver);
        registerSpotifypage = new RegisterSpotifypage(driver);

        homeSpotify.btnRegistrarse();
        registerSpotifypage.registro();






// Verify
// assertThat(title).contains("Selenium WebDriver");
    }
}
