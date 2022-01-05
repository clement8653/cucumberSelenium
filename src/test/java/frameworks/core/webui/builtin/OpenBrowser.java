package frameworks.core.webui.builtin;

import frameworks.core.keyword.IKeyword;
import frameworks.core.webui.driver.DriverFactory;

public class OpenBrowser implements IKeyword {
    @Override
    public void execute(Object param1, Object param2){
        openBrowser(param1.toString());
    }

    private void openBrowser(String rawURL){
        try{
            DriverFactory.openWebDriver();
            DriverFactory.getWebDriver().get(rawURL);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
