package bpino.pom.tests;

import bpino.pom.base.TestBase;
import bpino.pom.pages.spotify.HomePage;
import bpino.pom.pages.spotify.RegisterPage;
import org.junit.jupiter.api.Test;

public class TestSpotify extends TestBase {
    HomePage homePage;
    RegisterPage registrarPage;

    @Test
    public void CP001_FormularioOK(){
        homePage = new HomePage(super.driver);
        registrarPage = new RegisterPage(super.driver);
        homePage.navegarAPagina("https://open.spotify.com/");
        homePage.irARegistrarte();
        registrarPage.completarFormularioRegistro(
                "pajaritosfelices@pio.com",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                true,
                true);
    }
}
