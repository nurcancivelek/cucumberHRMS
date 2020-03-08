@SyntaxHRMSAPIEndToEnd2211
Feature: Validating Syntax HRMS API's
Background:
Given user generates token

Scenario: This test will check to see all job titles
Given user calls GETAllJobTitles.feature API
When User retrieves job titles response
Then status code is 200 correct for job titles
Then user validates job titles list
