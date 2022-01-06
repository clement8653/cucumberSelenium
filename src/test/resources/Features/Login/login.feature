#Author  Zhipeng

@SmokeScenario
Feature: testLogin

  @SmokeTest
  Scenario Outline: login taobao with valid validations
    Given I am going to login taobao
    When I input <userName> and <passWord>
    Then I should login taobao
    Examples:
    | userName | passWord |
    | 13379275604    | XXXXXXXXXX    |

  Scenario Outline: login taobao with invalid validations
    Given I am going to login taobao
    When I input <userName> and <passWord>
    Then I should not login taobao
    Examples:
      | userName | passWord |
      | user1    | pass1    |
      | @!#@#E    | DWQD!@312    |