package abracamonte;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class LocatorsTest {
    WebDriver driver;
    JavascriptExecutor js;

    WebDriverWait wait;

    @FindBy(xpath = "//button[contains(text(), 'Registra')]")
    WebElement btnRegistrarse;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void preTest() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, 10);

        PageFactory.initElements(driver, this);
        driver.get("https://www.spotify.com/cl");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    void test_CP001_LlenarFormulario_IngresoSpotify() {


        String title = driver.getTitle();

        System.out.println("Este es el titulo de la pagina: " + title);


        wait.until(ExpectedConditions.elementToBeClickable(btnRegistrarse));

        btnRegistrarse.click();



        WebElement inputEmail = driver.findElement(By.xpath("//input[contains(@placeholder, 'Pon tu correo electr')]"));
        inputEmail.sendKeys("elcorreo@email.com");


        boolean siAparece = driver.findElements(By.xpath("//input[contains(@placeholder, 'Vuelve a poner tu correo electr')]")).size() !=0;
        if (siAparece) {
            WebElement inputEmail2 = driver.findElement(By.xpath("//input[contains(@placeholder, 'Vuelve a poner tu correo electr')]"));
            inputEmail2.sendKeys("elcorreo@email.com");
        }

        WebElement creaPassword = driver.findElement(By.xpath("//input[contains(@placeholder, 'Crea una contrase')]"));
        creaPassword.sendKeys("Clave1234**");


        WebElement creaNombre = driver.findElement(By.xpath("//input[contains(@placeholder, 'Pon un nombre de perfil')]"));
        creaNombre.sendKeys("Mi nombre");


        WebElement diaNac = driver.findElement(By.xpath("//input[contains(@placeholder, 'DD')]"));
        diaNac.sendKeys("12");


        WebElement mesNac = driver.findElement(By.xpath("//select[contains(@name, 'month')]"));
        mesNac.sendKeys("Abril");


        WebElement yearNac = driver.findElement(By.xpath("//input[contains(@placeholder, 'AAAA')]"));
        yearNac.sendKeys("1994");


        WebElement female= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(@for, 'gender_option_female')]")));
        js.executeScript("arguments[0].scrollIntoView(true);", female);
        female.click();


        WebElement noMarket = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(@for, 'marketing-opt-checkbox')]")));
        noMarket.click();


        WebElement compartirDatos = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(@for, 'third-party-checkbox')]")));
        compartirDatos.click();

        title = driver.getTitle();
        System.out.println("Titulo de pagina: "+ title);


    }
    @AfterEach
    void afterTest() {
        driver.quit();
    }
}
