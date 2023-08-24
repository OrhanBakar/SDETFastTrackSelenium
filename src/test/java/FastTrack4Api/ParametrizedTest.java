package FastTrack4Api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static io.restassured.RestAssured.given;

public class ParametrizedTest extends TestBase {

    /*
     * Four ways to provide data
     * 1. value source
     * 2. Method source
     * 3. CSV source
     * 4. CSV file source
     * */

    //1. value source

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})

    public void test3(int id) {
        System.out.println(given().accept(ContentType.JSON)
                .and()
                .pathParam("id", id)
                .when().get("api/spartans/{id}")
                .then()
                .statusCode(200)
                .extract().response().path("name").toString());
    }

    //2. method source

    public static List<Integer> randomNums() {

        Random random = new Random();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(random.nextInt(100));
        }
        return nums;
    }

    @ParameterizedTest
    @MethodSource("randomNums")
    public void test1(int id) {

        System.out.println(given().accept(ContentType.JSON)
                .pathParam("id", id)
                .when().get("api/spartans/{id}")
                .then()
                .statusCode(200)
                .extract().response().path("name").toString());

    }

    //3. CSV source
    @ParameterizedTest
    @CsvSource({"20,Lothario",
    "21,Mark",
    "22,Koenraad"})
    public void nameID(String id,String name){
       Response response=given().accept(ContentType.JSON)
                .pathParam("id", id)
                .when().get("api/spartans/{id}");

        Assertions.assertEquals(name,response.path("name"));
    }

    //4. CSV File source

    @ParameterizedTest
    @CsvFileSource(resources = "/SpartanDataPOST.csv",numLinesToSkip=1)

    public void addSpartanTest(String name, String gender,Long phone){

        Map<String,Object> spartanMap=new HashMap<>();
        spartanMap.put("name",name);
        spartanMap.put("gender",gender);
        spartanMap.put("phone",phone);

        Response response= RestAssured.given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(spartanMap)
                .when().post("api/spartans")
                .then().statusCode(201)
                .extract().response();

    }


}
