package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import frameworks.core.webui.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.*;

public class ShowInOrderSteps {
    WebDriver driver;
    LoginPage loginPage;
    ItemsListPage itemsListPage;
    ItemDetails itemDetails;
    SearchItemsPage searchItemsPage;
    OrderPage orderPage;

    public void setUp(){
        driver = DriverFactory.getWebDriver();
        loginPage = new LoginPage(driver);
        searchItemsPage = new SearchItemsPage(driver);
        itemsListPage = new ItemsListPage(driver);
        itemDetails = new ItemDetails(driver);
        orderPage = new OrderPage(driver);
    }

    @Given("^item searched$")
    public void itemSearched() throws InterruptedException {
        setUp();
        loginPage.goToLoginPage();
        //cannot login with username and password
        //have to scan code through cell phone, so need to wait for 15 seconds
        loginPage.loginTaobao("asd", "ads");
        Thread.sleep(30000);
        searchItemsPage.searchItem("apple");
        itemsListPage.chooseFirstItem();
    }

    @When("^click place order$")
    public void clickPlaceOrder() {
        itemDetails.addItemIntoCart();
        itemDetails.goToCart();
        orderPage.selectAllItemsInShop();
    }

    @Then("^info should be shown in the page$")
    public void infoShouldBeShownInThePage() {
        orderPage.verifyItemInfo("5949");
    }

}
