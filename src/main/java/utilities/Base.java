package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;

public class Base {
    public static WebDriver driver;
    public RequestSpecification httpRequest;
    public Response response;
    public JsonPath jsonPath;
}
