Feature: Delete an user in Reqres API
  Me as QA Analyst
  I need an API by DELETE method
  To validate that an user is deleted successfully

  Scenario Outline: Delete an user successfully and validate status code
    Given The user is in API
    When The user deletes an user with id <id>
      | id   |
      | <id> |
    Then The user validates the status code 204
    Examples:
      | id |
      | 5  |
      | 2  |
      | 20 |




