package FastTrack4Api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class ResponseTime extends TestBase {
@Test
    public void test1(){
    Response response = given().accept(ContentType.JSON)
            .accept(ContentType.JSON)
            .when().get("https://api.qa.bookit.cydeo.com/api/campuses")
            .then()
            .time(both(greaterThan(500L)).and(lessThanOrEqualTo(3000L)))
            .extract().response();
    System.out.println("response.getTime() = " + response.getTime());
}

}
