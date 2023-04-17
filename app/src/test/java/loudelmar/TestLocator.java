package loudelmar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestLocator {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Registra')]")
    WebElement btnRegistrarse;
    @FindBy(xpath = "//*[@id=\'email\']")
    WebElement inputEmail;
    @FindBy(xpath = "//*[@id=\'confirm\']")
    WebElement inputConfirmMail;
    @FindBy(xpath = "//*[@id=\'password\']")
    WebElement inputPassword;
    @FindBy(xpath = "//*[@id=\'displayname\']")
    WebElement inputName;
    @FindBy(xpath = "//*[@id=\'day\']")
    WebElement inputDay;
    @FindBy(xpath = "//*[@id=\'year\']")
    WebElement inputYear;
    @FindBy(xpath = "//span[contains(text(),'Muj')]")
    WebElement selectMujer;
    @FindBy(xpath = "//span[contains(text(),'No quiero recibir')]")
    WebElement selectNoQuieroRecibirMensajes;
    @FindBy(xpath = "//*[@id=\'__next\']/main/div/div/form/div[8]/div/button/span[1]")
    WebElement btnConfirmarRegistro;
    @FindBy(xpath = "//*[@id=\'main\']/div/div[2]/div[1]/header/button[1]")
    WebElement btnMejorarTuCuenta;



    @BeforeAll
     static void preparacionClase(){
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void preTests(){
        driver = new ChromeDriver();
        PageFactory.initElements(driver,this);
    }

    @Test
    void test(){
        driver.get("https://open.spotify.com/");
        driver.manage().window().maximize();
        btnRegistrarse.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        inputEmail.sendKeys("lourdes.lede@tsoftlatam.com");
        inputPassword.sendKeys("loudelmarlede");
        try {
            if (driver.findElement(By.xpath("//*[@id=\'confirm\']")).isDisplayed()) {
                inputConfirmMail.sendKeys("lourdes.lede@tsoftlatam.com");
            }
        }catch (Exception e){

        }
        inputName.sendKeys("Lou");
        inputDay.sendKeys("17");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select selectMonth = new Select(driver.findElement(By.xpath("//*[@name=\'month\']")));
        selectMonth.selectByVisibleText("Febrero");
        inputYear.sendKeys("1998");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", selectMujer);
        selectMujer.click();

        selectNoQuieroRecibirMensajes.click();

        btnConfirmarRegistro.click();

        if(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/header/button[1]")).isDisplayed()){
            btnMejorarTuCuenta.click();
        }



        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @AfterEach
    void posTests() {
        //driver.close();
    }
}
