@SyntaxHRMSAPIEndToEnd2211
Feature: Validating Syntax HRMS API's
Background:
Given user generates token

Scenario: This test will check to see if Employee can be deleted
Given user calls DeleteEmployee API
When User retrieves delete response
Then status code is 200 correct for delete employee
Then user validates employee is deleted