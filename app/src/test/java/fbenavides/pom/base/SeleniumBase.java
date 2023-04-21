package fbenavides.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeleniumBase {
    private WebDriver driver;
    private WebDriverWait wait;
    private Select select;
    private JavascriptExecutor js;


    //Metodos

    public SeleniumBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    //Métodos para enmascarar/encapsular la libreria de selenium
    public WebElement buscarElementoWeb(By localizador){
        return driver.findElement(localizador);
    }

    public List<WebElement> buscarElementosWeb(By localizador){
        return driver.findElements(localizador);
    }

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
}
