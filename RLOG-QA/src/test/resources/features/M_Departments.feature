@DepatmentsFeature
Feature: Depatments Test Scenarios

  @Depatments_e2e
  Scenario Outline: Categories end to end scenario
    Given User is on the home page
    When user clicks on departments page
    Then user validates all the expected fields in the departments screen
    When User clicks on add new button
    And User enters Department ID as "<DeptID>" and "<DeptName>"
    And user selects a Category "<CatID>"
    And user selects a skip class as "<SkipClass>"
    And user clicks on save button
    Then user verifies the newly added department in the database "<DeptID>"
    And user clicks on Reset button
    When user selects created "<DeptID>" from department id dropdown
    And user clicks on Search button
    #And User clicks on Edit button
    #And user updates Recovery percent as <Percent>
    #And user clicks on save button
    #And user clicks on delete button
    #And user clicks confirms to delete
    #Then user verifies that the department record has been deleted from the database "<DeptID>"

    Examples: 
      | DeptID | DeptName    | CatID | SkipClass | Percent |
      | Mobile | Electronics |   001 | Y         |   20    |
