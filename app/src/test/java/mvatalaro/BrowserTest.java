package mvatalaro;


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
import org.openqa.selenium.support.ui.WebDriverWait;


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
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement b = driver.findElement(By.name("q"));
        b.sendKeys("Tsoft");
        b.sendKeys(Keys.ENTER);
        WebElement t = driver.findElement(By.partialLinkText("HOME - TSOFT"));
        t.click();
        String title = driver.getTitle();
        System.out.println("Titulo de pagina: "+title);
       //  Verify
        //assertThat(title).contains("Selenium WebDriver");
    }

}