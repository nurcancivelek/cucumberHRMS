@SyntaxHRMSAPIEndToEnd2211
Feature: Validating Syntax HRMS API's
Background:
Given user generates token

Scenario: This test will check to see all employee statuses
Given user calls getEmployeeStatuses API
When User retrieves getEmployeeStatuses response
Then status code is 200 correct for get employee statuses
Then user validates employee status
