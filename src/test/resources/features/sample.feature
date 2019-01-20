#Author: singh.hemant@live.com
#Sample Feature Definition Template
Feature: Revise Cucumber framework
  I want to use this template for my feature file

  Scenario Outline: Test Login
    Given I am on the bank login page "<url>"
#    When I enter the "<userName>" and "<password>"
#    Then I verify the "<status>" in step

    Examples: 
      | userName   | password    | status  | url                                          |
      | hsingh9483 | fqr56qtc56q | success | https://www.pnc.com/en/personal-banking.html |
