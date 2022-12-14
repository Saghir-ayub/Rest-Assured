package RequestTests;

import ServiceObjects.MyAccount;
import org.junit.Test;

public class MyAccountTest {

    MyAccount myAccount = new MyAccount();

    @Test
    public void guestCantViewMyAccount() {
        myAccount.goToMyAccountPage();
        myAccount.titleOfPage("Login");
    }
}
