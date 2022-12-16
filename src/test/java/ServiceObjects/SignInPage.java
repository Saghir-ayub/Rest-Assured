package ServiceObjects;

import org.junit.jupiter.api.Assertions;

public class SignInPage extends BasePage{
    private static final String EXTENSION = "?controller=my-account";
    public void login(String userName, String password) {
        getCookiesFilter();
        response = httpRequest
                .contentType("multipart/form-data")
                .queryParam("controller", "authentication")
                .queryParam("back", "my-account")
                .accept("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .redirects().follow(true)
                .multiPart("token", "8b3ee4f1cba54a1031be9bb7879e9dad")
                .multiPart("back", "my-account")
                .multiPart("email", userName)
                .multiPart("password", password)
                .multiPart("submitLogin", "1")
                .when()
                .post();
    }

    public void checkIfLoggedIn(){
        response = httpRequest.get(EXTENSION).andReturn();
        Assertions.assertEquals("My account", getTitleOfPage());
    }
}
