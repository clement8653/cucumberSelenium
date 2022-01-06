package Runners;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import frameworks.core.webui.WebUIKeywords;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/extent-report/report.html"},
        format = {"json:target/cucumber-report.json","pretty"},
        features = "src/test/resources/Features",
        glue = {"StepDefinitions"})
public class LoginRunnerTest {
        @BeforeClass
        public static void setup() {
                ExtentProperties extentProperties = ExtentProperties.INSTANCE;
                extentProperties.setReportPath("target/extent-report/myreport.html");
                //  extentProperties.setExtentXServerUrl("http://localhost:1337");
                extentProperties.setProjectName("xxx");
        }

        @AfterClass
        public static void tearDown() {
                Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));//1
                Reporter.setSystemInfo("user", System.getProperty("user.name"));
                Reporter.setSystemInfo("os", "mac");
                Reporter.setTestRunnerOutput("Sample test runner output message");
        }

}
