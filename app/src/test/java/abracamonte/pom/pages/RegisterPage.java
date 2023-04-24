package abracamonte.pom.pages;

import abracamonte.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends SeleniumBase {

    public RegisterPage(WebDriver driver){super(driver);}

    //Localizadores

    By btnRegistrase= By.xpath("//button[contains(text(), 'Registra')]");
    By locatorCorreo=By.xpath("//input[contains(@placeholder, 'Pon tu correo electr')]");
    By locatorRepetirCorreo=By.xpath("//input[contains(@placeholder, 'Vuelve a poner tu correo electr')]");
    By locatorClaveSecreta=By.xpath("//input[contains(@placeholder, 'Crea una contrase')]");
    By locatorNombre=By.xpath("//input[contains(@placeholder, 'Pon un nombre de perfil')]");
    By locatorDia=By.xpath("//input[contains(@placeholder, 'DD')]");
    By locatorMes=By.xpath("//select[contains(@name, 'month')]");
    By locatorAnio=By.xpath("//input[contains(@placeholder, 'AAAA')]");
    By locatorGender=By.xpath("//label[contains(@for,'gender')]");
    By locatorCheckBox=By.xpath("//label[contains(@for,'checkbox')]");
    By locatorBtnRegistrarse=By.xpath("//button[@type=\"submit\"]");

    By locatorTxtErrorCorreoExistente = By.xpath("//span[contains(text(),'Este correo')]");

    By locatorErrorClaveMuyCorta = By.xpath("//span[contains(text(), 'Tu contrase')]");

    //Métodos de la page

    public void llenarFormularioRegistro(String correo, String confirmarCorreo, String password, String nombre, String dia, String mes, String anio, String genero, boolean mensaje, boolean compartirDatos){
        escribir(correo, buscarYEsperarElementoWeb(locatorCorreo));
        if (estaDesplegado(locatorRepetirCorreo)){
            escribir(confirmarCorreo, buscarYEsperarElementoWeb(locatorRepetirCorreo));
        }
        escribir(password, buscarYEsperarElementoWeb(locatorClaveSecreta));
        escribir(nombre, buscarYEsperarElementoWeb(locatorNombre));
        escribir(dia, buscarYEsperarElementoWeb(locatorDia));
        scrolling(buscarYEsperarElementoWeb(locatorDia));
        seleccionarComboBoxPorTextoVisible(buscarYEsperarElementoWeb(locatorMes), mes);
        escribir(anio, buscarYEsperarElementoWeb(locatorAnio));

        List <WebElement> generos = buscarElementosWeb(locatorGender);

        switch (genero.toLowerCase()){
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
            case "prefiero no responder":
                clickear(generos.get(4));
                break;
            default:
                clickear(generos.get(4));
        }

        List <WebElement> cheksBox = buscarElementosWeb(locatorCheckBox);

        scrolling(cheksBox.get(0));

        if (mensaje){
            clickear(cheksBox.get(0));
        }
        if (compartirDatos){
            clickear(cheksBox.get(1));
        }

        clickear(locatorBtnRegistrarse);

    }

    public String obtenerErrorCorreoUtilizado(){
        return obtenerTexto(locatorTxtErrorCorreoExistente);
    }

    public String obtenerErrorClaveMuyCorta(){return  obtenerTexto(locatorErrorClaveMuyCorta);}
}
