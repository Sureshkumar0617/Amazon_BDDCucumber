Feature: Login for Amazon website
Scenario: Verify the Account for amazon chrome
Given as a user login for amazon website
Then as a  user click signin
Then as a user click create a account
Then as a user Verify the username Validate the Message "Enter your name"
Then as a user Verify the Mobilenumber Validate the Message "Enter your email or mobile phone number"
Then as a user Verify the Password Validate the Message "Minimum 6 characters required"