import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

public class UsersTests {
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
                .body("data.first_name", hasKey("Janet"))
                .body("data.last_name", hasKey("Weaver"))
                .body("data.id", is(2));
    }
}
