package ServiceObjects;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

abstract class BasePage {
    protected RequestSpecification httpRequest;
    protected Response response;

    BasePage() {
        RestAssured.baseURI = "http://3.11.77.136/index.php";
        this.httpRequest = RestAssured.given();
    }

    String getTitleOfPage() {
        return response.htmlPath().getString("html.head.title");
    }

    int getStatusCodeOfPage() {
        return response.statusCode();
    }
}