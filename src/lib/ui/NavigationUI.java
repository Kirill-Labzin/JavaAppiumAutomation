package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends  MainPageObject{

    private static final String
            BUTTON_NAVIGATE_UP = "//android.widget.ImageButton[@content-desc='Navigate up']",
            BUTTON_READING_LISTS = "org.wikipedia:id/nav_tab_reading_lists",
            ARTICLE_STACK_IN_MY_READING_LISTS = "org.wikipedia:id/item_title_container";

    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
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
