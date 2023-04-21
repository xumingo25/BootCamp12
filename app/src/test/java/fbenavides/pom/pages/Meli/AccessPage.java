package fbenavides.pom.pages.Meli;

import fbenavides.pom.base.SeleniumBase;
import fbenavides.pom.utilities.ManejoEncodingUFT8;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccessPage extends SeleniumBase {

    public AccessPage(WebDriver driver) {
        super(driver);
    }

    By locatorTxtIngresarACuenta = By.xpath(ManejoEncodingUFT8.fixEncoding("//h1[contains(text(),'¡Hola! Para comprar, ingresa a tu cuenta')]"));


    public String obtenerTxtAcceso() {
        return obtenerTexto(locatorTxtIngresarACuenta);
    }

}