@SyntaxHRMSAPIEndToEnd2211
Feature: Validating Syntax HRMS API's
Background:
Given user generates token

Scenario: This test will check to see if Employee details can be updated
Given user calls UpdateEmployee API
When User retrieves update response
Then status code is 200 correct for update employee
Then user validates employee is updated
