package frameworks.core.webui.builtin;

import frameworks.core.keyword.IKeyword;
import frameworks.core.webui.driver.DriverFactory;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class SwitchToAvailableTabUsingIndex implements IKeyword {
    @Override
    public void execute(@Nullable Object param1, @Nullable Object param2) {
        int index = Integer.parseInt(String.valueOf(param1));
        swithToNewTab(index);
    }

    public void swithToNewTab(int index){
        try{
            WebDriver driver = DriverFactory.getWebDriver();
            List<String> availableTabs = new ArrayList<>(driver.getWindowHandles());
            if(index < availableTabs.size()){
                driver.switchTo().window(availableTabs.get(index));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
