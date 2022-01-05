package pages;

import frameworks.core.webui.WebUIKeywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchItemsPage {
    WebDriver driver;

    @FindBy(id = "q")
    private WebElement input_queryString;

    @FindBy(xpath = "//*[@name = \"search\"]/div/button")
    private WebElement button_search;

    public SearchItemsPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchItem(String itemName){
        WebUIKeywords.setText(input_queryString, itemName);
        WebUIKeywords.click(button_search);
    }
}
