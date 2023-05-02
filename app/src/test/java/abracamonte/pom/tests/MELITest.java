package abracamonte.pom.tests;

import abracamonte.pom.pages.BusquedaPageMeli;
import abracamonte.pom.pages.ComprarAhoraPage;
import abracamonte.pom.pages.ProductoBuscadoPage;
import abracamonte.pom.pages.HomePageMELI;
import dsaavedra.pom.base.TestBase;
import dsaavedra.pom.utilities.ManejoEncodingUFT8;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class MELITest extends TestBase {

    HomePageMELI homePageMELI;

    BusquedaPageMeli busquedaPageMeli;
     ProductoBuscadoPage productoBuscadoPage;

     ComprarAhoraPage comprarAhoraPage;

     @Test
    public void CP001_BusquedaMeli() throws IOException {
         homePageMELI= new HomePageMELI(super.driver);
         busquedaPageMeli= new BusquedaPageMeli(super.driver);
         productoBuscadoPage= new ProductoBuscadoPage(super.driver);
         comprarAhoraPage=new ComprarAhoraPage(super.driver);

         homePageMELI.navegarAPagina("https://mercadolibre.com.ar/");
         homePageMELI.capturaPantalla("captura_"+ homePageMELI.toString()+".png", driver);
         homePageMELI.buscarProducto("calefaccion magiclick blanco");

         busquedaPageMeli.capturaPantalla("captura_"+ busquedaPageMeli.toString()+".png", driver);
         busquedaPageMeli.buscarProductoMeli();

         productoBuscadoPage.capturaPantalla("captura_"+ productoBuscadoPage.toString()+".png", driver);
         productoBuscadoPage.clikearComprarAhora();

         comprarAhoraPage.obtenerMensaje();
         comprarAhoraPage.capturaPantalla("captura_"+ comprarAhoraPage.toString()+".png", driver);

         Assertions.assertEquals(comprarAhoraPage.obtenerMensaje(), ManejoEncodingUFT8.fixEncoding("¡Hola! Para comprar, ingresá a tu cuenta"));
     }



}
