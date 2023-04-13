package rmagnarelli;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

     class BrowserTest {

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
            driver.get("https://www.youtube.com/");
            String title = driver.getTitle();
            System.out.println("el titulo de la pagina es "+title);
            // Verify
            //assertThat(title).contains("Selenium WebDriver");
        }

    }

