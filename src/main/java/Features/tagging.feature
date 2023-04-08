@FunctionalTest
Feature: Free CRM application testing


@SmokeTest @RegressionTest
Scenario: Login with correct username and correct password
    Given This is a valid login test


@RegressionTest
 Scenario: Login with correct username and correct password
    Given This is a invalid login test

@SmokeTest
Scenario: Create a contact
    Given This is a contact test case

@SmokeTest @RegressionTest
Scenario: Create a deal
    Given This is a deal test case

@RegressionTest
Scenario: Create a task
    Given This is a task test case

@SmokeTest
Scenario: Verify left panel links
    Given clicking on left panel links
    
@RegressionTest
Scenario: Search a deal
    Given This is a search deal test


@SmokeTest
    Scenario: Search a contact
    Given This is a search contact test


@SmokeTest @RegressionTest
    Scenario: Search a task
    Given This is a task deal test


@SmokeTest
    Scenario: Search a case
    Given This is a case deal test

@RegressionTest
    Scenario: Search a call
    Given This is a search call test


@SmokeTest @RegressionTest
    Scenario: Search an email
    Given This is a search email test


@SmokeTest @End2End
    Scenario: Search a docs
    Given This is a search docs test
 
 
@SmokeTest @End2End
    Scenario: Search a forms
    Given This is a search forms test
 
 
@End2End
    Scenario: Search a report
    Given This is a search report test case
    
@End2End
    Scenario: Application logout
    Given This is a logout test case