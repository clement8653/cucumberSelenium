package StepDefinitions.additemintocart;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import frameworks.core.webui.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.additemintocart.ItemDetails;
import pages.additemintocart.ItemsListPage;
import pages.login.LoginPage;
import pages.additemintocart.SearchItemsPage;

public class AddItemToCartSteps {
    WebDriver driver;
    LoginPage loginPage;
    ItemsListPage itemsListPage;
    ItemDetails itemDetails;
    SearchItemsPage searchItemsPage;

    public void setUp(){
        driver = DriverFactory.getWebDriver();
        loginPage = new LoginPage(driver);
        searchItemsPage = new SearchItemsPage(driver);
        itemsListPage = new ItemsListPage(driver);
        itemDetails = new ItemDetails(driver);
    }

    @Given("^login taobao$")
    public void loginTaobao() throws InterruptedException {
        setUp();
        loginPage.goToLoginPage();
        //cannot login with username and password
        //have to scan code through cell phone, so need to wait for 15 seconds
        loginPage.loginTaobao("asd", "ads");
        Thread.sleep(30000);
    }

    @When("^search item and add apple into cart$")
    public void searchItemAndAddAppleIntoCart() {
        searchItemsPage.searchItem("apple");
        itemsListPage.chooseFirstItem();
        itemDetails.addItemIntoCart();
    }

    @Then("^this item shows in cart$")
    public void thisItemsShowsInCart() {
    }

    @When("^search item and add apple with different types into cart$")
    public void searchItemAndAddAppleWithDifferentTypesIntoCart() {
    }

    @Then("^these items should show in cart$")
    public void theseItemsShouldShowInCart() {
    }
}
