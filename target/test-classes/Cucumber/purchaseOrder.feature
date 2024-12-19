#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file


  @tag2
  Scenario Outline: Positive Test to submit the order
    Given Login withuserName <name> and Password<value>
    When Add the product <Prodname> to the cart
    And Chckout product <Prodname> from cart
    Then  verify the confirmation message <Message>

    Examples: 
      | name  | value | Prodname | Message |
      | sandeep.c07@gmail.com  | 1JS18ME079@s    |ZARA COAT 3 | THANKYOU FOR THE ORDER.|
     
