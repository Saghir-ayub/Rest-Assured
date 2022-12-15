package RequestTests;

import ServiceObjects.HomePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AddToShoppingCartTest {
    HomePage homePage = new HomePage();

    @Test
    @Tag("")
    public void addItemsToCart(){
        homePage.getCookies();
        homePage.addToCart(2,1,7);
    }
}
