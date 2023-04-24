package bpino.pom.pages.meli;

import bpino.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static bpino.pom.utilities.ManejoEncodingUFT8.fixEncoding;

public class HomePage extends SeleniumBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By locatorTxtCookies = By.xpath("//button[contains(text(),'Entendido')]");
    By locatorTxtUbicacion = By.xpath(fixEncoding("//span[contains(text(),'Más tarde')]"));
    By locatorInputProducto = By.xpath("//input[@id='cb1-edit']");
    By locatorBtnBuscar = By.xpath("//button[@class='nav-search-btn']");


    public void buscarProducto(String producto) {
        if (estaDesplegado(locatorTxtCookies)) {
            clickear(esperarPorElementoVisible(locatorTxtCookies));
            clickear(esperarPorElementoVisible(locatorTxtUbicacion));
            escribir(producto, locatorInputProducto);
            clickear(esperarPorElementoVisible(locatorBtnBuscar));
        }
    }
}
