package frameworks.core.webui.builtin;

import frameworks.core.keyword.IKeyword;
import frameworks.core.webui.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.time.Duration;

public class WaitForElementClickable implements IKeyword {

    @Override
    public void execute(@Nullable Object param1, @Nullable Object param2) {
        WebElement element = (WebElement) param1;
        int timeOut = (Integer) param2;
        waitForElementClickable(element, timeOut);
    }

    public void waitForElementClickable(WebElement element, int timeOut){
        try{
            WebDriver driver = DriverFactory.getWebDriver();
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
