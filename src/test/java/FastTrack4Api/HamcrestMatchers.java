package FastTrack4Api;

import io.restassured.http.*;
import org.junit.jupiter.api.Test;
import io.restassured.response.*;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class HamcrestMatchers extends TestBase {

    @Test
    public void test1() {

        given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then().statusCode(200);//then() validation yapmak icin kulanilir
    }
@Test
    public void test2() {

        given().accept(ContentType.JSON)
                .and().pathParam("id", 20)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200)//then() validation yapmak icin kulanilir
                .and().assertThat().contentType(ContentType.JSON)
                .and()
                .body("name", is("Lothario"),
                        "id", equalTo(20),
                        "gender", is(not("Female")),
                        "phone", equals(7551551687l));
    }
    @Test
    public void test3() {

        List<String> names=given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then().statusCode(200)//then() validation yapmak icin kulanilir
                .extract().jsonPath().getList("name");
        System.out.println(names);

        assertThat(names,hasSize(greaterThan(20)));
        assertThat(names,hasItem("Paige"));
        assertThat(names,everyItem(not(nullValue())));
    }

}
