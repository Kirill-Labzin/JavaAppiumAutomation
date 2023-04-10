package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {

    //    @Test
//    public void testCompareArticleTitle()
//    {
////в видео применяется поиск по айдишнику, у меня в примере ничего подобного нет, поэтому тест не дописан
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//        SearchPageObject.initSKIP();
//        SearchPageObject.clickSearchField();
//        SearchPageObject.typeSearchLine("Java");
//        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
////эти методы написаны без проверки, чисто по видео
//        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
//        String aricle_title = ArticlePageObject.getArticleTitle();
//
//        Assert.assertEquals(
//                "We see unexpected title!",
//                "Java (programming language)",
//                aricle_title
//        );
//
//    }

    @Test
    public void testSwipeArticle() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSKIP();
        SearchPageObject.clickSearchField();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstringByResourceText("Appium");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeToFooter();

    }


}
