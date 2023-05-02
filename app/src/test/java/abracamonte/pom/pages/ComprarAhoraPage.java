package abracamonte.pom.pages;

import abracamonte.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComprarAhoraPage extends SeleniumBase {
    public ComprarAhoraPage(WebDriver driver){super(driver);}

    //localizadores

    By locatorMensajeEsperado = By.xpath("//h1[contains(text(), '\u00A1Hola! Para comprar, ingres\u00e1 a tu cuenta')]");

    public String obtenerMensaje(){return obtenerTexto(locatorMensajeEsperado);}
}
