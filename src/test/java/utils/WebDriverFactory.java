package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
    public static WebDriver createDriver(String browser, String options) {
        String browserName = browser == null ? "CHROME" : browser.toUpperCase();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (Browsers.valueOf(browserName)) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                /* run autotests remotely */
/*                chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model, MUST BE THE VERY FIRST OPTION
                chromeOptions.addArguments("--headless");
                chromeOptions.setExperimentalOption("useAutomationExtension", false);
                chromeOptions.addArguments("start-maximized"); // open Browser in maximized mode
                chromeOptions.addArguments("disable-infobars"); // disabling infobars
                chromeOptions.addArguments("--disable-extensions"); // disabling extensions
                chromeOptions.addArguments("--disable-gpu"); // applicable to windows os only
                chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
                chromeOptions.merge(capabilities);*/
                /**/
                if (options.length() > 0) chromeOptions.addArguments(options);
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                return new ChromeDriver(chromeOptions);
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(options);
                if (options.length() > 0) firefoxOptions.addArguments(options);
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
                firefoxOptions.merge(capabilities);
                return new FirefoxDriver(firefoxOptions);
            default:
                throw new IllegalStateException("browser name must be specified");
        }

    }

    public static WebDriver createDriver(String browser) {
        return createDriver(browser, new String());
    }
}
