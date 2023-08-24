package FastTrack4Api;

import FastTrack4Api.POJO.Spartan;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class SerializationPostMethod extends TestBase {
//creating a new spartan
    //serialization(java-->Json)

    @Test

    public void test1() {
        //1.Yol
        String bodyString = "{\n" +
                " \"gender\": \"Male\",\n" +
                " \"name\": \"John\",\n" +
                " \"phone\":1234567895\n" +
                "}";
        Response responseString = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(bodyString)
                .when().post("api/spartans");
        responseString.prettyPrint();

        //2.Yol
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("name", "Jack");
        bodyMap.put("gender", "Male");
        bodyMap.put("phone", 2345678432l);
        Response responseMap = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(bodyMap)
                .when().post("api/spartans");
         responseMap.prettyPrint();

        //3.Yol(POJO) daha basit
        Spartan bodySpartan = new Spartan();
        bodySpartan.setName("Harry");
        bodySpartan.setGender("Male");
        bodySpartan.setPhone(123098765l);

        Response responseClass = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(bodySpartan)
                .when().post("api/spartans");
        responseClass.prettyPrint();


    }


}
