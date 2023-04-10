package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase {

    @Test
    public void testSearch()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSKIP();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.presentForSearchResult("Object-oriented programming language");

    }

    @Test
    public void testCancelSearch()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSKIP();
        SearchPageObject.clickSearchField();
        SearchPageObject.clickSearchButtonBackward();
        SearchPageObject.notPresentBackButton();

    }

    @Test
    public void testClear()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSKIP();
        SearchPageObject.clickSearchField();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clearInputField();
        SearchPageObject.checkEmptyMessage();

    }

    @Test
    public void testAmountOfNotEmptySearch()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSKIP();
        SearchPageObject.clickSearchField();

        String search_line = "Linkin Park Discography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticle();

        assertTrue("We found too few results", amount_of_search_results > 0);

    }

    @Test
//    переписать, не отрабатывает как на видео
    public void testAmountOfEmptySearch()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSKIP();
        SearchPageObject.clickSearchField();

        String search_line = "23r42rqwef";
        SearchPageObject.typeSearchLine(search_line);
//        SearchPageObject.waitForEmptyResultLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }
}
