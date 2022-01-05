package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import frameworks.core.webui.WebUIKeywords;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = {"StepDefinitions"},
        plugin = {"pretty", "html:target/HTMLReports"
        })
public class LoginRunnerTest {
}
