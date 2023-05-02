package lgalbiatti.pages;

import dsaavedra.pom.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class RegisterSpotifypage extends SeleniumBase {
    public RegisterSpotifypage(WebDriver driver) {
        super(driver);
    }
    By correo = By.xpath("//input[@id='email']");
    By confirmarcorreo = By.xpath("//*[@id=\'confirm\']");
    By contrasena = By.xpath( "//*[@id=\'password\']");
    By nombre = By.xpath("//*[@id='displayname']");
    By dia = By.xpath("//*[@id=\'day\']");
    By mes = By.xpath("//*[@id=\'month\']");
    By anio = By.xpath("//*[@id=\'year\']");
    By genero = By.xpath("//span[contains(text(),'Prefiero no responder')]");
    By ingresar = By.cssSelector("div.encore-light-theme:nth-child(2) div.indexpage__Signup-zyim1e-0.kSgpSo form:nth-child(7) div.EmailForm__Center-jwtojv-0.bTvwxQ:nth-child(9) div.SignupButton__ButtonContainerSignup-cjcq5h-0.jxMjKv:nth-child(3) button.Button-sc-qlcn5g-0.kHvryD > span.ButtonInner-sc-14ud5tc-0.dqLIWu.encore-bright-accent-set.SignupButton___StyledButtonPrimary-cjcq5h-1.jazsmO");

    public void registro (){
espera();
escribir("luciaa@lariojaa.com",correo);
        exist(confirmarcorreo);
        escribir("Abcaadgdfafdfgd123",contrasena);
        escribir("lucia",nombre);
        escribir("4",dia);
        escribir("Noviembre",mes);
        escribir("2000",anio);
        scroll(genero);
        clickear(genero);
        scroll(ingresar);
        clickear(ingresar);
    }
}
