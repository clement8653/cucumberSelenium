package StepDefinitions;

import cucumber.api.java.After;
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

    @Given("^I am going to login taobao$")
    public void loginTaobao() {
        WebUIKeywords.openBrowser("https://www.taobao.com/");
    }

    @When("^I input (.*) and (.*)$")
    public void inputUserNameAndPassWord(String userName, String passWord){
        driver = DriverFactory.getWebDriver();
        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        loginPage.loginTaobao(userName, passWord);
    }

    @Then("^I should login taobao$")
    public void verifyNotLogin(){

    }

    @Then("^I should not login taobao$")
    public void verifyLogin(){

    }

    @After
    public void tearDown(){
        WebUIKeywords.closeBrowser();
    }
}
