import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.when;

public class GetRequest {
    private static final String BASE_URL = "https://swapi.dev/api";
    @Test
    public void getRequest(){
        when().get(BASE_URL+"/people/1").then().statusCode(200);
    }
}
