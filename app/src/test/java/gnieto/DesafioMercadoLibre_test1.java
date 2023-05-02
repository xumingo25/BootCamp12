package gnieto;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class DesafioMercadoLibre_test1 {
    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() throws InterruptedException {
        //  driver.quit();
    }

    @Test
    void test() throws InterruptedException {

        // abrimos la URL de Mercado Libre
        driver.get("https://www.mercadolibre.com.ar/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println(title);

        // Esperamos a que la página esté cargada
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleContains("Mercado Libre"));


        //Accedemos al buscador

        By locator_buscar = By.xpath("//*[@id=\"cb1-edit\"]");
        WebElement txt_buscar =wait.until(ExpectedConditions.presenceOfElementLocated(locator_buscar));
        txt_buscar.sendKeys("Smart TV Philips 7000 Series 50PUD7406/77");

        // Le damos click en la lupita para buscar el producto a comprar

        WebElement btn_lupa = driver.findElement(By.xpath("//div/div[2]/form/button"));
        btn_lupa.click();


        // Seleccionar el producto elegido para ver la información

        WebElement seleccionar = driver.findElement(By.xpath("//div[2]/div[2]/a[1]/h2"));
        seleccionar.click();


        /// Scrolleamos la página
                        Actions actions = new Actions(driver);

                // Desplazarse hacia abajo
                        actions.sendKeys(Keys.PAGE_DOWN).pause(1000).perform();

                // Desplazarse hacia arriba
                        actions.sendKeys(Keys.PAGE_UP).pause(1000).perform();

        //Acpeto coockies

        WebElement btn_cook = driver.findElement(By.xpath("//div[2]/div[1]/div[2]/button[1]"));
        btn_cook.click();
        Thread.sleep(1000);

          // Le damos click al botón comprar

        WebElement btncompra = driver.findElement(By.xpath("//*[@id=\"buybox-form\"]/div[4]/div/button[1]"));
        btncompra.click();
        Thread.sleep(1000);


        // dar click en botón ingresar

        By locator_btnIngresar = By.xpath("//*[@class=\"andes-button login-link andes-button--large andes-button--transparent\"]");
        WebElement btn_ingresar  = wait.until(ExpectedConditions.presenceOfElementLocated(locator_btnIngresar));
        btn_ingresar.click();

        // Ingresar correo electronico para ingresar


        By locator_email = By.xpath("//*[@id=\"user_id\"]");
        WebElement txt_email = wait.until(ExpectedConditions.presenceOfElementLocated(locator_email));
        txt_email.sendKeys("cuentaparamercadolibre177@gmail.com");
        Thread.sleep(1000);


        // Doy click en el botón continuar

        WebElement btnContinuar = driver.findElement(By.xpath("//*[@id=\"login_user_form\"]/div[2]/button/span"));
        btnContinuar.click();
        Thread.sleep(1000);

        // Ingreso contraseña

        By locator_Pass = By.xpath("//*[@id=\"password\"]");
        WebElement txt_Pass = wait.until(ExpectedConditions.presenceOfElementLocated(locator_Pass));
        txt_Pass.sendKeys("*******");


        // Iniciar Sesión

        By locator_btningresar = By.xpath("//*[@id=\"action-complete\"]");
        WebElement txt_btningresar = wait.until(ExpectedConditions.presenceOfElementLocated(locator_btningresar));
        txt_btningresar.click();




        /*
                Profe! aprovecho este espacio para comentarle : No pude seguir con la compra del producto por los captchas



*/    }


}
