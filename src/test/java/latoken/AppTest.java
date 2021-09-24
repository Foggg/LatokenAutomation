package latoken;

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

public class AppTest extends WebDriverUtils {

    @Test
    public void validateModalWindow() {

        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        //Open Latoken Page
        openMainPage();

        //Find STORJ / USDT and go to the Terminal
        searchForPair("STORJ", "USDT");

        //Check for a spread and insert to the console
        checkSpreadHigherThen(0);

        //Click login button and check for the modal window
        login();
        checkForModalWindow();

        closeAndQuit();
    }
}