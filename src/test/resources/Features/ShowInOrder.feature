#Author  Zhipeng

@SmokeScenario
Feature: Shows data in order page

  @SmokeTest
  Scenario: price and quantity show in the page
    Given item searched
    When click place order
    Then info should be shown in the page