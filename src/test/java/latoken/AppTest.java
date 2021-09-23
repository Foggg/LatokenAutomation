package latoken;

import constants.PropertyConfigs;
import org.testng.annotations.Test;
import utils.WebDriverUtils;

import java.util.concurrent.TimeUnit;

/*
Используя java + selenium написать следующий тест:
Открыть страницу latoken.com
Найти в таблице пар STORJ/USDT
Кликнуть в эту строку и перейти в терминал
Проверить что спред в стакане > 0 и вывести его значение
Кликнуть на кнопку login to trader на панели buy\sell
Проверить что открылась модалка авторизации.
 */

public class AppTest extends WebDriverUtils{

    @Test
    public void validateModalWindow(){

        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        //Open Latoken Page
        driver.get(PropertyConfigs.MAIN_URL);
        driver.manage().window().maximize();

        //Find STORJ / USDT and go to the Terminal
        scrollDown();
        driver.findElement(LatokenSite.usdtButton).click();
        driver.findElement(LatokenSite.search).clear();
        driver.findElement(LatokenSite.search).sendKeys("STORJ");
        driver.findElement(LatokenSite.storj).click();

        //Check for a spread and insert to the console
        String spread = driver.findElement(LatokenSite.spread).getText();
        checkHigherThen0(Double.parseDouble(spread));

        //Click login button and check for the modal window
        driver.findElement(LatokenSite.login).click();
        driver.switchTo().activeElement();
        String modalTest = driver.findElement(LatokenSite.modalTest).getText();
        checkForModalWindow(modalTest);
        driver.quit();
    }
}