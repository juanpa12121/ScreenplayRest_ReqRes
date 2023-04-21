Feature: Get user on Reqres API
  Me as Product Owner
  I need an API by GET method
  That consults me by id

  Background:
    Given The user is in API

  @Scenario1
  Scenario: Get user by id and validate the status code
    When The user enters the id 5
    Then The user validates the status code 201

  @Scenario2
  Scenario: Get user by id and validate quantity of principal keys
    When The user enters the id 5
    Then The user validates the quantity of keys 2

  @Scenario3
  Scenario: Get user by id and validate json response schema
    When The user enters the id 5
    Then The user validates the json schema "GetUserJson"

  @Scenario4
  Scenario: Get user by id and validate response fields
    When The user enters the id 5
    Then The user validates the response fields api

  @Scenario5
  Scenario Outline: Request an user in the API and validate response fields and expected data
    When The user consults by id <id>
    Then The user validates the response fields and expected data
      | id   | email   | first_name   | last_name   | avatar   | url   | text   |
      | <id> | <email> | <first_name> | <last_name> | <avatar> | <url> | <text> |
    Examples:
      | id | email                  | first_name | last_name | avatar                                   | url                                | text                                                                     |
      | 10 | byron.fields@reqres.in | Byron      | Fields    | https://reqres.in/img/faces/10-image.jpg | https://reqres.in/#support-heading | To keep ReqRes free, contributions towards server costs are appreciated! |


  @Scenario6
  Scenario Outline: Request an user in the API and validate expected data
    When The user consults by id <id>
    Then The user validates the response fields
      | id   | email   | first_name   | last_name   | avatar   | url   | text   |
      | <id> | <email> | <first_name> | <last_name> | <avatar> | <url> | <text> |
    Examples:
      | id | email                  | first_name | last_name | avatar                                   | url                                | text                                                                     |
      | 10 | byron.fields@reqres.in | Byron      | Fields    | https://reqres.in/img/faces/10-image.jpg | https://reqres.in/#support-heading | To keep ReqRes free, contributions towards server costs are appreciated! |

