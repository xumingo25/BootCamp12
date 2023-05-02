package fbazan.pom.pages.meli;

import fbazan.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends SeleniumBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //atributos
    By locatorTextBuscarProducto = By.xpath("//input[@id='cb1-edit']");

    By locatorSeleccionarProducto = By.xpath("//div[contains(@class, 'andes-card') and (@xpath = '1')]");

    //metodo
    public void buscarProducto (String producto) {

        escribir(producto, esperarPorElementoVisible(buscarElementoWeb(locatorTextBuscarProducto)));
        scrolling(buscarElementoWeb(locatorSeleccionarProducto));


    }

}
