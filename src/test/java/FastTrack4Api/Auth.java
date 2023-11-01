package FastTrack4Api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Auth{
    //basic Auth
@Test
    public void test1(){

    Response response=given().accept(ContentType.JSON)
            .and().auth().basic("user","user")
            .when().get("http://3.80.111.193:7000//api/spartans");

    response.prettyPrint();
}
//Bearer token
@Test
public void test2(){
 String token="Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTUxNiIsImF1ZCI6InRlYWNoZXIifQ.saFcTsRyMJQj1e8jhya1zpxngBggh5fC3lGsGyBCrQs";
   given().header("Authorization",token)
           .and().accept(ContentType.JSON)
           .when().get("https://api.qa.bookit.cydeo.com/api/campuses")
           .then().statusCode(200);
}

}
