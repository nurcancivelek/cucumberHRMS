package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class GetAllEmployeesAPI {
	
	
   
	
    private Response response;
    private static RequestSpecification request;
    String getAllEmployeesURI = "http://54.167.125.15/syntaxapi/api/getAllEmployees.php";
    
    
    @Given("user calls getAllEmployees API")
    public void user_calls_getAllEmployees_API() {
          request = given().header("Content-Type", "application/json").header("Authorization",
                    SyntaxAPIAuthenticationSteps.Token);
      
    }
    @When("User retrieves getAllEmployees response")
    public void user_retrieves_getAllEmployees_response() {
        
    	System.out.println(request.log().all());
    	response=request.get(getAllEmployeesURI);
      
    }
    @Then("status code is {int} correct for get AllEmployees")
    public void status_code_is_correct_for_get_AllEmployees(int int1) {
//        Assert.assertEquals(int1,response.getStatusCode());
//        System.out.println(response.getStatusCode());
        response.then().assertThat().statusCode(int1);
       
    }
    @Then("user validates all employees are listed")
    public void user_validates_all_employees_are_listed() {
//        boolean displayed=response.prettyPrint().contains("Employee");
//        Assert.assertTrue("Employee list is displayed ", displayed);
    	JSONObject json = new JSONObject(response.prettyPrint());
		JSONArray array = json.getJSONArray("Employee");
		System.out.println("Size of list for returned Employee is: "+array.length());
		
		for(int i=0;i<=array.length()-1;i++) {
			 //"emp_firstname": "SyntaxAPIInstructor",
			  String createdEmployee=response.jsonPath().getString("Employee["+i+"].emp_firstname");
			  if(createdEmployee.equals("SyntaxAPIInstructor")) {
				  response.then().body("Employee["+i+"].emp_lastname", equalTo("employee"));
				  response.then().body("Employee["+i+"].emp_middle_name", equalTo("syntax"));
				  response.then().body("Employee["+i+"].emp_gender", equalTo("2"));
				  response.then().body("Employee["+i+"].emp_birthday", equalTo("1991-04-22"));
				  response.then().body("Employee["+i+"].emp_status", equalTo("Employee"));
				  response.then().body("Employee["+i+"].emp_job_title", equalTo("Developer"));
				  System.out.println("Employee is found!!!!!");
				  break;
			  }else {
				  //System.out.println("Employee is NOT found!!!!!");
			  }
		}
		
    }
}