package lgalbiatti.pages;

import dsaavedra.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends SeleniumBase {
    public Homepage(WebDriver driver) {
        super(driver);
    }

    By barradebusqueda = By.xpath("//input[@id='cb1-edit']");

    public void buscarProducto (){
        escribir("Bicicletas",barradebusqueda);
        hacerenter(barradebusqueda);
    }
}

