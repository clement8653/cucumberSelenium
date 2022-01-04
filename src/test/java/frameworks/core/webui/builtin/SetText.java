package frameworks.core.webui.builtin;

import frameworks.core.keyword.IKeyword;
import org.openqa.selenium.WebElement;

public class SetText implements IKeyword {

    @Override
    public void execute(Object param1, Object param2) {
        WebElement ele = (WebElement) param1;
        String input = param2.toString();
        setText(ele, input);
    }

    private void setText(WebElement element, String input){
        element.clear();
        //we may face textarea and other scenarios, just sendKeys here for now, later to improve
        element.sendKeys(input);
    }
}
