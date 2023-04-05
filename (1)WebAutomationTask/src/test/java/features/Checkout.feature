Feature: Checkout

  Scenario: User fails to Checkout
    Given user is on Shop Homepage
    When user selects language as English
    And user goes to Brand section and selects Apple
    And user adds an Apple item to basket and proceeds to checkout
    And user selects the delivery options
    And user adds the address details and presses continue
    And user leaves personal info tab empty and presses continue
    Then Error message is returned from Fullname Field