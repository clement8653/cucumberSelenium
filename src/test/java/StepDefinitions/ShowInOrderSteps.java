package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import frameworks.core.webui.WebUIKeywords;
import frameworks.core.webui.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShowInOrderSteps {
    @Given("^Order is ready$")
    public void orderIsReady() {
        WebUIKeywords.openBrowser("https://thoughtworks.okta.com/");
    }

    @When("^click place order$")
    public void clickPlaceOrder() {
        WebDriver driver = DriverFactory.getWebDriver();
        WebElement ele = driver.findElement(By.id("okta-signin-submit"));
        WebUIKeywords.click(ele);
    }

    @Then("^info should be shown in the page$")
    public void infoShouldBeShownInThePage() {
        System.out.println("123");
    }
}
