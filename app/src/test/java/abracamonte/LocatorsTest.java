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


        By locatorCorreo= null;
        WebElement inputEmail;
        try{
            locatorCorreo = By.xpath("//input[contains(@placeholder, 'Pon tu correo electr')]");
            inputEmail = wait.until((ExpectedConditions.presenceOfElementLocated(locatorCorreo)));
            inputEmail.sendKeys("elcorreo@email.com");
        }catch (Exception e){
            System.out.println("Ocurrió un error al obtener el elemento con el locator: " + locatorCorreo.toString());
        }


        boolean siAparece = driver.findElements(By.xpath("//input[contains(@placeholder, 'Vuelve a poner tu correo electr')]")).size() !=0;
        if (siAparece) {
            WebElement inputEmail2;
            By locatorCorreo2=null;
            try {
                locatorCorreo2= By.xpath("//input[contains(@placeholder, 'Vuelve a poner tu correo electr')]");
                inputEmail2 = wait.until(ExpectedConditions.presenceOfElementLocated(locatorCorreo2));
                inputEmail2.sendKeys("elcorreo@email.com");
            }catch (Exception e){
                System.out.println("No se pudo obterer el elemento con el locator: " + locatorCorreo2.toString());
            }
        }


        By locatorPass=null;
        WebElement creaPassword;
        try {
            locatorPass=By.xpath("//input[contains(@placeholder, 'Crea una contrase')]");
            creaPassword = wait.until(ExpectedConditions.presenceOfElementLocated(locatorPass));
            creaPassword.sendKeys("Clave1234**");
        }catch (Exception e){
            System.out.println("No se pudo obterer el elemento con el locator: " + locatorPass.toString());
        }

        By locatorNombre=null;
        WebElement creaNombre;
        try {
            locatorNombre=By.xpath("//input[contains(@placeholder, 'Pon un nombre de perfil')]");
            creaNombre=wait.until(ExpectedConditions.presenceOfElementLocated(locatorNombre));
            creaNombre.sendKeys("Mi nombre");
        }catch (Exception e){
            System.out.println("No se pudo obterer el elemento con el locator: " + locatorNombre.toString());
        }


        By locatorDia=null;
        WebElement diaNac;
        try{
            locatorDia=By.xpath("//input[contains(@placeholder, 'DD')]");
            diaNac = wait.until(ExpectedConditions.presenceOfElementLocated(locatorDia));
            diaNac.sendKeys("12");
        }catch (Exception e){
        System.out.println("No se pudo obterer el elemento con el locator: " + locatorDia.toString());
        }

        By locatorMes=null;
        WebElement mesNac;
        try {
            locatorMes=By.xpath("//select[contains(@name, 'month')]");
            mesNac = wait.until(ExpectedConditions.presenceOfElementLocated(locatorMes));
            mesNac.sendKeys("Abril");
        }catch (Exception e){
            System.out.println("No se pudo obterer el elemento con el locator: " + locatorMes.toString());
        }

        By locatorYear=null;
        WebElement yearNac;
        try {
            locatorYear=By.xpath("//input[contains(@placeholder, 'AAAA')]");
            yearNac = wait.until(ExpectedConditions.presenceOfElementLocated(locatorYear));
            yearNac.sendKeys("1994");
        }catch (Exception e){
            System.out.println("No se pudo obterer el elemento con el locator: " + locatorYear.toString());
        }

        By locatorFemale=null;
        WebElement female;

        try {
            locatorFemale=By.xpath("//label[contains(@for, 'gender_option_female')]");
            female= wait.until(ExpectedConditions.elementToBeClickable(locatorFemale));
            js.executeScript("arguments[0].scrollIntoView(true);", female);
            female.click();
        }catch (Exception e){
            System.out.println("No se pudo obterer el elemento con el locator: " + locatorFemale.toString());
        }

        By locatorMarket=null;
        WebElement noMarket;
        try {
            locatorMarket=By.xpath("//label[contains(@for, 'marketing-opt-checkbox')]");
            noMarket = wait.until(ExpectedConditions.elementToBeClickable(locatorMarket));
            noMarket.click();
        }catch (Exception e){
            System.out.println("No se pudo obterer el elemento con el locator: " + locatorMarket.toString());
        }

        By locatorDatos=null;
        WebElement compartirDatos;
        try {
            locatorDatos=By.xpath("//label[contains(@for, 'third-party-checkbox')]");
            compartirDatos = wait.until(ExpectedConditions.elementToBeClickable(locatorDatos));
            compartirDatos.click();
        }catch (Exception e){
            System.out.println("No se pudo obterer el elemento con el locator: " + locatorDatos.toString());
        }


        title = driver.getTitle();
        System.out.println("Titulo de pagina: "+ title);


    }
    @AfterEach
    void afterTest() {
        driver.quit();
    }
}
