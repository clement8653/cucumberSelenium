package pages;

import frameworks.core.webui.WebUIKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage {
    WebDriver driver;

//    @FindBy(xpath = "//div[@class=\"shop-info\"]/div/label")
//    private WebElement label_allItemsInShop;
//
//    @FindBy(id = "J_Go")
//    private WebElement button_confirmBuying;

    By byAllItemsInShop = By.xpath("//div[@class=\"shop-info\"]/div/label");
    By byConfirmBuying = By.id("J_Go");

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectAllItemsInShop(){
        WebUIKeywords.click(driver.findElement(byAllItemsInShop));
    }

    public void confirmBuy(){
        WebUIKeywords.click(driver.findElement(byConfirmBuying));
    }

    public void verifyItemInfo(String money){
        WebUIKeywords.verifyElementPresent(
                "//*[@id=\"J_Total\" and contains(text(), \"" + money + "\")]");
    }
}
