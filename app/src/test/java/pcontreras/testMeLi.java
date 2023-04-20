package pcontreras;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class testMeLi {

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void teardown() {
        //driver.quit();
    }

    @Test
    void testAbrirPag() {
        driver.navigate().to("https://www.mercadolibre.cl/");

        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"nav-search-input\"]"));
            searchBar.sendKeys("puur");

        // Verify
        //assertThat(title).contains("Selenium WebDriver");
    }

}