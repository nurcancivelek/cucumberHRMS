package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetAllJobTitlesAPI {
	
    private Response response;
    private static RequestSpecification request;
    String getJobTitlesURI="http://54.167.125.15/syntaxapi/api/jobTitle.php";
    
    @Given("user calls GETAllJobTitles.feature API")
    public void user_calls_GETAllJobTitles_feature_API() {
        request = given().header("Content-Type", "application/json").header("Authorization",
                SyntaxAPIAuthenticationSteps.Token);
        
    }
    @When("User retrieves job titles response")
    public void user_retrieves_job_titles_response() {
        response=request.get(getJobTitlesURI); 
        response.prettyPrint();
    }
    @Then("status code is {int} correct for job titles")
    public void status_code_is_correct_for_job_titles(int int1) {
    	response.then().assertThat().statusCode(int1);
//        Assert.assertEquals(int1, response.getStatusCode());
//        System.out.println("Response code is: "+response.getStatusCode());
       
    }
    @Then("user validates job titles list")
    public void user_validates_job_titles_list() {
        //boolean isDisplayed=response.prettyPrint().contains("Job Title List");   
        //Assert.assertTrue("Employee Job List is NOT displayed",isDisplayed);
    	
    	JSONObject json = new JSONObject(response.prettyPrint());
        JSONArray array = json.getJSONArray("Job Title List");
        for (int i=0; i<=array.length()-1; i++) {
        	System.out.println(array.get(i));
        	if ( i==0) {
        		Assert.assertEquals("Cloud Architect", array.get(i));
        	}else if (i==1) {
        		Assert.assertEquals("Cloud Consultant", array.get(i));
        	}else if (i==2) {
        		Assert.assertEquals("Cloud Product and Project Manager", array.get(i));
        	}else if (i==3) {
        		Assert.assertEquals("IT Analyst", array.get(i));
        	}else if (i==4) {
        		Assert.assertEquals("Network Administrator", array.get(i));
        	}else if (i==5) {
        		Assert.assertEquals("IT Support Manager", array.get(i));
        	}else if (i==6) {
        		Assert.assertEquals("Data Quality Manager", array.get(i));
        	}else if (i==7) {
        		Assert.assertEquals("Database Administrator", array.get(i));
        	}else if (i==8) {
        		Assert.assertEquals("Application Developer", array.get(i));
        	}else if (i==9) {
        		Assert.assertEquals("Developer", array.get(i));
        	}else if (i==10) {
        		Assert.assertEquals("Accountant", array.get(i));
        	}else if (i==11) {
        		Assert.assertEquals("Chief Financial Officer", array.get(i));
        	}else if (i==12) {
        		Assert.assertEquals("Controller", array.get(i));
        	}else if (i==13) {
        		Assert.assertEquals("Production Manager", array.get(i));
        	}else if (i==14) {
        		Assert.assertEquals("Jr Production Manager", array.get(i));
        	}else if (i==15) {
        		Assert.assertEquals("Sales&Marketing Manager", array.get(i));
        	}else if (i==16) {
        		Assert.assertEquals("Jr Sales Manager", array.get(i));
        	}else if (i==17) {
        		Assert.assertEquals("Graphic Designer", array.get(i));
        	}else if (i==18) {
        		Assert.assertEquals("Usaqmuri", array.get(i));
        	}
        }
        Assert.assertEquals(19, array.length());// starts from index 0 and compares the size.
		System.out.println(array.length());
        
    }
}

