package bpino.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumBase {
    private WebDriver driver;

    public SeleniumBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    //encapsular selenium

    public WebElement buscarEelementoWeb(By localizador){
        return driver.findElement(localizador);
    }
}
