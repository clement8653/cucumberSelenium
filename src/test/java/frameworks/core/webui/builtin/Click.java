package frameworks.core.webui.builtin;

import frameworks.core.keyword.IKeyword;
import frameworks.core.webui.WebUIKeywords;
import org.openqa.selenium.WebElement;

public class Click implements IKeyword {

    @Override
    public void execute(Object param1, Object param2) {
        click((WebElement) param1);
    }

    private void click(WebElement ele) {
        try {
            WebUIKeywords.waitForElementClickable(ele, 5);
            ele.click();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(ele.toString().contains("no such element: Unable to locate element")) {
                WebUIKeywords.waitForPageLoading(60);
                System.out.println("second click");
                ele.click();
            }
        }
    }
}
