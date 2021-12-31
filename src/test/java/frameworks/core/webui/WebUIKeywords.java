package frameworks.core.webui;

import frameworks.core.keyword.KeywordExecutor;
import org.openqa.selenium.WebElement;

public class WebUIKeywords {
    public static void openBrowser(String rawURL)  {
        KeywordExecutor.executeFromPlatform(KeywordExecutor.PLATFORM_WEB, "openBrowser", rawURL);
    }

    public static void click(WebElement ele)  {
        KeywordExecutor.executeFromPlatform(KeywordExecutor.PLATFORM_WEB, "click", ele);
    }

    public static void waitForPageLoading(int timeOut)  {
        KeywordExecutor.executeFromPlatform(KeywordExecutor.PLATFORM_WEB, "waitForPageLoading", timeOut);
    }
}
