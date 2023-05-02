package dpites.pom.pages;

import dpites.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends SeleniumBase {

    By locatorRegistrarte = By.xpath("//button[contains(text(),'Registra')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void irARegistrarte(){
        if(estaDesplegado(locatorRegistrarte)){
            clickear(locatorRegistrarte);
        }
    }



}
