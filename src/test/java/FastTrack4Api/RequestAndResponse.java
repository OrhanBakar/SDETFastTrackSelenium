package FastTrack4Api;

import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static io.restassured.RestAssured.given;

public class RequestAndResponse extends TestBase {

    @Test
    public void test1(){

        Response response= given().accept(ContentType.JSON)
                .when().get("http://3.87.65.105:8000/api/spartans/25");
        System.out.println(response.statusCode());
        Assertions.assertEquals(200,response.statusCode());
        Assertions.assertTrue(response.headers().exist());
        Assertions.assertEquals("application/json",response.header("Content-Type"));

    }

    @Test

    public void test2(){

        Response response= given().accept(ContentType.JSON)
                .when().get("/api/spartans/25");
        Assertions.assertEquals(200,response.statusCode());
        Assertions.assertEquals("Valentin",response.path("name"));
        Assertions.assertEquals("Male",response.path("gender"));
    }
    public void test3(){

        Response response= given().accept(ContentType.JSON)
                .when().get("/api/spartans");
        JsonPath jsonPath=response.jsonPath();
        List<String>names=jsonPath.getList("name");

        String name=jsonPath.getString("[0].name");
        System.out.println(name);
    }
    public void test4(){

        Response response= given().accept(ContentType.JSON)
                        .and().pathParam("id",20)
                .when().get("/api/spartans/{id}");
        response.prettyPrint();
    }
    public void test5(){

        Response response= given().accept(ContentType.JSON)
                .and().queryParam("gender","Male")
                .and().queryParam("nameContains","va")
                .when().get("/api/spartans/search");
        response.prettyPrint();
        JsonPath jsonPath=response.jsonPath();
        Long phone=jsonPath.getLong("content[1].phone");
        String name=jsonPath.getString("content[0].name");
        System.out.println(phone);
        System.out.println(name);

    }
    public void test6(){
        Map<String,Object>query=new HashMap<>();
        query.put("nameContains","ha");
        query.put("nameContains","zu");
        query.put("nameContains","yu");
        Response response= given().accept(ContentType.JSON)
                .and().queryParams(query)
                .when().get("/api/spartans/search");
        response.prettyPrint();
    }
}
