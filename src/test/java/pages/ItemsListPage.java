package pages;

import frameworks.core.webui.WebUIKeywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemsListPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"mainsrp-itemlist\"]//div[contains(@class, \"items\")]/div[1]")
    private WebElement div_firstItem;

    public ItemsListPage(WebDriver driver){
        this.driver = driver;
    }

    public void chooseFirstItem(){
        WebUIKeywords.click(div_firstItem);
        //taobao would open a new tab, so here we switch to new tab
        WebUIKeywords.swithToAvailableTab(1);
    }
}
