package csalgan.pom.pages.MLPage;

import csalgan.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends SeleniumBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //localizador
    By locatorSearchCategories = By.xpath("//input[@id='cb1-edit']");
    By locatorCardInterestMe = By.xpath("//ol[@class='ui-search-layout ui-search-layout--stack shops__layout']/li[1]//h2[@class='ui-search-item__title shops__item-title']");


    //h2[contains(text(),'Bicicleta Mountain Mtb Firebird Rodado 29 21v Envi')]
    //By locatorCardInterestMe = By.xpath("//*[@id=\'root-app\']/div/div[2]/section/ol/li[15]/div/div/div[1]/a/div/div/div/div/div/img");
    //quito la linea de arriba porque me da el error de element click intercepted
    //List<WebElement> cards = buscarElementosWeb(locatorCardInterestMe);
    //el error de la linea 18 es java.lang.IndexOutOfBoundsException: Index: 0, Size: 0


    By locatorSearchCategorieButton = By.xpath("/html/body/header/div/div[2]/form/button");
    By locatorButtonBuyNow = By.xpath("//*[@id=\'main_actions\']/form/div/button[1]");

    //acciones
    // buscar una categoria
    public void buscarCategoria(String categoria){
        clickear(locatorSearchCategories);
        escribir(categoria,locatorSearchCategories);
    }

    public void navegarPorProductos(){
        clickear(locatorSearchCategorieButton);
        scrolling(buscarElementoWeb(locatorCardInterestMe));
        clickear(esperarPorElementoVisible(buscarElementoWeb(locatorCardInterestMe)));
        //quito esta linea bara buscar directamente el elemento card que me interesa
        //scrolling(cards.get(0));

    }



}
