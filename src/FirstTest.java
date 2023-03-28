import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

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

        waitForElementPresent(
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
        WebElement empty_finder_message = waitForElementPresent(
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

        WebElement empty_finder_message = waitForElementPresent(
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
                "appium",
                "---Cannot find search input 'Search Wikipedia'---",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']"),
                "---Cannot find search Article Appium---",
                6
        );

        swipeUpToFindElements(
                By.xpath("//android.view.View[@content-desc='View article in browser']"),
                "Cannot find the end of the article",
                10
        );
    }

    @Test
    public void testSavingArticleInFavorites()
    {
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

        waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "---Cannot find button saved---",
                6
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "---Cannot find button back---",
                6
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "---Cannot find button back_2 ---",
                6
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/nav_tab_reading_lists"),
                "---Cannot find button favorites---",
                6
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/item_title_container"),
                "---Cannot find button article stack---",
                6
        );

        assertElementHasText(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "Object-oriented programming language",
                "Not find saved article"
        );

        swipeElementToLeft(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "Saved article not found"
        );

        assertElementHasText(
                By.id("org.wikipedia:id/reading_list_empty_text"),
                "You have no articles added to this list.",
                "Message about empty list favorite absent"
        );
    }

    @Test
    public void testAmountOfNotEmptySearch()
    {
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

        String search_line = "Linkin Park Discography";
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                search_line,
                "---Cannot find search input 'Search Wikipedia'---",
                5
        );

        String search_result_container = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@class='android.view.ViewGroup']";
        waitForElementPresent(
                By.xpath(search_result_container),
                "Cannot find anything by the request " + search_line
        );
//функция getAmountOfElements записывает интовое значение в переменную amount_of_search_results
        int amount_of_search_results = getAmountOfElements(
                By.xpath(search_result_container)
        );
        System.out.println(amount_of_search_results);
//сравнивает значение перемененной с ожидаемым, в данном случае оно должно быть больше нуля
        Assert.assertTrue(
                "We found too few results",
                amount_of_search_results > 0
        );


    }

    @Test
    public void testChangeScreeOrientationOnSearchResult()
    {
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

        String searching_line = "java";
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                searching_line,
                "---Cannot find search input 'Search Wikipedia'---",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "---Object-oriented programming language topic searching by---" + searching_line,
                6
        );

        String title_before_rotation = waitForElementAndGetAttribute(
                By.id("pcs-edit-section-title-description"),
                "text",
                "---Cаnnot find title of article---",
                15
        );

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation =
                waitForElementAndGetAttribute(
                By.id("pcs-edit-section-title-description"),
                "text",
                "---Cаnnot find title of article---",
                15
        );

        Assert.assertEquals(
                "Article title have been changed after screen rotation",
                title_before_rotation,
                title_after_rotation
        );

        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    @Test
    public void testSearchArticleInBackground()
    {
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

        waitForElementPresent(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "---Cannot find search Article Java---",
                6
        );

        driver.runAppInBackground(3);

//после возврата не находит статью, тест валится

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

        waitForElementPresent(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "---Cannot find search Article Java---",
                6
        );

    }





        private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
        {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            wait.withMessage(error_message + "\n");
            return wait.until(
                    ExpectedConditions.presenceOfElementLocated(by)
            );
        }

        private WebElement waitForElementPresent(By by, String error_message)
        {
            return waitForElementPresent(by, error_message, 5);
        }
// Один метод, перезапуск метода }}

        private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
        {
            WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
            element.click();
            return element;
        }

        private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
        {
            WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
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
            WebElement element = waitForElementPresent(by, error_message,timeoutInSeconds);
            element.clear();
            return element;
        }

    // задание 1 раздела 3
        private void assertElementHasText(By by, String expected, String message)
        {
            WebElement dev = waitForElementPresent(by, "Locator not found");
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

            action
                    .press(x, start_y)
                    .waitAction(timeOfSwipe)
                    .moveTo(x, end_y)
                    .release()
                    .perform();
        }

        protected void swipeUpQuick()
        {
            swipeUp(200);
        }

        protected void swipeUpToFindElements(By by, String error_message, int max_swipes)
        {
//находит все элементы на странице
//            driver.findElements(by);
//выводит количество элементов на странице
//            driver.findElements(by).size();

//цикл будет работать пока функция не находит ни одного элемента
//то есть пока условие == 0 соблюдается, будет постоянный свайп вверх
            int already_swiped = 0;
            while (driver.findElements(by).size() == 0)
            {
                if (already_swiped > max_swipes)
                {
                    waitForElementPresent(by, "Cannot find element by swiping up.\n" + error_message);
                    return;
                }

                swipeUpQuick();
                ++already_swiped;
            }
            while (driver.findElements(by).size() == 0);
            {
                swipeUpQuick();
            }
        }

        protected void swipeElementToLeft(By by, String error_message)
        {
            WebElement element = waitForElementPresent(
                    by,
                    error_message,
                    10);
            //записывает в переменную самую левую точку элемента по оси Х
            int left_x = element.getLocation().getX();
            //берем уже найденную точку left_x, берем размер нашего элемента по ширине и прибавляем к точке left_x
            int right_x = left_x + element.getSize().getWidth();
            int upper_y = element.getLocation().getY();
            int lower_y = upper_y + element.getSize().getHeight();
            int middle_y = (upper_y + lower_y) / 2;

            TouchAction action = new TouchAction(driver);
            action
                    .press(right_x, middle_y)
                    .waitAction(150)
                    .moveTo(left_x, middle_y)
                    .release()
                    .perform();
        }

        private int getAmountOfElements (By by)
        {
            List elements = driver.findElements(by);
            return elements.size();
        }

        private String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeoutInSeconds)
        {
            WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
            return element.getAttribute(attribute);
        }

}






//{
//        "appPackage": "org.wikipedia",
//        "appActivity": ".main.MainActivity",
//        "platformName": "Android",
//        "deviceName": "AndroidTestDevice"
//}