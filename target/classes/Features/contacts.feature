 
Feature: Free CRM Create Contacts
 
  Scenario Outline: Free CRM Create a Scenario
    Given user is already on Login Page
    When title of login page is Free CRM
    Then user enters username and password
    Then user clicks on login button 
    Then user is on home page
    Then user move to new contact page
    Then user enters contacts details "<firstname>" and "<lastname>" and "<position>"
    Then Close the browser
    
    Examples: 
    | userName       | Password  | firstname | lastname | position |
    | Ravikumar@9999 | test@9999 | ARK       | Kumar    | Director |
    | Ravikumar@9999 | test@9999 | Ravi      | Kumar    | CEO      |