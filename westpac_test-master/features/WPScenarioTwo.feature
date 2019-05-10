@Test
Feature: I want that the KiwiSaver Retirement Calculator users are able to calculate what their
  KiwiSaver projected balance would be at retirement

  @TestCase1
  Scenario: User whose Current age is 30 is Employed @ a Salary 82000 p/a and contributes to KiwiSaver @ 4% has a PIR 17.5% and chooses a high risk profile is able to calculate his projected balances at retirement
   Given I have a fields with following details
      | age | employment | salary | kiwisaver | PIR   | kiwibalance | Voluntary | Frequency | profile | goal |
      |  30 | Employed   | $82000 | 4%        | 17.5% |             |           |           | High    |      |
   When user clicks on view projection
   Then user should be able to see his projected balances at retirement

 @TestCase2
  Scenario: User whose current aged 45 is Self-employed, has a PIR 10.5%, current KiwiSaver balance is $100000, voluntary contributes $90 fortnightly and chooses medium risk profile with saving goals requirement of $290000 is able to calculate his projected balances at retirement.
    Given I have a fields with following details
      | age | employment   | salary | kiwisaver | PIR   | kiwibalance | Voluntary | Frequency   | profile | goal    |
      |  45 | Self-employed|        |           | 10.5% | $100000     | $90       | Fortnightly | Medium  | $290000 |
   When user clicks on view projection
    Then user should be able to see his projected balances at retirement

  @TestCase3
 Scenario: User whose current aged 55 is not employed, has a PIR 10.5%, current KiwiSaver balance is $140000, voluntary contributes $10 annually and chooses medium risk profile with
    saving goals requirement of $200000 is able to calculate his projected balances at retirement
    Given I have a fields with following details
      | age | employment  | salary | kiwisaver | PIR   | kiwibalance | Voluntary | Frequency | profile | goal    |
      |  55 | Not employed|        |           | 10.5% | $140000     | $10       | Annually  | Medium  | $200000 |
   When user clicks on view projection
    Then user should be able to see his projected balances at retirement
