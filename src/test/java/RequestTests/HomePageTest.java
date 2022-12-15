package RequestTests;

import ServiceObjects.HomePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
    @Tag("")
    public void searchIsWorking() {
        homePage.checkSearch("top");
    }
}
