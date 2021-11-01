Feature: Home Page Search Tests

  Scenario: User can do a search from the home page
    Given I search flight from "New Delhi" to "Bengaluru" in the search input of the home page
    When I select "2" passangers and "Economy" class
    And I press the search button in the home page
    Then the links are displayed on the results page