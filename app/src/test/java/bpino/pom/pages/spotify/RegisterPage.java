package bpino.pom.pages.spotify;

import bpino.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends SeleniumBase {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    By locatorTxtCorreo = By.xpath("");
    By locatorTxtConfirmarCorreo = By.xpath("");
    By locatorTxtContrasena = By.xpath("");
    By locatorTxtApodo = By.xpath("");
    By locatorTxtDia = By.xpath("");
    By locatorCBDia = By.xpath("");
    By locatorTxtConfirmarAnnio = By.xpath("");
    By locatorCBAnnio = By.xpath("");
    By locatorTxtMes = By.xpath("");
    By locatorCBMes = By.xpath("");
    By locatorGeneros = By.xpath("");
    By locatorCheckBox = By.xpath("");
    By locatorBtnRegistrarse = By.xpath("");
    By locatorTxtErrorCorreoExistente = By.xpath("");

    public void completarFormularioRegistro(String correo, String confirmarCorreo, String password, String apodo, String dia, String mes, String annio, String genero, boolean recibirMensaje, boolean recibirDatos) {
        escribir(correo, locatorTxtCorreo);
        if (estaDesplegado(locatorTxtConfirmarCorreo)) {
            escribir(confirmarCorreo, locatorTxtConfirmarCorreo);
        }
        escribir(password, locatorTxtContrasena);
        escribir(apodo, locatorTxtApodo);
        escribir(dia, locatorTxtDia);
        scroll(buscarElementoWeb(locatorTxtDia));

        List<WebElement> generos = buscarElementosWeb(locatorGeneros);
        switch (genero.toLowerCase()) {
            case "hombre":
                clickear(generos.get(0));
                break;
            case "mujer":
                break;
            case "no binario":
                break;
            case "otro":
                break;
            case "prefiero no responder":
                break;
            default:
                break;
        }
    }

}

