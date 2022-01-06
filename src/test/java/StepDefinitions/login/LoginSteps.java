package StepDefinitions.login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import frameworks.core.webui.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.login.LoginPage;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    public void setUp(){
        driver = DriverFactory.getWebDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("^I am going to login taobao$")
    public void gotoLoginTaobao() {
        setUp();
        loginPage.goToLoginPage();
    }

    @When("^I input (.*) and (.*)$")
    public void inputUserNameAndPassWord(String userName, String passWord){
        loginPage.loginTaobao(userName, passWord);
    }

    @Then("^I should login taobao$")
    public void verifyNotLogin(){
    }

    @Then("^I should not login taobao$")
    public void verifyLogin(){
    }

}
