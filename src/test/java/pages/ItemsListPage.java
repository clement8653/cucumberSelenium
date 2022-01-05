package pages;

import frameworks.core.webui.WebUIKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemsListPage {
    WebDriver driver;

//    @FindBy(xpath = "//*[@id=\"mainsrp-itemlist\"]//div[contains(@class, \"items\")]/div[1]")
//    private WebElement div_firstItem;

    By byFirstItem = By.xpath("//*[@id=\"mainsrp-itemlist\"]//div[contains(@class, \"items\")]/div[1]");

    public ItemsListPage(WebDriver driver){
        this.driver = driver;
    }

    public void chooseFirstItem(){
        WebUIKeywords.click(driver.findElement(byFirstItem));
        //taobao would open a new tab, so here we switch to new tab
        WebUIKeywords.switchToAvailableTabUsingIndex(1);
    }
}
