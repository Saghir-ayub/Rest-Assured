package ServiceObjects;

import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.junit.Assert;

public class HomePage extends BasePage {

    private Cookies cookies;

    public HomePage() {
        super();
    }

    public void goToHomepage() {
        response = httpRequest.get();
    }

    public void getCookies(){
        cookies = httpRequest.get("").then().extract().detailedCookies();
    }

    public void addToCart(){
        response = httpRequest
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
    }

    public void statusCodeOfPage(int statusCode) {
        Assert.assertEquals(statusCode, getStatusCodeOfPage());
    }

    public void titleOfPage(String title) {
        Assert.assertEquals(title, getTitleOfPage());
    }
}
