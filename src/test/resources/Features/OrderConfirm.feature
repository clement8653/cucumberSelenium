Feature: confirm order
  Scenario: there is one item in order
    Given one item is added into cart
    When click confirm order
    Then item info show in order confirm page
    And address info shows

  Scenario: there are several items in order
    Given several items are added into cart
    When click confirm order
    Then items info show in order confirm page
    And address info shows
