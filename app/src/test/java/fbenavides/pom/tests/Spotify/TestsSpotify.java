package fbenavides.pom.tests.Spotify;

import fbenavides.pom.pages.Spotify.HomePage;
import fbenavides.pom.pages.Spotify.RegisterPage;
import fbenavides.pom.utilities.ManejoEncodingUFT8;
import fbenavides.pom.base.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsSpotify extends TestBase {

    HomePage homePage;
    RegisterPage registerPage;

    @Test
    public void CP001_FormularioOK(){
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistro
                ("pruebanumero100000paraspotifyBC@yopmail.net",
                        "pruebanumero100000paraspotifyBC@yopmail.net",
                        "Estaesmiclaveasies1",
                        "Fran Bc",
                        "08",
                        "Enero",
                        "1993",
                        "mujer",
                        true,
                        false);
    }

    @Test
    public void CP001_FormularioNOOK_CorreoExistente(){
        homePage = new HomePage(super.driver);
        registerPage = new RegisterPage(super.driver);
        homePage.navegarAPagina("https://www.spotify.com/");
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistro
                ("pruebaSpotifyBootcamp12cl@yopmail.net",
                        "pruebaSpotifyBootcamp12cl@yopmail.net",
                        "Estaesmiclaveasies1",
                        "Fran Bc",
                        "08",
                        "Enero",
                        "1993",
                        "mujer",
                        true,
                        false);
        Assertions.assertEquals(registerPage.obtenerErrorCorreoUtilizado(), ManejoEncodingUFT8.fixEncoding("Este correo electrónico ya está conectado a una cuenta. Inicia sesión."));
    }

}
