package utils;

import constants.PropertyConfigs;
import latoken.LatokenSite;
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

    public static void openMainPage(){
        driver.get(PropertyConfigs.MAIN_URL);
        driver.manage().window().maximize();
    }

    public static void scrollDown() {
        js.executeScript("window.scrollBy(0," + driver.manage().window().getSize().height / 2 + ")", "");
    }

    public static void searchForPair(String assetOne,String assetTwo) {
        scrollDown();
        switch(assetTwo){
            case "USDT":
                driver.findElement(LatokenSite.usdtButton).click();
                break;
            case "BTC":
                driver.findElement(LatokenSite.btcButton).click();
                break;
            case "ETH":
                driver.findElement(LatokenSite.ethButton).click();
                break;
            case "TRX":
                driver.findElement(LatokenSite.trxButton).click();
                break;
            case "LA":
                driver.findElement(LatokenSite.laButton).click();
                break;
        }
        driver.findElement(LatokenSite.search).clear();
        driver.findElement(LatokenSite.search).sendKeys(assetOne);
        driver.findElement(LatokenSite.storj).click();
    }

    public static void checkSpreadHigherThen(int compare) {
        String spread = driver.findElement(LatokenSite.spread).getText();
        System.out.println(spread);
        hardAssert.assertTrue(Double.parseDouble(spread) >= compare, "Spread is less or equal than 0");
    }

    public static void login(){
        driver.findElement(LatokenSite.login).click();
        driver.switchTo().activeElement();
    }

    public static void checkForModalWindow() {
        String value = driver.findElement(LatokenSite.modalTest).getText();
        hardAssert.assertEquals(value, "Login or sign up");
    }

    public static void closeAndQuit(){
        driver.close();
        driver.quit();
    }

}
