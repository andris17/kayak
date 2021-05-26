package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/"},
        glue = "steps utilities",
        plugin = {"json:target/CucumberReports/cucumberReport.json"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
