package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.EbayPages;
import org.example.utils.DriverFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EbaySteps {

    private final EbayPages ebayPages = new EbayPages();

    @And("[user] fills {string} into the search bar on Home Page of the Ebay website")
    public void userFillsIntoTheSearchBarOnHomePageOfTheEbayWebsite(String query) {
        ebayPages.fillSearchBar(query);
    }

    @And("[user] click search button on Home Page of the Ebay website")
    public void userClickSearchButtonOnHomePageOfTheEbayWebsite() {
        ebayPages.clickButtonSearch();
    }

    @And("[user] verify the page loads successfully after searching for {string}")
    public void userVerifyThePageLoadsSuccessfullyAfterSearchingFor(String query) {
        String actualTitle = DriverFactory.getDriver().getTitle();
        System.out.println("Actual Title is: " + actualTitle);
        assertThat("wrong assertion for current page", actualTitle, containsString(query));
    }

    @And("[user] verify the index {} of the result is contains {string}")
    public void userVerifyTheIndexOfTheResultIsContains(Integer index, String query) {
        String actualResult = ebayPages.listOfResultQuery().get(index).toLowerCase();
        System.out.println("Actual Query for index " + index + " is: " + actualResult);
        assertThat("wrong assertion for query result", actualResult, containsString(query.toLowerCase()));
    }

    @When("[user] click shop by category button on Home Page of Ebay website")
    public void userClickShopByCategoryButtonOnHomePageOfEbayWebsite() {
        ebayPages.clickShopByCategoryBtn();
    }

    @Then("[user] select {string} on Category Ebay website")
    public void userSelectOnCategoryEbayWebsite(String category) {
        ebayPages.selectCategory(category);
    }

    @And("[user] select the {string} filter and chooses {string} in condition on the eBay website")
    public void userSelectTheFilterAndChoosesInConditionOnTheEBayWebsite(String filter, String condition) {
        ebayPages.selectFilter(filter);
        ebayPages.selectCondition(condition);
    }

    @And("[user] select the {string} filter and chooses {string} in price on the eBay website")
    public void userSelectTheFilterAndChoosesInPriceOnTheEBayWebsite(String filter, String price) {
        ebayPages.selectFilter(filter);
        ebayPages.selectCondition(price);
    }

    @And("[user] select the {string} filter and chooses {string} in buying format on the eBay website")
    public void userSelectTheFilterAndChoosesInBuyingFormatOnTheEBayWebsite(String filter, String buyingFormat) {
        ebayPages.selectFilter(filter);
        ebayPages.selectCondition(buyingFormat);
    }

    @Then("[user] click {string} button on the Ebay website")
    public void userClickFilterAppliedButtonOnTheEbayWebsite(String query) {
        ebayPages.clickFilterAppliedBtn(query);
    }

    @And("[user] verify the filter applied are {string}")
    public void userVerifyTheFilterAppliedAre(String filterApplied) {
        List<String> expectedFilterApplied = new ArrayList<>();
        String[] filters = filterApplied.split(",");

        for (String filter : filters) {
            expectedFilterApplied.add(filter.trim());
        }

        List<String> actualFiltersApplied = ebayPages.listOfFiltersApplied();

        List<String> processedActualFilters = new ArrayList<>();
        for (String actualFilter : actualFiltersApplied) {
            String[] splitFilter = actualFilter.split(":");
            if (splitFilter.length > 1) {
                String filter = splitFilter[1].trim().split(" ")[0]; // Take only the first word (e.g., "Under")
                processedActualFilters.add(filter);
            }
        }

        System.out.println("Expected Filters: " + expectedFilterApplied);
        System.out.println("Actual Filters: " + processedActualFilters);

        for (String expected : expectedFilterApplied) {
            assertThat("The expected filter '" + expected + "' is not applied on the page",
                    processedActualFilters.contains(expected), is(true));
        }
    }
}
