package abracamonte.pom.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SeleniumBase {
    private WebDriver driver;

    private WebDriverWait wait;

    private  TakesScreenshot takesScreenshot;



    private ChromeDriver chromeDriver;

    private Select select;
    private JavascriptExecutor js;

    //Métodos

    //Constructor
    public SeleniumBase(WebDriver driver) {
        this.driver = driver;
    }

    //Getters & Setters
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


    //Métodos para enmascarar/encapsular la libreria de selenium
    public WebElement buscarYEsperarElementoWeb(By localizador){
        wait = new WebDriverWait(driver,20);

        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    public List<WebElement> buscarElementosWeb(By localizador){
        return driver.findElements(localizador);
    }

    //navigate().to(url)
    public void navegarAPagina(String url){
        driver.navigate().to(url);
    }

    public void clickear(By localizador){
        driver.findElement(localizador).click();
    }

    public void clickear(WebElement elemento){
        elemento.click();
    }

    public void escribir(String texto, By localizador){
        driver.findElement(localizador).sendKeys(texto);
    }

    public void escribir(String texto, WebElement elemento){
        elemento.sendKeys(texto);
    }


    public void cerrarVentana(){
        driver.close();
    }

    public String obtenerTexto(By localizador){
        return driver.findElement(localizador).getText();
    }

    public boolean estaDesplegado(By localizador){
        try{
            return driver.findElement(localizador).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public boolean estaSeleccionado(By localizador){
        try{
            return driver.findElement(localizador).isSelected();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public void scrolling(WebElement elemento){
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elemento);
    }

    public void seleccionarComboBoxPorTextoVisible(WebElement elemento,String valor){
        select = new Select(elemento);
        select.selectByVisibleText(valor);
    }

    public WebElement esperarPorElementoVisible(WebElement element){
        wait = new WebDriverWait(driver,20);

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void capturaPantalla(String texto, WebDriver driver) throws IOException {


        TakesScreenshot takesScreenshot =(( TakesScreenshot ) driver );

        File SrcFile = takesScreenshot . getScreenshotAs (OutputType.FILE);

        File DestFile=new File(texto);
        FileUtils.copyFile(SrcFile, DestFile);

    }


}
