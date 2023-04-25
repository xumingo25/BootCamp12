package csalgan.pom.test.TestsSpotify;

import csalgan.pom.base.TestBase;
import csalgan.pom.pages.SpotifyPage.HomePage;
import csalgan.pom.pages.SpotifyPage.RegisterPage;
import csalgan.pom.utilities.ManejoEncodingUFT8;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsSpotify extends TestBase {
    HomePage homePage;
    RegisterPage registerPage;

    @Test
    public void CP001_FormularioOK(){
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistro
                ("prueba123453321@gmail.com",
                        "prueba123453321@gmail.com",
                        "F+++21312",
                        "Pobre Domingo",
                        "28",
                        "Febrero",
                        "1991",
                        "hombre",
                        true,
                        true);
    }

    @Test
    public void CP001_FormularioNOOK_CorreoExistente(){
        homePage = new HomePage(super.driver);
        registerPage = new RegisterPage(super.driver);
        homePage.navegarAPagina("https://www.spotify.com/");
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistro
                ("alexandrasalgan@gmail.com",
                        "alexandrasalgan@gmail.com",
                        "F+++21312",
                        "Pobre Domingo",
                        "28",
                        "Febrero",
                        "1991",
                        "hombre",
                        true,
                        true);
        Assertions.assertEquals(registerPage.obtenerErrorCorreoUtilizado(), ManejoEncodingUFT8.fixEncoding("Este correo electrónico ya está conectado a una cuenta. Inicia sesión."));
    }

}

