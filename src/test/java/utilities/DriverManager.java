package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class DriverManager {
    public static final Logger logger = LoggerFactory.getLogger(DriverManager.class);
    private static WebDriver driver = null;

    private static void initDriver(String browser) {
        setDriverExecutableProperty(browser);
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        } else {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }

        logger.info("Executing on {}", browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    public static WebDriver getDriver() {
        return getDriver("chrome");
    }

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            initDriver(browser);
        }
        return driver;
    }

    public static void quitWebDriver() {
        driver.quit();
        driver = null;
    }

    private static void setDriverExecutableProperty(String browser) {
        String driverPath = System.getProperty("exec.driverPath");
        if (driverPath != null) {
            switch (browser) {
                case "chrome": {
                    System.setProperty("webdriver.chrome.driver", driverPath);
                }
                case "firefox": {
                    System.setProperty("webdriver.gecko.driver", driverPath);
                }
                case "ie": {
                    System.setProperty("webdriver.ie.driver", driverPath);
                }
                case "edge": {
                    System.setProperty("webdriver.edge.driver", driverPath);
                }
            }
        }
    }
}
