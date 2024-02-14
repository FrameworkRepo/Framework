@tag
Feature: Place order in rahulshettyacademydemoPage
  I want to use this template for my feature file
  
  Background:
  	Given I landed on ecommerce page

  @tag2
  Scenario Outline: Place order in rahulshettyacademydemo
    Given Logged in with username <username> and password <password>
    When Add Item<item> to the cart and submit the order
    Then "THANKYOU FOR THE ORDER." verify the message on confirmationPage

    Examples: 
      | username  							| password 						| item  |
      | Framework@email.com 		| Selenium@2024		 		| ZARA COAT 3 |
