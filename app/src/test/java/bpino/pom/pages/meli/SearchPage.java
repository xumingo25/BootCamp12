package bpino.pom.pages.meli;

import bpino.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends SeleniumBase {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    By locatorTxtProducto = By.xpath("//h2[contains(text(),'Bastones De Trekking 2 Unidades Par Ajustable Aluminio 7075')]");
    public void seleccionProducto(){
        scroll(buscarElementoWeb(locatorTxtProducto));
        clickear(locatorTxtProducto);
    }
}
