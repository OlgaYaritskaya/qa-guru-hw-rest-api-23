import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;
public class StatusTests {
    //make request to https://selenoid.autotests.cloud/status

    //get response

    //check total is equals 20

    @Test
    void checkTotal20(){
        get("https://selenoid.autotests.cloud/status")
                .then()
                .body("total",is(20));
    }

    @Test
    void checkTotalWithResponseLogs(){
        get("https://selenoid.autotests.cloud/status")
                .then()
                .log().all()
                .body("total",is(20));
    }

    @Test
    void checkTotalWithLogs(){
        given()
                .log().uri() //логи запроса
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().body() //логи ответа
                .body("total", is(20));
    }

    @Test
    void checkStatusCode200(){
        given()
                .log().uri()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().status()
                .statusCode(200);
    }
    @Test
    void checkChromeVersion100(){
        given()
                .log().uri()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().body()
                .body("browsers.chrome",hasKey("100.0"));
    }
}
