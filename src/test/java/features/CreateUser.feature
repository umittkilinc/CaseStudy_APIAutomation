Feature: User Testing WitWiser

  Scenario: Success Create User
    Given Send "CreateUserAPI" with "POST" https request
    Then Status code is 200
    And "active" in response body is true
    And I retrieve the UserID

  Scenario: Fail 00427 Create User
    Given Send "CreateUserAPI" with "POST" https request
    Then Status code is 500
    And "success" in response body is false
    And "errorCode" is in response body "00427"

  Scenario: Query User With User ID
    Given Send "CreateUserAPI" with "GET" https request
    Then Status code is 200
    And "active" in response body is true



