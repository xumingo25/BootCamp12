package pcontreras;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        //driver.quit();
    }

    @Test
    void testNavegador() {
        // Exercise
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String title = driver.getTitle();
        System.out.println("Titulo pagina : " + title);

        driver.navigate().to("https://github.com/palomaandrea");
        title = driver.getTitle();
        System.out.println("Titulo pagina : " + title);

        // Verify
        //assertThat(title).contains("Selenium WebDriver");
    }

    @Test
    void testIngreso(){
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("APjFqb")).sendKeys("Tsoft",(Keys.ENTER));
        driver.findElement(By.className("VuuXrf")).click();
        String title = driver.getTitle();
        System.out.println("Titulo pagina : " + title);
    }
}