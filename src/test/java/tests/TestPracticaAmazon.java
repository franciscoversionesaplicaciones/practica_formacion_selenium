package tests;

import org.openqa.selenium.WebDriver;
import apps.*;

public class TestPracticaAmazon {
    private static WebDriver driver;

    public static void main(String[] args) {
        setup();
    }

    public static void setup() {
        Base base = new Base(driver);
        driver = base.chromeDriverConnection();
        base.visit("https://google.es");
        GoogleHomePage homepage = new GoogleHomePage(driver);
        homepage.aceptaCookiesGoogle(driver);
        homepage.buscaEnGoogle();
        ResultsGooglePage results = new ResultsGooglePage(driver);
        results.seleccionaProductoAmazon();
        ProductPage product = new ProductPage(driver);
        product.cambiaAPestanaNavegador(driver);
        product.aceptaCookiesAmazon();
        product.imprimePrecioYFecha();
        base.visit("https://google.es");
        homepage.buscaEnGoogle();
        results.seleccionaEnlaceAmazon(driver);
        product.cambiaAPestanaNavegador(driver);
        homepage.filtraPrime(driver);
        homepage.precioMenorAMayor();
        homepage.imprimeNombresYPrecios();
    }
}
