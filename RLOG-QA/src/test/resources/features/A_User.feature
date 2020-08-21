@User_Screen_Feature
Feature: User Test Scenarios

  @User_Search_UserData
  Scenario Outline: User searchers for particular user id and verifies the user data in the database
    Given User is on the home page
    When user clicks on Administration
    And user click on user screen
    When user enters userid as "<userid>"
    And user clicks on search button
    Then user verifies all the details of the user "<userid>" in database

    Examples: 
      | userid |
      | system |

  @User_Search_LOV
  Scenario Outline: Searching for the user using username from the list
    Given User is on the home page
    When user clicks on Administration
    And user click on user screen
    And user clicks on list
    And user selects username "<username>" from the list
    And user clicks on search button
    Then user verifies the user present in the grid "<username>"

    Examples: 
      | username |
      | system   |

  @User_Search_UserRole
  Scenario Outline: User searchers for particular user id and verifies the user role data in the database
    Given User is on the home page
    When user clicks on Administration
    And user click on user screen
    When user enters userid as "<userid>"
    And user clicks on search button
    And user clicks on "<userid>"
    Then user verifies all the user role data of "<userid>" in database

    Examples: 
      | userid |
      | system |

  @User_Search_UserPrevileges
  Scenario Outline: User searchers for particular user id and verifies the user previleges data in the database
    Given User is on the home page
    When user clicks on Administration
    And user click on user screen
    When user enters userid as "<userid>"
    And user clicks on search button
    And user clicks on "<userid>"
    Then user verifies all the user Previleges data of "<userid>" in database

    Examples: 
      | userid |
      | system |

  @User_Search_Negative_Scenarios
  Scenario Outline: Negative Scenarios related to Blind search,Invalid Search and No records found.
    Given User is on the home page
    When user clicks on Administration
    And user click on user screen
    And user clicks on search button
    Then user verifies error message "<Blind_Search>"
    When user enters userid as "<Invalid>"
    And user clicks on search button
    Then user verifies error message "<Invalid_Search>"
    When user enters userid as "<Special_char>"
    And user clicks on search button
    Then user verifies error message "<Valid_user_search>"

    Examples: 
      | Invalid | Special_char | Blind_Search                              | Invalid_Search   | Valid_user_search                    |
      | Invalid | System%      | Please enter at least one search criteria | No records found | Please enter valid User ID/User Name |

    
    
    
    
       