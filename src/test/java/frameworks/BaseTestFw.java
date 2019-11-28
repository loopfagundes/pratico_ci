package frameworks;

import static frameworks.DriverManagerFactoryFw.quitDriver;
import static frameworks.DriverManagerFactoryFw.setDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseTestFw {

    private static WebDriver driver;

    public WebDriver getDriver() {
        this.driver = setDriver(DriverTypeFw.CHROME);
        return driver;
    }

    @BeforeClass
    public static void setUp() {

    }

    @AfterClass
    public static void tearDown() {
        quitDriver();
    }
}