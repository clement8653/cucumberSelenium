package frameworks.core.webui.builtin;

import frameworks.core.keyword.IKeyword;
import org.openqa.selenium.WebElement;

public class Click implements IKeyword {

    @Override
    public void execute(Object param) {

        click((WebElement) param);
    }

    private void click(WebElement ele){
        WaitForPageLoading.waitforElement(5);
        ele.click();
    }
}
