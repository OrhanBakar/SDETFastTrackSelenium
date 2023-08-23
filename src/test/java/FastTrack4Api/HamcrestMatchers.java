package FastTrack4Api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class HamcrestMatchers extends TestBase {

@Test
    public void test1(){

    given().accept(ContentType.JSON)
            .when().get("/api/spartans")
            .then().statusCode(200);
}


}
