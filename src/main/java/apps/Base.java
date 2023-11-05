package apps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Base {
    private WebDriver driver;
    private WebDriverWait wait;
    public Base(WebDriver driver){
        this.driver=driver;
    }
    public WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    public WebElement findElement (By locator){
        return driver.findElement(locator);
    }
    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }
    public String getText(WebElement element){
        return element.getText();
    }
    public String getText(By locator){
        return driver.findElement(locator).getText();
    }
    public String getValue(By locator){
        return driver.findElement(locator).getAttribute("value");
    }
    public void type(String inputText,By locator){
        driver.findElement(locator).sendKeys(inputText);
    }
    public void click(By locator){
        driver.findElement(locator).click();
    }
    public void click(WebElement element){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public String click(List<WebElement> elements, int index){
        String radio=elements.get(index).getAttribute("value");
        elements.get(index).click();
        return radio;
    }
    public void setValue(String value,By locator){
        WebElement element=findElement(locator);
        element.sendKeys(value);
        element.submit();
    }
    public String selectCombo(String value,By locator){
        WebElement element=findElement(locator);
        Select dropdown=new Select(element);
        dropdown.selectByValue(value);
        return value;
    }
    public void setKeys(WebElement elemento, String texto){
        elemento.sendKeys(texto);
    }
    public Boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        }catch(org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
    public void visit (String url){
        try{
            driver.get(url);
        }catch (Exception e){
            System.out.println("Error al intentar acceder a la página de Google.");
        }
    }
    public int aleatorio(int max){
        int aleat=(int)(Math.random()*max);
        return aleat;
    }
}
