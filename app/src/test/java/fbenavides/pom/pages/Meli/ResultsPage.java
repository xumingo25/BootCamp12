package fbenavides.pom.pages.Meli;

import fbenavides.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage extends SeleniumBase {

    public ResultsPage(WebDriver driver) {super(driver);}

    By locatorProductoElegido = By.xpath("//h2[contains(text(),'Cd The Weeknd - After Hours Nuevo Y Sellado Obivinilos')]");
    By locatorComprar = By.xpath("//button[@class= 'andes-button andes-spinner__icon-base andes-button--loud']");


    public void seleccionarProducto(){
        scrolling(buscarElementoWeb(locatorProductoElegido));
        clickear(locatorProductoElegido);
    }

}
