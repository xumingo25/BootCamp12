package dpites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class RegistroYoutubev2 {

    public static WebDriver driver;

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
        Random rm = new Random();

        String nombreUsuario = "Nombrerto";
        String apellidoUsuario = "Apelledinsky";

        int numRan = rm.nextInt(999999);
        String mailUsuario = nombreUsuario+apellidoUsuario+numRan;
        //NombrertoApelledinsky1145764909
        System.out.println(mailUsuario);

        String paswordUsuario = "aA1!2#Bb_-";

        //numero de telefono
        String numeroTelefono = "223 5"+numRan;
        //CODIGO VERIFICACION
        int codigoVerificacionNumero = numRan;
        String codigoVerificacionString;
        codigoVerificacionString =String.valueOf(codigoVerificacionNumero);


        //ABRIMOS LA URL DE Youtube
        driver.get("https://www.youtube.com/");

        //se crea el objerto wait de la clase Webdriverwait para utilizar la funcion wait.until
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //Click en boton Acceder
        By botonAccederXpath = By.xpath("//*[@id='buttons']/ytd-button-renderer/yt-button-shape");
        WebElement botonAccederVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(botonAccederXpath));
        WebElement botonAcceder = driver.findElement(By.xpath("//*[@id='buttons']/ytd-button-renderer/yt-button-shape"));
        botonAcceder.click();

        //Esperar a que el boton crear cuenta aparezca.
        By botonCrearCuentaXpath = By.xpath("//*[@id='yDmH0d']/c-wiz/div/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/button/span");
        WebElement inputEmailVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(botonCrearCuentaXpath));
        System.out.println(inputEmailVisible);
        //enviamos datos al input
        WebElement botonCrearCuenta = driver.findElement(By.xpath("//*[@id='yDmH0d']/c-wiz/div/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/button/span"));
        botonCrearCuenta.click();
        //DONE

        //esperar que aparezcan los elementos del dropdown
        By botonUsoPersonalXpath = By.xpath("//*[@id='yDmH0d']/c-wiz/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/ul/li[1]/span[2]");
        WebElement botonUsoPersonalVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(botonUsoPersonalXpath));
        WebElement botonUsoPersonal =  driver.findElement(By.xpath("//*[@id='yDmH0d']/c-wiz/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/ul/li[1]/span[2]"));
        botonUsoPersonal.click();

        //pasar a la siguiente pagina y esperar a que cargue el inputNombre
        By inputNombrexpath = By.xpath("//*[@id='firstName']");
        WebElement inputNombreVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(inputNombrexpath));
        System.out.println(inputNombreVisible);
        //enviamos datos al inputNombre
        WebElement inputNombre = driver.findElement(By.xpath("//*[@id='firstName']"));
        inputNombre.sendKeys(nombreUsuario);

        //inputApellido
        By inputApellidoXpath = By.xpath("//*[@id='lastName']");
        WebElement inputApellidoVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(inputApellidoXpath));
        System.out.println(inputApellidoVisible);
        WebElement inputApellido = driver.findElement(By.xpath("//*[@id='lastName']"));
        inputApellido.sendKeys(apellidoUsuario);

        //Click en "Crea una nueva dirección de Gmail en su lugar"
        WebElement spanCrearNuevoGmail = driver.findElement(By.xpath("//*[@id='view_container']/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[2]/div[3]/div/div/button/span"));
        spanCrearNuevoGmail.click();

        //Crear un mail Random
        WebElement inputCrearNuevoMail = driver.findElement(By.xpath("//*[@id='username']"));
        inputCrearNuevoMail.sendKeys(mailUsuario);

        //Crear Password
        WebElement inputCrearPassword = driver.findElement(By.xpath("//*[@id='passwd']/div[1]/div/div[1]/input"));
        inputCrearPassword.sendKeys(paswordUsuario);

        //Repetir Password
        WebElement inputCrearPasswordConfirmacion = driver.findElement(By.xpath("//*[@id='confirm-passwd']/div[1]/div/div[1]/input"));
        inputCrearPasswordConfirmacion.sendKeys(paswordUsuario);
        //DONE

        //Apretar botn Siguiente
        WebElement botonSiguiente = driver.findElement(By.xpath("//*[@id='accountDetailsNext']/div/button/span"));
        botonSiguiente.click();

        //llenar inputNumeroTelefono

        By inputNumeroTelefonoXpath = By.xpath("//*[@id='phoneNumberId']");
        WebElement inputNumeroTelefonoVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(inputNumeroTelefonoXpath));
        WebElement inputNumeroTelefono = driver.findElement(By.xpath("//*[@id='phoneNumberId']"));
        inputNumeroTelefono.sendKeys(numeroTelefono);

        //Verificar que se haya tomado el numero
        try{
            //By divNoSeEncontroXpath = By.xpath("//*[@id='view_container']/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[2]/div[1]/div[2]/div[2]/div");
            //WebElement divNoSeEncontro = wait.until(ExpectedConditions.visibilityOfElementLocated(divNoSeEncontroXpath));
            WebElement divNoSeEncontro = driver.findElement(By.xpath("//*[@id='view_container']/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[2]/div[1]/div[2]/div[2]/div/text()"));
            WebElement inputNumeroTelefono2 = driver.findElement(By.xpath("//*[@id='phoneNumberId']"));
            inputNumeroTelefono2.clear();
            inputNumeroTelefono2.sendKeys(numeroTelefono);
        }catch (NoSuchElementException e){
            System.out.println("no se encontro problemas con el numero");
        }

        //presionar botonSiguiente2
        By botonSiguiente2Xpath = By.xpath(("//*[@id='view_container']/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span"));
        WebElement botonSiguiente2Visible = wait.until(ExpectedConditions.visibilityOfElementLocated(botonSiguiente2Xpath));
        WebElement botonSiguiente2 = driver.findElement(By.xpath("//*[@id='view_container']/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span"));
        botonSiguiente2.click();

        //Despues de esto Se recquiere confirmar Codigo de Verificacion...
        By inputCodigoVerificacionXpath = By.xpath("//*[@id='code']");
        WebElement inputCodigoVerificacionVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(inputCodigoVerificacionXpath));
        WebElement inputCodigoVerificacion = driver.findElement(By.xpath("//*[@id='code']"));
        inputCodigoVerificacion.sendKeys(codigoVerificacionString);

        //Presionar Verificar
        By botonVerificarXpath = By.xpath("//*[@id='view_container']/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span");
        WebElement botonVerificarVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(botonVerificarXpath));
        WebElement botonVerificar = driver.findElement(By.xpath("//*[@id='view_container']/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span"));
        botonVerificar.click();

        //Devolver Sting del error
        WebElement errorVerificacion = driver.findElement(By.xpath("//*[@id='view_container']/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[2]/div/div[2]/div[2]/div/text()"));
        String errorVerificacionString = errorVerificacion.getText();



        System.out.println("\n----------------------------------------------------------------------------------------------------------------\n");
        System.out.println("GMAIL: "+mailUsuario);
        System.out.println("Nombre: "+nombreUsuario);
        System.out.println("Apellido: "+apellidoUsuario);
        System.out.println("Telefono: "+numeroTelefono);
        System.out.println("Password: "+paswordUsuario);
        System.out.println("ERROR VERIFICACION :"+errorVerificacionString);
        System.out.println("\n----------------------------------------------------------------------------------------------------------------\n");

    }





    @AfterEach

    void teardown() {


        //driver.quit();
    }
















}
