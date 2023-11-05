package tests;

import org.openqa.selenium.WebDriver;
import apps.*;

import java.sql.Driver;

public class TestPracticaAmazon {
    private static WebDriver driver;
    public static void main(String[] args) {
        setup();
    }
    public static void setup() {
        Base base=new Base(driver);
        driver=base.chromeDriverConnection();
        base.visit("https://google.es");
        GoogleHomePage homepage=new GoogleHomePage(driver);
        homepage.buscadorGoogle();
        ResultsGooglePage results=new ResultsGooglePage(driver);
        results.seleccionaProducto();
        ProductPage product=new ProductPage(driver);
        product.aceptaCookiesAmazon();
        product.imprimePrecioYFecha();
        base.visit("https://google.es");
        homepage.buscadorGoogle();
        results.seleccionaEnlaceAmazon();
        homepage.filtraPrime();
        homepage.ordenar();
        homepage.imprimeNombresYPrecios();
    }
}
