package RequestTests;

import ServiceObjects.HomePage;
import ServiceObjects.OrderPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class OrderPlacementTest {
    HomePage homePage = new HomePage();
    OrderPage orderPage = new OrderPage();
    @Tag("")
    @Test
    public void guestCanPlaceOrder(){
        homePage.getCookies();
        homePage.addToCart(2,1,7);
        homePage.deleteCookies();
        orderPage.fillInPersonalInformation("Bob", "thetester", "bobthetester2@ten10.com");
        orderPage.fillInAddress("Bob","thetester","bob town road", "bobbyville", "12345");
        orderPage.confirmShippingMethod("Deliver fast please");
        orderPage.orderValidation();
        orderPage.orderConfirmation();
    }
}
