package fbenavides.pom.pages.Spotify;

import fbenavides.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends SeleniumBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //localizadores
    By locatorRegistrarte = By.xpath("//button[contains(text(),'Registra')]");


    //acciones del sitio
    //ir a registrarte
    public void irARegistrarte(){
        if(estaDesplegado(locatorRegistrarte)){
            clickear(locatorRegistrarte);
        }
    }


}
