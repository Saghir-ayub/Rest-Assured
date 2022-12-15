package ServiceObjects;

import org.junit.jupiter.api.Assertions;

public class InvalidPage extends BasePage {

    private static final String EXTENSION = "?controller=basket";

    public InvalidPage() {
        super();
    }

    public void goToInvalidPage() {
        response = httpRequest.get(EXTENSION);
    }

    public void statusCodeOfPage(int statusCode) {
        Assertions.assertEquals(statusCode, getStatusCodeOfPage());
    }

    public void titleOfPage(String title) {
        Assertions.assertEquals(title, getTitleOfPage());
    }
}
