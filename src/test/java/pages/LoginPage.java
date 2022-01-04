package pages;

import frameworks.core.webui.WebUIKeywords;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(), \"请登录\")]")
    private WebElement button_toLogIn;

    @FindBy(id = "fm-login-id")
    private WebElement input_userName;

    @FindBy(id = "fm-login-password")
    private WebElement input_passWord;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement button_logIn;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void loginTaobao(String userName, String passWord) {
        WebUIKeywords.click(button_toLogIn);
        WebUIKeywords.setText(input_userName, userName);
        WebUIKeywords.setText(input_passWord, passWord);
        WebUIKeywords.click(button_logIn);
    }
}
