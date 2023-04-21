package loudelmar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestLocator {
    WebDriver driver;
    WebDriverWait espera;
    JavascriptExecutor js;

    @BeforeAll
     static void preparacionClase(){
        System.setProperty("file.encoding", "UTF-8");
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void preTests(){
        driver = new ChromeDriver();
        espera = new WebDriverWait(driver,7);
        js = (JavascriptExecutor) driver;

        PageFactory.initElements(driver,this);

        driver.get("https://open.spotify.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(7,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);

    }

    @Test
    void test(){

        By locatorBtnRegistrarse = null;
        WebElement btnRegistrarse = null;

        By locatorInputEmail = null;
        WebElement inputEmail = null;

        By locatorInputConfirmEmail = null;
        WebElement inputConfirmEmail = null;

        By locatorInputPassword = null;
        WebElement inputPassword = null;

        By locatorInputName = null;
        WebElement inputName = null;

        By locatorInputDay = null;
        WebElement inputDay = null;

        By locatorInputMonth = null;
        WebElement inputMonth = null;

        By locatorInputYear = null;
        WebElement inputYear = null;

        List<WebElement> generos = null;
        By locatorGeneros = null;

        List<WebElement> checkboxs = null;
        By locatorCheckboxs = null;

        By locatorBtnConfirmar = null;
        WebElement btnConfirmar = null;

        try{
            locatorBtnRegistrarse = By.xpath("//button[contains(text(),'Registra')]");
            btnRegistrarse = driver.findElement(locatorBtnRegistrarse);
            btnRegistrarse.click();
        } catch (Exception e){
            System.out.println("Te agarre error. Aca lo tenes: "+locatorBtnRegistrarse.toString());
        }

        try{
            locatorInputEmail = By.xpath("//*[@id=\'email\']");
            inputEmail = espera.until(ExpectedConditions.presenceOfElementLocated(locatorInputEmail));
            inputEmail.sendKeys("lourdes.lede@tsoftlatam.com");
        } catch (Exception e){
            System.out.println("Te agarre error. Aca lo tenes: "+locatorInputEmail.toString());
        }

        try{
            locatorInputConfirmEmail = By.xpath("//*[@id=\'confirm\']");
            inputConfirmEmail = driver.findElement(locatorInputConfirmEmail);
            inputConfirmEmail.sendKeys("lourdes.lede@tsoftlatam.com");
        } catch (Exception e){
            System.out.println("Te agarre error. Aca lo tenes: "+locatorInputEmail.toString());
        }

        try{
            locatorInputPassword = By.xpath("//*[@id=\'password\']");
            inputPassword = driver.findElement(locatorInputPassword);
            inputPassword.sendKeys("loudelmarlede");
        } catch (Exception e){
            System.out.println("Te agarre error. Aca lo tenes: "+locatorInputPassword.toString());
        }

        try{
            locatorInputName = By.xpath("//*[@id=\'displayname\']");
            inputName = driver.findElement(locatorInputName);
            inputName.sendKeys("Lou");
        } catch (Exception e){
            System.out.println("Te agarre error. Aca lo tenes: "+locatorInputName.toString());
        }

        try{
            locatorInputDay = By.xpath("//*[@id=\'day\']");
            inputDay = driver.findElement(locatorInputDay);
            inputDay.sendKeys("17");
        } catch (Exception e){
            System.out.println("Te agarre error. Aca lo tenes: "+locatorInputDay.toString());
        }

        try{
            locatorInputMonth = By.xpath("//select");
            inputMonth = driver.findElement(locatorInputMonth);
            Select selectorMes = new Select(inputMonth);
            selectorMes.selectByVisibleText("Febrero");
        }catch (Exception e){
            System.out.println("Te agarre error. Aca lo tenes: "+locatorInputMonth.toString());
        }

        try{
            locatorInputYear = By.xpath("//input[@name='year']");
            inputYear = driver.findElement(locatorInputYear);
            inputYear.sendKeys("1998");
        }catch (Exception e){
            System.out.println("Te agarre error. Aca lo tenes: "+locatorInputYear.toString());
        }

        try{
            locatorGeneros = By.xpath("//label[contains(@for,'gender')]");
            generos = espera.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorGeneros));

            js.executeScript("arguments[0].scrollIntoView(true);", generos.get(0));
            generos.get(0).click();
        }catch (Exception e){
            System.out.println("Te agarre error. Aca lo tenes: "+locatorGeneros.toString());
        }

        try{
            locatorCheckboxs = By.xpath("//label[contains(@for,'checkbox')]");
            checkboxs = espera.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorCheckboxs));

            if(checkboxs.size()==2){
                checkboxs.get(0).click();
            }
        }catch (Exception e){
            System.out.println("Te agarre error. Aca lo tenes: "+ locatorCheckboxs.toString());
        }

        try{
            locatorBtnConfirmar = By.xpath("//button[@type=\"submit\"]");
            btnConfirmar = driver.findElement(locatorBtnConfirmar);
            btnConfirmar.click();
        } catch (Exception e){
            System.out.println("Te agarre error. Aca lo tenes: "+locatorBtnConfirmar.toString());
        }

        String resultadoEsperado = "Este correo electrónico ya está conectado a una cuenta. Inicia sesión.";
        //resultadoEsperado = resultadoEsperado.replaceAll("\\p{InCOMBINING_DIACRITICAL_MARKS}", "");
        //resultadoEsperado = Normalizer.normalize(resultadoEsperado, Normalizer.Form.NFD);
        //String resultadoEsperadoC = java.text.Normalizer.normalize(resultadoEsperado, Normalizer.Form.NFD);
        //byte[] b = resultadoEsperado.getBytes(StandardCharsets.UTF_8);
        String resultadoActual = espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='LinkContainer-sc-1t58wcv-0 bSSutB']"))).getText();

        Assertions.assertEquals(resultadoEsperado,resultadoActual);

    }

    @AfterEach
    void posTests() {
        //driver.close();
    }
}
