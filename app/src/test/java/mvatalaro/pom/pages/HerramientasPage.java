package mvatalaro.pom.pages;

import mvatalaro.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HerramientasPage extends SeleniumBase {


    public HerramientasPage(WebDriver driver) {
        super(driver);
    }


    By locatorItemHerramientas =By.xpath( "//ul[@class='nav-categs-departments']//descendant::li//a[contains(text(), 'Herramientas')]");


       public void seleccionarPageHerramientas(){

        clickear(locatorItemHerramientas);

    }

}
