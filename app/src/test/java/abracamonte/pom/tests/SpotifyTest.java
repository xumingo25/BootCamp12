package abracamonte.pom.tests;

import abracamonte.pom.pages.RegisterPage;
import dsaavedra.pom.base.TestBase;
import dsaavedra.pom.pages.HomePage;
import org.junit.jupiter.api.Test;

public class SpotifyTest extends TestBase {
    HomePage homePage;
    RegisterPage registerPage;

    @Test
    public void CP001_FormOK(){
        homePage = new HomePage(super.driver);
        registerPage = new RegisterPage(super.driver);
        homePage.navegarAPagina("https://www.spotify.com/");
        homePage.irARegistrarte();
        registerPage.llenarFormularioRegistro("esuncorreo@gmail.com", "esuncorreo@gmail.com",
                "esunaclave 12345", "Es un apodo", "1",
                "Septiembre", "1950", "otro", true, true);
    }
}
