import frameworks.core.keyword.KeywordExecutor;
import frameworks.core.webui.WebUIKeywords;
import frameworks.core.webui.driver.DriverFactory;

import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args){
//        KeywordExecutor.getAllClassInPackage("frameworks.core.webui.builtin", "openbrowser");
//        KeywordExecutor.executeFromPlatform("web", "openbrowser", "https://www.baidu.com/");


        WebUIKeywords.openBrowser("https://www.baidu.com/");

    }
}
