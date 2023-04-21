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

        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"cb1-edit\"]"));
            searchBar.sendKeys("puur bottle denda");

        WebElement btnSubmit = driver.findElement(By.xpath("//header/div[1]/div[2]/form[1]/button[1]"));
            btnSubmit.submit();

        WebElement btnProducto1 = driver.findElement(By.xpath("//h2[contains(text(),'Puur Bottle Blossom Blue 500ml - Puur')]"));
            btnProducto1.submit();
        // Verify
        //assertThat(title).contains("Selenium WebDriver");
    }

}