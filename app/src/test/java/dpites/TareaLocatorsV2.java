package dpites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TareaLocatorsV2 {

    public static WebDriver driver;

    //@FindBy(name = )

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();


    }
    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        //Maximizamos la ventana
        driver.manage().window().maximize();
    }
    @Test
    void test(){

        //ABRIMOS LA URL DE SPOTIFY
        driver.get("https://open.spotify.com/");
        //creamos un WebElement dedl boton de registo
        WebElement botonRegis = driver.findElement(By.xpath("//*[@id='main']/div/div[2]/div[1]/header/div[5]/button[1]"));
        //hacemos click(); en el WebElement
        botonRegis.click();

        //Hasta ahi funciona OK ahora hay que lograr editar el input de email, etc.

        //escribo los Waits para que la pagina cargue bien antes de seguir testeando
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement espera = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='email']")));
        WebElement esperaConfirm = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='confirm']")));
        WebElement esperaPass= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='password']")));
        WebElement esperaUser= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='displayname']")));
        WebElement esperaFechaDia = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='day']")));
        WebElement esperaFechaMes = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='month']")));
        WebElement esperaFechaMes2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='month']/option[5]")));
        WebElement esperaFechaAnio = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='year']")));
        WebElement esperaGeneroPNR = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='__next']/main/div/div/form/fieldset/div/div[1]")));


        //defino los webelements y comienzo a completar los distintos inputs
        WebElement elementoEmail = driver.findElement(By.xpath("//*[@id='email']"));
        elementoEmail.sendKeys("asdkfjasdofudhusofa@gmail.com");
        WebElement elementoConfirm = driver.findElement(By.xpath("//*[@id='confirm']"));
        elementoConfirm.sendKeys("asdkfjasdofudhusofa@gmail.com");
        WebElement elementoPass = driver.findElement(By.xpath("//*[@id='password']"));
        elementoPass.sendKeys("Aa11!@KkPp_");
        WebElement elementoUser = driver.findElement(By.xpath("//*[@id='displayname']"));
        elementoUser.sendKeys("FakeAccount34");
        WebElement elementoFechaDia = driver.findElement(By.xpath("//*[@id='day']"));
        elementoFechaDia.sendKeys("28");
        WebElement elementoFechaMes = driver.findElement(By.xpath("//*[@id='month']"));
        elementoFechaMes.sendKeys("a");
        WebElement elementoFechaMes2 = driver.findElement(By.xpath("//*[@id='month']/option[5]"));
        elementoFechaMes2.click();
        WebElement elementoFechaAnio = driver.findElement(By.xpath("//*[@id='year']"));
        elementoFechaAnio.sendKeys("1995", Keys.TAB,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.TAB,Keys.SPACE,Keys.TAB,Keys.SPACE);









    }









    @AfterEach

    void teardown() {
        //driver.quit();
    }



}
