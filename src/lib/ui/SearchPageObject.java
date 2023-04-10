package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPageObject extends MainPageObject{


    private static final String
            BUTTON_SKIP = "//*[contains(@text,'SKIP')]",
            BUTTON_BACKWARD = "android.widget.ImageButton",
            SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains(@text,'Search Wikipedia')]",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[contains(@text,'{SUBSTRING}')]",
            SEARCH_RESULT_BY_SUBSTRING_RESOURCE_TEXT_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{SUBSTRING}']",
            SEARCH_INPUT_FIELD = "org.wikipedia:id/search_src_text",
            SEARCH_EMPTY_MESSAGE = "org.wikipedia:id/search_empty_message",
            SEARCH_RESULT_ELEMENT = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@class='android.view.ViewGroup']",
            STRING_EMPTY_RESULT_LABEL = "//*[contains(@text,'No results')]",
            STRING_RESULT_TPL = "//*[contains(@text,'{SUBSTRING_STRING_RESULT}')]";

//            ARTCLE_SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[contains(@text,'{SUBSTRING}')]";

    public SearchPageObject(AppiumDriver driver)
    {
//        берем драйвер из MainPageObject
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
//       замена в SEARCH_RESULT {SUBSTRING} на переменную
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getResultSearchWait(String substring)
    {
        return STRING_RESULT_TPL.replace("{SUBSTRING_STRING_RESULT}", substring);
    }

    private static String getResultSearchElementByResourceText(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_RESOURCE_TEXT_TPL.replace("{SUBSTRING}", substring);
    }

    /* TEMPLATES METHODS */

    public void initSKIP()
    {
        this.waitForElementAndClick(By.xpath(BUTTON_SKIP), "---Cannot find search contains 'SKIP'---", 6);
    }
    public void initSearchInput() {

        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element");
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find and Type into search input", 5);
    }




    public void clickSearchField()
    {
        this.waitForElementAndClick(By.xpath(SEARCH_INPUT), "---Cannot find search contains 'Search Wikipedia'---", 6);
    }
    public void clickSearchButtonBackward()
    {
        this.waitForElementAndClick(By.className(BUTTON_BACKWARD), "---'Not found backButton'---", 5);
    }
    public void notPresentBackButton()
    {
        this.waitForElementNotPresent(By.className(BUTTON_BACKWARD), "i can found button", 5);
    }
    public void presentForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with substring " + substring);
    }
    public void clearInputField()
    {
        this.waitForElementAndClear(By.id(SEARCH_INPUT_FIELD), "---not found---", 5);
    }
    public void checkEmptyMessage()
    {
        WebElement empty_finder_message = this.waitForElementPresent(
                By.id(SEARCH_EMPTY_MESSAGE),
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

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find and click search result with substring " + substring, 10);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result =  getResultSearchWait(substring);
        this.waitForElementPresent(By.xpath(search_result), "Cannot find search Article " + substring, 10);
    }

    public void clickByArticleWithSubstringByResourceText(String substring)
    {
        String search_result_article_xpath = getResultSearchElementByResourceText(substring);
        this.waitForElementAndClick(By.xpath(search_result_article_xpath), "Cannot find and click search result with substring " + substring, 10);
    }

    public int getAmountOfFoundArticle()
    {
        this.waitForElementPresent(
                By.xpath(SEARCH_RESULT_ELEMENT),
                "Cannot find anything by the request "
        );
        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));

    }

    public void waitForEmptyResultLabel()
    {
        this.waitForElementPresent(By.xpath(STRING_EMPTY_RESULT_LABEL), "Cannot find empty result element", 10);
    }

    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(By.className("android.view.ViewGroup"), "We supported not to find any results");
    }
}
