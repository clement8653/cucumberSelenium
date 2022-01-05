package pages;

import frameworks.core.webui.WebUIKeywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class=\"shop-info\"]/div/label")
    private WebElement label_allItemsInShop;

    @FindBy(id = "J_Go")
    private WebElement button_confirmBuying;

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectAllItemsInShop(){
        WebUIKeywords.click(label_allItemsInShop);
    }

    public void confirmBuy(){
        WebUIKeywords.click(button_confirmBuying);
    }

    public void verifyItemInfo(String money){
        WebUIKeywords.verifyElementPresent(
                "//*[@id=\"J_Total\" and contains(text(), \"" + money + "\")]");
    }
}
