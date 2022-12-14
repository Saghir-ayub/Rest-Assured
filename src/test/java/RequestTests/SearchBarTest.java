package RequestTests;

import org.junit.Test;

import static io.restassured.RestAssured.*;

public class SearchBarTest {

    @Test
    public void checkSearch() {

        given().queryParam("controller", "search")
                .queryParam("s", "top");

        when().get("http://3.11.77.136/index.php").then().assertThat().statusCode(200)
                .and().assertThat().contentType("text/html; charset=utf-8");
    }
}
