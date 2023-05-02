package fbenavides.pom.tests.Meli;

import fbenavides.pom.pages.Meli.HomePage;
import fbenavides.pom.pages.Meli.ResultsPage;
import fbenavides.pom.pages.Meli.ArticlePage;
import fbenavides.pom.pages.Meli.AccessPage;
import fbenavides.pom.utilities.ManejoEncodingUFT8;
import fbenavides.pom.base.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMeli extends TestBase {

    HomePage homePage;
    ResultsPage resultsPage;
    ArticlePage articlePage;
    AccessPage accessPage;

    @Test
    public void CP001_BuscarProducto() {
        homePage = new HomePage(super.driver);
        resultsPage = new ResultsPage(super.driver);
        articlePage = new ArticlePage(super.driver);
        accessPage = new AccessPage(super.driver);
        homePage.navegarAPagina("https://www.mercadolibre.cl/");
        homePage.irABuscador("cd starboy the weeknd");
        resultsPage.seleccionarProducto();
        articlePage.comprarProducto();
        Assertions.assertEquals(accessPage.obtenerTxtAcceso(), ManejoEncodingUFT8.fixEncoding("¡Hola! Para comprar, ingresa a tu cuenta"));

    }
}
