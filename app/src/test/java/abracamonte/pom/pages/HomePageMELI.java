package abracamonte.pom.pages;

import abracamonte.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageMELI extends SeleniumBase {
    public HomePageMELI(WebDriver driver) {super(driver);}

    //localizadores

    By locatorInputBuscar = By.xpath("//input[contains(@class, 'nav-search-input')]");
    By locatorBtnBuscar = By.xpath("//button[contains(@class, 'nav-search-btn')]");

    public  void buscarProducto(String productoBuscado){
        escribir(productoBuscado, buscarYEsperarElementoWeb(locatorInputBuscar));
        clickear(buscarYEsperarElementoWeb(locatorBtnBuscar));
    }

}
