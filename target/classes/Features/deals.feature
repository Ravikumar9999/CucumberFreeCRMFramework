Feature: Deat Data creation
  I want to use this template for my feature file

Scenario: Free CRM Create a new deal Scenario
    Given user is already on Login page
    When title of Login page is Free CRM
    Then user Enters username and password
    | Ravikumar@9999 | test@9999 |
    
    Then user clicks on Login button 
    Then user is on Home page
    Then user move to new deal page
    Then user enters deal details
    | test deal | 10000 | 50 | 10 |
    
    Then Close the Browser
