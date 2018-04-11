Feature: To validate Loan Tuner screen
Scenario: Navigate to Loan Tuner screen
Given User is on Citi Flex Loan welcome screen
When User clicks on Get Started on welcome screen
Then User should navigate to Customize Your Citi Flex Loan Offer screen
Given User is navigated to Customize Your Citi Flex Loan Offer screen
When User enters loan amount
Then Entered amount is shown in the loan amount field

