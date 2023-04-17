package gnieto;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

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
    void teardown() throws InterruptedException {
        driver.quit();
    }

    @Test
    void test() throws InterruptedException {
        // Exercise
        driver.get("https://www.google.com/");

        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println(title);

        WebElement barraDeGoogle = driver.findElement(By.xpath("//*[@id=\'APjFqb\']"));
        barraDeGoogle.sendKeys("tsoft");

        barraDeGoogle.submit();
        WebElement tsoftPagina = driver.findElement(By.xpath("//*[@id=\'rso\']/div[1]/div/div/div/div/div/div/div/div[1]/a/h3"));

        tsoftPagina.click();

        // Verify
        // assertThat(title).contains("Selenium WebDriver");
    }
}
