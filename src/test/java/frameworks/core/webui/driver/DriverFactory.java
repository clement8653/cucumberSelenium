package frameworks.core.webui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DriverFactory {

    public static final String BROWSER_CHROME = "chrome";
    public static final String BROWSER_FIREFOX = "firefox";
    public static final String CHROME_DRIVER_PATH_PROPERTY_KEY = "webdriver.chrome.driver";
    public static final String FIREFOX_DRIVER_PATH_PROPERTY_KEY = "webdriver.gecko.driver";
    public static final String DRIVER_PATH = "src/test/resources/Drivers/";

    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            return null;
        }
    };

    private static Map getConfiguration() throws FileNotFoundException {
        Yaml yml = new Yaml();
        Map configuration = yml.load(new FileInputStream(new File("src/test/java/configuration.yml")));
        return configuration;
    }

    public static WebDriver openWebDriver(){
        Map cap = new HashMap();
        String browser = new String();
        try{
            browser = getConfiguration().get("browser").toString();
            cap = (Map) getConfiguration().get("desiredCapabilities");
        }catch(FileNotFoundException e){
            //do nothing
        }

        WebDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if(cap != null){
            Iterator<Map.Entry<String, Boolean>> iter = cap.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry<String, Boolean> entrySet = iter.next();
                capabilities.setCapability(entrySet.getKey(), entrySet.getValue());
            }
        }

        switch (browser){
            case BROWSER_CHROME:
                driver = createNewChromeDriver(capabilities); break;
            case BROWSER_FIREFOX:
                driver = createNewFirefoxDriver(capabilities); break;
            default:
                driver = new ChromeDriver(); break;
        }
        webDriverThreadLocal.set(driver);
        return driver;
    }

    private static WebDriver createNewChromeDriver(DesiredCapabilities desiredCapabilities) {
        System.setProperty(CHROME_DRIVER_PATH_PROPERTY_KEY, DRIVER_PATH+"chromedriver");
        return new ChromeDriver(desiredCapabilities);
    }

    private static WebDriver createNewFirefoxDriver(DesiredCapabilities desiredCapabilities) {
        //firefox driver may encounter version issue, just ignore here, modify in future
        System.setProperty(FIREFOX_DRIVER_PATH_PROPERTY_KEY, DRIVER_PATH+"geckodriver");
        return new FirefoxDriver(desiredCapabilities);
    }

    public static WebDriver getWebDriver(){
        return webDriverThreadLocal.get();
    }
}
