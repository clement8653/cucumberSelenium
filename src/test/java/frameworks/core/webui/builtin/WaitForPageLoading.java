package frameworks.core.webui.builtin;

import com.sun.org.apache.xpath.internal.operations.Bool;
import frameworks.core.keyword.IKeyword;
import frameworks.core.webui.driver.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WaitForPageLoading implements IKeyword {
    @Override
    public void execute(Object param1, Object param2) {
        waitforElement((Integer) param1);
    }

    public static void waitforElement(int timeOut){
        boolean isLoaded =false;
        WebDriver driver = DriverFactory.getWebDriver();
            String script = "var jQueryFlag = true;"+
                            "if (window.jQuery !=undefined) {jQueryFlag = (jQuery.active ==0)}"+
                            "return document.readyState ==='complete' && jQueryFlag;";
        while(!isLoaded && timeOut-->0) {
            try{
                isLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript(script);
            }catch (Exception e){
                isLoaded = false;
            }
        }
    }
}
