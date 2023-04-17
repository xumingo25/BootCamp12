package rquezada;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TareaSpotify {
    WebDriver driver;
        @BeforeAll
        static void setupClass() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeEach
        void setupTest() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test
        void test() {
            //Abrir sporify
            driver.get("https://open.spotify.com/");
            WebElement Registrar = driver.findElement(By.xpath("//button[contains(text(),'Registrarte')]"));
            Registrar.click();

            //Llenar formulario
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement wait2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='email']")));

            //Gmail
            WebElement email = driver.findElement(By.xpath("//*[@id='email']"));
            email.sendKeys("lulu_lulita@example.com");

            //Confirmar Gamil
            //WebElement confirmarGmail = driver.findElement(By.xpath("//*[@id='confirm']"));
            //confirmarGmail.sendKeys("lulu_lulita@example.com");

            //Contraseña
            WebElement pass = driver.findElement(By.xpath("//*[@id='password']")); // []
            pass.sendKeys("lulugordita123");

            //Nombre
            WebElement nick = driver.findElement(By.xpath("//*[@id='displayname']"));
            nick.sendKeys("Lulu");

            //Rellenar cuadro | Dia
            WebElement day = driver.findElement(By.xpath("//*[@id='day']"));
            day.sendKeys("31");

            //Rellenar select | Mes
            Select fruits = new Select (driver.findElement(By.xpath("//*[@id='month']")));
            fruits.selectByVisibleText("Octubre");

            //Rellenar cuadro | AÑo
            WebElement year = driver.findElement(By.xpath("//*[@id='year']"));
            year.sendKeys("2001");

            //Rellenar checkbox | Genero
            driver.findElement(By.cssSelector("label[for='gender_option_female']")).click();

            //Rellenar Checkbox
            driver.findElement(By.cssSelector("label[for='marketing-opt-checkbox']")).click();
            driver.findElement(By.cssSelector("label[for='third-party-checkbox']")).click();

            //Boton registro
            //WebElement Registro = driver.findElement(By.xpath("//button[contains(text(),'Regístrate')]"));
            //Registro.click();
        }
}