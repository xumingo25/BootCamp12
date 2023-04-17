package dpites;

//import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

     void teardown() {driver.quit();}


lñ<<<<<<< HEAD


=======
>>>>>>> 5e32b7e44e30e37c0446ea0fa56bf10484d10b3b
    @Test
    void test() {
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        System.out.println("Titulo de la pagina: "+title);

        driver.navigate().to("https://www.youtube.com/");
        title = driver.getTitle();
        System.out.println("Titulo de la pagina: "+title);
        // Verify
        //assertThat(title).contains("Selenium WebDriver");
    }
    
    @Test
    void testTareaGoogle(){
    driver.navigate().to("https://www.google.com") ;
        driver.manage().window().maximize();
        driver.findElement(By.id("APjFqb")).sendKeys("tsoft",(Keys.ENTER));
        driver.findElement(By.className("byrV5b")).click();
        String title = driver.getTitle();
        System.out.println("Titulo de la pagina: "+title);

        //driver.manage().window().setSize(new Dimension(1920, 1080));
        //driver.manage().window().fullscreen();
   }



}

