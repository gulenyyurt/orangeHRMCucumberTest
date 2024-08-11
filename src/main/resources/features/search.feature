Feature: Search Feature verification
  @search
  Scenario: Search by employee name
    Given The user have to logged in
    When The user clicked to PIM link form left menu
    And The user navigate to the PIM page
    And The user enters the employee name filter to "123"
    And The user clicks on the search button
    Then the user must see the employees which are names started with "123"

  @search
  Scenario: Search by employee id
    Given The user have to logged in
    When The user clicked to PIM link form left menu
    And The user navigate to the PIM page
    And The user enters the employee id filter to "0320"
    And The user clicks on the search button
    Then the user must see the employees which are id's equal with "0320"