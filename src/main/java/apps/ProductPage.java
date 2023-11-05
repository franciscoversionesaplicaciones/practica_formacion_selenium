package apps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends Base{
    //Localizador del botón de aceptar Cookies de Amazon
    By aceptaCookies=By.xpath("//input[@name='accept']");
    By precio=By.xpath("//*[@id='corePrice_feature_div']//span[@class='a-offscreen']");
    By fecha=By.xpath("//*[@id='mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE']//span[@class='a-text-bold']");
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    //Método para aceptar las Cookies de Amazon
    public void aceptaCookiesAmazon(){
        WebElement element=findElement(aceptaCookies);
        click(element);
    }
    //Método para mostrar por consola el precio y la fecha del producto
    public void imprimePrecioYFecha() {
        String prec, fech;
        prec=getText(precio);
        fech=getText(fecha);
        System.out.println(prec);
        System.out.println(fech);
    }
}
