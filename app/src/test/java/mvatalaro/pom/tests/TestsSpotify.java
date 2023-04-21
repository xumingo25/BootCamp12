package mvatalaro.pom.tests;

import mvatalaro.pom.base.TestBase;
import mvatalaro.pom.pages.HomePage;
import mvatalaro.pom.pages.RegisterPage;
import mvatalaro.pom.utilities.ManejoEncodingUFT8;
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
                ("domingo.saavedra.saavedra@gmail.com",
                        "domingo.saavedra.saavedra@gmail.com",
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
