package pages;

import frameworks.core.webui.WebUIKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemDetails {
    WebDriver driver;

//    @FindBy(xpath = "//*[@data-property=\"机身颜色\"]/li[1]")
//    private WebElement li_firstColor;
//
//    @FindBy(xpath = "//*[@data-property=\"存储容量\"]/li[1]")
//    private WebElement li_firstSize;
//
//    @FindBy(xpath = "//*[@data-property=\"存储容量\"]/li[2]")
//    private WebElement li_secondSize;
//
//    @FindBy(xpath = "//*[@class=\"tm-clear\"]/li[1]")
//    private WebElement li_firstPayment;
//
//    @FindBy(id = "J_LinkBasket")
//    private WebElement button_addToCart;
//
//    @FindBy(xpath = "//*[@class = \"sn-cart-link\"]")
//    private WebElement button_cart;

    By byFirstColor = By.xpath("//*[@data-property=\"机身颜色\"]/li[1]");
    By byFirstSize = By.xpath("//*[@data-property=\"存储容量\"]/li[1]");
    By bySecondSize = By.xpath("//*[@data-property=\"存储容量\"]/li[2]");
    By byFirstPayment = By.xpath("//*[@class=\"tm-clear\"]/li[1]");
    By byAddToCart = By.id("J_LinkBasket");
    By byCart = By.xpath("//*[@class = \"sn-cart-link\"]");

    public ItemDetails(WebDriver driver){
        this.driver = driver;
    }

    public void addItemIntoCart(){
        WebUIKeywords.click(driver.findElement(byFirstColor));
        WebUIKeywords.click(driver.findElement(byFirstSize));
        WebUIKeywords.click(driver.findElement(byFirstPayment));
        WebUIKeywords.click(driver.findElement(byAddToCart));
    }

    public void goToCart(){
        WebUIKeywords.click(driver.findElement(byCart));
    }

    public void addSecondItemIntoCart(){
        WebUIKeywords.click(driver.findElement(bySecondSize));
        WebUIKeywords.click(driver.findElement(byAddToCart));
    }
}
