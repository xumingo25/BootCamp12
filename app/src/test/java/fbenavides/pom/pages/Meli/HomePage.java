package fbenavides.pom.pages.Meli;
import fbenavides.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends SeleniumBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //localizadores
    By locatorAceptarGalletas = By.xpath("//button[contains(text(),'Entendido')]");
    By locatorNoCompartirUbicacion = By.xpath("//button[@class= 'onboarding-cp-button andes-button andes-button--transparent andes-button--small']");
    By locatorEscribirProducto = By.xpath("//input[@id='cb1-edit']");
    By locatorBtnBuscar = By.xpath("//button[@class= 'nav-search-btn']");

    public void irABuscador(String producto) {
        if (estaDesplegado(locatorAceptarGalletas)) {
            clickear(locatorAceptarGalletas);
            clickear(locatorNoCompartirUbicacion);
            escribir(producto, locatorEscribirProducto);
            clickear(locatorBtnBuscar);

        }
    }


}