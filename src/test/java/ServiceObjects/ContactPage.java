package ServiceObjects;

import org.junit.Assert;

public class ContactPage extends BasePage {

    private static final String EXTENSION = "?controller=contact";

    public ContactPage() {
        super();
    }

    public void goToContactPage() {
        response = httpRequest.get(EXTENSION);
    }

    public void statusCodeOfPage(int statusCode) {
        Assert.assertEquals(statusCode, getStatusCodeOfPage());
    }

    public void titleOfPage(String title) {
        Assert.assertEquals(title, getTitleOfPage());
    }
}
