package casesHabr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class HabrBaseTest {
    public static Logger logger = LogManager.getLogger(HabrBaseTest.class);
    public static WebDriver driver;
    public static WebDriverFactory factory = new WebDriverFactory();

    public static String browser = System.getProperty("browser");
    public static String options = System.getProperty("options");


    @Before
    public void setup() {
        if (options == null) {
            driver = factory.createDriver(browser);
        } else {
            driver = factory.createDriver(browser, options);
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void closeDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }
}
