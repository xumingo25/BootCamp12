package fbazan.pom.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;

    @BeforeAll
    public static void initTesting(){
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    public void setUp (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterEach
    public void close(){
        driver.close();
    }
}
