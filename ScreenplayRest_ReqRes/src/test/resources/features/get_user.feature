Feature: Get user on Reqres API
  Me as Product Owner
  I need an API by GET method
  That consults me by id

  @Scenario1
  Scenario: Request an user correctly
    Given The user is in API
    When The user enter the id 5
    Then The user validates the status code 200
