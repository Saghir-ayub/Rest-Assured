package ServiceObjects;

import org.junit.jupiter.api.Assertions;

public class ContactPage extends BasePage {

    private static final String EXTENSION = "?controller=contact";

    public ContactPage() {
        super();
    }

    public void goToContactPage() {
        response = httpRequest.get(EXTENSION);
    }

    public void statusCodeOfPage(int statusCode) {
        Assertions.assertEquals(statusCode, getStatusCodeOfPage());
    }

    public void titleOfPage(String title) {
        Assertions.assertEquals(title, getTitleOfPage());
    }
}
