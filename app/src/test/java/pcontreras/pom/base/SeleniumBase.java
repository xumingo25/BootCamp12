package pcontreras.pom.base;

public class SeleniumBase {

}

public WebElement buscarElementoWeb(By localizador){
    return driver.findElement(localizador);
}

public List <WebElement> buscarElementosWeb(By localizador){
    return driver.findElements(localizador);
}

public void navegarAPagina(String url){
    driver.navigate().to(url);
}

public void clickear(By localizador){
    driver.findElement(localizador).click();
}

public void escribir(String texto, By localizador){
    driver.findElement(localizador).sendKeys(texto);
}

public void cerrarVentana(){
    driver.close();
}

public String obtenerTexto(By localizador){
    return driver.findElement(localizador).getText();
}

public boolean estaDespleado(){
    try {

    }catch (org.openqa.selenium.NoSuchElementException e){

    }
}