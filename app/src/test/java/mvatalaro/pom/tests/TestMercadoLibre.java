package mvatalaro.pom.tests;

import mvatalaro.pom.base.TestBase;
import mvatalaro.pom.pages.HerramientasPage;
import mvatalaro.pom.pages.HomePageML;
import mvatalaro.pom.pages.ProductoSeleccionadoPage;
import mvatalaro.pom.utilities.ManejoEncodingUFT8;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMercadoLibre extends TestBase {

    HomePageML homePageML;

    HerramientasPage herramientasPage;

    ProductoSeleccionadoPage productoPage;

    @Test
    public void CP001_CompraDebeLoguearse(){
        homePageML= new HomePageML(super.driver);
        herramientasPage= new HerramientasPage(super.driver);
        productoPage= new ProductoSeleccionadoPage(super.driver);
        homePageML.navegarAPagina("https://www.mercadolibre.com.ar/");
        homePageML.irACategoriaSeleccionada();
        herramientasPage.seleccionarPageHerramientas();
        productoPage.seleccionarProductoYComprar();

        Assertions.assertEquals(productoPage.obtenerErrorporFaltaLogin(), ManejoEncodingUFT8.fixEncoding("¡Hola! Para comprar, ingresá a tu cuenta"));
    }

}
