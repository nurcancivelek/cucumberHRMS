package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class GetEmployeeStatusAPI {
	
   
	private Response response;
    private static RequestSpecification request;
    String getEmployeeStatusURI="http://54.167.125.15/syntaxapi/api/employeeStatus.php";
    
    @Given("user calls getEmployeeStatuses API")
    public void user_calls_getEmployeeStatuses_API() {
          request = given().header("Content-Type", "application/json").header("Authorization",
                    SyntaxAPIAuthenticationSteps.Token);
          
       
    }
    @When("User retrieves getEmployeeStatuses response")
    public void user_retrieves_getEmployeeStatuses_response() {
        response=request.get(getEmployeeStatusURI);
        System.out.println(response.prettyPrint());
    }
    @Then("status code is {int} correct for get employee statuses")
    public void status_code_is_correct_for_get_employee_statuses(int int1) {
        Assert.assertEquals(int1,response.getStatusCode());
       
    }
    @Then("user validates employee status")
    public void user_validates_employee_status() {
        boolean isContained=response.prettyPrint().contains("Employee Status List");   
        Assert.assertTrue("Employee Status List is NOT displayed",isContained);
        
    }
}
