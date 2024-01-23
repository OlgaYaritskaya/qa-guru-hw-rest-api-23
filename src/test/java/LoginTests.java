import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class LoginTests {
    @Test
    @Feature("Authorization")
    @Story("Negative tests")
    @Owner("yaritskayao")
    @Severity(SeverityLevel.BLOCKER)
    void userNotFoundLoginTest() {
        String authData = "{\"email\":\"eva/holt@reqres.in\", \"password\":\"citvslicka\"}";

        given()
                    .body(authData)
                    .contentType(ContentType.JSON)
                .when()
                    .log().uri()
                    .post("https://reqres.in/api/login")
                .then()
                    .log().status()
                    .log().body()
                    .statusCode(400);
    }
    @Test
    @Feature("Authorization")
    @Story("Successfull authorization")
    @Owner("yaritskayao")
    @Severity(SeverityLevel.BLOCKER)
    void successfulLoginTest() {
        String authData = "{\"email\":\"eve.holt@reqres.in\", \"password\":\"cityslicka\"}";

        given()
                .body(authData)
                .contentType(ContentType.JSON)
                .when()
                .log().uri()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }
}
