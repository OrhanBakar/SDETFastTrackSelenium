package FastTrack4Api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.*;

public class SpartanSpecTestBase {

    public RequestSpecification reqSpec= RestAssured.given().accept(ContentType.JSON)
            .pathParam("id",107);

    public ResponseSpecification resSpec=reqSpec.expect().statusCode(200);


}
