package ServiceObjects;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class HomePage extends BasePage {

    private Cookies cookies;

    public HomePage() {
        super();
    }

    public void goToHomepage() {
        response = httpRequest.get();
    }

    public void getCookies() {
        cookies = httpRequest.get("").then().extract().detailedCookies();
    }

    public void addToCart(int productID, int quantity, int productAttrID) {
        response = httpRequest
                .cookies(cookies)
                .queryParam("controller", "cart")
                .contentType("multipart/form-data")
                .multiPart("token", "8b3ee4f1cba54a1031be9bb7879e9dad")
                .multiPart("action", "add-to-cart")
                .multiPart("id_product", productID)
                .multiPart("id_product_attribute", productAttrID)
                .multiPart("qty", quantity)
                .multiPart("add", "1")
                .when()
                .post();
        Assertions.assertEquals("(" + quantity + ")", xmlParseByAttribute("class", "cart-products-count"));
    }

    public void statusCodeOfPage(int statusCode) {
        Assertions.assertEquals(statusCode, getStatusCodeOfPage());
    }

    public void titleOfPage(String title) {
        Assertions.assertEquals(title, getTitleOfPage());
    }

    public void checkSearch(String searchTerm) {
        response = httpRequest.queryParam("controller", "search").queryParam("s", searchTerm).when().get();
        response.then().assertThat().statusCode(200);
        Assertions.assertEquals("Search results", xmlParseByAttribute("class", "h2"));
    }

    public void login(String userName, String password) {
        getCookiesFilter();
        Response response = httpRequest
                .contentType("multipart/form-data")
                .queryParam("controller", "authentication")
                .queryParam("back", "my-account")
                .accept("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .redirects().follow(true)
                .multiPart("token", "8b3ee4f1cba54a1031be9bb7879e9dad")
                .multiPart("back", "my-account")
                .multiPart("email", "test@123.com")
                .multiPart("password", "test123")
                .multiPart("submitLogin", "1")
                .when()
                .post();
        response.getBody().prettyPrint();
        response = httpRequest.get().andReturn();
        System.out.println(response.getStatusCode());
        Response response1 = httpRequest.get().andReturn();
        response1.getBody().prettyPrint();
        Assertions.assertEquals("My account", response1.htmlPath().getString("html.head.title"));



    }
}
