package csalgan;


//import static org.assertj.core.api.Assertions.assertThat;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
    //equipo Lourdes del mar Lede/Rocio Magnarelli/Claudia Salgán
    @Test
    void test() {
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("APjFqb")).sendKeys("TSOFT" + Keys.ENTER);
        //driver.findElement(By.id("APjFqb")).sendKeys("TSOFT");
        //driver.findElement(By.className("gNO89b")).submit();
        driver.findElement(By.partialLinkText("HOME - TSOFT - Make IT Real")).click();
        String expectedTitle = "HOME - TSOFT - Make IT Real";
        assertEquals(expectedTitle, driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Verify
        //assertThat(title).contains("Selenium WebDriver");
    }

}
