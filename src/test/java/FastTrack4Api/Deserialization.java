package FastTrack4Api;

import FastTrack4Api.POJO.Search;
import FastTrack4Api.POJO.Spartan;
import io.restassured.http.ContentType;
import io.restassured.response.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Deserialization extends TestBase{

    @Test

    public void test1(){

        Response response=given().accept(ContentType.JSON)
                .when().get("/api/spartans/20");

        Map<String,Object> spartan20=response.as(Map.class);
        System.out.println(spartan20);


    }
    @Test
    public void test2(){//converting response to List object

        Response response=given().accept(ContentType.JSON)
                .and().queryParam("gender","Male")
                .when().get("/api/spartans");

        List<Map<String,Object>> maleSpartans=response.as(List.class);
        System.out.println(maleSpartans.get(5));
        System.out.println(maleSpartans);
    }
    @Test
    public void test3(){//converting response to custom class

        Response response=given().accept(ContentType.JSON)
                .when().get("/api/spartans/20");

        Spartan spartan20=response.as(Spartan.class);
        System.out.println(spartan20);
    }
    @Test
    public void test4(){//converting response to custom class

        Response response=given().accept(ContentType.JSON)
                .and().queryParam("gender","Male")
                .and().queryParam("nameContains","va")
                .when().get("/api/spartans/search");

        Search search=response.as(Search.class);
        System.out.println(search);
    }
}
