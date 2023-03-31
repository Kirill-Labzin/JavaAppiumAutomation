package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{

    private static final String
            BUTTON_SKIP = "//*[contains(@text,'SKIP')]",
            SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains(@text,'Search Wikipedia')]",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[contains(@text,'{SUBSTRING}')]";

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

    public void waitForSearchResult(String substring)
    {

        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with substring " + substring);
    }


}
