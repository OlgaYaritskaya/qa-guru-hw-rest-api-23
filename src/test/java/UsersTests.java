import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;

public class UsersTests {
    @Test
    @Feature("UsersProfile")
    @Story("Get user info")
    @Owner("oyaritskayao")
    void getUsersList() {

        String firstName = "Lindsay";
        String lastName = "Ferguson";
        int usersCount = 12;

        given()
                .log().uri()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().body()
                .log().status()
                .body("data[1].first_name", equalToIgnoringCase(firstName))
                .body("data[1].last_name", equalToIgnoringCase(lastName))
                .body("total", is(usersCount))
                .statusCode(200);    }

    @Test
    @Feature("UsersProfile")
    @Story("Get user info")
    @Owner("yaritskayao")
    void getUserById() {
        given()
                .log().uri()
                .get("https://reqres.in/api/users/2")
                .then()
                .log().body()
                .log().status()
                .body("data.first_name", equalToIgnoringCase("Janet"))
                .body("data.last_name", equalToIgnoringCase("Weaver"))
                .body("data.id", is(2));
    }
    @Test
    @Feature("UsersProfile")
    @Story("Get user info")
    @Owner("oyaritskayao")
    void singleUserNotFound() {
        given().
                log().uri()
                .get("https://reqres.in/api/users/23")
                .then()
                .log().body()
                .log().status()
                .statusCode(404);
    }
}
