package RequestTests;

import ServiceObjects.MyAccount;
import ServiceObjects.SignInPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class MyAccountTest {
    MyAccount myAccount = new MyAccount();
    SignInPage signInPage = new SignInPage();
    private static final String Account_page = "http://3.11.77.136/index.php?controller=authentication&back=my-account";

    @Test
    @Tag("AUT-5")
    public void guestCantViewMyAccount() {
        myAccount.goToMyAccountPage();
        myAccount.titleOfPage("Login");
    }

    @Test
    public void getResponseBody() {
        given().when().get(Account_page).then().log().body();
    }

    @Test
    public void getResponseStatus() {
        myAccount.goToMyAccountPage();
        int statusCode = given().queryParam("email", "test@123.com")
                .queryParam("password", "test123")
                .when().get(Account_page).getStatusCode();
        System.out.println("The status code is " + statusCode);
        given().when().get(Account_page).then().assertThat().statusCode(200);
    }

    @Test
    @Tag("AUT-13")
    public void userLogin() {
        signInPage.login("test@123.com", "test123");
        signInPage.checkIfLoggedIn();
    }
}
