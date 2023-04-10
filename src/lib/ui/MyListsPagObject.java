package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPagObject extends MainPageObject{

    public static final String
        FOLDER_BY_NAME_TPL = "//*[@text='{FOLDER_NAME}']",
        ARTICLE_NAME_TO_DELETE_TPL = "//*[contains(@text,'{ARTICLE_DELETE}')]";

    /* TEMPLATES METHODS */
    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getArticleXpathByName(String article_title)
    {
        return ARTICLE_NAME_TO_DELETE_TPL.replace("{ARTICLE_DELETE}", article_title);
    }
    /* TEMPLATES METHODS */

    public MyListsPagObject (AppiumDriver driver)
    {
        super(driver);
    }

//    нигде не использую
    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                By.xpath(folder_name_xpath),
                "---Cannot find folder by name " + name_of_folder,
                6);
    }


    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getArticleXpathByName(article_title);
        this.waitForElementNotPresent(
                By.xpath(article_xpath),
                "Saved article still present with title " + article_title,
                15
        );
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getArticleXpathByName(article_title);
        this.waitForElementPresent(
                By.xpath(article_xpath),
                "Cannot find saved article by title " + article_title,
                15
        );
    }

    //    нигде не использую
    public void swipeByArticleToDelete(String article_title)
    {
        String article_xpath = getArticleXpathByName(article_title);
        this.swipeElementToLeft(
                By.xpath(article_xpath),
                "Cannot find saved article"
        );

        this.assertElementHasText(
                By.id("org.wikipedia:id/reading_list_empty_text"),
                "You have no articles added to this list.",
                "Message about empty list favorite absent"
        );
    }
}
