package lgalbiatti.pages;

import dsaavedra.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeSpotify extends SeleniumBase {
    public HomeSpotify(WebDriver driver) {
        super(driver);
    }

    By btnRegistrarse = By.xpath("//button[contains(text(),'Registra')]");

    public void btnRegistrarse (){
        clickear(btnRegistrarse);
    }


}
