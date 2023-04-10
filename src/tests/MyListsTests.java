package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPagObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);


        SearchPageObject.initSKIP();
        SearchPageObject.clickSearchField();
        SearchPageObject.typeSearchLine("Java");
        String name_of_article = "Object-oriented programming language";
        SearchPageObject.clickByArticleWithSubstring(name_of_article);

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
//        String article_title = ArticlePageObject.getArt
        ArticlePageObject.addArticleToMyList();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.wayUpToMyList();

        SearchPageObject.presentForSearchResult(name_of_article);

        MyListsPagObject MyListsPagObject = new MyListsPagObject(driver);
        MyListsPagObject.swipeByArticleToDelete(name_of_article);
    }
}
