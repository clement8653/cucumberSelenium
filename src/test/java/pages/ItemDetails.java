package pages;

import frameworks.core.webui.WebUIKeywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemDetails {
    WebDriver driver;

    @FindBy(xpath = "//*[@data-property=\"机身颜色\"]/li[1]")
    private WebElement li_firstColor;

    @FindBy(xpath = "//*[@data-property=\"存储容量\"]/li[1]")
    private WebElement li_firstSize;

    @FindBy(xpath = "//*[@data-property=\"存储容量\"]/li[2]")
    private WebElement li_secondSize;

    @FindBy(xpath = "//*[@class=\"tm-clear\"]/li[1]")
    private WebElement li_firstPayment;

    @FindBy(id = "J_LinkBasket")
    private WebElement button_addToCart;

    @FindBy(xpath = "//*[@class = \"sn-cart-link\"]")
    private WebElement button_cart;

    public ItemDetails(WebDriver driver){
        this.driver = driver;
    }

    public void addItemIntoCart(){
        WebUIKeywords.click(li_firstColor);
        WebUIKeywords.click(li_firstSize);
        WebUIKeywords.click(li_firstPayment);
        WebUIKeywords.click(button_addToCart);
    }

    public void goToCart(){
        WebUIKeywords.click(button_cart);
    }

    public void addSecondItemIntoCart(){
        WebUIKeywords.click(li_secondSize);
        WebUIKeywords.click(button_addToCart);
    }
}
