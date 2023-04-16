package gnieto;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
            driver.quit();
        }

        @Test
        void test() {
            // Exercise
            driver.get("https://www.google.com/");
            String title = driver.getTitle();
            System.out.println(title);

            // Verify
            // assertThat(title).contains("Selenium WebDriver");
        }

    }



