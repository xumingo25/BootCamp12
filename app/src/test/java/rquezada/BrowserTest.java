package rquezada;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

class ChromeTest {

    WebDriver driver;

    @BeforeAll
    static void setupClass() {

        //WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeEach
    void setupTest() {

        driver = new EdgeDriver();
    }

    @AfterEach
    void teardown() {

        driver.quit();
    }

    @Test
    void test() {
        // Exercise
        driver.get("https://www.google.com/");
        String title = driver.getTitle();

        System.out.println("Titulo página de Google: "+title);

        driver.navigate().to("https://www.spotify.com/");
        title = driver.getTitle();

        System.out.println("Titulo página de Spotify: "+title);

        // Verify
        //assertThat(title).contains("Selenium WebDriver");
    }

}