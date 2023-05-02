package bpino.pom.tests.spotify;

import bpino.pom.base.TestBase;
import bpino.pom.pages.spotify.HomePage;
import bpino.pom.pages.spotify.RegisterPage;
import dsaavedra.pom.utilities.ManejoEncodingUFT8;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSpotify extends TestBase {
    HomePage homePage;
    RegisterPage registerPage;

    @Test
    public void CP001_FormularioOK(){
        homePage = new HomePage(super.driver);
        registerPage = new RegisterPage(super.driver);
        homePage.navegarAPagina("https://open.spotify.com/");
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistro(
                "pajaritosfelices@pio.com",
                "pajaritosfelices@pio.com",
                "243423",
                "Pajarito",
                "11",
                "Abril",
                "1990",
                "no binario",
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
                ("piopio@gmail.com",
                        "piopio@gmail.com",
                        "12312",
                        "Pio",
                        "23",
                        "Mayo",
                        "1998",
                        "otro",
                        true,
                        true);
        Assertions.assertEquals(registerPage.obtenerErrorCorreoUtilizado(), ManejoEncodingUFT8.fixEncoding("Este correo electrónico ya está conectado a una cuenta. Inicia sesión."));
    }
}
