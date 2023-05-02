package csalgan.pom.test.TestML;

import csalgan.pom.base.TestBase;
import csalgan.pom.pages.MLPage.HomePage;
import org.junit.jupiter.api.Test;


public class TestsML extends TestBase{
    //atributos
    HomePage homePage;

    //metodos
    @Test
    public void CP001_BusquedaExitosa(){
        homePage= new HomePage(super.driver);
        homePage.navegarAPagina("https://www.mercadolibre.com.ar/");
        homePage.buscarCategoria("mascotas");
        homePage.navegarPorProductos();

    }


}
