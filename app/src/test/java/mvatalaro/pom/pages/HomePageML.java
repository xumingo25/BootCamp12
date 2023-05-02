package mvatalaro.pom.pages;

import mvatalaro.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageML extends SeleniumBase {

    public HomePageML(WebDriver driver) {
        super(driver);
    }

    By locatorCookies = By.xpath("//button[contains(text(),'Entendido')]");

    By locatorUbicacion = By.xpath("//button[@data-js=\"onboarding-cp-close\"]");
    By locatorCategorias = By.xpath("//a[@class=\"nav-menu-categories-link\"]");


    //acciones del sitio
    //Ir a categoria seleccionada
    public void irACategoriaSeleccionada(){
        clickear(locatorCookies);
        clickear(locatorUbicacion);
        if (estaDesplegado(locatorCategorias)) {
            clickear(locatorCategorias);
        }
    }
}