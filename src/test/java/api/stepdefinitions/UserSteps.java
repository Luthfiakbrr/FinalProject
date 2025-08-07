package api.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import io.qameta.allure.Step;

public class UserSteps {
    private Response response;
    private String userId;
    private final String BASE_URL = "https://dummyapi.io/data/v1";
    private final String APP_ID = "63a804408eb0cb069b57e43a";
    private static String createdUserId;

    @Step
    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to_user_by_path(String path) {
        response = given()
                .header("app-id", APP_ID)
                .when()
                .get(BASE_URL + path);
    }

    @Step
    @When("I send a POST request to {string} with valid user data")
    public void i_send_a_post_request_to_with_valid_user_data(String path) {
        String requestBody = "{ \"firstName\": \"Test\", \"lastName\": \"User\", \"email\": \"testuser" + System.currentTimeMillis() + "@example.com\" }";

        response = given()
                .header("app-id", APP_ID)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(BASE_URL + path);

        createdUserId = response.jsonPath().getString("id");
    }

    @Step
    @When("I send a GET request to \"/user/{createdUserId}\"")
    public void i_send_a_get_request_to_created_user_id() {
        response = given()
                .header("app-id", APP_ID)
                .when()
                .get(BASE_URL + "/user/" + createdUserId);
    }

    @Step
    @When("I send a PUT request to update the user")
    public void i_send_a_put_request_to_update_user() {
        String updatedBody = "{ \"firstName\": \"Updated\", \"lastName\": \"User\" }";

        response = given()
                .header("app-id", APP_ID)
                .contentType("application/json")
                .body(updatedBody)
                .when()
                .put(BASE_URL + "/user/" + createdUserId);
    }

    @Step
    @When("I send a DELETE request to delete the user")
    public void i_send_a_delete_request_to_delete_the_user() {
        response = given()
                .header("app-id", APP_ID)
                .when()
                .delete(BASE_URL + "/user/" + createdUserId);
    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("response body should contain {string}")
    public void response_body_should_contain(String keyword) {
        assertTrue(response.getBody().asString().contains(keyword));
    }

    @Then("response body should contain created user details")
    public void response_should_contain_created_user_details() {
        response.then().body("id", notNullValue());
        response.then().body("firstName", equalTo("Test"));
    }

    @Then("response should reflect updated fields")
    public void response_should_reflect_updated_fields() {
        response.then().body("firstName", equalTo("Updated"));
    }
}
