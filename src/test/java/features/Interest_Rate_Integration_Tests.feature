@InterestRate
Feature: Integration Tests for Interest rate Functionality

  Scenario Outline: To Verify if <field> has corect value for index <index>
    Given url 'http://localhost:8080/api/interest-rates'
    When method  GET
    Then status 200
    And match response[<index>].<field> == <expectedValue>

    Examples:
      | field          | index | expectedValue |
      | maturityPeriod | 0     | 5             |
      | maturityPeriod | 1     | 10            |
      | maturityPeriod | 2     | 15            |
      | interestRate   | 0     | 2.5           |
      | interestRate   | 1     | 3             |
      | interestRate   | 2     | 3.5           |