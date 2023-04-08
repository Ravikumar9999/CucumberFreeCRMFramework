
Feature: Free CRM Login Feature
 
  #With out Examples keyword:
  #Scenario: Free CRM Login Test Scenario
    #Given user is already on Login Page
    #When title of login page is Free CRM
    #Then user enters "Ravikumar@9999" and "test@9999"
    #Then user clicks on login button 
    #Then user is on home page
    
 #With Examples keyword
  Scenario Outline: Free CRM Login Test Scenario
    Given user is already on Login Page
    When title of login page is Free CRM
    Then user enters "<username>" and "<password>"
    Then user clicks on login button 
    Then user is on home page
    Then Close the browser
    
    Examples: 
    | username | password |
    | Ravikumar@9999 | test@9999 |
