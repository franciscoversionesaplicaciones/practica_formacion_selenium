package apps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsGooglePage extends Base{
    /*Localizador del primer producto de compresor eléctrico de Amazon que se muestra al buscar compresor eléctrico
    en Google*/
    By enlaceProductoAmazon=By.xpath("//img[@alt='Imagen de Cecotec Compresor de Aire Eléctrico Portátil Air Max, Inflador, 50 W, 16000 rpm, Apto para Coches, Motos, Bicicletas, Patinetes y Balones, 7.4 V y']");
    //Localizador del enlace de compresores eléctricos de Amazon que se muestra al buscar compresor eléctrico en Google
    By enlaceAmazon=By.xpath("//h3[text()='Compresores de aire: Bricolaje y herramientas']");
    public ResultsGooglePage(WebDriver driver) {
        super(driver);
    }
    /*Método para pulsar sobre el primer producto de compresor eléctrico de Amazon que se muestra al buscar compresor eléctrico
    en Google*/
    public void seleccionaProducto(){
        try{
            click(enlaceProductoAmazon);
        }catch (Exception e){
            System.out.println("Error al intentar acceder a la página del producto: "+e.getMessage());
        }
    }
    //Método para pulsar en el enlace de compresores eléctricos de Amazon que se muestra al buscar compresor eléctrico en Google
    public void seleccionaEnlaceAmazon() {
        try{
            click(enlaceAmazon);
        }catch(Exception e){
            System.out.println("Error al intentar acceder a la página del listado de productos: "+e.getMessage());
        }

    }
}
