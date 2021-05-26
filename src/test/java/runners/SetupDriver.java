package runners;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.DriverManager;

public class SetupDriver {
    public SetupDriver() {
    }

    @Before
    public void prepare() {
        DriverManager.getDriver("chrome");
    }

    @After
    public void tearDown() {
        DriverManager.quitWebDriver();
    }
}
