package csalgan;


//import static org.assertj.core.api.Assertions.assertThat;


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
        //driver = new ChromeDriver();
        driver = new EdgeDriver();
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
        //System.out.println("ejecutando el driver de google devuelve el titulo: " + title);
        System.out.println("ejecutando el driver de google devuelve el titulo: " + title);
        driver.navigate().to("https://github.com/xumingo25?tab=repositories");
        String titleRedirect = driver.getCurrentUrl();
        System.out.println("probando metodo navigate y getCurrentUrl  me devuelve lo siguiente: " + titleRedirect);


        // Verify
        //assertThat(title).contains("Selenium WebDriver");
    }

}
