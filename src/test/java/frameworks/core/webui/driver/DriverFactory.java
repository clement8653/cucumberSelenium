package frameworks.core.webui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DriverFactory {

    public static final String RUNNING_MODE_REMOTE = "remote";
    public static final String BROWSER_CHROME = "chrome";
    public static final String BROWSER_FIREFOX = "firefox";
    public static final String CHROME_DRIVER_PATH_PROPERTY_KEY = "webdriver.chrome.driver";
    public static final String FIREFOX_DRIVER_PATH_PROPERTY_KEY = "webdriver.gecko.driver";
    public static final String DRIVER_PATH = "src/test/resources/Drivers/";

    private static final ThreadLocal<WebDriver> webDriverThreadLocal = ThreadLocal.withInitial(() -> null);

    private static Map getConfiguration() throws FileNotFoundException {
        Yaml yml = new Yaml();
        Map configuration = yml.load(new FileInputStream(new File("src/test/java/configuration.yml")));
        return configuration;
    }

    public static WebDriver openWebDriver(){
        Map cap = new HashMap();
        String browser = "";
        String runningMode = "";
        String gridURL = "";

        try{
            browser = getConfiguration().get("browser").toString();
            cap = (Map) getConfiguration().get("desiredCapabilities");
            runningMode = getConfiguration().get("runningMode").toString();
            gridURL = getConfiguration().get("gridURL").toString();
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

        if(runningMode.equals(RUNNING_MODE_REMOTE)){
            driver = startRemoteDriver(gridURL, capabilities);
        }else{
            driver = startWebDriver(browser, capabilities);
        }

        webDriverThreadLocal.set(driver);
        return driver;
    }

    private static WebDriver startWebDriver(String browser, DesiredCapabilities capabilities) {
        WebDriver driver;
        switch (browser){
            case BROWSER_CHROME:
                driver = createNewChromeDriver(capabilities); break;
            case BROWSER_FIREFOX:
                driver = createNewFirefoxDriver(capabilities); break;
            default:
                driver = new ChromeDriver(); break;
        }
        return driver;
    }

    private static WebDriver startRemoteDriver(String gridURL, DesiredCapabilities capabilities) {
        WebDriver driver = null;
        try{
            driver = new RemoteWebDriver(new URL(gridURL), capabilities);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return driver;
    }

    private static WebDriver createNewChromeDriver(DesiredCapabilities desiredCapabilities) {
        System.setProperty(CHROME_DRIVER_PATH_PROPERTY_KEY, DRIVER_PATH+"chromedriver");
        return new ChromeDriver(desiredCapabilities);
    }

    private static WebDriver createNewFirefoxDriver(DesiredCapabilities desiredCapabilities) {
        //firefox driver may encounter version issues, just ignore here, modify in future
        System.setProperty(FIREFOX_DRIVER_PATH_PROPERTY_KEY, DRIVER_PATH+"geckodriver");
        return new FirefoxDriver(desiredCapabilities);
    }

    public static WebDriver getWebDriver(){
        return webDriverThreadLocal.get();
    }
}
