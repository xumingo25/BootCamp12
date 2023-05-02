package fbazan.pom.tests.spotify;

import fbazan.pom.base.TestBase;
import fbazan.pom.pages.spotify.HomePage;
import fbazan.pom.pages.spotify.RegisterPage;
import fbazan.pom.utilities.ManejoEncodingUFT8;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSpotify extends TestBase {

    HomePage homePage;
    RegisterPage registerPage;

    @Test
    public void CP001_FormularioOK(){
        homePage = new HomePage(super.driver);
        registerPage = new RegisterPage(super.driver);
        homePage.navergarPagina("https://open.spotify.com/");

        homePage.irARegistrarte();
        registerPage.completarFormularioRegister
                ("usuario2@gmail.com",
                        "usuario2@gmail.com",
                        "123ABC.",
                        "Usuario2",
                        "23",
                        "Abril",
                        "1991",
                        "mujer",
                        true,
                        true);
    }

    @Test
    public void CP001_FormularioNOOK_correoExistente(){
        homePage = new HomePage(super.driver);
        registerPage = new RegisterPage(super.driver);
        homePage.navergarPagina("https://open.spotify.com/");

        homePage.irARegistrarte();
        registerPage.completarFormularioRegister
                ("usuario@gmail.com",
                        "usuario@gmail.com",
                        "123ABC.",
                        "Usuario2",
                        "23",
                        "Abril",
                        "1991",
                        "mujer",
                        true,
                        true);

        Assertions.assertEquals(registerPage.obtenerErrorCorreoCorreoUtilizado(), ManejoEncodingUFT8.fixEncoding("Este correo electrónico ya está asociado a una cuenta. Inicia sesión."));
    }
}
