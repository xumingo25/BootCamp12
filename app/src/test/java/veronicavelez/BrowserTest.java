package veronicavelez;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class ChromeTest {

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void test() {
        // Exercise
        driver.get("https://www.google.com");
        String title = driver.getTitle();

        System.out.println("Titulo de pagina de google: "+ title);

        driver.navigate().to("https://www.spotify.com");

        title = driver.getTitle();

        System.out.println("Titulo de pagina de spotify: "+ title);

        // Verify
        //assertThat(title).contains("Selenium WebDriver");
    }

}
