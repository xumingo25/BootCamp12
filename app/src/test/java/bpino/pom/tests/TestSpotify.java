package bpino.pom.tests;

import bpino.pom.base.TestBase;
import bpino.pom.pages.HomePage;
import bpino.pom.pages.RegistrarPage;
import org.junit.jupiter.api.Test;

public class TestSpotify extends TestBase {
    HomePage homePage = new HomePage(super.driver);
    RegistrarPage registrarPage = new RegistrarPage(super.driver);

    @Test
    public void CP001_FormularioOK(){
        homePage.irARegistrarte();
        registrarPage.completarFormularioRegistro("pajaritosfelices@pio.com",
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
