package fbazan.pom.tests.meli;

import fbazan.pom.base.TestBase;
import fbazan.pom.pages.meli.HomePage;
import org.junit.jupiter.api.Test;

public class TestMeli extends TestBase {

    HomePage homePage;


    @Test
    public void CP002_buscaProducto_OK() throws InterruptedException {
        homePage = new fbazan.pom.pages.meli.HomePage(super.driver);
        homePage.navergarPagina("https://www.mercadolibre.com.ar/");
        driver.manage().deleteAllCookies();
        homePage.buscarProducto("celular");
        Thread.sleep(2000);

    }
}