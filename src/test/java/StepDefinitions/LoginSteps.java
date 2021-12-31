package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import frameworks.core.webui.WebUIKeywords;
import frameworks.core.webui.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginSteps {
    @Given("^I am going to login taobao$")
    public void navigateToTaobao(){
        WebUIKeywords.openBrowser("https://thoughtworks.okta.com/");
    }


    @And("^I input <userName> and <passWord>$")
    public void inputUserNameAndPassWord(){
        WebDriver driver = DriverFactory.getWebDriver();
        WebElement ele = driver.findElement(By.id("okta-signin-submit12312313"));
        WebUIKeywords.click(ele);
    }

    @Then("^I should login taobao$")
    public void verifyLogin(){

    }
}
