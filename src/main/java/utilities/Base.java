package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObjects.CalculatePage;

public class Base {
    public static WebDriver driver;


    //API
    protected static String restUrl="http://admin:admin@localhost:3000/api/admin";
    protected static RequestSpecification request;
    protected static Response response;
    protected static JsonPath jp;
    protected static JSONObject params;

    //Desktop
    protected static DesiredCapabilities capabilities;
    protected static WindowsDriver Windowsdriver;
    protected static String calcApp = "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App";

    protected static CalculatePage calculatePage;
    protected static int result;
}
