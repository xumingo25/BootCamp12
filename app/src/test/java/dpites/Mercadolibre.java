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

public class Mercadolibre {

    public static WebDriver driver;
    @BeforeAll
    static void classSetup(){
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
        void setupTest(){
        driver = new ChromeDriver();
        //Maximizamos la ventana
        driver.manage().window().maximize();
    }
    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void compraMercadoLibre(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor js = (JavascriptExecutor) driver;


        //ir a mercado libre
        driver.get("https://www.mercadolibre.com.ar/");

        //cerrar cartel cookies
        try {
            By cerrarCookieXpath = By.xpath("/html/body/div[2]/div[1]/div[2]/button[1]");
            WebElement cerrarCookieVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(cerrarCookieXpath));
            WebElement cerrarCookie = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/button[1]"));
            cerrarCookie.click();
        }catch (NoSuchElementException e){
            System.out.println("No se encontro el Elemento cerrarCookie");
        }

        //hacer click en boton "Categoria"
        try {
            By botonCategoriasXpath = By.xpath("/html/body/header/div/div[5]/div/ul/li[1]/a");
            WebElement botonCategoriaVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(botonCategoriasXpath));
            WebElement botonCategoria = driver.findElement(By.xpath("/html/body/header/div/div[5]/div/ul/li[1]/a"));
            botonCategoria.click();
        }catch (NoSuchElementException e){
        System.out.println("No se encontro el Elemento botonCategoria");
        }

        //hacer click en boton "Mas Vendidos"
        try {
            By botonMasVendidosXpath = By.xpath("/html/body/header/div/div[5]/div/ul/li[1]/div/ul/li[20]/a");
            WebElement botonMasVendidosVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(botonMasVendidosXpath));
            WebElement botonMasVendidos = driver.findElement(By.xpath("/html/body/header/div/div[5]/div/ul/li[1]/div/ul/li[20]/a"));

            //hacer scroll hasta que sea visible el elemento buscado con JavascriptExecutor
            js.executeScript("arguments[0].scrollIntoView(true);", botonMasVendidos);
            botonMasVendidos.click();

        }catch (NoSuchElementException e){
            System.out.println("No se encontro el Elemento botonMasVendidos");
        }

        //Seleccionar objeto a comprar
        try {
            By objetoComprarXpath = By.xpath("//*[@id='root-app']/div/div[4]/section/section/div[2]/div/div/div/div[1]/div");
            WebElement objetoComprarVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(objetoComprarXpath));
            WebElement objetoComprar = driver.findElement(By.xpath("//*[@id='root-app']/div/div[4]/section/section/div[2]/div/div/div/div[1]/div"));
            js.executeScript("arguments[0].scrollIntoView(true);", objetoComprar);
            objetoComprar.click();
        }catch (NoSuchElementException e){
            System.out.println("No se encontro el Elemento objetoComprar");
        }

        //Click en boton comprarAhora
        try {
            By comprarAhoraXpath = By.xpath("//*[@id='buybox-form']/div[5]/div/button[1]/span");
            WebElement comprarAhoraVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(comprarAhoraXpath));
            WebElement comprarAhora = driver.findElement(By.xpath("//*[@id='buybox-form']/div[5]/div/button[1]/span"));
            comprarAhora.click();
        }catch (NoSuchElementException e){
            System.out.println("No se encontro el Elemento comprarAhora");
        }

        //imprimir en la terminal mensaje
        try {
            By mensajeXpath = By.xpath("//*[@id='root-app']/div/div[1]/div/div[2]/div[1]/h1");
            WebElement mensajeVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(mensajeXpath));
            WebElement mensaje = driver.findElement(By.xpath("//*[@id='root-app']/div/div[1]/div/div[2]/div[1]/h1"));
            String mensajeString = mensaje.getText();
            System.out.println(mensajeString);

        }catch (NoSuchElementException e){
            System.out.println("No se encontro el Elemento mensaje");
        }






    }








}
