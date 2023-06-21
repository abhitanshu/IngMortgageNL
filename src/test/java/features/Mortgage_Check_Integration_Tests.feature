@MortgageCheck

Feature: Integration Tests for Mortgage Check Functionality

  Scenario: To Verify if Loan should be processed homevalue is more than the loanvalue
    Given url 'http://localhost:8080/api/mortgage-check'
    And def payload = read('files/test1.json')
    And request payload
    When method  POST
    Then status 200
    And match response.feasible == true
    And match response.monthlyCosts == 532.42

  Scenario: To Verify - Loan should be processed when Loan value is less than 4 times the salary
    Given url 'http://localhost:8080/api/mortgage-check'
    And def payload = read('files/test2.json')
    And request payload
    When method  POST
    Then status 200
    And match response.feasible == true
    And match response.monthlyCosts == 177.47

  Scenario: To Verify - Loan should not be processed when Home value is less than Loan Value
    Given url 'http://localhost:8080/api/mortgage-check'
    And def payload = read('files/test3.json')
    And request payload
    When method  POST
    Then status 200
    And match response.feasible == false
    And match response.monthlyCosts == 177.47

  Scenario: To Verify - Loan should not be processed when Loan value is more than 4 times the salary
    Given url 'http://localhost:8080/api/mortgage-check'
    And def payload = read('files/test4.json')
    And request payload
    When method  POST
    Then status 200
    And match response.feasible == false
    And match response.monthlyCosts == 177.47