package apps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class GoogleHomePage extends Base{
    //Variable que almacena el nombre del producto que se va a buscar
    String producto="compresor eléctrico";
    //Localizador del botón para rechazar cookies de Google
    By rechazarCookies=By.id("W0wltc");
    //Localizador del buscador de Google
    By buscadorGoogle=By.id("APjFqb");
    //Localizador del checkbox entregas Prime
    By entregasPrime=By.xpath("//*[@id='p_90/6820340031']//input[@type='checkbox']");
    //Localizador del despegable de opciones para ordenar
    By iconoDesplegableOrdenar=By.xpath("//*[@id=\"a-autoid-8\"]//i[@class='a-icon a-icon-dropdown']");
    //Localizador de la opción para ordenar de menor a mayor precio
    By menorAMayor=By.id("//*[@id='s-result-sort-select_1']");
    By nombresProductos=By.xpath("//div[@class='a-section a-spacing-base']//span[@class='a-size-base-plus a-color-base a-text-normal']");
    By preciosProductos=By.xpath("//div[@class='a-section a-spacing-base']//span[@class='a-price']//span[@class='a-offscreen']");
    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public void buscadorGoogle() {
        //Método para rechazar Cookies de Google
        click(rechazarCookies);
        //Método para escribir el nombre del producto y pulsar enter en el buscador de Google
        setValue(producto,buscadorGoogle);
    }
    public void filtraPrime(){
        //Método para marcar el checkbox de la opción entregas Prime
        click(entregasPrime);
    }
    public void ordenar(){
        //Método para abrir el desplegable de opciones para ordenar
        click(iconoDesplegableOrdenar);
        //Método para seleccionar la opción de ordenar de menor a mayor precio
        click(menorAMayor);
    }
    //Método para mostrar por consola los nombres y los precios de los productos del listado
    public void imprimeNombresYPrecios(){
        List<WebElement> nombProductos=findElements(nombresProductos);
        List<WebElement>precProductos=findElements(preciosProductos);
        for(int i=0;i< nombProductos.size();i++){
            System.out.println("Producto: "+nombProductos.get(i));
            System.out.println("Precio: "+precProductos.get(i));
        }
    }
}
