package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
// import junit.framework.Assert;

public class GetOneEmployeeAPI {
	
//	private static RequestSpecification request;
//	private Response response;
//	
//	@Given("user calls getOneEmployee API")
//	public void user_calls_getOneEmployee_API() {
//		request = given().header("Content-Type", "application/json").header("Authorization",
//				SyntaxAPIAuthenticationSteps.Token);	    
//		request.param("employee_id", "06952A");
//		//.when().get("http://54.167.125.15/syntaxapi/api/getOneEmployee.php");
//	
//	}
//
//	@When("User retrieves response for getOneEmployee")
//	public void user_retrieves_response_for_getOneEmployee() {
//		response=request.get("http://54.167.125.15/syntaxapi/api/getOneEmployee.php");
//		System.out.println(response.prettyPrint());
//	}
//
//	@Then("status code is {int} for get OneEmployee")
//	public void status_code_is_for_get_OneEmployee(int int1) {
//	   Assert.assertEquals(int1, response.getStatusCode());
//	}
//
//	@Then("user validates created employee exists")
//	public void user_validates_created_employee_exists() {
//		boolean isDisplayed = response.prettyPrint().contains("T~5");
//		Assert.assertTrue("Employee is displayed", isDisplayed);	
//		}
//
//
}
