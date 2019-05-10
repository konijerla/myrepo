@Test
Feature: I want that while using the KiwiSaver Retirement Calculator all fields in the calculator have got the information icon present

 @TestCase1
  Scenario: User Clicks information icon besides Current age the message “This calculator has an age limit of 64 years old as you need to be under the age of 65 to join KiwiSaver.” is displayed below the current age field.
   Given Open url and navigate to Westpac KiwiSaver Scheme Retirement Calculator
   When User Clicks information icon beside field cuurent age
   Then user should be able to see help text "This calculator has an age limit of 64 years old as you need to be under the age of 65 to join KiwiSaver."
     
