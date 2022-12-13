import io.restassured.RestAssured;
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
        String htmlContent = when().
                get(BASE_URL+"?controller=my-account").htmlPath().getString("html.body");
        Assert.assertTrue("Log in to your account not present",htmlContent.contains("Log in to your account"));
    }
}
