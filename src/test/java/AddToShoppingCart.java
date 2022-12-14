import ServiceObjects.HomePage;
import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;


public class AddToShoppingCart {

    HomePage homePage = new HomePage();


    @Test
    public void addToBasket() {

        homePage.goToHomepage();
        RequestSpecification request = RestAssured.given();
        Cookies cookies = request.get("").then().extract().detailedCookies();

        Response response = request
                .cookies(cookies)
                .queryParam("controller", "cart")
                .contentType("multipart/form-data")
                .multiPart("token", "8b3ee4f1cba54a1031be9bb7879e9dad")
                .multiPart("action", "add-to-cart")
                .multiPart("id_product", "2")
                .multiPart("id_product_attribute", "7")
                .multiPart("qty", "1")
                .multiPart("add", "1")
                .when()
                .post();
        XmlPath xmlPath = new XmlPath(response.getBody().asPrettyString());
        String title = xmlPath.get("**.find {it.@class == 'cart-products-count'}");
        Assert.assertEquals("(1)",title);
    }
    @Test
    public void deleteItemsToBasket(){

        homePage.goToHomepage();
        RequestSpecification request = RestAssured.given();

        Response response = request
                .cookie("PHPSESSID","n8mp0udd0h0ehibc36u1jsa19k")
                .queryParam("controller","cart")
                .queryParam("action","show")
                .multiPart("token","8b3ee4f1cba54a1031be9bb7879e9dad")
                .multiPart("action", "delete-from-cart")
                .multiPart("id_product", "1")
                .multiPart("id_product_attribute", "1")
                .when()
                .post();
        System.out.println(response.getBody().prettyPrint());
        System.out.println(response.getStatusCode());
    }
}
