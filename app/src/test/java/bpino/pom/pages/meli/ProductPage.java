package bpino.pom.pages.meli;

import bpino.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends SeleniumBase {
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    By locatorBtnComprar = By.xpath("//span[contains(text(),'Comprar ahora')]");

    public void comprarProducto(){
        scroll(buscarElementoWeb(locatorBtnComprar));
        clickear(esperarPorElementoVisible(locatorBtnComprar));
    }
}
