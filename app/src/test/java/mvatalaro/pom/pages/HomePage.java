package mvatalaro.pom.pages;

import mvatalaro.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends SeleniumBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Localizadores
    By locatorRegistrarte = By.xpath("//button[contains(text(),'Registra')]");


    //acciones del sitio
    //Ir a registrarte
    public void irARegistrarte(){
        if(estaDesplegado(locatorRegistrarte)){
            clickear(locatorRegistrarte);
        }
    }
}
