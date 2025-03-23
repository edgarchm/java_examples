package com.testing;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RestAssuredAPITest {

    private static final String GET_URL = "https://api.example.com";

    @Test
    public void testRestAssuredAPI() {
        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .when()
                .get(GET_URL+"/data")
                .then()
                .extract()
                .response();

        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        System.out.println("Response Code: " + statusCode);
        System.out.println("Response: " + responseBody);

        assertEquals(200, statusCode); // Check if the response code is 200 (OK)
        assertTrue(responseBody.length() > 0, "Response body should not be empty"); //check that the response body has some data.
        String s = "100";
        int number = Integer.valueOf("100");
    }
}