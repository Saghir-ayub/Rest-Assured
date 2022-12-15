package ServiceObjects;

import io.restassured.http.Cookies;
import io.restassured.path.xml.XmlPath;
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

    public void addToCart(int productID, int quantity, int productAttrID){
        response = httpRequest
                .cookies(cookies)
                .queryParam("controller", "cart")
                .contentType("multipart/form-data")
                .multiPart("token","8b3ee4f1cba54a1031be9bb7879e9dad")
                .multiPart("action", "add-to-cart")
                .multiPart("id_product", productID)
                .multiPart("id_product_attribute", productAttrID)
                .multiPart("qty", quantity)
                .multiPart("add", "1")
                .when()
                .post();
        Assert.assertEquals("("+quantity+")",xmlParseByAttribute("class","cart-products-count"));
    }

    public void deleteFromCart(int productID, int productAttrID){
        response = httpRequest
                .cookies(cookies)
                .queryParam("controller","cart")
                .queryParam("action","show")
                .multiPart("token","8b3ee4f1cba54a1031be9bb7879e9dad")
                .multiPart("action", "delete-from-cart")
                .multiPart("id_product", productID)
                .multiPart("id_product_attribute", productAttrID)
                .when()
                .post();
        XmlPath xmlPath = new XmlPath(response.getBody().asPrettyString());
        Assert.assertEquals("(0)",xmlPath.get("**.find {it.@class == 'cart-products-count'}"));
    }

    public void statusCodeOfPage(int statusCode) {
        Assert.assertEquals(statusCode, getStatusCodeOfPage());
    }

    public void titleOfPage(String title) {
        Assert.assertEquals(title, getTitleOfPage());
    }

    public void checkSearch(String searchTerm) {
        response = httpRequest.queryParam("controller", "search").queryParam("s", searchTerm).when().get();
        response.then().assertThat().statusCode(200);
        Assert.assertEquals("Search results",xmlParseByAttribute("class","h2"));
    }
}
