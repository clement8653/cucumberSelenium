package frameworks.core.webui.builtin;

import frameworks.core.keyword.IKeyword;
import org.openqa.selenium.WebElement;

public class Click implements IKeyword {

    @Override
    public void execute(Object param1, Object param2) {
        click((WebElement) param1);
    }

    private void click(WebElement ele){
        try {
            WaitForPageLoading.waitforElement(60);
            ele.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
