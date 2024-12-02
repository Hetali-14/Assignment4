package com.example.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {
	@Test
	public void testGetRequest() {
	    Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");
	    // Temporary solution: Just verifying the status code for now
	    Assert.assertEquals(response.getStatusCode(), 200);
	    Assert.assertNotNull(response.getBody());
	    Assert.assertTrue(response.getBody().asString().contains("userId"));
       
    }
	@Test
	public void testPostRequest() {
	    // Known issue: This end point occasionally fails under load
	    Response response = RestAssured.given()
	        .contentType("application/json")
	        .body("{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }")
	        .post("https://jsonplaceholder.typicode.com/posts");
	    Assert.assertEquals(response.getStatusCode(), 201);
	}
	@Test
	public void testAllPosts() {
	    Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");
	    Assert.assertEquals(response.getStatusCode(), 200);
	    Assert.assertTrue(response.getBody().jsonPath().getList("$").size() > 0);
	}

}

