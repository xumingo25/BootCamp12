package bpino.pom.pages.spotify;

import bpino.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends SeleniumBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By locatorRegistrarte = By.xpath("//button[contains(text(),'Registra')]");

    public void irARegistrarte(){
        if(estaDesplegado(locatorRegistrarte)){
            clickear(locatorRegistrarte);
        }
    }
}
