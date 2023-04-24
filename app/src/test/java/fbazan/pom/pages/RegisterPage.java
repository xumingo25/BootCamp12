package fbazan.pom.pages;

import fbazan.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends SeleniumBase {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //atributos
    By locatorTextCorreo = By.xpath("//input[@id = 'email']");
    By locatorTextConfirmarCorreo = By.xpath("//input[@id = 'confirm']");
    By locatorTextPassword = By.xpath("//input[@name = 'password']");
    By locatorTextName = By.xpath("//input[@id = 'displayname']");
    By locatorTextDay = By.xpath("//input[@id = 'day']");
    By locatorComboBoxMonth = By.xpath("//select [@id = 'month']");
    By locatorTextYear = By.xpath("//input [@id = 'year']");
    By locatorGeneros = By.xpath("//label[contains(@for, 'gender')]");
    By locatorCheckBoxs = By.xpath("//label[contains(@for, 'checkbox')]");
    By locatorBtnRegistrarte = By.xpath("//button[@type = \"submit\"]");

    By locatorTxtErrorCorreoExistente = By.xpath("//span[contains(text(),'Este correo')]");

    //metodos
    public void completarFormularioRegister (String correo, String confirmarCorreo, String password, String name, String day, String month, String year,String genero, boolean recibirMsj, boolean compartirDatos) {


        escribir(correo, esperarPorElementoVisible(buscarElementoWeb(locatorTextCorreo)));

        if (estaDesplegado(locatorTextConfirmarCorreo)) {
            escribir(correo, locatorTextConfirmarCorreo);
        }

        escribir(password, locatorTextPassword);
        escribir(name, locatorTextName);
        escribir(day, locatorTextDay);
        scrolling(buscarElementoWeb(locatorTextDay));
        seleccionarComboBoxPorTextoVisible(buscarElementoWeb(locatorComboBoxMonth), "Abril");
        escribir(year, locatorTextYear);

        List<WebElement> generos = buscarElementosWeb(locatorGeneros);

        switch (genero.toLowerCase()) {
            case "hombre":
                clickear(generos.get(0));
                break;
            case "mujer":
                clickear(generos.get(1));
                break;
            case "no binario":
                clickear(generos.get(2));
                break;
            case "otro":
                clickear(generos.get(3));
                break;
            case "prefiero no respodner":
                clickear(generos.get(4));
                break;
            default:
                clickear(generos.get(4));
                break;

        }

        List<WebElement> checks = buscarElementosWeb(locatorCheckBoxs);

        scrolling(checks.get(0));

        if (recibirMsj) {
            clickear(checks.get(0));
        }

        scrolling(checks.get(1));

        if (compartirDatos) {
            clickear(checks.get(1));
        }

        clickear(locatorBtnRegistrarte);


    }

    public String obtenerErrorCorreoCorreoUtilizado(){
        return obtenerTexto(locatorTxtErrorCorreoExistente);

    }
}
