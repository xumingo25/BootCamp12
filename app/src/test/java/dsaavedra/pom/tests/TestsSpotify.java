package dsaavedra.pom.tests;

import dsaavedra.pom.base.TestBase;
import dsaavedra.pom.pages.HomePageSpotify;
import dsaavedra.pom.pages.RegisterPageSpotify;
import dsaavedra.pom.utilities.ManejoEncodingUFT8;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsSpotify extends TestBase {
    HomePageSpotify homePageSpotify;
    RegisterPageSpotify registerPageSpotify;

    @Test
    public void CP001_FormularioOK(){
        homePageSpotify.irARegistrarte();
        registerPageSpotify.completarFormularioRegistro
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
        homePageSpotify = new HomePageSpotify(super.driver);
        registerPageSpotify = new RegisterPageSpotify(super.driver);
        homePageSpotify.navegarAPagina("https://www.spotify.com/");
        homePageSpotify.irARegistrarte();
        registerPageSpotify.completarFormularioRegistro
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
        Assertions.assertEquals(registerPageSpotify.obtenerErrorCorreoUtilizado(), ManejoEncodingUFT8.fixEncoding("Este correo electrónico ya está conectado a una cuenta. Inicia sesión."));
    }

}
