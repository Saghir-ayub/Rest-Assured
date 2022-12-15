package ServiceObjects;

import org.junit.jupiter.api.Assertions;

public class MyAccount extends BasePage {
    private static final String EXTENSION = "?controller=my-account";

    public MyAccount() {
        super();
    }

    public void goToMyAccountPage() {
        response = httpRequest.get(EXTENSION);
    }

    public void titleOfPage(String title) {
        Assertions.assertEquals(title, getTitleOfPage());
    }
}
