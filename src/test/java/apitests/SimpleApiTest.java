package apitests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.UserRegistrationModel;
import org.testng.annotations.Test;

public class SimpleApiTest {

    @Test
    public void checkGetRequestResponseCodeTest() {
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void  checkPostRequestResponseCodeTest() {
        UserRegistrationModel userRegistrationModel = new UserRegistrationModel();
        userRegistrationModel.setEmail("eve.holt@reqres.in");
        userRegistrationModel.setPassword("pistol");
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .body(userRegistrationModel)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log()
                .all()
                .statusCode(200);
    }
}
