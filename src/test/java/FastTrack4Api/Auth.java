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
            .when().get("https://3.87.65.105:7000/api/spartans");

    response.prettyPrint();
}
//Bearer token
@Test
public void test2(){
 String token="Bearer (token buraya gelecek. Bearerdan sonra bosluk var)";
   given().header("Authorization",token)
           .and().accept(ContentType.JSON)
           .when().get("https://api.qa.bookit.cydeo.com/api/campuses")
           .then().statusCode(200);
}

}
