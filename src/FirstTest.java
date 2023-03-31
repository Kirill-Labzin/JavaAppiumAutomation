import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
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

public class FirstTest extends CoreTestCase {

    private MainPageObject MainPageObject;

    protected void setUp() throws Exception
    {
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    }


    @Test
    public void testSearch()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSKIP();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");

    }

    @Test
    public void testCancelSearch()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSKIP();
        SearchPageObject.clickButtonSearch();
        SearchPageObject.clickButtonBackward();
        SearchPageObject.notPresentBackButton();

    }

    @Test
    public void testCompareArticleTitle()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSKIP();
        SearchPageObject.clickButtonSearch();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickForSearchResult("Object-oriented programming language");

    }

    @Test
    public void testClear()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSKIP();
        SearchPageObject.clickButtonSearch();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clearInputField();

// проверяет на соответствие
        WebElement empty_finder_message = MainPageObject.waitForElementPresent(
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
    public void testExp2(){

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "---Cannot find search contains 'SKIP'---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "---Cannot find search contains 'Search Wikipedia'---",
                6
        );

        MainPageObject.assertElementHasText(
                By.id("org.wikipedia:id/search_src_text"),
                "Search Wikipedia",
                "Not found"
        );
    }

    @Test
    public void testExp3(){

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "---Cannot find search contains 'SKIP'---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "---Cannot find search contains 'Search Wikipedia'---",
                6
        );

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "exp3",
                "---Cannot find search input 'Search Wikipedia'---",
                5
        );

        MainPageObject.assertElementHasText(
                By.xpath("//*[contains(@text,'Substance that can explode')]"),
                "Substance that can explode",
                "Not found"
        );

        MainPageObject.assertElementHasText(
                By.xpath("//*[contains(@text,'Mathematical operation')]"),
                "Mathematical operation",
                "Not found"
        );

        MainPageObject.assertElementHasText(
                By.xpath("//*[contains(@text,'Average value of a random variable')]"),
                "Average value of a random variable",
                "Not found"
        );

        MainPageObject.assertElementHasText(
                By.xpath("//*[contains(@text,'Conscious event, perception or practical knowledge')]"),
                "Conscious event, perception or practical knowledge",
                "Not found"
        );

        MainPageObject.waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "---not found---",
                5
        );

        WebElement empty_finder_message = MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/search_empty_message"),
                "---is not empty finder message---",
                5
        );

        MainPageObject.assertElementHasText(
                By.id("org.wikipedia:id/search_src_text"),
                "Search Wikipedia",
                "Not found"
        );
    }

    @Test
    public void testSwipeArticle(){

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "---Cannot find search contains 'SKIP'---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "---Cannot find search contains 'Search Wikipedia'---",
                6
        );

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "appium",
                "---Cannot find search input 'Search Wikipedia'---",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']"),
                "---Cannot find search Article Appium---",
                6
        );

        MainPageObject.swipeUpToFindElements(
                By.xpath("//android.view.View[@content-desc='View article in browser']"),
                "Cannot find the end of the article",
                10
        );
    }

    @Test
    public void testSavingArticleInFavorites()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "---Cannot find search contains 'SKIP'---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "---Cannot find search contains 'Search Wikipedia'---",
                6
        );

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "java",
                "---Cannot find search input 'Search Wikipedia'---",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "---Cannot find search Article Java---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "---Cannot find button saved---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "---Cannot find button back---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "---Cannot find button back_2 ---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/nav_tab_reading_lists"),
                "---Cannot find button favorites---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/item_title_container"),
                "---Cannot find button article stack---",
                6
        );

        MainPageObject.assertElementHasText(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "Object-oriented programming language",
                "Not find saved article"
        );

        MainPageObject.swipeElementToLeft(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "Saved article not found"
        );

        MainPageObject.assertElementHasText(
                By.id("org.wikipedia:id/reading_list_empty_text"),
                "You have no articles added to this list.",
                "Message about empty list favorite absent"
        );
    }

    @Test
    public void testAmountOfNotEmptySearch()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "---Cannot find search contains 'SKIP'---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "---Cannot find search contains 'Search Wikipedia'---",
                6
        );

        String search_line = "Linkin Park Discography";
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                search_line,
                "---Cannot find search input 'Search Wikipedia'---",
                5
        );

        String search_result_container = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@class='android.view.ViewGroup']";
        MainPageObject.waitForElementPresent(
                By.xpath(search_result_container),
                "Cannot find anything by the request " + search_line
        );
//функция getAmountOfElements записывает интовое значение в переменную amount_of_search_results
        int amount_of_search_results = MainPageObject.getAmountOfElements(
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
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "---Cannot find search contains 'SKIP'---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "---Cannot find search contains 'Search Wikipedia'---",
                6
        );

        String searching_line = "java";
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                searching_line,
                "---Cannot find search input 'Search Wikipedia'---",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "---Object-oriented programming language topic searching by---" + searching_line,
                6
        );

        String title_before_rotation = MainPageObject.waitForElementAndGetAttribute(
                By.id("pcs-edit-section-title-description"),
                "text",
                "---Cаnnot find title of article---",
                15
        );

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation =
                MainPageObject.waitForElementAndGetAttribute(
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
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "---Cannot find search contains 'SKIP'---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "---Cannot find search contains 'Search Wikipedia'---",
                6
        );

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "java",
                "---Cannot find search input 'Search Wikipedia'---",
                5
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "---Cannot find search Article Java---",
                6
        );

        driver.runAppInBackground(3);

//после возврата не находит статью, тест валится

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "---Cannot find search contains 'Search Wikipedia'---",
                6
        );

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "java",
                "---Cannot find search input 'Search Wikipedia'---",
                5
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "---Cannot find search Article Java---",
                6
        );

    }

    @Test
    public void testExp5()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "---Cannot find search contains 'SKIP'---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "---Cannot find search contains 'Search Wikipedia'---",
                6
        );

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "java",
                "---Cannot find search input 'Search Wikipedia'---",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "---Cannot find search Article Java---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "---Cannot find button saved---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.className("android.widget.ImageButton"),
                "---Cannot find button backward in article---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Austronesian language')]"),
                "---Cannot find search Article Java---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "---Cannot find button saved in acticle---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.className("android.widget.ImageButton"),
                "---Cannot find button backward in article---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.className("android.widget.ImageButton"),
                "---Cannot find button backward in article---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/nav_tab_reading_lists"),
                "---Cannot find button favorites---",
                6
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/item_title_container"),
                "---Cannot find button article stack---",
                6
        );

        String article_1 = "Object-oriented programming language";
        MainPageObject.assertElementHasText(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                article_1,
                "Not find saved article" + article_1
        );

        String article_2 = "Austronesian language";
        MainPageObject.assertElementHasText(
                By.xpath("//*[contains(@text,'Austronesian language')]"),
                article_2,
                "Not find saved article" + article_2
        );

        MainPageObject.swipeElementToLeft(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "Saved article not found"
        );

        MainPageObject.waitForElementNotPresent(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "Saved article not found",
                5
        );

        MainPageObject.assertElementHasText(
                By.xpath("//*[contains(@text,'Austronesian language')]"),
                article_2,
                "Not find saved article" + article_2
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Austronesian language')]"),
                article_2,
                6
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[contains(@text,'Austronesian language')]"),
                "Article is not found",
                5
        );

    }







}






//{
//        "appPackage": "org.wikipedia",
//        "appActivity": ".main.MainActivity",
//        "platformName": "Android",
//        "deviceName": "AndroidTestDevice"
//}