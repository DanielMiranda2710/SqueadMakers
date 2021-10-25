Feature: Successful purchase
  @smokeTest
  Scenario: Successful purchase
    Given that a web user wants to buy products in swaglabs
    When he logs in
    And he selects the products he wants to buy
    Then he should see the purchase order

  @regression
  Scenario Outline: Create a shipment successful
    Given that a web user wants to buy products in swaglabs
    When he logs in him correct credentials he selects the products that he wants to buy
      | username   | password   | firstName   | lastName   | zipCode   |
      | <username> | <password> | <firstName> | <lastName> | <zipCode> |
    Then he should see the purchase order correctly
    Examples:
      | username        | password     | firstName | lastName | zipCode |
      | problem_user | secret_sauce | Dante     | Valencia | 000000  |