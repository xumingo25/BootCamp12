package fbazan.pom.pages;

import fbazan.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends SeleniumBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //atributos
    By locatorRegistrarte = By.xpath("//button[contains(text(), 'Regis')]");

    //metodos
    public void irARegistrarte(){
        if(estaDesplegado(locatorRegistrarte)){
            clickear(locatorRegistrarte);
        }
    }
}
