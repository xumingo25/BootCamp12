package fbazan;


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

        System.out.println("Titulo de pagina de google: "+ title);

        driver.navigate().to("https://bonigarcia.dev/webdrivermanager/");
        title = driver.getTitle();

        System.out.println("Titulo de pagina de webDriverManager: "+ title);

        // Verify
        //assertThat(title).contains("Selenium WebDriver");
    }

}
