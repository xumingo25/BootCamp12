package lgalbiatti.pages;

import dsaavedra.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Searchpage extends SeleniumBase {
    public Searchpage(WebDriver driver) {
        super(driver);
    }

    By producto = By.xpath("//body/main[@id='root-app']/div[1]/div[2]/section[1]/ol[1]/li[1]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/div[1]/div[1]/div[1]/img[1]");

    public void producto (){
        clickear(producto);
    }
}
