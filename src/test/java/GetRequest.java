import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.when;

public class GetRequest {
    @Test
    public void getRequest(){
        when().get("https://swapi.dev/api/people/1").then().equals(5);
    }
}
