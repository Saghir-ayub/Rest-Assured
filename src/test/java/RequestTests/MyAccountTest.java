package RequestTests;

import ServiceObjects.MyAccount;
import io.restassured.RestAssured;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.head;

public class MyAccountTest {




    MyAccount myAccount = new MyAccount();
    private static String Account_page = "http://3.11.77.136/index.php?controller=authentication&back=my-account";
    @Test
    public void guestCantViewMyAccount() {
        myAccount.goToMyAccountPage();
        myAccount.titleOfPage("Login");
    }

    @Test
    public void getResponseBody(){
        given().when().get(Account_page).then().log().body();
    }

    @Test
    public void getResponseStatus(){
        myAccount.goToMyAccountPage();
        int statusCode= given().queryParam("email", "test@123.com")
                .queryParam("password","test123")
                .when().get(Account_page).getStatusCode();
        System.out.println("The status code is " + statusCode);
        given().when().get(Account_page).then().assertThat().statusCode(200);
    }

    @Test
    public void postUserLogin(){
       /* Map<String,Object> requestBody = new HashMap<>();
        requestBody.put("email", "test123");
        requestBody.put("password","test123");*/
        RestAssured.baseURI = "http://3.11.77.136/index.php";
        CookieFilter cookieFilter = new CookieFilter();
        RequestSpecification request = RestAssured.given().filter(cookieFilter);

        Response response = request
                .filter(cookieFilter)
             //   .header("Cookie",cookies.toString())
                //.accept(ContentType.HTML.getAcceptHeader())
                //.contentType("application/x-www-form-urlencoded")
                .contentType("multipart/form-data")
                .queryParam("controller", "authentication")
                .queryParam("back", "my-account")
                .accept("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .redirects().follow(true)
                .multiPart("token","8b3ee4f1cba54a1031be9bb7879e9dad")
                .multiPart("back", "my-account")
                .multiPart("email","test@123.com")
                .multiPart("password", "test123")
                .multiPart("submitLogin","1")
                .when()
                .post();
       // cookies = response.then().extract().detailedCookies();
        Assert.assertEquals("My account", myAccount.getTitleOfPage());
       // Assert.assertEquals(200,response.statusCode());
        response.getBody().prettyPrint();
        System.out.println(response.getStatusCode());
        Response response1 = request.filter(cookieFilter).get();
       response1.getBody().prettyPrint();
        System.out.println(cookieFilter);




    }



}
