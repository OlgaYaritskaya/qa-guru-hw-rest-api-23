import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class LoginTests {
    @Test
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
