package gnieto;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 class desafioSpotify {

    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Registra')]")
    WebElement btnRegistrase;



    @BeforeAll
    static void preparacionClase() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void preTests() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://open.spotify.com/");

// Maximizar la página
        driver.manage().window().maximize();
    }

    @Test
    void testEjemploSpotify() throws InterruptedException {

        //Aqui crearemos el test
        btnRegistrase.click();
        Thread.sleep(5000);

// Crear usuario con correo electrónico
        WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        email.sendKeys("usuario1-guada@algo.com");

// Confirmación de correo electrónico
        WebElement confirmEmail = driver.findElement(By.xpath("//*[@id=\"confirm\"]"));
        confirmEmail.sendKeys("usuario1-guada@algo.com");

// Contraseña
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("hola-domingo123");

// Cómo quieres que te llamemos?
        WebElement displayname = driver.findElement(By.xpath("//*[@id=\"displayname\"]"));
        displayname.sendKeys("guadita123");

// Fecha de nacimiento
        WebElement birthMonth = driver.findElement(By.xpath("//*[@id=\"month\"]"));
        birthMonth.sendKeys("Mayo"); // Selecciona el mes de nacimiento
        WebElement birthDay = driver.findElement(By.xpath("//*[@id=\"day\"]"));
        birthDay.sendKeys("17"); // Selecciona el día de nacimiento
        WebElement birthYear = driver.findElement(By.xpath("//*[@id=\"year\"]"));
        birthYear.sendKeys("1992"); // Selecciona el año de nacimiento

// Aquí selecciona mi género
        WebElement Mujer = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/form/fieldset/div/div[2]/label/span[2]"));
        Mujer.click();

// Aquí selecciona el check button "No quiero recibir notificaciones de Marketing de Spotify"
        WebElement Noquiero = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/form/div[6]/div/label/span[2]"));
        Noquiero.click();

// Aquí doy clic en el botón "No compartir datos con los proveedores de sp"
        WebElement Nocompartir = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/form/div[6]/div/label/span[2]"));

// Aquí hacemos clic en el botón "Registrarse"
        WebElement registrarse = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/form/div[8]/div/button/span[1]"));
        registrarse.click();
    }

    @AfterEach
    void posTests() {
        driver.close();
    }
}
