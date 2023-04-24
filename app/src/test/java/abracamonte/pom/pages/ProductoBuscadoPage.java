package abracamonte.pom.pages;

import abracamonte.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductoBuscadoPage extends SeleniumBase {
    public ProductoBuscadoPage(WebDriver driver){super(driver);}

    //localizadores
    By locatorBtnComprarAhora = By.xpath("//button[@class='andes-button andes-spinner__icon-base andes-button--loud']");

    public void clikearComprarAhora(){
        scrolling(buscarYEsperarElementoWeb(locatorBtnComprarAhora));
        clickear(buscarYEsperarElementoWeb(locatorBtnComprarAhora));
    }
}
