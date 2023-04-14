package rmagnarelli;


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

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrowserTest {

        WebDriver driver;
        WebElement element;

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
            // Ejercicio
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

