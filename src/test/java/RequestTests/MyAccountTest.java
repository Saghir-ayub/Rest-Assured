package RequestTests;

import ServiceObjects.MyAccount;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MyAccountTest {




    MyAccount myAccount = new MyAccount();
    private static String Account_page = "http://3.11.77.136/index.php?controller=authentication&back=my-account";
    @Test
    public void guestCantViewMyAccount() {
        myAccount.goToMyAccountPage();
        myAccount.titleOfPage("Login");
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
        Map<String,Object> requestBody = new HashMap<>();
        requestBody.put("email", "test123");
        requestBody.put("password","test123");
        Response response = given()
                .contentType("authenticate/html")
                .body(requestBody)
                .post(Account_page);
        response.getStatusCode();
        //given(response).when().get(Account_page).then().assertThat().statusCode(200);



    }



}
