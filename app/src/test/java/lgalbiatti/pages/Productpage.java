package lgalbiatti.pages;

import dsaavedra.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Productpage extends SeleniumBase {
    public Productpage(WebDriver driver) {
        super(driver);
    }


    By comprar = By.xpath("//span[contains(text(),'Comprar ahora')]");
    By btncookies = By.xpath("/html/body/div[2]/div[1]/div[2]/button[1]");


    public void comprar (){
        clickear(comprar);
    }
    public void btncookies (){
        clickear(btncookies);
    }

}
