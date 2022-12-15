package RequestTests;

import ServiceObjects.HomePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

public class HomePageTest {
    HomePage homePage = new HomePage();

    @Test
    @Tag("")
    public void homePageIsWorking() {
        homePage.goToHomepage();
        homePage.statusCodeOfPage(200);
        homePage.titleOfPage("Ten10 Store");
    }

    @Test
    @Tag("AUT-10")
    public void searchIsWorking() {
        homePage.checkSearch("top");
    }
}
