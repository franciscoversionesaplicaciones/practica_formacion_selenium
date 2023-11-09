package apps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoogleHomePage extends Base{
    //Variable que almacena el nombre del producto que se va a buscar
    String nombreProducto="compresor eléctrico";
    //Localizador del botón para aceptar cookies de Google
    By botonAceptCookies = By.id("L2AGLb");
    //Localizador del buscador de Google
    By buscadorGoogle = By.id("APjFqb");
    //Localizador del checkbox entregas Prime
    By prime = By.id("apb-browse-refinements-checkbox_31");
    //Localizador del despegable de opciones para ordenar
    By iconoDesplegableOrdenar = By.xpath("//span[text()='Ordenar por:']");
    //Localizador de la opción para ordenar de menor a mayor precio
    By menorAMayor = By.id("s-result-sort-select_1");
    By nombresProductos = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
    By precioEnteros=By.xpath("//span[@class='a-price-whole']");
    By precioDecimales=By.xpath("//span[@class='a-price-fraction']");
    By monedas=By.xpath("//span[@class='a-price-symbol']");
    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public void aceptaCookiesGoogle(WebDriver driver) {
        WebDriverWait wait=new WebDriverWait(driver, 10);
        WebElement botAcepCook = findElement(botonAceptCookies);
        Actions scrollVertical = new Actions(driver);
        scrollVertical.scrollToElement(botAcepCook).perform();
        wait.until(ExpectedConditions.elementToBeClickable(botAcepCook));
        botAcepCook.click();
    }
    public void buscaEnGoogle(){
        WebElement buscGoogl = findElement(buscadorGoogle);
        buscGoogl.sendKeys(nombreProducto);
        buscGoogl.submit();
    }
    public void filtraPrime(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver, 10);
        WebElement prim = findElement(prime);
        Actions scrollVertic = new Actions(driver);
        scrollVertic.scrollToElement(prim).perform();
        wait.until(ExpectedConditions.elementToBeClickable(prim));
        Actions act = new Actions(driver);
        act.doubleClick(prim).perform();
    }
    public void precioMenorAMayor(){
        WebElement iconDespOrd = findElement(iconoDesplegableOrdenar);
        iconDespOrd.click();
        WebElement menAMay = findElement(menorAMayor);
        menAMay.click();
    }
    //Método para mostrar por consola los nombres y los precios de los productos del listado
    public void imprimeNombresYPrecios(){
        List<WebElement> nombProductos = findElements(nombresProductos);
        List<WebElement> precEnt = findElements(precioEnteros);
        List<WebElement> precDec = findElements(precioDecimales);
        List<WebElement> moned = findElements(monedas);
        for (int i = 0; i < nombProductos.size(); i++) {
            System.out.println("Producto: " + nombProductos.get(i).getText());
            System.out.println("Precio: " + precEnt.get(i).getText()+","+precDec.get(i).getText()+moned.get(i).getText());
        }
    }
}
