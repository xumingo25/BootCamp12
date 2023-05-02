package pcontreras.pom.tests;


import org.junit.jupiter.api.Assertions;
import pcontreras.pom.base.TestBase;
import pcontreras.pom.pages.HomePage;
import  pcontreras.pom.pages.RegisterPage;
import org.junit.jupiter.api.Test;

public class TestSpotify extends TestBase {
    HomePage homePage = new HomePage;
    RegisterPage registerPage = new RegisterPage;

    @Test
    public void CP001_FormularioOK(){
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistro
                ("prueba1234@gmail.com",
                        "prueba1234@gmail.com",
                        "12342121PACM",
                        "Pepe Tapia",
                        "17",
                        "Febrero",
                        "1994",
                        "Hombre",
                        true,
                        true);
        String resultadoEsperado = "";

        Assertions.assertEquals(registerPage.obtenerErrorCorreoUtilizado(),resultadoEsperado);
    }
}//fin clase
