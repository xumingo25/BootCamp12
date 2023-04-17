package bpino;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TareaLocatorsSpotify {
    WebDriver driver;
    @FindBy(xpath = "//button[contains(text(),'Registrarte')]")
    WebElement btnRegistrase;
    @FindBy(xpath = "//*[@id=\'email\']")
    WebElement correo;
    @FindBy(xpath = "//*[@id=\'confirm\']")
    WebElement correoConfirmar;
    @FindBy(xpath = "//*[@id=\'password\']")
    WebElement pass;
    @FindBy(xpath = "//*[@id='displayname']")
    WebElement nombre;
    @FindBy(xpath = "//*[@id=\'day\']")
    WebElement day;
    @FindBy(xpath = "//*[@id=\'month\']")
    WebElement month;
    @FindBy(xpath = "//*[@id=\'year\']")
    WebElement year;
    @FindBy(xpath = "//span[contains(text(),'Otro')]")
    WebElement other;
    @FindBy(xpath = "//label[contains(@for,'marketing-opt-checkbox')]")
    WebElement marketing;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;
    @FindBy(xpath = "//span[contains(text(),'Tu biblioteca')]")
    WebElement find;
    String biblioteca = "Tu biblioteca";


    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://www.spotify.com/");
        driver.manage().window().maximize();
    }


    @AfterEach
    void teardown() throws InterruptedException {
        //driver.close();
    }

    @Test
    void test() throws InterruptedException {
        btnRegistrase.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        correo.sendKeys("pajaritos.musicales@pio.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        boolean exists = driver.findElements(By.xpath("//*[@id=\'confirm\']")).size() != 0;

        if (exists) {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            correoConfirmar.sendKeys("pajaritos.musicales@pio.com");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        }

        pass.sendKeys("PajaritoConChaleco12");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        nombre.sendKeys("Piopio");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        day.sendKeys("22");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        month.sendKeys("Agosto");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        year.sendKeys("1993");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", other);
        other.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        marketing.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        submit.submit();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        find.getText();
        System.out.println(find.getText());
        assertEquals(biblioteca, find.getText());
    }
}
