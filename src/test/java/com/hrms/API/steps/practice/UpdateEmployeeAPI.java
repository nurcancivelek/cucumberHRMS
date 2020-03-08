package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateEmployeeAPI {
	
//	private Response response;
//	//public static String Token;
//	private static RequestSpecification request;
//	String updateEmployeeURI = "http://54.167.125.15/syntaxapi/api/updateEmployee.php";
//	
//	@Given("user calls UpdateEmployee API")
//	public void user_calls_UpdateEmployee_API() {
//		request = given().header("Content-Type", "application/json").header("Authorization",
//				SyntaxAPIAuthenticationSteps.Token);	    
//		request.body(CommonMethods.readJson("/Users/vcivelek/eclipse-workspace/cucumberHRMS/src/test/resources/JSONFiles/updateEmployee.json"));
//	
//	}
//
//	@When("User retrieves update response")
//	public void user_retrieves_update_response() {
//		response = request.put(updateEmployeeURI);
//		System.out.println(response.prettyPrint());
//	}
//
//	@Then("status code is {int} correct for update employee")
//	public void status_code_is_correct_for_update_employee(int expectedStatusCode) {
//		int actualStatusCode = response.getStatusCode();
//		System.out.println("Actual status code is "+ actualStatusCode);
//		Assert.assertEquals(expectedStatusCode, actualStatusCode);
//		
//	}
//
//	@Then("user validates employee is updated")
//	public void user_validates_employee_is_updated() {
//		boolean empUpdated= response.getBody().asString().contains("Entry updated");
//		Assert.assertTrue("Employee could not be updated", empUpdated);
//	}

}
