package dsaavedra;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TareaLocators {
    WebDriver driver; //Creación de atributo WebDriver
    WebDriverWait wait;

    JavascriptExecutor js;

    @FindBy(xpath = "//button[contains(text(),'Registra')]")
    WebElement btnRegistrase;

    @BeforeAll
    static void preparacionClase(){
        //System.setProperty("file.encoding", "UTF-8");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void preTests(){
        driver = new ChromeDriver(); //Instanciamos el chromeDriver
        wait = new WebDriverWait(driver,10);
        js = (JavascriptExecutor) driver;

        PageFactory.initElements(driver,this);
        driver.get("https://open.spotify.com/");

        //Maximizar page
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
    void CP001_CreacionCtaSpotify_NOOK_CorreoYaIngresado() throws InterruptedException {
        //Aqui crearemos el test
        btnRegistrase.click();

        By locatorTxtCorreo = By.xpath("//input[@id='email']");
        WebElement txtCorreo = wait.until(ExpectedConditions.presenceOfElementLocated(locatorTxtCorreo));

        txtCorreo.sendKeys("domingo.saavedra.saavedra@gmail.com");

        By locatorConfirmarCorreo = null;
        WebElement txtConfirmarCorreo = null;
        try{
            locatorConfirmarCorreo = By.xpath("//input[@name='confirm']"); //Creo el localizador
            txtConfirmarCorreo = driver.findElement(locatorConfirmarCorreo); //Creo el elemento Web
            txtConfirmarCorreo.sendKeys("domingo.saavedra.saavedra@gmail.com");
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorConfirmarCorreo.toString());
        }

        By locatorPassword = null;
        WebElement txtPassword = null;
        try{
            locatorPassword = By.xpath("//input[@type=\"password\"]"); //Creo el localizador
            txtPassword = driver.findElement(locatorPassword); //Creo el elemento Web sin espera
            txtPassword.sendKeys("312312asrdeas");
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorPassword.toString());
        }

        By locatorNombrePerfil = null;
        WebElement txtNombrePerfil = null;
        try{
            locatorNombrePerfil = By.xpath("//input[@id='displayname']"); //Creo el localizador
            txtNombrePerfil = wait.until(ExpectedConditions.presenceOfElementLocated(locatorNombrePerfil)); //creación de elemento web
            //con wait
            txtNombrePerfil.sendKeys("User00001");
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorNombrePerfil.toString());
        }


        By locatorDia = null;
        WebElement txtDia = null;
        try{
            locatorDia = By.xpath("//input[@name='day']"); //Creo el localizador
            txtDia = wait.until(ExpectedConditions.presenceOfElementLocated(locatorDia)); //creación de elemento web
            //con wait
            txtDia.sendKeys("28");
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorDia.toString());
        }

        //Mes
        By locatorMes =null;
        WebElement ddlMes = null;
        try{
            locatorMes = By.xpath("//select");
            ddlMes = wait.until(ExpectedConditions.presenceOfElementLocated(locatorMes));
            Select selectorMes = new Select(ddlMes);

            selectorMes.selectByValue("10");
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorMes.toString());
        }

        By locatorAnnio = null;
        WebElement txtAnnio = null;
        try{
            locatorAnnio = By.xpath("//input[@name='year']"); //Creo el localizador
            txtAnnio = wait.until(ExpectedConditions.presenceOfElementLocated(locatorAnnio)); //creación de elemento web
            //con wait
            txtAnnio.sendKeys("1991");
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorAnnio.toString());
        }

        List<WebElement> generos = null;
        By locatorGeneros = null;
        try{
            locatorGeneros = By.xpath("//label[contains(@for,'gender')]");
            generos = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorGeneros));

            //Scroll a los generos
            js.executeScript("arguments[0].scrollIntoView(true);", generos.get(0));

            generos.get(0).click();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorGeneros.toString());
        }

        List<WebElement> checks = null;
        By locatorChecks = null;
        try{
            locatorChecks = By.xpath("//label[contains(@for,'checkbox')]");
            checks = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorChecks));

            if(checks.size()==2){
                checks.get(0).click();
                checks.get(1).click();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorGeneros.toString());
        }


        By locatorBtnConfirmar = null;
        WebElement btnConfirmar = null;


        try{
            locatorBtnConfirmar = By.xpath("//button[@type=\"submit\"]"); //Creo el localizador
            btnConfirmar = wait.until(ExpectedConditions.presenceOfElementLocated(locatorBtnConfirmar)); //creación de elemento web
            //Scroll
            js.executeScript("arguments[0].scrollIntoView(true);", btnConfirmar);

            //con wait
            btnConfirmar.click();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorBtnConfirmar.toString());
        }

        String resultadoEsperado = fixEncoding("Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");

        String resultadoActual = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Este correo')]"))).getText();

        Assertions.assertEquals(resultadoEsperado,resultadoActual);

    }

    void CP002_CreacionCtaSpotify_NOOK_CorreoFormatoErroneo() throws InterruptedException {
        //Aqui crearemos el test
        btnRegistrase.click();

        By locatorTxtCorreo = By.xpath("//input[@id='email']");
        WebElement txtCorreo = wait.until(ExpectedConditions.presenceOfElementLocated(locatorTxtCorreo));

        txtCorreo.sendKeys("domingo.saavedra.saavedra");

        By locatorConfirmarCorreo = null;
        WebElement txtConfirmarCorreo = null;
        try{
            locatorConfirmarCorreo = By.xpath("//input[@name='confirm']"); //Creo el localizador
            txtConfirmarCorreo = driver.findElement(locatorConfirmarCorreo); //Creo el elemento Web
            txtConfirmarCorreo.sendKeys("domingo.saavedra.saavedra");
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorConfirmarCorreo.toString());
        }

        By locatorPassword = null;
        WebElement txtPassword = null;
        try{
            locatorPassword = By.xpath("//input[@type=\"password\"]"); //Creo el localizador
            txtPassword = driver.findElement(locatorPassword); //Creo el elemento Web sin espera
            txtPassword.sendKeys("312312asrdeas");
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorPassword.toString());
        }

        By locatorNombrePerfil = null;
        WebElement txtNombrePerfil = null;
        try{
            locatorNombrePerfil = By.xpath("//input[@id='displayname']"); //Creo el localizador
            txtNombrePerfil = wait.until(ExpectedConditions.presenceOfElementLocated(locatorNombrePerfil)); //creación de elemento web
            //con wait
            txtNombrePerfil.sendKeys("User00001");
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorNombrePerfil.toString());
        }


        By locatorDia = null;
        WebElement txtDia = null;
        try{
            locatorDia = By.xpath("//input[@name='day']"); //Creo el localizador
            txtDia = wait.until(ExpectedConditions.presenceOfElementLocated(locatorDia)); //creación de elemento web
            //con wait
            txtDia.sendKeys("28");
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorDia.toString());
        }

        //Mes
        By locatorMes =null;
        WebElement ddlMes = null;
        try{
            locatorMes = By.xpath("//select");
            ddlMes = wait.until(ExpectedConditions.presenceOfElementLocated(locatorMes));
            Select selectorMes = new Select(ddlMes);

            selectorMes.selectByValue("10");
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorMes.toString());
        }

        By locatorAnnio = null;
        WebElement txtAnnio = null;
        try{
            locatorAnnio = By.xpath("//input[@name='year']"); //Creo el localizador
            txtAnnio = wait.until(ExpectedConditions.presenceOfElementLocated(locatorAnnio)); //creación de elemento web
            //con wait
            txtAnnio.sendKeys("1991");
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorAnnio.toString());
        }

        List<WebElement> generos = null;
        By locatorGeneros = null;
        try{
            locatorGeneros = By.xpath("//label[contains(@for,'gender')]");
            generos = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorGeneros));

            //Scroll a los generos
            js.executeScript("arguments[0].scrollIntoView(true);", generos.get(0));

            generos.get(0).click();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorGeneros.toString());
        }

        List<WebElement> checks = null;
        By locatorChecks = null;
        try{
            locatorChecks = By.xpath("//label[contains(@for,'checkbox')]");
            checks = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorChecks));

            if(checks.size()==2){
                checks.get(0).click();
                checks.get(1).click();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorGeneros.toString());
        }


        By locatorBtnConfirmar = null;
        WebElement btnConfirmar = null;


        try{
            locatorBtnConfirmar = By.xpath("//button[@type=\"submit\"]"); //Creo el localizador
            btnConfirmar = wait.until(ExpectedConditions.presenceOfElementLocated(locatorBtnConfirmar)); //creación de elemento web
            //Scroll
            js.executeScript("arguments[0].scrollIntoView(true);", btnConfirmar);

            //con wait
            btnConfirmar.click();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorBtnConfirmar.toString());
        }

        String resultadoEsperado = fixEncoding("Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");

        String resultadoActual = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'formato como este: ejemplo@email.com')]"))).getText();

        Assertions.assertEquals(resultadoEsperado,resultadoActual);


    }

    @AfterEach
    void posTests(){
        driver.close();
    }

    public static String fixEncoding(String text) {
        byte[] utf8Bytes = text.getBytes(StandardCharsets.ISO_8859_1);
        return new String(utf8Bytes, StandardCharsets.UTF_8);
    }
}