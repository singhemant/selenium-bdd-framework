#Author: Suruchi_Tiwari@pepboys.com
@smoke
Feature: Smoke Test HomePage
  I want to use this template for my feature file

  Scenario: Able to find my pepboys store
    Given I am at pepboys homepage
    When I click on Find-a-store link
    Then switch to my favorite store
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
