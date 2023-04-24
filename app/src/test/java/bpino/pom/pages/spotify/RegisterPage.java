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

    By locatorTxtCorreo = By.xpath("//input[@id='email']");
    By locatorTxtConfirmarCorreo = By.xpath("//input[@name='confirm']");
    By locatorTxtContrasena = By.xpath("//input[@type=\"password\"]");
    By locatorTxtApodo = By.xpath("//input[@id='displayname']");
    By locatorTxtDia = By.xpath("//input[@name='day']");

    By locatorTxtAnnio = By.xpath("//input[@name='year']");
    By locatorCBMes = By.xpath("//select");
    By locatorGeneros = By.xpath("//label[contains(@for,'gender')]");
    By locatorCheckBox = By.xpath("\"//label[contains(@for,'checkbox')]\"");
    By locatorBtnRegistrarse = By.xpath("//button[@type=\"submit\"]");
    By locatorTxtErrorCorreoExistente = By.xpath("//span[contains(text(),'Este correo')]");

    public void completarFormularioRegistro(String correo, String confirmarCorreo, String password, String apodo, String dia, String mes, String annio, String genero, boolean recibirMensaje, boolean compartirDatos) {
        escribir(correo, locatorTxtCorreo);
        if (estaDesplegado(locatorTxtConfirmarCorreo)) {
            escribir(confirmarCorreo, locatorTxtConfirmarCorreo);
        }
        escribir(password, locatorTxtContrasena);
        escribir(apodo, locatorTxtApodo);
        escribir(dia, locatorTxtDia);
        scroll(buscarElementoWeb(locatorTxtDia));
        seleccionarCBPorTxtVisible(buscarElementoWeb(locatorCBMes), "Febrero");
        escribir(annio, locatorTxtAnnio);

        List<WebElement> generos = buscarElementosWeb(locatorGeneros);
        switch (genero.toLowerCase()) {
            case "hombre":
                clickear(generos.get(0));
                break;
            case "mujer":
                clickear(generos.get(1));
                break;
            case "no ninario":
                clickear(generos.get(2));
                break;
            case "otro":
                clickear(generos.get(3));
                break;
            case "prefiero no responder":
                clickear(generos.get(4));
                break;
            default:
                clickear(generos.get(4));
                break;
        }

        List<WebElement> checks = buscarElementosWeb(locatorCheckBox);

        scroll(checks.get(0));

        if (recibirMensaje) {
            clickear(checks.get(0));
        }

        scroll(checks.get(1));

        if (compartirDatos) {
            clickear(checks.get(1));
        }

        clickear(locatorBtnRegistrarse);
    }

    public String obtenerErrorCorreoUtilizado(){
        return obtenerTexto(locatorTxtErrorCorreoExistente);
    }
}



