Feature: Add items into cart
  Scenario: Add one item into cart
    Given login taobao
    When search item and add apple into cart
    Then this item shows in cart


#
#  Scenario: add several items into cart
#    Given login taobao
#    When search item and add apple with different types into cart
#    Then these items should show in cart