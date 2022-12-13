import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.containsString;

public class StarWarsTemplate {
    private static final String STAR_WARS_API_URL = "https://swapi.dev/api";
    @Test
    public void getRequest(){
        when().
                get(STAR_WARS_API_URL +"/people/1").
        then().
                statusCode(200).
                    body("name",containsString("Luke Skywalker"));
    }
}
