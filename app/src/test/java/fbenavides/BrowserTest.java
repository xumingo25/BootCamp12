package fbenavides;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

class EdgeTest {

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
        driver.get("https://www.bing.com/");
        String title = driver.getTitle();
        System.out.println("Titulo pagina de Bing: " + title);

        driver.navigate().to(" https://www.google.cl");
        title = driver.getTitle();
        System.out.println("Titulo pagina del Gugul: " + title);


        // Verify
        // assertThat(title).contains("Selenium WebDriver");
    }

}
