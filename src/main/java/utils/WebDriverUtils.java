package utils;

import constants.PropertyConfigs;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;


public class WebDriverUtils {

    private static final String chromePath = System.setProperty(PropertyConfigs.SELENIUM_DRIVER, PropertyConfigs.SELENIUM_DRIVER_PATH);

    public static final int timeout = Integer.parseInt(PropertyConfigs.APP_WAIT);
    public static final WebDriver driver = new ChromeDriver();
    private static final JavascriptExecutor js = (JavascriptExecutor) driver;
    private static final SoftAssert softAssert = new SoftAssert();
    private static final Assertion hardAssert = new Assertion();

    public static void scrollDown() {
        js.executeScript("window.scrollBy(0," + driver.manage().window().getSize().height / 2 + ")", "");
    }

    public static void checkHigherThen0(double value) {
        hardAssert.assertTrue(value >= 0, "Spread is less or equal than 0");
        System.out.println(value);
    }
    public static void checkForModalWindow(String value) {
        hardAssert.assertEquals(value, "Login or sign up");
    }

}
