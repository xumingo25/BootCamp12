package bpino.pom.pages.meli;

import bpino.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static bpino.pom.utilities.ManejoEncodingUFT8.fixEncoding;

public class LoginPage extends SeleniumBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    By locatorTxtResultadoEsperado = (By.xpath(fixEncoding("//h1[contains(text(),'¡Hola! Para comprar, ingresa a tu cuenta')]")));

    public String textoObtenido(){
        return obtenerTexto(locatorTxtResultadoEsperado);
    }
}

