package frameworks.core.webui.builtin;

import frameworks.core.keyword.IKeyword;
import frameworks.core.webui.driver.DriverFactory;

public class OpenBrowser implements IKeyword {
    @Override
    public void execute(Object param){
        openBrowser(param.toString());
    }

    private void openBrowser(String rawURL){
        DriverFactory.openWebDriver();
        DriverFactory.getWebDriver().get(rawURL);
    }
}
