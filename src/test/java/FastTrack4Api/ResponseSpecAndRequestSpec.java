package FastTrack4Api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class ResponseSpecAndRequestSpec extends SpartanSpecTestBase{

    @Test
    public void test1(){

        Response response= RestAssured.given()
                .spec(reqSpec)
                .when().get("http://3.87.65.105:8000/api/spartans/{id}")
                .then().spec(resSpec).extract().response();
        response.prettyPrint();
    }
}
