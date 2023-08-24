package FastTrack4Api;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Xml extends TestBase {
//getting XML format

    @Test
    public void test1() {

        Response response = given().accept(ContentType.XML)
                .when().get("/api/spartans");
        //response.prettyPrint();
        System.out.println(response.path("List.item[0].id").toString());//Tek tek gitmemiz gerekiyor
        Assertions.assertEquals("Jerry",response.path("List.item[1].name"));

        XmlPath xmlPath=response.xmlPath();
        System.out.println(xmlPath.get("List.item[4].name").toString());


    }

}
