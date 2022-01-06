package StepDefinitions.confirmorder;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import frameworks.core.webui.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.additemintocart.ItemDetails;
import pages.additemintocart.ItemsListPage;
import pages.additemintocart.SearchItemsPage;
import pages.login.LoginPage;
import pages.order.OrderPage;

public class OrderConfirmSteps {
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

    @Given("^one item is added into cart$")
    public void oneItemIsAddedIntoCart() {

    }

    @When("^click confirm order$")
    public void clickConfirmOrder() {
    }

    @Then("^item info show in order confirm page$")
    public void itemInfoShowInOrderConfirmPage() {
    }

    @And("^address info shows$")
    public void addressInfoShows() {
    }

    @Given("^several items are added into cart$")
    public void severalItemsAreAddedIntoCart() {
    }

    @Then("^items info show in order confirm page$")
    public void itemsInfoShowInOrderConfirmPage() {
    }
}
