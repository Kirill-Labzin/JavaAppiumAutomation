import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","/Users/kirilllabzin/Desktop/Lessons/JavaAppiumAutomation/apks/Wikipedia_2.7.50431-r-2023-02-22_Apkpure.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void firstTest()
    {
//        перезапуск простых действий в методах
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "---Cannot find search contains 'SKIP'---",
                6
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "---Cannot find search contains 'Search Wikipedia'---",
                6
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "java",
                "---Cannot find search input 'Search Wikipedia'---",
                5
        );

        waitElementPresent(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "---Object-oriented programming language---",
                15
        );
    }

    @Test
    public void testCancelSearch() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "---Cannot find search contains 'SKIP'---",
                6
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "---Cannot find search contains 'Search Wikipedia'---",
                6
        );


        waitForElementAndClick(
                By.className("android.widget.ImageButton"),
                "---Cannot find search contains 'Not found backButton'---",
                5
        );

        waitForElementNotPresent(
               By.className("android.widget.ImageButton"),
                "i can found button",
                5
        );
    }

    @Test
    public void testCompareArticleTitle(){

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "---Cannot find search contains 'SKIP'---",
                6
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "---Cannot find search contains 'Search Wikipedia'---",
                6
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "java",
                "---Cannot find search input 'Search Wikipedia'---",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "---Cannot find search Article Java---",
                6
        );
    }

    @Test
    public void clear(){
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "---Cannot find search contains 'SKIP'---",
                6
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "---Cannot find search contains 'Search Wikipedia'---",
                6
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "java",
                "---Cannot find search input 'Search Wikipedia'---",
                5
        );

// очищает поле ввода
        waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "---not found---",
                5
        );
// проверяет на соответствие
        WebElement empty_finder_message = waitElementPresent(
                By.id("org.wikipedia:id/search_empty_message"),
                "---is not empty finder message---",
                5
        );

        String finder_message = empty_finder_message.getAttribute("text");
        System.out.println(finder_message);
        Assert.assertEquals(
                "---We see unexpected title---",
                "Search Wikipedia in more languages",
                finder_message
        );
    }

    @Test
    public void exp2(){

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "---Cannot find search contains 'SKIP'---",
                6
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "---Cannot find search contains 'Search Wikipedia'---",
                6
        );

        assertElementHasText(
                By.id("org.wikipedia:id/search_src_text"),
                "Search Wikipedia",
                "Not found"
        );
    }

    @Test
    public void exp3(){

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "---Cannot find search contains 'SKIP'---",
                6
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "---Cannot find search contains 'Search Wikipedia'---",
                6
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "exp3",
                "---Cannot find search input 'Search Wikipedia'---",
                5
        );

        assertElementHasText(
                By.xpath("//*[contains(@text,'Substance that can explode')]"),
                "Substance that can explode",
                "Not found"
        );

        assertElementHasText(
                By.xpath("//*[contains(@text,'Mathematical operation')]"),
                "Mathematical operation",
                "Not found"
        );

        assertElementHasText(
                By.xpath("//*[contains(@text,'Average value of a random variable')]"),
                "Average value of a random variable",
                "Not found"
        );

        assertElementHasText(
                By.xpath("//*[contains(@text,'Conscious event, perception or practical knowledge')]"),
                "Conscious event, perception or practical knowledge",
                "Not found"
        );

        waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "---not found---",
                5
        );

        WebElement empty_finder_message = waitElementPresent(
                By.id("org.wikipedia:id/search_empty_message"),
                "---is not empty finder message---",
                5
        );

        assertElementHasText(
                By.id("org.wikipedia:id/search_src_text"),
                "Search Wikipedia",
                "Not found"
        );
    }

    @Test
    public void testSwipeArticle(){

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "---Cannot find search contains 'SKIP'---",
                6
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "---Cannot find search contains 'Search Wikipedia'---",
                6
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "java",
                "---Cannot find search input 'Search Wikipedia'---",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "---Cannot find search Article Java---",
                6
        );

        swipeUp(2000);
        swipeUp(2000);
        swipeUp(2000);
        swipeUp(2000);
    }





        private WebElement waitElementPresent(By by, String error_message, long timeoutInSeconds)
        {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            wait.withMessage(error_message + "\n");
            return wait.until(
                    ExpectedConditions.presenceOfElementLocated(by)
            );
        }

        private WebElement waitElementPresent(By by, String error_message)
        {
            return waitElementPresent(by, error_message, 5);
        }
// Один метод, перезапуск метода }}

        private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
        {
            WebElement element = waitElementPresent(by, error_message, timeoutInSeconds);
            element.click();
            return element;
        }

        private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
        {
            WebElement element = waitElementPresent(by, error_message, timeoutInSeconds);
            element.sendKeys(value);
            return element;
        }

        private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds)
        {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            wait.withMessage(error_message + "\n");
            return wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(by)
            );
        }

        private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
        {
            WebElement element = waitElementPresent(by, error_message,timeoutInSeconds);
            element.clear();
            return element;
        }

    // задание 1 раздела 3
        private void assertElementHasText(By by, String expected, String message)
        {
            WebElement dev = waitElementPresent(by, "Locator not found");
            String finder_message = dev.getAttribute("text");
            Assert.assertEquals(message, expected, finder_message);
        }

        protected void swipeUp(int timeOfSwipe)
        {
            io.appium.java_client.TouchAction action = new TouchAction(driver);

// узнаем параметры экрана, задаем координаты
            Dimension size = driver.manage().window().getSize();
            int x = size.width / 2;
            int start_y = (int) (size.height * 0.8);
            int end_y = (int) (size.height * 0.2);

            action.press(x, start_y).waitAction(timeOfSwipe).moveTo(x, end_y).release().perform();
        }

}






//{
//        "appPackage": "org.wikipedia",
//        "appActivity": ".main.MainActivity",
//        "platformName": "Android",
//        "deviceName": "AndroidTestDevice"
//}