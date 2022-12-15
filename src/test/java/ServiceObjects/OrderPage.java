package ServiceObjects;

import org.junit.jupiter.api.Assertions;

public class OrderPage extends BasePage {

    public void fillInPersonalInformation(String firstName, String lastName, String email) {
        response = httpRequest
                .filter(cookieFilter)
                .queryParam("controller", "order")
                .contentType("multipart/form-data")
                .multiPart("token", "8b3ee4f1cba54a1031be9bb7879e9dad")
//                .multiPart("id_customer","")
                .multiPart("id_gender","1")
                .multiPart("firstname",firstName)
                .multiPart("lastname",lastName)
                .multiPart("email",email)
                .multiPart("submitCreate","1")
                .multiPart("continue","1")
                .redirects().follow(true)
                .when()
                .post();
        System.out.println(response.getStatusCode());
    }

    public void fillInAddress(String firstName, String lastName, String address, String city, String zipCode) {
        response = httpRequest
                .filter(cookieFilter)
                .queryParam("controller", "order")
                .contentType("multipart/form-data")
                .multiPart("token", "8b3ee4f1cba54a1031be9bb7879e9dad")
//                .multiPart("id_address","")
//                .multiPart("id_customer","")
                .multiPart("firstname",firstName)
                .multiPart("lastname",lastName)
                .multiPart("address",address)
                .multiPart("submitCreate","1")
                .multiPart("city",city)
                .multiPart("id_state","28")
                .multiPart("postcode","12345")
                .multiPart("id_country","21")
                .multiPart("saveAddress","delivery")
                .multiPart("use_same_address","1")
                .multiPart("submitAddress","1")
                .multiPart("confirm_addresses","1")
                .redirects().follow(true)
                .when()
                .post();
        System.out.println(response.getStatusCode());
    }

    public void confirmShippingMethod(String deliveryMessage) {
        response = httpRequest
                .filter(cookieFilter)
                .queryParam("controller", "order")
                .contentType("multipart/form-data")
                .multiPart("token", "8b3ee4f1cba54a1031be9bb7879e9dad")
                .multiPart("delivery_option[135]","2")
                .multiPart("delivery_message",deliveryMessage)
                .multiPart("confirmDeliveryOption","1")
                .redirects().follow(true)
                .when()
                .post();
        System.out.println(response.getStatusCode());
    }

    public void orderValidation() {
        response = httpRequest
                .filter(cookieFilter)
                .queryParam("controller", "validation")
                .contentType("multipart/form-data")
                .multiPart("token", "8b3ee4f1cba54a1031be9bb7879e9dad")
                .multiPart("fc","module")
                .multiPart("module","ps_wirepayment")
                .redirects().follow(true)
                .when()
                .post();
        System.out.println(response.getStatusCode());
    }

    public void orderConfirmation() {
        response = httpRequest
                .filter(cookieFilter)
                .queryParam("controller", "order-confirmation")
                .contentType("multipart/form-data")
                .multiPart("token", "8b3ee4f1cba54a1031be9bb7879e9dad")
                .multiPart("id_cart","11433")
                .multiPart("id_module","26")
                .multiPart("id_order","147")
                .multiPart("key","ab7e251d7d975e31be3ca569e63107b4")
                .redirects().follow(true)
                .when()
                .get();
        System.out.println(response.getStatusCode());
        response.getBody().prettyPrint();
        Assertions.assertEquals("Order confirmation",getTitleOfPage());
    }
}
