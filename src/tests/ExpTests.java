package tests;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExpTests extends CoreTestCase {

//    @Test
//    public void testExp2(){
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'SKIP')]"),
//                "---Cannot find search contains 'SKIP'---",
//                6
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "---Cannot find search contains 'Search Wikipedia'---",
//                6
//        );
//
//        MainPageObject.assertElementHasText(
//                By.id("org.wikipedia:id/search_src_text"),
//                "Search Wikipedia",
//                "Not found"
//        );
//    }
//
//    @Test
//    public void testExp3(){
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'SKIP')]"),
//                "---Cannot find search contains 'SKIP'---",
//                6
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "---Cannot find search contains 'Search Wikipedia'---",
//                6
//        );
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "exp3",
//                "---Cannot find search input 'Search Wikipedia'---",
//                5
//        );
//
//        MainPageObject.assertElementHasText(
//                By.xpath("//*[contains(@text,'Substance that can explode')]"),
//                "Substance that can explode",
//                "Not found"
//        );
//
//        MainPageObject.assertElementHasText(
//                By.xpath("//*[contains(@text,'Mathematical operation')]"),
//                "Mathematical operation",
//                "Not found"
//        );
//
//        MainPageObject.assertElementHasText(
//                By.xpath("//*[contains(@text,'Average value of a random variable')]"),
//                "Average value of a random variable",
//                "Not found"
//        );
//
//        MainPageObject.assertElementHasText(
//                By.xpath("//*[contains(@text,'Conscious event, perception or practical knowledge')]"),
//                "Conscious event, perception or practical knowledge",
//                "Not found"
//        );
//
//        MainPageObject.waitForElementAndClear(
//                By.id("org.wikipedia:id/search_src_text"),
//                "---not found---",
//                5
//        );
//
//        WebElement empty_finder_message = MainPageObject.waitForElementPresent(
//                By.id("org.wikipedia:id/search_empty_message"),
//                "---is not empty finder message---",
//                5
//        );
//
//        MainPageObject.assertElementHasText(
//                By.id("org.wikipedia:id/search_src_text"),
//                "Search Wikipedia",
//                "Not found"
//        );
//    }
//
//    @Test
//    public void testExp5()
//    {
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'SKIP')]"),
//                "---Cannot find search contains 'SKIP'---",
//                6
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "---Cannot find search contains 'Search Wikipedia'---",
//                6
//        );
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "java",
//                "---Cannot find search input 'Search Wikipedia'---",
//                5
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
//                "---Cannot find search Article Java---",
//                6
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/page_save"),
//                "---Cannot find button saved---",
//                6
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.className("android.widget.ImageButton"),
//                "---Cannot find button backward in article---",
//                6
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Austronesian language')]"),
//                "---Cannot find search Article Java---",
//                6
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/page_save"),
//                "---Cannot find button saved in acticle---",
//                6
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.className("android.widget.ImageButton"),
//                "---Cannot find button backward in article---",
//                6
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.className("android.widget.ImageButton"),
//                "---Cannot find button backward in article---",
//                6
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/nav_tab_reading_lists"),
//                "---Cannot find button favorites---",
//                6
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/item_title_container"),
//                "---Cannot find button article stack---",
//                6
//        );
//
//        String article_1 = "Object-oriented programming language";
//        MainPageObject.assertElementHasText(
//                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
//                article_1,
//                "Not find saved article" + article_1
//        );
//
//        String article_2 = "Austronesian language";
//        MainPageObject.assertElementHasText(
//                By.xpath("//*[contains(@text,'Austronesian language')]"),
//                article_2,
//                "Not find saved article" + article_2
//        );
//
//        MainPageObject.swipeElementToLeft(
//                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
//                "Saved article not found"
//        );
//
//        MainPageObject.waitForElementNotPresent(
//                By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
//                "Saved article not found",
//                5
//        );
//
//        MainPageObject.assertElementHasText(
//                By.xpath("//*[contains(@text,'Austronesian language')]"),
//                article_2,
//                "Not find saved article" + article_2
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Austronesian language')]"),
//                article_2,
//                6
//        );
//
//        MainPageObject.waitForElementPresent(
//                By.xpath("//*[contains(@text,'Austronesian language')]"),
//                "Article is not found",
//                5
//        );
//
//    }

}
