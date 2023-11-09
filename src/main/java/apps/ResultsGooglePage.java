package apps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsGooglePage extends Base{

    /*Localizador del primer producto de compresor eléctrico de Amazon que se muestra al buscar compresor eléctrico
    en Google*/
    By enlaceProductoAmazon = By.xpath("//img[@alt='Imagen de Cecotec Compresor de Aire Eléctrico Portátil Air Max, Inflador, 50 W, 16000 rpm, Apto para Coches, Motos, Bicicletas, Patinetes y Balones, 7.4 V y']");
    //Localizador del enlace de compresores eléctricos de Amazon que se muestra al buscar compresor eléctrico en Google
    By enlaceAmazon = By.xpath("//a[@href='https://www.amazon.es/compresores-aire/b?ie=UTF8&node=3049705031']");
    public ResultsGooglePage(WebDriver driver) {
        super(driver);
    }
    /*Método para pulsar sobre el primer producto de compresor eléctrico de Amazon que se muestra al buscar compresor eléctrico
    en Google*/
    public void seleccionaProductoAmazon(){
        WebElement enlProdAmaz = findElement(enlaceProductoAmazon);
        try{
            click(enlProdAmaz);
        }catch (Exception e){
            System.out.println("Error al intentar acceder a la página del producto: "+e.getMessage());
        }
    }

    //Método para pulsar en el enlace de compresores eléctricos de Amazon que se muestra al buscar compresor eléctrico en Google
    public void seleccionaEnlaceAmazon(WebDriver driver) {
        WebDriverWait wait=new WebDriverWait(driver, 10);
        WebElement enlacAmaz = findElement(enlaceAmazon);
        Actions scrollVertical = new Actions(driver);
        try{
            scrollVertical.scrollToElement(enlacAmaz).perform();
            wait.until(ExpectedConditions.elementToBeClickable(enlacAmaz));
            click(enlacAmaz);
        }catch(Exception e){
            System.out.println("Error al intentar acceder a la página del listado de productos: "+e.getMessage());
        }

    }
}
