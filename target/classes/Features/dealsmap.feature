Feature: Deat Data creation
  I want to use this template for my feature file

Scenario: Free CRM Create a new deal Scenario
    Given iuser is already on Login Page
    When title of login page is Free Crm
    Then iuser enters username and password
    | userName       | Password  |
    | Ravikumar@9999 | test@9999 |
    
    Then iuser clicks on login button 
    Then iuser is on home page
    Then iuser move to new deal page
    Then iuser enters deal details
    | title        | amount| probability | commission |
    | test deal1   | 20000 | 50          | 10        |
    | test deal2   | 50000 | 60          | 20        |
    | test deal3   | 75000 | 30          | 12        |
    | project deal | 90000 | 40          | 15        |
    
    Then close the browser
