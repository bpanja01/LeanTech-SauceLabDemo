@test
Feature: Checkout the selected products in Saucelab

  Background:
    Given Login into "SauceLabUrl"

  Scenario Outline: customer flow of selecting 3 random items and completing the checkout flow.
    When User select following products
      | Sauce Labs Backpack | Sauce Labs Fleece Jacket | Sauce Labs Onesie |
    Then User click on "cart"
    And Verify the following products
      | 1 | SAUCE LABS BACKPACK      |
      | 2 | SAUCE LABS FLEECE JACKET |
      | 3 | SAUCE LABS ONESIE        |
    And User click on "Checkout"
    When User enters <FirstName> <LastName> <ZipPostalCode>
    Then User click on "Continue"
    Then User click on "Finish"

    Examples:
      | FirstName  | LastName   | ZipPostalCode |
      | TestUserFN | TestUserLN | abcdef        |