package dpites.pom.tests;

import dsaavedra.pom.base.TestBase;
import dsaavedra.pom.pages.HomePage;
import dsaavedra.pom.pages.RegisterPage;
import dsaavedra.pom.utilities.ManejoEncodingUFT8;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSpotify extends TestBase {
    HomePage homePage;
    RegisterPage registerPage;

    @Test
    public void CP001_FormularioOK(){
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistro
                ("FakeAccount4040@gmail.com",
                        "FakeAccount4040@gmail.com",
                        "Aa11!@KkPp_",
                        "FakeAccount40",
                        "28",
                        "Abril",
                        "1995",
                        "Mujer",
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
                ("FakeAccount4040@gmail.com",
                        "FakeAccount4040@gmail.com",
                        "Aa11!@KkPp_",
                        "FakeAccount40",
                        "28",
                        "Abril",
                        "1995",
                        "Mujer",
                        true,
                        true);
        Assertions.assertEquals(registerPage.obtenerErrorCorreoUtilizado(), ManejoEncodingUFT8.fixEncoding("Este correo electrónico ya está conectado a una cuenta. Inicia sesión."));
    }

}