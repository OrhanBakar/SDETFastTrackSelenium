package FastTrack4Api;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SchemaValidation extends TestBase{
//Schema Json formatindaki dönütün icerisindeki bilgi formunu gösterir.
    //Yani ne tür basliklar olacak gibi.Postmanden aldigimiz dönütü kopyalayip
    //json schema generator sitelerinden Schema mizi aliyoruz. "resources" directory sinde bir file olusturup
    //bilgileri oraya kaydediyoruz. Daha sonra asagidaki islemleri uyguluyoruz
    @Test
    public void test1(){
        String token="Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTUxNiIsImF1ZCI6InRlYWNoZXIifQ.saFcTsRyMJQj1e8jhya1zpxngBggh5fC3lGsGyBCrQs";

        given().header("Authorization",token)
                .accept(ContentType.JSON)
                .and().queryParam("id",11234)
                .when().get("https://api.qa.bookit.cydeo.com/api/campuses")
                .then().statusCode(200)
                .and().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("bookitSchema.json"));

    }
}
