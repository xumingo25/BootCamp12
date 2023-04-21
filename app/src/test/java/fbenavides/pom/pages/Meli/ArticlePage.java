package fbenavides.pom.pages.Meli;

import fbenavides.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticlePage extends SeleniumBase {

    public ArticlePage(WebDriver driver) {super(driver);}

    By locatorComprar = By.xpath("//button[@class= 'andes-button andes-spinner__icon-base andes-button--loud']");


    public void comprarProducto(){
        scrolling(buscarElementoWeb(locatorComprar));
        clickear(locatorComprar);
    }

}