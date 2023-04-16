package dpites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TareaLocatorsV3 {



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


        //defino los webelements y comienzo a completar los distintos inputs
        WebElement elementoEmail = driver.findElement(By.xpath("//*[@id='email']"));
        elementoEmail.sendKeys("FakeAccount3838@gmail.com");

        try{

            //WebElement confirmacionEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='confirm']")));
            WebElement elementoConfirmacionEmail = driver.findElement(By.xpath("//*[@id='confirm']"));
            elementoConfirmacionEmail.sendKeys("FakeAccount3838@gmail.com");

        }catch (NoSuchElementException e){

            System.out.println("No hay input de confirmacion de email");

        }


        WebElement confirmacionPass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
        WebElement elementoPass = driver.findElement(By.xpath("//*[@id='password']"));
        elementoPass.sendKeys("Aa11!@KkPp_");

        WebElement confirmacionUser = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='displayname']")));
        WebElement elementoUser = driver.findElement(By.xpath("//*[@id='displayname']"));
        elementoUser.sendKeys(
                "FakeAccount38",
                Keys.TAB, "28",
                Keys.TAB, Keys.ENTER, "a", Keys.ENTER,
                Keys.TAB, "1995",
                Keys.TAB, Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,
                Keys.TAB, Keys.SPACE,
                Keys.TAB, Keys.SPACE
                ,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER
        );

        WebElement confirmacionMejoraTuCuenta = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='main']/div/div[2]/div[1]/header/button[1]")));
        WebElement elementoMejoraTuCuenta = driver.findElement(By.xpath("//*[@id='main']/div/div[2]/div[1]/header/button[1]"));
        String devolucion = elementoMejoraTuCuenta.getText();

        System.out.println(devolucion);

    }









    @AfterEach

    void teardown() {
        //driver.quit();
    }













}
