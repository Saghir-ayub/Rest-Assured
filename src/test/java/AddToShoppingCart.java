import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;


public class AddToShoppingCart {


    @Test
    public void addToBasket() {

        RestAssured.baseURI = "http://3.11.77.136/index.php";
        RequestSpecification request = RestAssured.given();
        Cookies cookies = request.get("").then().extract().detailedCookies();

        Response response = request
                .cookies(cookies)
                .queryParam("controller", "cart")
                .contentType("multipart/form-data")
                .multiPart("token","8b3ee4f1cba54a1031be9bb7879e9dad")
                .multiPart("action", "add-to-cart")
                .multiPart("id_product", "2")
                .multiPart("id_product_attribute", "7")
                .multiPart("qty", "1")
                .multiPart("add", "1")
                .when()
                .post();
        System.out.println(response.getBody().prettyPrint());
        System.out.println(response.getStatusCode());
    }

}