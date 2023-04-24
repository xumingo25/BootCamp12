package mvatalaro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegisterSpotifyTest {

    WebDriver driver; //creo del atributo webDriver

    WebDriverWait wait; //creo del atributo webDriverWait

    JavascriptExecutor js; //creo el atributo JavascriptExecutor


    @FindBy(xpath = "//button[contains(text(),'Registra')]")//Utilizo el xpath contains(text) para localizar el btn registrarse
    WebElement btnRegistrarse; //creo el atributo WebElement


    @BeforeAll
    static void preparacionClase(){
        System.setProperty("file.encoding", "UTF-8");
        WebDriverManager.chromedriver().setup(); //especificamos el controlador que vamos a utilizar (chromedriver)

    }

    @BeforeEach
    void preTests(){
        driver = new ChromeDriver(); //Instancio el ChromeDriver
        wait= new WebDriverWait(driver, 10); //Instancio el WebDriverWait
        js = (JavascriptExecutor) driver; //creo la referencia a JavascriptExecutor


        PageFactory.initElements(driver,this); //Inicializo los elementos de la pagina
        driver.get("https://open.spotify.com/"); //obtengo la URL

        //Maximizar page
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);//Establezco que debe esperar 10 segundos para completar la carga antes de arrojar error
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //Establezco que debe esperar 10 segundos para lanzar la excepcion por no encontrar un elemento
    }

    @Test
    void CP001_CreacionCtaSpotify_NOOK_CorreoYaIngresado() throws InterruptedException {
        //Aqui crearemos el test
        btnRegistrarse.click();

        By locatorTextoEmail = By.xpath("//input[@id='email']");
        WebElement textoEmail = wait.until(ExpectedConditions.presenceOfElementLocated(locatorTextoEmail));

        textoEmail.sendKeys("probando_nuevamusica@gmail.com");

        //***********************Elemento confirmar correo************************************
        By locatorConfirmarMail = null;
        WebElement textoConfirmarMail = null;

        try {
            locatorConfirmarMail = By.xpath("//input[@name='confirm']"); //Creo el localizador
            textoConfirmarMail = driver.findElement(locatorConfirmarMail); //Creo el elemento Web
            textoConfirmarMail.sendKeys("probando_nuevamusica@gmail.com");
        } catch (Exception e) {
            System.out.println("ocurrio un error al obtener el elemento web con el locator " + locatorConfirmarMail.toString());
        }
        //*********************Elemento Password*************************************************

        By locatorPassword = null;
        WebElement textoPassword = null;
        try {
            locatorPassword = By.xpath("//input[@type=\"password\"]"); //Creo el localizador
            textoPassword = driver.findElement(locatorPassword); //Creo el elemento Web sin espera
            textoPassword.sendKeys("Probando123");
        } catch (Exception e) {
            System.out.println("ocurrio un error al obtener el elemento web con el locator " + locatorPassword.toString());
        }
        //**********************Elemento Nombre Usuario********************************************

        By locatorNombrePerfil = null;
        WebElement textoNombrePerfil = null;
        try {
            locatorNombrePerfil = By.xpath("//input[@id='displayname']"); //Creo el localizador
            textoNombrePerfil = wait.until(ExpectedConditions.presenceOfElementLocated(locatorNombrePerfil)); //creación de elemento web
            //con wait
            textoNombrePerfil.sendKeys("Testeando2023");
        } catch (Exception e) {
            System.out.println("ocurrio un error al obtener el elemento web con el locator " + locatorNombrePerfil.toString());
        }
        //************************Elementos Dia, Mes y Anio****************************************
        By locatorDia = null;
        WebElement textoDia = null;
        try {
            locatorDia = By.xpath("//input[@name='day']"); //Creo el localizador
            textoDia = wait.until(ExpectedConditions.presenceOfElementLocated(locatorDia)); //creación de elemento web
            //con wait
            textoDia.sendKeys("18");
        } catch (Exception e) {
            System.out.println("ocurrio un error al obtener el elemento web con el locator " + locatorDia.toString());
        }

        //Mes
        By locatorMes = null;
        WebElement elegidoMes = null;
        try {
            locatorMes = By.xpath("//select");
            elegidoMes = wait.until(ExpectedConditions.presenceOfElementLocated(locatorMes));
            Select selectorMes = new Select(elegidoMes);

            selectorMes.selectByValue("03");
        } catch (Exception e) {
            System.out.println("ocurrio un error al obtener el elemento web con el locator " + locatorMes.toString());
        }

        By locatorAnnio = null;
        WebElement textoAnio = null;
        try {
            locatorAnnio = By.xpath("//input[@name='year']"); //Creo el localizador
            textoAnio = wait.until(ExpectedConditions.presenceOfElementLocated(locatorAnnio)); //creación de elemento web
            //con wait
            textoAnio.sendKeys("1984");
        } catch (Exception e) {
            System.out.println("ocurrio un error al obtener el elemento web con el locator " + locatorAnnio.toString());
        }

        //************************Elemento géneros***************************************************
        List<WebElement> generos = null; //utilizo una List WebElement
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

        //*****************************Elemento Check****************************************

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

        //**********************Elemento Boton Confirmar*******************************************
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
        //*************************Comprobacion de resultados****************************************
        String resultadoEsperado = "Este correo electrónico ya está conectado a una cuenta.";

        String resultadoActual = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Este correo')]"))).getText();

        Assertions.assertEquals(resultadoEsperado,resultadoActual);


    }
    void CP002_CreacionCtaSpotify_NOOK_CorreoFormatoErroneo() throws InterruptedException {
        //Aqui crearemos el test
        btnRegistrarse.click();

        By locatorTxtCorreo = By.xpath("//input[@id='email']");
        WebElement txtCorreo = wait.until(ExpectedConditions.presenceOfElementLocated(locatorTxtCorreo));

        txtCorreo.sendKeys("probando.nuevaMusica");

        By locatorConfirmarCorreo = null;
        WebElement txtConfirmarCorreo = null;
        try{
            locatorConfirmarCorreo = By.xpath("//input[@name='confirm']"); //Creo el localizador
            txtConfirmarCorreo = driver.findElement(locatorConfirmarCorreo); //Creo el elemento Web
            txtConfirmarCorreo.sendKeys("probando.nuevaMusica");
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorConfirmarCorreo.toString());
        }

        By locatorPassword = null;
        WebElement txtPassword = null;
        try{
            locatorPassword = By.xpath("//input[@type=\"password\"]"); //Creo el localizador
            txtPassword = driver.findElement(locatorPassword); //Creo el elemento Web sin espera
            txtPassword.sendKeys("Probando123");
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorPassword.toString());
        }

        By locatorNombrePerfil = null;
        WebElement txtNombrePerfil = null;
        try{
            locatorNombrePerfil = By.xpath("//input[@id='displayname']"); //Creo el localizador
            txtNombrePerfil = wait.until(ExpectedConditions.presenceOfElementLocated(locatorNombrePerfil)); //creación de elemento web
            //con wait
            txtNombrePerfil.sendKeys("Testeando2023");
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorNombrePerfil.toString());
        }


        By locatorDia = null;
        WebElement txtDia = null;
        try{
            locatorDia = By.xpath("//input[@name='day']"); //Creo el localizador
            txtDia = wait.until(ExpectedConditions.presenceOfElementLocated(locatorDia)); //creación de elemento web
            //con wait
            txtDia.sendKeys("18");
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

            selectorMes.selectByValue("03");
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorMes.toString());
        }

        By locatorAnnio = null;
        WebElement txtAnnio = null;
        try{
            locatorAnnio = By.xpath("//input[@name='year']"); //Creo el localizador
            txtAnnio = wait.until(ExpectedConditions.presenceOfElementLocated(locatorAnnio)); //creación de elemento web
            //con wait
            txtAnnio.sendKeys("1984");
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
        String resultadoEsperado = "Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com";

        String resultadoActual = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'formato como este: ejemplo@email.com')]"))).getText();

        Assertions.assertEquals(resultadoEsperado,resultadoActual);


    }

    @AfterEach
    void posTests(){
        //driver.close();
    }





}
