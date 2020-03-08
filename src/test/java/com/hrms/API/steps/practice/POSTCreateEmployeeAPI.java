package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import com.hrms.utils.APIConstants;
import com.hrms.utils.CommonMethods;
import static org.hamcrest.Matchers.equalTo;



/**
 * 
 * 
 * @author API Instructor Please manually import --import static org.hamcrest.Matchers.equalTo;
 *
 */
public class POSTCreateEmployeeAPI {
	
	/**
	 * Declaring RequestSpecification request & Response response as global
	 * variables
	 */
	
	
	private static RequestSpecification request;
	private Response response;
	public static Object employee_ID;
	
	@Given("user calls createEmployee API to verify that an employee was created")
	public void user_calls_createEmployee_API_to_verify_that_an_employee_was_created() {
		/**
		 * Preparing request using given() method
		 **/
	 
		request = given().header("Content-Type", "application/json").header("Authorization", SyntaxAPIAuthenticationSteps.Token);
		
		/**
		 * Sending body which is stored in createEmployee.json file stored in JSONFiles
		 * folder(We installed JSON editor) we are sending body using public static
		 * readJson() method which we stored in CommonMethods class-- (will change
		 * location next class) which will read your JSON payload and convert to a
		 * String
		 * 
		 **/
				request.body(CommonMethods.readJson(APIConstants.CREATE_EMPLOYEE_JSON));
	}

	@When("User retrieves response for createEmployee API")
	public void user_retrieves_response_for_createEmployee_API() {
		
		/**
		 * Calling /createEmployee.php endpoint using when() method and storing in to
		 * response which we made global
		 */
	 
		response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
		

		/**
		 * At this point, we have sent our body with a POST request to our
		 * /createEmployee.php REST endpoint and below you can do response.prettyPrint()
		 * to see the response we get
		 */
		response.prettyPrint();
	}

	@Then("status code is {int} for createEmployeeAPI")
	public void status_code_is_for_createEmployeeAPI(int int1) {
	 
		/**
		 * we are using then() method to perform assertions below are two ways to assert
		 */

		/**
		 * Asserting using Assert class from JUnit and using assertEquals() method
		 */
		response.then().assertThat().statusCode(int1);
		/**
		 * Preferred way to assert because we can use then() method
		 */
	}

	@Then("user validates employee was created")
	public void user_validates_employee_was_created() {
	
		/**
		 * Here we are asserting to verify that in our response body we see "Message" :
		 * "Entry Created" We are asserting with equalTo() that comes from --import
		 * static org.hamcrest.Matchers.equalTo;(You need to manually import)
		 */
		response.then().body("Message", equalTo("Entry Created"));
		
		/**
		 * Here we are asserting to verify that in our response body we see --
		 * "emp_firstname" : "SyntaxAPIInstructor" We are asserting with equalTo() that
		 * comes from --import static org.hamcrest.Matchers.equalTo;(You need to
		 * manually import) The [0]is because, if you look at the response it is in the
		 * first object of the Array and first stored object to an array begins with
		 * index [0]
		 */ 
		response.then().body("Employee[0].emp_firstname", equalTo("SyntaxAPIInstructor"));
		
		JsonPath jsonPathEvaluater = response.jsonPath();
		
		employee_ID = jsonPathEvaluater.getString("Employee[0].employee_id");
		
		System.out.println("Employee ID is: "+employee_ID);
		

	}


}
