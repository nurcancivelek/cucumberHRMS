package com.hrms.API.steps.practice;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;

import static io.restassured.RestAssured.*;


public class DELETEEmployeeAPI {
	
    private Response response;
    private static RequestSpecification request;
    String deleteEmployeeURI = "http://54.167.125.15/syntaxapi/api/deleteEmployee.php";
    
    @Given("user calls DeleteEmployee API")
    public void user_calls_DeleteEmployee_API() {
         request = given().header("Content-Type", "application/json").header("Authorization",
                    SyntaxAPIAuthenticationSteps.Token);
         request.param("employee_id", POSTCreateEmployeeAPI.employee_ID);
         
         //request.param("employee_id","3657");
       
    }
    @When("User retrieves delete response")
    public void user_retrieves_delete_response() {
        
        response=request.delete(deleteEmployeeURI);
        response.prettyPrint();
       
    }
    @Then("status code is {int} correct for delete employee")
    public void status_code_is_correct_for_delete_employee(int int1) {
         Assert.assertEquals(int1, response.getStatusCode());
         response.then().assertThat().statusCode(int1);
        
    }
    @Then("user validates employee is deleted")
    public void user_validates_employee_is_deleted() {
         //response.then().body("Message", equalTo("Entry deleted")); 
        //boolean isUpdated=response.prettyPrint().contains("Entry deleted");
        
        //Assert.assertTrue("Employee is NOT deleted",isUpdated);
    	response.then().body("employee[0].employee_id", equalTo(POSTCreateEmployeeAPI.employee_ID));

		response.then().body("message", equalTo("Entry deleted"));
	
		boolean responeMessage = response.asString().contains("Entry deleted");
		
		if(responeMessage) {
			
			System.out.println("Message is correct");
		}else {
			
			System.out.println("------INVALID MESSAGE--------");
		}
    }
}
