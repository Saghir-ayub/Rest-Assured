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
}
