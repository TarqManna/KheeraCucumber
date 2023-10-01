Feature: Customer
Background: Steps common for all scenario
Given User Launch Chrome browser
When User opens URL "http://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And click on Login
Then User can view Dashboard

@sanity
Scenario: Add NewCustomer
When User click on customers menu
And click on customers Menu Item
And click on Add new button
Then User can view and Add new customer page
When User enter customer info
And click on Save button
Then User can view confirmation message "The new customer has been added successfully."
And close browser

@regression
Scenario: Search Customer by Email
When User click on customers menu
And click on customers Menu Item
And Enter customer Email
When click on search button
Then User should found Email in the search table
And close browser

