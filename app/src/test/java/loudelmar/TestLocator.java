package loudelmar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLocator {
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
    void test() {
        driver.get("https://open.spotify.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@class='Button-sc-1dqy6lx-0 jjtmnk sibxBMlr_oxWTfBrEz2G'")).click();




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
