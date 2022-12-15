package RequestTests;

import ServiceObjects.HomePage;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class HomePageTest {
    HomePage homePage = new HomePage();

    @Test
    public void homePageIsWorking() {
        homePage.goToHomepage();
        homePage.statusCodeOfPage(200);
        homePage.titleOfPage("Ten10 Store");
    }
}
