@tag
Feature: Purchase the order from ecommersce

Background:
Given I landed on ecommerse website

@Regression
Scenario Outline: Positive test of submitting order
Given Logged in with username <name> and password <password>
When I add product ADIDAS ORIGINAL to cart
And checkout ADIDAS ORIGINAL and submit the order
Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation page


Examples:
|name|password|productName|
|nabeelans@gmail.com|Abcd@123|ADIDAS ORIGINAL|
|sathish123@gmail.com|Abcd@123|ADIDAS ORIGINAL|

@Smoke
Scenario Outline: Negative test of submitting order
Given Logged in with username <name> and password <password>
When I add product ADIDAS ORIGINAL to cart
And checkout ADIDAS ORIGINAL and submit the order
Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation page

Examples:
|name|password|productName|
|sathish123@gmail.com|Abcd@123|ADIDAS ORIGINAL|

@NegativeScenario
Scenario Outline: Negative test of submitting order
Given Logged in with username <name> and password <password>
Then "Incorrect email or password." message is displayed

Examples:
|name|password|productName|
|shibil@gmail.com|Abcd@123|ADIDAS ORIGINAL|