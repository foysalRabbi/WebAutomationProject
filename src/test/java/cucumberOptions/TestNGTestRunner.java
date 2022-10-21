package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features={"src/test/feature"},
        glue ={"stepDefinitions"},
        monochrome=true,
        tags ="@PlaceOrder",
        plugin= {"html:target/cucumber.html", "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"}
)

public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel=false)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }
}

