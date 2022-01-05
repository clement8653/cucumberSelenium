package pages;

import frameworks.core.webui.WebUIKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchItemsPage {
    WebDriver driver;

//    @FindBy(id = "q")
//    private WebElement input_queryString;
//
//    @FindBy(xpath = "//*[@name = \"search\"]/div/button")
//    private WebElement button_search;

    By byQueryString = By.id("q");
    By bySearch = By.xpath("//*[@name = \"search\"]/div/button");

    public SearchItemsPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchItem(String itemName){
        WebUIKeywords.setText(driver.findElement(byQueryString), itemName);
        WebUIKeywords.click(driver.findElement(bySearch));
    }
}
