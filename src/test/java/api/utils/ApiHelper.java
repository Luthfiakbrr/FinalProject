package api.utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class ApiHelper {
    private static final String BASE_URL = "https://dummyapi.io/data/v1";
    private static final String APP_ID = "63a804408eb0cb069b57e43a";

    public static Response getUserById(String userId) {
        return given()
                .header("app-id", APP_ID)
                .get(BASE_URL + "/user/" + userId);
    }

    public static Response createUser(String firstName, String lastName, String email) {
        Map<String, Object> body = new HashMap<>();
        body.put("firstName", firstName);
        body.put("lastName", lastName);
        body.put("email", email);

        return given()
                .header("app-id", APP_ID)
                .contentType("application/json")
                .body(body)
                .post(BASE_URL + "/user/create");
    }

    public static Response updateUser(String userId, String field, String newValue) {
        Map<String, Object> body = new HashMap<>();
        body.put(field, newValue);

        return given()
                .header("app-id", APP_ID)
                .contentType("application/json")
                .body(body)
                .put(BASE_URL + "/user/" + userId);
    }

    public static Response deleteUser(String userId) {
        return given()
                .header("app-id", APP_ID)
                .delete(BASE_URL + "/user/" + userId);
    }
}
