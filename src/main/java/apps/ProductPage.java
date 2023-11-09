package apps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends Base {
    //Localizador del botón de aceptar Cookies de Amazon
    By botonAceptarCookiesAmazon = By.xpath("//input[@name='accept']");
    By precioEntero = By.xpath("//span[@class='a-price-whole']");
    By precioDecimal = By.xpath("//span[@class='a-price-fraction']");
    By moneda = By.xpath("//span[@class='a-price-symbol']");
    By fecha = By.xpath("//*[@id='mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE']//span[@class='a-text-bold']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    //Método para cambiar a la segunda pestaña del navegador
    public void cambiaAPestanaNavegador(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("Cecotec Compresor de Aire Eléctrico Portátil Air Max, Inflador, 50 W, 16000 rpm, Apto para Coches, Motos, Bicicletas, Patinetes y Balones, 7.4 V y 2000 mAh x 2 de Capacidad de Batería, Compacto : Amazon.es: Coche y moto")) {
                break;
            }
        }
    }

    //Método para aceptar las Cookies de Amazon
    public void aceptaCookiesAmazon() {
        WebElement botAcepCookAmaz = findElement(botonAceptarCookiesAmazon);
        botAcepCookAmaz.click();
    }

    //Método para mostrar por consola el precio y la fecha del producto
    public void imprimePrecioYFecha() {
        WebElement precEnt = findElement(precioEntero);
        WebElement precDecim = findElement(precioDecimal);
        WebElement moned = findElement(moneda);
        WebElement fech = findElement(fecha);
        System.out.println(precEnt.getText() + "," + precDecim.getText() + moned.getText());
        System.out.println(fech.getText());
        System.out.println("----------------------------------------------");
    }
}
