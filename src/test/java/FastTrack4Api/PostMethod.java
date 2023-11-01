package FastTrack4Api;

import FastTrack4Api.POJO.Spartan;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;

public class PostMethod extends TestBase{
    /**
     * creating a new spartan
     * json --> java object(map,list,custom class) deserialization
     * java object -->json serialization*/

    @Test//create a new spartan
    public void test1() {

        String bodyString= "{\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Savanna\",\n" +
                "        \"gender\": \"male\",\n" +
                "        \"phone\": 1698855561\n" +
                "    }";

        Map<String,Object> bodyMap= new HashMap<>();
        bodyMap.put("name","Jack");
        bodyMap.put("gender","Male");
        bodyMap.put("phone","8907654321L");

        Spartan bodySpartan=new Spartan();
        bodySpartan.setName("Alias");
        bodySpartan.setGender("Female");
        bodySpartan.setPhone(123456789098L);

        Response responseString=given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(bodyString)
                .when().post("/api/spartans");

        responseString.prettyPrint();

        Response responseMap=given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(bodyMap)
                .when().post("/api/spartans");

        responseMap.prettyPrint();

        Response responseClass=given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(bodySpartan)
                .when().post("/api/spartans");

        responseClass.prettyPrint();
    }
}
