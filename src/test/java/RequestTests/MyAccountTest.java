package RequestTests;

import ServiceObjects.MyAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

public class MyAccountTest {

    MyAccount myAccount = new MyAccount();

    @Test
    @Tag("AUT-5")
    public void guestCantViewMyAccount() {
        myAccount.goToMyAccountPage();
        myAccount.titleOfPage("Login");
    }
}
