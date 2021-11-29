package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;

public class Base {
    public static WebDriver driver;


    //API
    protected static String restUrl="http://admin:admin@localhost:3000/api/admin";
    protected static RequestSpecification request;
    protected static Response response;
    protected static JsonPath jp;
    protected static JSONObject params;
    protected static int numOfUsers;
}
