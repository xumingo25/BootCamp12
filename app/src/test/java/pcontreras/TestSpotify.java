package pcontreras;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class TareaLocators {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Registra')]")
    WebElement btnRegistrase;

    @BeforeAll
    static void preparacionClase(){
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void preTests(){
        driver = new ChromeDriver();
        PageFactory.initElements(driver,this);
        driver.get("https://open.spotify.com/");

        //Maximizar page
        driver.manage().window().maximize();
    }

    @Test
    void testEjemploSpotify() throws InterruptedException {
        //Aqui crearemos el test
        btnRegistrase.click();
        Thread.sleep(5000);
        WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
            email.sendKeys("mailfalso@gfalso.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            password.sendKeys("ContraFalsa_1234");
        WebElement name = driver.findElement(By.xpath("//*[@id=\"displayname\"]"));
            name.sendKeys("Erbmon Oslaf");
        WebElement birthDate = driver.findElement(By.xpath("//*[@id=\"day\"]"));
            birthDate.sendKeys("17");
        WebElement birthYear = driver.findElement(By.xpath("//*[@id=\"year\"]"));
            birthYear.sendKeys("1994");
        WebElement birthMonth = driver.findElement(By.xpath("//*[@id=\"month\"]"));
            birthMonth.sendKeys("Febrero");
        //WebElement gender = driver.findElement(By.xpath("//*[@id=\"gender_option_female\"]")).sendKeys("Mujer");
        //WebElement optBox = driver.findElement(By.xpath("//*[@id=\"marketing_check_optbox\"]"));
        //    optBox.click();
    }

    @AfterEach
    void posTests(){
        //driver.close();
    }
}
