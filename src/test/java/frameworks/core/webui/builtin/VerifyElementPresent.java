package frameworks.core.webui.builtin;

import frameworks.core.keyword.IKeyword;
import frameworks.core.webui.driver.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import javax.annotation.Nullable;

public class VerifyElementPresent implements IKeyword {
    @Override
    public void execute(@Nullable Object param1, @Nullable Object param2) {
        String xPath = String.valueOf(param1);
        verifyElementPresent(xPath);
    }

    private void verifyElementPresent(String xPath){
        try{
            WebDriver driver = DriverFactory.getWebDriver();
            WebElement element = driver.findElement(By.xpath(xPath));
            if(element != null){
                Assert.assertTrue(true);
            }else{
                Assert.assertFalse(false);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
