package latoken;

import org.openqa.selenium.By;

public class LatokenSite {

    //Buttons
    public static final By usdtButton = By.xpath("//div[contains(@class, 'StyledButtonGroup')]/div[contains(@class, 'jss') and text() = 'USDT']");
    public static final By btcButton = By.xpath("//div[contains(@class, 'StyledButtonGroup')]/div[contains(@class, 'jss') and text() = 'BTC']");
    public static final By ethButton = By.xpath("//div[contains(@class, 'StyledButtonGroup')]/div[contains(@class, 'jss') and text() = 'ETH']");
    public static final By trxButton = By.xpath("//div[contains(@class, 'StyledButtonGroup')]/div[contains(@class, 'jss') and text() = 'TRX']");
    public static final By laButton = By.xpath("//div[contains(@class, 'StyledButtonGroup')]/div[contains(@class, 'jss') and text() = 'LA']");

    //Elements
    public static final By storj = By.xpath("//div[contains(@class, 'MuiBox-root')]/h6[contains(@class, 'MuiTypography-root') and text() = 'STORJ']");
    public static final By spread = By.xpath("//*[@id=\"app\"]//span[contains(@class, 'MuiTypography')][contains(@style,'font-weight: bold')]");
    public static final By search = By.xpath("//input[@placeholder='Search']");
    public static final By login = By.xpath("//span[@class='MuiButton-label']//div[text() = 'Log in to trade']");
    public static final By modalTest = By.xpath("//h2[text() = 'Login or sign up']");
}
