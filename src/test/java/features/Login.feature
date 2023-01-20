Feature: Login WitWiser

  @LoginAdmin
  Scenario: Login with Admin User
    Given Send "LoginAPI" with "POST" https request
    Then Status code is 200
    And "enabled" in response body is true
    And Get "Cookie" from response header
