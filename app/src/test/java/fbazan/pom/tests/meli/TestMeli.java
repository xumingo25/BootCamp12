package fbazan.pom.tests.meli;

import fbazan.pom.base.TestBase;
import fbazan.pom.pages.meli.HomePage;
import fbazan.pom.pages.spotify.RegisterPage;
import org.junit.jupiter.api.Test;

public class TestMeli extends TestBase {

    HomePage homePage;

    @Test
    public void CP002_buscaProducto_OK() {
        homePage = new fbazan.pom.pages.meli.HomePage(super.driver);
        homePage.navergarPagina("https://www.mercadolibre.com.ar/");
        homePage.buscarProducto("cascos");

    }
}