package fbazan.pom.pages.meli;

import fbazan.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends SeleniumBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //atributos
    By locatorTextBuscarProducto = By.xpath("//input[@id='cb1-edit']");

    By locatorSeleccionarProducto = By.xpath("//ol[@class='ui-search-layout ui-search-layout--stack shops__layout']/li[1]//div[@class='carousel-container arrow-visible']");
    By locatorBtnCookies = By.xpath("//button[contains(text(), 'Entendido')]");
    By locatorBtnComprarAhora = By.xpath("//span[contains(text(),'Comprar ahora')]");


    public void buscarProducto(String producto) throws InterruptedException {

        escribir(producto, esperarPorElementoVisible(buscarElementoWeb(locatorTextBuscarProducto)));
        scrolling(buscarElementoWeb(locatorSeleccionarProducto));
        clickear(locatorSeleccionarProducto);
        //scrolling(buscarElementoWeb(locatorBtnComprarAhora));
        clickear (locatorBtnCookies);
        clickear(locatorBtnComprarAhora);
        Thread.sleep(9000);
    }

}

