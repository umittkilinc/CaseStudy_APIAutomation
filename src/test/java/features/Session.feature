@Session
Feature: Session Testing WitWiser
  
  Scenario: Success Assign Session To User
    Given Send "AssignSessionAPI" with "POST" https request
    Then Status code is 200

  Scenario: Fail 0045 Session To User
    Given Send "AssignSessionAPI" with "POST" https request
    Then Status code is 404
    And "success" in response body is false
    And "errorCode" is in response body "0045"

  Scenario: Query Session With ID
    Given Send "AssignSessionAPI" with "GET" https request
    Then Status code is 200
    And "name" is in response body "TEST_AUTOMATIN_OTURUM_ŞABLONU"

  Scenario: Query Session Templates
    Given Send "SessionTemplatesAPI" with "GET" https request
    Then Status code is 200
    Then Total Templates check
