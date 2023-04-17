package loudelmar;

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
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrowserTest {

    WebDriver driver;
    WebElement element;



    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.edgedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        //driver = new EdgeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void test() {
        // Exercise

        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("APjFqb")).sendKeys("TSOFT" + Keys.ENTER);
        //driver.findElement(By.id("APjFqb")).sendKeys("TSOFT");
        //driver.findElement(By.className("gNO89b")).submit();
        driver.findElement(By.partialLinkText("HOME - TSOFT - Make IT Real")).click();
        String expectedTitle = "HOME - TSOFT - Make IT Real";
        assertEquals(expectedTitle, driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //System.out.println(title);

        //driver.findElement(By.id("id_of_previous_input_field")).sendKeys(Keys.TAB,"This text will appear in textarea");

        // Verify
        //assertThat(title).contains("Selenium WebDriver");
    }

}