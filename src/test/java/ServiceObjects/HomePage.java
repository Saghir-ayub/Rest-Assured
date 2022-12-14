package ServiceObjects;

import org.junit.Assert;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    public void goToHomepage() {
        response = httpRequest.get();
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
    }
}
