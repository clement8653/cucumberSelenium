#Author  Zhipeng

@SmokeScenario
Feature: testLogin

  @SmokeTest
  Scenario: login taobao
    Given I am going to login taobao
    When I input <userName> and <passWord>
    Then I should login taobao

#    Examples:
#    | userName | passWord |
#    | user1    | pass1    |

