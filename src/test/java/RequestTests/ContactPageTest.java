package RequestTests;

import ServiceObjects.ContactPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ContactPageTest {

    ContactPage contactPage = new ContactPage();

    @Test
    @Tag("")
    public void contactPageIsAvailable() {
        contactPage.goToContactPage();
        contactPage.statusCodeOfPage(200);
        contactPage.titleOfPage("Contact us");
    }
}
