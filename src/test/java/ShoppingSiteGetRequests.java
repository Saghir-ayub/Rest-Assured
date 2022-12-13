import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.containsString;

public class ShoppingSiteGetRequests {
    private static final String BASE_URL = "http://3.11.77.136/";
    @Test
    public void homepageStatusCode200(){
        when().
                get(BASE_URL).
        then().
                statusCode(200);
    }

    @Test
    public void viewMyAccountNotLoggedIn(){
        String htmlTitle = when().
                get(BASE_URL+"?controller=my-account").htmlPath().getString("html.head.title");
        Assert.assertNotEquals("My Account",htmlTitle);
    }
}
