package abracamonte;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TareaLocators {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(), 'Registra')]")
    WebElement btnRegistrarse;

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
        PageFactory.initElements(driver, this);
        driver.get("https://www.spotify.com");
        String title = driver.getTitle();
        System.out.println("Este es el titulo de la pagina: " + title);

        driver.manage().window().maximize();

        btnRegistrarse.click();

        // Esperar a que se cargue la página de resultados
        try {
            Thread.sleep(5000); // Esperar 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        title = driver.getTitle();
        System.out.println("Titulo de pagina: "+ title);



    }
}
