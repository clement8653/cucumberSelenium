package frameworks.core.webui.builtin;

import frameworks.core.keyword.IKeyword;
import frameworks.core.webui.driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class CloseBrowser implements IKeyword {
    @Override
    public void execute(Object param1, Object param2) {
        closeBrowser();
    }

    private void closeBrowser(){
        WebDriver webDriver = DriverFactory.getWebDriver();
        webDriver.quit();
    }
}
