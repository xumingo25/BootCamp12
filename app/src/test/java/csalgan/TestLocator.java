package csalgan;

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

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class TestLocator {

    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Registra')]")
    WebElement btnRegistrase;
    @FindBy(xpath = "//*[@id=\'email\']")
    WebElement inputEmail;

    @FindBy(xpath = "//*[@id=\'confirm\']")
    WebElement inputEmailConfir;
    @FindBy(xpath = "//*[@id=\'password\']")
    WebElement inputPassword;

    @FindBy(xpath = "//*[@id=\'displayname\']")
    WebElement optionName;
    @FindBy(xpath = "//*[@id=\'day\']")
    WebElement dayBirthday;

    @FindBy(xpath = "//*[@id=\'month\']")
    WebElement monthBirthday;

    @FindBy(xpath = "//*[@id=\'year\']")
    WebElement yearBirthday;

    @FindBy(xpath = "//span[contains(text(),'Mujer')]")
    WebElement sexOption;

    @FindBy(xpath = "//span[contains(text(),'No quiero')]")
    WebElement publicityOption;

    @FindBy(xpath = "//*[@id=\'__next\']/main/div/div/form/div[7]/div/label/span[1]")
    WebElement infoShare;

    @FindBy(xpath = "//*[@id=\'__next\']/main/div/div/form/div[8]/div/button/span[1]")
    WebElement registerButton;



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
    void testEjemploSpotify() {
        //Aqui crearemos el test
        btnRegistrase.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        inputEmail.sendKeys("caramelitocato@gmail.com");
        if(driver.findElement(By.xpath("//*[@id=\'confirm\']")).isDisplayed()){
            inputEmailConfir.sendKeys("caramelitocato@gmail.com");
        }
        inputPassword.sendKeys("2234567");
        optionName.sendKeys("caramelito");
        dayBirthday.sendKeys("23");
        monthBirthday.sendKeys("December");
        yearBirthday.sendKeys("1944");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", sexOption);
        sexOption.click();
        publicityOption.click();
        infoShare.click();
        registerButton.click();


    }

    @AfterEach
    void posTests(){
        //driver.close();
    }

}
