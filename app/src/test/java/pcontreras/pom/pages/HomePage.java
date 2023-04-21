package pcontreras.pom.pages;

import org.openqa.selenium.WebDriver;
import pcontreras.pom.base.SeleniumBase;

public class HomePage extends SeleniumBase {
    public HomePage(WebDriver driver){
        super(driver);
    }

    //localizadores
    By locatorRegistrarte =

    //acciones del sitio
    //ir a registrarte
    public void irARegistrarte(){
        if (estaDespleado(locatorRegistrarte))
    }
}//fin clase
