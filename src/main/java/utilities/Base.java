package utilities;

import org.sikuli.script.Screen;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;

public class Base {
    public static WebDriver driver;
    public static Screen screen;
    public static Pattern login_btn;
    public RequestSpecification httpRequest;
    public Response response;
    public JsonPath jsonPath;
}
