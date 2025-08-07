package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/api",
                "src/test/resources/ui"
        },
        glue = {
                "api.stepdefinitions",
                "web.stepdefinitions",
                "hooks"
        },
        plugin = {
                "pretty",
                "html:build/cucumber-reports.html",
                "json:build/cucumber-reports.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        tags = "@api or @ui",
        monochrome = true
)
public class CombinedTestRunner extends AbstractTestNGCucumberTests {}
