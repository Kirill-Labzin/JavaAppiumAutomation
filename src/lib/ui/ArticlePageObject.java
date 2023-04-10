package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject
{
    private static final String
        TITLE = "pcs-edit-section-title-description",
        FOOTER_ELEMENT = "//android.view.View[@content-desc='View article in browser']";


    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.id(TITLE), "Cannot find article title on page!", 10);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
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
}
