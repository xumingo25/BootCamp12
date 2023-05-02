package abracamonte;

//import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        System.out.println("Este es el titulo de la pagina: " + title);

        driver.navigate().to("https://bonigarcia.dev/webdrivermanager/");
        title = driver.getTitle();
        System.out.println("Este es el titulo de la pagina: " + title);




        // Verify
        //assertThat(title).contains("Selenium WebDriver");
    }

}
