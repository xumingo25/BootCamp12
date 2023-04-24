package mvatalaro.pom.pages;

import mvatalaro.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends SeleniumBase {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //Localizadores
    By locatorTextBoxCorreo = By.xpath("//input[@id='email']");
    By locatorTextBoxConfirmarCorreo = By.xpath("//input[@name='confirm']");

    By locatorTextBoxContrasena = By.xpath("//input[@type=\"password\"]");

    By locatorTextBoxApodo = By.xpath("//input[@id='displayname']");

    By locatorTextBoxDia = By.xpath("//input[@name='day']");

    By locatorComboBoxMes = By.xpath("//select");
    By locatorTxtAnnio = By.xpath("//input[@name='year']");

    By locatorGeneros = By.xpath("//label[contains(@for,'gender')]");

    By locatorCheckBoxs = By.xpath("//label[contains(@for,'checkbox')]");

    By locatorBtnRegistrate = By.xpath("//button[@type=\"submit\"]");

    By locatorTxtErrorCorreoExistente = By.xpath("//span[contains(text(),'Este correo')]");

    //Acciones
    //CompletarElFormulario
    public void completarFormularioRegistro(String correo, String confirmarCorreo, String password, String apodo, String dia, String mes, String annio, String genero, boolean recibirMensaje, boolean compartirDatos) {

        escribir(correo, locatorTextBoxCorreo);
        if (estaDesplegado(locatorTextBoxConfirmarCorreo)) {
            escribir(confirmarCorreo, locatorTextBoxConfirmarCorreo);
        }
        escribir(password, locatorTextBoxContrasena);
        escribir(apodo, locatorTextBoxApodo);
        escribir(dia, locatorTextBoxDia);
        scrolling(buscarElementoWeb(locatorTextBoxDia));
        seleccionarComboBoxPorTextoVisible(buscarElementoWeb(locatorComboBoxMes), "Marzo");
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

        List<WebElement> checks = buscarElementosWeb(locatorCheckBoxs);

        scrolling(checks.get(0));

        if (recibirMensaje) {
            clickear(checks.get(0));
        }

        scrolling(checks.get(1));

        if (compartirDatos) {
            clickear(checks.get(1));
        }

        clickear(locatorBtnRegistrate);
    }

    public String obtenerErrorCorreoUtilizado() {
        return obtenerTexto(locatorTxtErrorCorreoExistente);
    }

}