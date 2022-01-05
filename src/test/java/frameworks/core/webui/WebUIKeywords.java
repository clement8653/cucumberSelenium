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

    public static void closeBrowser() {
        KeywordExecutor.executeFromPlatform(KeywordExecutor.PLATFORM_WEB, "closeBrowser");
    }

    public static void setText(WebElement element, String input) {
        KeywordExecutor.executeFromPlatform(KeywordExecutor.PLATFORM_WEB, "setText", element, input);
    }

    public static void switchToAvailableTabUsingIndex(int index) {
        KeywordExecutor.executeFromPlatform(KeywordExecutor.PLATFORM_WEB, "switchToAvailableTabUsingIndex", index);
    }

    public static void verifyElementPresent(String xPath)  {
        KeywordExecutor.executeFromPlatform(KeywordExecutor.PLATFORM_WEB, "verifyElementPresent", xPath);
    }
}
