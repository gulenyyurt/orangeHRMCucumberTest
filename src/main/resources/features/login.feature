Feature: Login test verification
  @login
  Scenario: Valid login verification
    Given The user is open the OrangeHRM login page
    When The user enters valid username and password
    And The user clicks on the login button
    Then The user should be redirected to the dashboard
  @login
  Scenario: Invalid login verification
    Given The user is open the OrangeHRM login page
    When The user enters invalid username and password
    And The user clicks on the login button
    Then The user shown an error message in display
@login
  Scenario: Invalid login verification
    Given The user is open the OrangeHRM login page
    When The user enters invalid username and valid password
    And The user clicks on the login button
    Then The user shown an error message in display
@login
  Scenario: Invalid login verification
    Given The user is open the OrangeHRM login page
    When The user enters valid username and invalid password
    And The user clicks on the login button
    Then The user shown an error message in display