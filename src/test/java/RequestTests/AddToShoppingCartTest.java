package RequestTests;

import ServiceObjects.HomePage;
import org.junit.Test;

public class AddToShoppingCartTest {
    HomePage homePage = new HomePage();

    @Test
    public void addItemsToCart(){
        homePage.getCookies();
        homePage.addToCart();
    }
}
