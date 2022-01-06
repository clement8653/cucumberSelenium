package pages.login;

import frameworks.core.webui.WebUIKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

//    @FindBy(xpath = "//a[contains(text(), \"请登录\")]")
//    private WebElement button_toLogIn;
//
//    @FindBy(id = "fm-login-id123123123")
//    private WebElement input_userName;
//
//    @FindBy(id = "fm-login-password123123")
//    private WebElement input_passWord;
//
//    @FindBy(xpath = "//button[@type=\"submit\"]")
//    private WebElement button_logIn;

    By byToLogin = By.xpath("//a[contains(text(), \"请登录\")]");
    By byUserName = By.id("fm-login-id");
    By byPassWord = By.id("fm-login-password");
    By byLogin = By.xpath("//button[@type=\"submit\"]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void goToLoginPage(){
        WebUIKeywords.click(driver.findElement(byToLogin));
    }

    public void loginTaobao(String userName, String passWord) {
        WebUIKeywords.setText(driver.findElement(byUserName), userName);
        WebUIKeywords.setText(driver.findElement(byPassWord), passWord);
        WebUIKeywords.click(driver.findElement(byLogin));
    }
}
