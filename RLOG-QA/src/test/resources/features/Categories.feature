@CategoriesFeature
Feature: Category Test Scenarios

  @Categories_Validating_the_fields_present_in_display_page
  Scenario: Launching category page and validting the required fields in the launch screen
    Given User is on the home page
    Then user validates all the expected fields in the screen

  @Categories_Creating_new_category @category1355
  Scenario Outline: Creating a new category with mandatory fields and validating in database
    Given User is on the home page
    When User clicks on add new button
    And user creates a new category with id as "<CatID>" and name as "<CatName>"
    Then user verifies that success message is  displayed
    Then user verifies the newly added record in the database "<CatID>"

    Examples: 
      | CatID | CatName |
      | num   | Rlog    |

  @Editing_a_Category @category1355
  Scenario Outline: Editing a new category with mandatory fields and validating in database
    Given User is on the home page
    When user selects "<category id>" and clicks on search button
    And User clicks on Edit button
    And enters cat name as"<name>"
    And enters a cat quantity as <quantity>
    And enters a number of pallets as <NoOfPallets>
    And enters a cat days as <Days>
    And enters a cat amount as <Amount>
    And enters expiry date as<ExpiryDate>
    And user clicks on Add button
    And user verifies that update message is  displayed
    Then user verifies the edited record in the database "<category id>","<name>",<quantity>,<NoOfPallets>,<Days>,<Amount>

    Examples: 
      | category id | category name | id   | name   | quantity | NoOfPallets | Days | Amount | ExpiryDate |
      | num4124     | NIke          | 5789 | skybag |        2 |           3 |    1 |    100 |   12052021 |

  @Deleting_a_Category @category1355
  Scenario Outline: User deletes a category
    Given User is on the home page
    When user selects "<category id>" and clicks on search button
    And user clicks on delete button
    And user clicks confirms to delete
    And user verifies that Deleted message is  displayed
    Then user verifies that the record has been deleted from the database "<category id>"

    Examples: 
      | category id |
      | num4247     |

  @Reset_a_Category @category1355
  Scenario Outline: User resets a category
    Given User is on the home page
    When user selects a "<category id>" and clicks on search button
    And user clicks on Reset button
    And user verifies that the data is not displayed on the page

    Examples: 
      | category id |
      | num4124     |
