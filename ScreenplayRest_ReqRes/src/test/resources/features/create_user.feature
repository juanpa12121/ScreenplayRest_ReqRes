Feature: Create a new user in Reqres API
  Me as a Product Owner
  I need an API by POST method
  To validate hat it is has been successfully created

  Scenario Outline: Create an user successfully
    Given The user is in API
    When The user creates an user
      | name   | job   |
      | <name> | <job> |
    Then The user should see that the user has been created successfully
      | name   | job   |
      | <name> | <job> |
    Examples:
      | name | job |
      | Juan | qa  |
