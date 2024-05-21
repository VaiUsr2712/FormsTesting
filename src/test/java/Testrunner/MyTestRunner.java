package Testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "C:\\Users\\DELL\\Sai\\FormsTesting\\src\\test\\resources\\Features\\launchpage.feature",
glue = {"stepdefinitions"},
        tags = "@Smoke4"
)

public class MyTestRunner extends AbstractTestNGCucumberTests {
}
