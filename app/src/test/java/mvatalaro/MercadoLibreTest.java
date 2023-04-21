package mvatalaro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MercadoLibreTest {

    WebDriver driver; //creo del atributo webDriver

    WebDriverWait wait; //creo del atributo webDriverWait

    JavascriptExecutor js; //creo el atributo JavascriptExecutor
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
        driver.get("https://www.mercadolibre.com.ar/"); //obtengo la URL

        //Maximizar page
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);//Establezco que debe esperar 10 segundos para completar la carga antes de arrojar error
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //Establezco que debe esperar 10 segundos para lanzar la excepcion por no encontrar un elemento
    }

    @Test
    void CP001_CompraProductoML_NOOK_DebeLoguearse() throws InterruptedException {

       //**************************Aceptar las cookies*********************************************

        By locatorCookies = null;
        WebElement cookies = null;
        try {
            locatorCookies = By.xpath("//button[contains(text(),'Entendido')]");
            cookies = wait.until(ExpectedConditions.presenceOfElementLocated(locatorCookies));
            cookies.click();
        } catch (Exception e) {
            System.out.println("ha ocurrido un error al obtener el elemento web con el locator " + locatorCookies.toString());
        }
        //**********************Postergar la ubicacion****************************************************

        By locatorUbicacion = null;
        WebElement ubicacion = null;
        try {
            locatorUbicacion = By.xpath("//button[@data-js=\"onboarding-cp-close\"]");
            ubicacion = wait.until(ExpectedConditions.presenceOfElementLocated(locatorUbicacion));
            ubicacion.click();
        } catch (Exception e) {
            System.out.println("ha ocurrido un error al obtener el elemento web con el locator " + locatorUbicacion.toString());
        }
    //******************Elemento Item Desplegable Categorias*************************************

        By locatorItemCategorias = null;
        WebElement itemCategorias;
        try{
            locatorItemCategorias = By.xpath("//a[@class=\"nav-menu-categories-link\"]"); //Creo el localizador
            itemCategorias = wait.until(ExpectedConditions.presenceOfElementLocated(locatorItemCategorias)); //creación de elemento web
            //con wait
            itemCategorias.click();
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorItemCategorias.toString());
        }
    //************************Elemento Herramientas*************************************************

        By locatorItemHerramientas =null;
        WebElement itemHerramientas;

        try{
            locatorItemHerramientas = By.xpath( "//a[@href=\"https://www.mercadolibre.com.ar/c/herramientas#menu=categories\"]"); ////a[contains(text(), 'Herramientas')] //ul[@class='nav-categs-departments']//descendant::li//a[contains(text(), 'Herramientas')]
            itemHerramientas = wait.until(ExpectedConditions.presenceOfElementLocated(locatorItemHerramientas));                //ul[@class="nav-categs-departments"]//descendant::li//a[contains(text(), 'Herramientas')]
            js.executeScript("arguments[0].click();", itemHerramientas);

        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorItemHerramientas.toString());
        }
       //************************Elemento Taladro*******************************************************

        By locatorItemTaladro =null;
        WebElement itemTaladro;
        try{
            locatorItemTaladro= By.xpath("//div[@data-index=\"0\" and @class=\"slick-slide slick-active\"] ");
            itemTaladro = wait.until(ExpectedConditions.presenceOfElementLocated(locatorItemTaladro));
            js.executeScript("arguments[0].scrollIntoView(true);", itemTaladro);
            itemTaladro.click();
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorItemTaladro.toString());
        }


        //**********************Elemento boton Comprar ahora**********************************************
        By locatorBtnComprarAhora = null;
        WebElement btnComprarAhora;


        try{
            locatorBtnComprarAhora = By.xpath("//button//span[@class=\"andes-button__content\" and contains(text(), 'Comprar ahora') ]"); //Creo el localizador
            btnComprarAhora = wait.until(ExpectedConditions.presenceOfElementLocated(locatorBtnComprarAhora)); //creación de elemento web
            //Scroll
            js.executeScript("arguments[0].scrollIntoView(true);", btnComprarAhora);

            //con wait
            btnComprarAhora.click();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorBtnComprarAhora.toString());
        }

        //*********************Resultados********************************************************

        String resultadoEsperado ="¡Hola! Para comprar ingresa a tu cuenta";

        String resultadoActual = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class=\"center-card__title\"]"))).getText();

        Assertions.assertEquals(resultadoEsperado,resultadoActual);




    }








}
