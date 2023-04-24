package abracamonte.pom.tests;

import abracamonte.pom.pages.RegisterPage;
import dsaavedra.pom.base.TestBase;
import dsaavedra.pom.pages.HomePageSpotify;
import dsaavedra.pom.utilities.ManejoEncodingUFT8;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpotifyTest extends TestBase {
    HomePageSpotify homePageSpotify;
    RegisterPage registerPage;

    @Test
    public void CP001_FormOK(){
        homePageSpotify = new HomePageSpotify(super.driver);
        registerPage = new RegisterPage(super.driver);
        homePageSpotify.navegarAPagina("https://www.spotify.com/");
        homePageSpotify.irARegistrarte();
        registerPage.llenarFormularioRegistro("esuncorreo@gmail.com", "esuncorreo@gmail.com",
                "esunaclave 12345", "Es un apodo", "1",
                "Septiembre", "1950", "otro", true, true);
    }

    @Test
    public void CP002_FormNoOK_Email(){
        homePageSpotify = new HomePageSpotify(super.driver);
        registerPage = new RegisterPage(super.driver);
        homePageSpotify.navegarAPagina("https://www.spotify.com/");
        homePageSpotify.irARegistrarte();
        registerPage.llenarFormularioRegistro("esuncorreo@gmail.com", "esuncorreo@gmail.com",
                "esunaclave 12345", "Es un apodo", "1",
                "Septiembre", "1950", "otro", true, true);

        Assertions.assertEquals(registerPage.obtenerErrorCorreoUtilizado(), ManejoEncodingUFT8.fixEncoding("Este correo electrónico ya está conectado a una cuenta. Inicia sesión."));
    }

    @Test
    public void CP003_FormNoOK_Clave_Email(){
        homePageSpotify = new HomePageSpotify(super.driver);
        registerPage = new RegisterPage(super.driver);
        homePageSpotify.navegarAPagina("https://www.spotify.com/");
        homePageSpotify.irARegistrarte();
        registerPage.llenarFormularioRegistro("esuncorreo@gmail.com", "esuncorreo@gmail.com",
                "clave", "Es un apodo", "1",
                "Septiembre", "1950", "otro", true, true);

        Assertions.assertEquals(registerPage.obtenerErrorCorreoUtilizado(), ManejoEncodingUFT8.fixEncoding("Este correo electrónico ya está conectado a una cuenta. Inicia sesión."));

        Assertions.assertEquals(registerPage.obtenerErrorClaveMuyCorta(), ManejoEncodingUFT8.fixEncoding("Tu contraseña es demasiado corta."));
    }
}
