Feature: Get user on Reqres API
  Me as Product Owner
  I need an API by GET method
  That consults me by id

  Background:
    Given The user is in API

  @Scenario1
  Scenario: Request an user correctly
    When The user enter the id 5
    Then The user validates the status code 200

  @Scenario2
  Scenario Outline: Request an user in the API and validate the fields
    When The user consults by id <id>
    Then The user validates the response fields
      | id   | email   | first_name   | last_name   | avatar   |
      | <id> | <email> | <first_name> | <last_name> | <avatar> |
    Examples:
      | id | email                  | first_name | last_name | avatar                                   |
      | 10 | byron.fields@reqres.in | Byron      | Fields    | https://reqres.in/img/faces/10-image.jpg |