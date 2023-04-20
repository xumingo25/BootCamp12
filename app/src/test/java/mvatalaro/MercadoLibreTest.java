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


    //******************Elemento Item Desplegable Categorias*************************************
        By locatorItemCategorias = null;
        WebElement itemCategorias;
        try{
            locatorItemCategorias = By.xpath("//a[@class=\"nav-menu-categories-link\"]"); //Creo el localizador
            itemCategorias = wait.until(ExpectedConditions.presenceOfElementLocated(locatorItemCategorias)); //creación de elemento web
            //con wait
            itemCategorias.isDisplayed();
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorItemCategorias.toString());
        }


        By locatorItemElectrodomesticos =null;
        WebElement itemElectrodomesticos;

        try{
            locatorItemElectrodomesticos = By.xpath("");
            itemElectrodomesticos = wait.until(ExpectedConditions.presenceOfElementLocated(locatorItemCategorias));

            itemElectrodomesticos.click();

        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorItemElectrodomesticos.toString());
        }

        By locatorItemHeladera =null;
        WebElement itemHeladera;
        try{
            locatorItemHeladera = By.xpath("//img[@alt=\"Heladeras \"]");
            itemHeladera = wait.until(ExpectedConditions.presenceOfElementLocated(locatorItemHeladera));

            itemHeladera.click();
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorItemHeladera.toString());
        }

        By locatorHeladeraElegida =null;
        WebElement itemHeladeraElegida;
        try{
            locatorHeladeraElegida = By.xpath("//p[@class=\"ui-recommendations-card__title\"]//ancestor::a[contains(text(), \"555L\")]");
            itemHeladeraElegida = wait.until(ExpectedConditions.presenceOfElementLocated(locatorHeladeraElegida));

            itemHeladeraElegida.click();
        }catch (Exception e){
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorHeladeraElegida.toString());
        }

        By locatorBtnComprarAhora = null;
        WebElement btnComprarAhora;


        try{
            locatorBtnComprarAhora = By.xpath("//button[@class=\"andes-button andes-spinner__icon-base andes-button--loud\"]"); //Creo el localizador
            btnComprarAhora = wait.until(ExpectedConditions.presenceOfElementLocated(locatorBtnComprarAhora)); //creación de elemento web
            //Scroll
            js.executeScript("arguments[0].scrollIntoView(true);", btnComprarAhora);

            //con wait
            btnComprarAhora.click();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ocurrio un error al obtener el elemento web con el locator "+ locatorBtnComprarAhora.toString());
        }

        String resultadoEsperado ="¡Hola! Para comprar ingresa a tu cuenta";

        String resultadoActual = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class=\"center-card__title\"]"))).getText();

        Assertions.assertEquals(resultadoEsperado,resultadoActual);




    }








}
