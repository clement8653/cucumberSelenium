package StepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import frameworks.core.webui.WebUIKeywords;
import frameworks.core.webui.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    public void setUp(){
        System.out.println("from login step");
        WebUIKeywords.openBrowser("https://www.taobao.com/");
        driver = DriverFactory.getWebDriver();
        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
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
        tearDown();
    }

    @Then("^I should not login taobao$")
    public void verifyLogin(){
        tearDown();
    }

    public void tearDown(){
        WebUIKeywords.closeBrowser();
    }
}
