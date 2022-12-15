package RequestTests;

import ServiceObjects.ContactPage;
import org.junit.Test;

public class ContactPageTest {

    ContactPage contactPage = new ContactPage();

    @Test
    public void contactPageIsAvailable() {
        contactPage.goToContactPage();
        contactPage.statusCodeOfPage(200);
        contactPage.titleOfPage("Contact us");
    }
}
