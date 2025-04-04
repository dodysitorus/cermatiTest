@CermatiTest @CermatiTestFeature
Feature: Ebay Website Filter and Search Functionality

  @Positive
  Scenario: Access a Product via category after applying multiple filters
    Given [user] opens website using the endpoint "https://www.ebay.com/"
    Then [user] verify the current url of website contains "ebay"

    When [user] click shop by category button on Home Page of Ebay website
    Then [user] select "Electronics" on Category Ebay website
    And [user] select the "Condition" filter and chooses "New" in condition on the eBay website
    And [user] select the "Price" filter and chooses "Under" in price on the eBay website
    And [user] select the "Buying Format" filter and chooses "Best Offer" in buying format on the eBay website

    Then [user] click "filters applied" button on the Ebay website
    And [user] verify the filter applied are "Under,New,Best"

  @Positive
  Scenario: Access a Product via Search
    Given [user] opens website using the endpoint "https://www.ebay.com/"
    Then [user] verify the current url of website contains "ebay"

    When [user] fills "MacBook" into the search bar on Home Page of the Ebay website
    Then [user] click search button on Home Page of the Ebay website
    And [user] verify the page loads successfully after searching for "MacBook"
    And [user] verify the index 0 of the result is contains "Macbook"