package RequestTests;

import ServiceObjects.InvalidPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class InvalidPageTest {

    InvalidPage invalidPage = new InvalidPage();
    
    @Test
    @Tag("AUT-17")
    public void checkInvalid() {
        invalidPage.goToInvalidPage();
        invalidPage.statusCodeOfPage(404);
    }
    @Test
    @Tag("AUT-17")
    public void checkRedirectToHomepage() {
        invalidPage.goToRedirectedHomepage();
        invalidPage.statusCodeOfPage(302);
    }
}
