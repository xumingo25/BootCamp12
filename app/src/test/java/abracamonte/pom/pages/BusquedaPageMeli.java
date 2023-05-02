package abracamonte.pom.pages;

import abracamonte.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BusquedaPageMeli extends SeleniumBase {

    public BusquedaPageMeli(WebDriver driver){super(driver);}

    //localizadores

    By locatorProducto = By.xpath("//h2[contains(text(), 'Calefactor el\u00e9ctrico Magiclick C1009 blanco 220V')]");

    public void buscarProductoMeli(){
        clickear(buscarYEsperarElementoWeb(locatorProducto));
    }

}
