package fbenavides.MisPrimerosTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

class EdgeTest {

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new EdgeDriver();
    }

    @AfterEach
    void teardown() {
       //driver.quit();
    }

    @Test
    void test() {

        /* driver.get("https://www.bing.com/");
        String title = driver.getTitle();
        System.out.println("Titulo pagina de Bing: " + title);

        driver.navigate().to(" https://www.google.cl");
        title = driver.getTitle();
        System.out.println("Titulo pagina del Gugul: " + title); */

        driver.navigate().to("https://www.google.com") ;
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1920, 1080));
        //driver.manage().window().fullscreen();

        driver.findElement(By.id("APjFqb")).sendKeys("tsoft",(Keys.ENTER));
        driver.findElement(By.className("byrV5b")).click();
        String title = driver.getTitle();
        System.out.println("Titulo de la pagina: "+title);

        // Verify
        // assertThat(title).contains("Selenium WebDriver");
    }

}
