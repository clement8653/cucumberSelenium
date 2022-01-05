package StepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import frameworks.core.webui.WebUIKeywords;

public class Steps {
    @Before
    public void openBrowser(){
        WebUIKeywords.openBrowser("https://www.taobao.com");
    }

    @After
    public void closeBrowser(){
        WebUIKeywords.closeBrowser();
    }
}
