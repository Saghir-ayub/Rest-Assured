import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.when;

public class GetRequest {
    @Test
    public void getRequest(){
        when().get("https://swapi.dev/api/people/1").then().statusCode(200);
    }
    @Test
    public void getHeader(){
        RestAssured.baseURI = "http://3.11.77.136/index.php";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType, "text/html; charset=utf-8" );
    }
}
