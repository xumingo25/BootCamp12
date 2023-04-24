package bpino.pom.tests.meli;

import bpino.pom.base.TestBase;
import bpino.pom.pages.meli.HomePage;
import bpino.pom.pages.meli.LoginPage;
import bpino.pom.pages.meli.ProductPage;
import bpino.pom.pages.meli.SearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static bpino.pom.utilities.ManejoEncodingUFT8.fixEncoding;

public class TestMeli extends TestBase {
    HomePage homePage;
    SearchPage searchPage;
    ProductPage productPage;
    LoginPage loginPage;

    @Test
    public void CP001_BuscarOK(){
        homePage = new HomePage(super.driver);
        searchPage = new SearchPage(super.driver);
        productPage = new ProductPage(super.driver);
        loginPage = new LoginPage(super.driver);
        homePage.navegarAPagina("https://www.mercadolibre.cl/");
        homePage.buscarProducto("Bastones Trekking");
        searchPage.seleccionProducto();
        productPage.comprarProducto();
        Assertions.assertEquals(loginPage.textoObtenido(), fixEncoding("¡Hola! Para comprar, ingresa a tu cuenta"));
    }
}
