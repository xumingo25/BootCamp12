package mvatalaro.pom.pages;

import mvatalaro.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductoSeleccionadoPage extends SeleniumBase {

    public ProductoSeleccionadoPage(WebDriver driver) {
        super(driver);
    }


  By locatorProductoSeleccionado= By.xpath("//div[@data-index=\"0\" and @class=\"slick-slide slick-active\"] ");

  By locatorBtnComprarAhora = By.xpath("//button[@type=\"submit\" and @class=\"andes-button andes-spinner__icon-base andes-button--loud\"]");

  By locatorTextDebeLoguearse= By.xpath("//h1[@class=\"center-card__title\"]");
  public void seleccionarProductoYComprar(){

      clickear(locatorProductoSeleccionado);

      clickear(locatorBtnComprarAhora);




  }
    public String obtenerErrorporFaltaLogin(){
        return obtenerTexto(locatorTextDebeLoguearse);
    }
}



