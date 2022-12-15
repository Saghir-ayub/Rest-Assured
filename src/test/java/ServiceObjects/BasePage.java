package ServiceObjects;


import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

abstract class BasePage {
    protected RequestSpecification httpRequest;
    protected Response response;
    protected XmlPath xmlPath;

    BasePage() {
        RestAssured.baseURI = "http://3.11.77.136/index.php";
        this.httpRequest = RestAssured.given();
    }

    public String getTitleOfPage() {
        return response.htmlPath().getString("html.head.title");
    }

    int getStatusCodeOfPage() {
        return response.statusCode();
    }

    String xmlParseByAttribute(String attribute, String attributeValue) {
        xmlPath = new XmlPath(response.getBody().asPrettyString());
        return xmlPath.get("**.find {it.@"+attribute+" == '"+attributeValue+"'}");
    }
}
