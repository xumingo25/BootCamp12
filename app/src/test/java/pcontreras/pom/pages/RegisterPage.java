package pcontreras.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pcontreras.pom.base.SeleniumBase;

public class RegisterPage extends SeleniumBase {
    public RegisterPage (WebDriver driver){
        super(driver);
    }

    //localizadores
    By locatorTxtBoxCorreo = By.xpath();

    By locatorTxtBoxConfirmarCorreo = By.xpath();

    By locatorTxtBoxContrasena = By.xpath();

    By locatorTxtBoxApodo = By.xpath();

    By locatorTxtBoxDia = By.xpath();

    By locatorTxtBoxMes = By.xpath();

    By locatorTxtBoxAnnio = By.xpath();

    By locatorTxtBoxApodo = By.xpath();

    By locatorTxtErrorCorreoExistente = By.xpath();

    //Acciones
        //Completar el formulario
    public void completarFormularioRegistro(String correo, String confirmarCorreo, String password, String apodo, int dia, String mes, int annio, String genero, boolean recibirMensaje){

        escribir(correo, locatorTxtBoxCorreo);
        if (estaDespleado(locatorTxtBoxConfirmarCorreo)){
            escribir(confirmarCorreo,locatorTxtBoxConfirmarCorreo);
        }
        escribir(password,locatorTxtBoxContrasena);
        escribir(apodo, locatorTxtBoxApodo);
        escribir(dia,locatorTxtBoxDia);
        scrolling(buscarElementosWeb(locatorTxtBoxDia));
        seleccionarComboBoxPorTextoVisible(buscarElementosWeb(locatorTxtBoxMes),"Febrero");
        escribir(annio,locatorTxtBoxAnnio);

        list <WebElement>
    }
}//fin clase
