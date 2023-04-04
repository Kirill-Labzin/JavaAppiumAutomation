package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject
{
    private static final String
        TITLE = "pcs-edit-section-title-description",
        FOOTER_ELEMENT = "//android.view.View[@content-desc='View article in browser']",
        BUTTON_NAVIGATE_UP = "//android.widget.ImageButton[@content-desc='Navigate up']",
        BUTTON_READING_LISTS = "org.wikipedia:id/nav_tab_reading_lists",
        ARTICLE_STACK_IN_MY_READING_LISTS = "org.wikipedia:id/item_title_container";


    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.id(TITLE), "Cannot find article title on page!", 10);
    }


    public void swipeToFooter()
    {
        this.swipeUpToFindElements(
                By.xpath(FOOTER_ELEMENT), "Cannot find the end of article", 20);
    }

    public void addArticleToMyList()
    {
        this.waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "---Cannot find button saved---",
                6
        );
    }

    public void wayUpToMyList()
    {
        this.waitForElementAndClick(By.xpath(BUTTON_NAVIGATE_UP), "---Cannot find button back---", 6);

        this.waitForElementAndClick(By.xpath(BUTTON_NAVIGATE_UP), "---Cannot find button back_2 ---", 6);

        this.waitForElementAndClick(By.id(BUTTON_READING_LISTS), "---Cannot find button favorites---", 6);

        this.waitForElementAndClick(By.id(ARTICLE_STACK_IN_MY_READING_LISTS), "---Cannot find button article stack---", 6);

        this.assertElementHasText(
                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                "Object-oriented programming language",
                "Not find saved article"
        );
    }
}
