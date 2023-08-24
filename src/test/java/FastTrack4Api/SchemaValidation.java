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

        Response response=given().accept(ContentType.JSON)
                .when().get("api/spartans/20")
                .then().statusCode(200)
                .and().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("singleSpartanSchema.json"))
                .extract().response();

    }
}
