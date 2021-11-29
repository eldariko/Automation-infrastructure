package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static String platform;
    protected static String browserName;
    protected static String timeout;
    protected static String url;
    protected static String ddtFile;
    protected static String activeDB;
    protected static String dbURL;
    protected static String dbUserName;
    protected static String dbPassword;

    //WEB

    public static WebDriver driver;

    //API
    public RequestSpecification httpRequest;
    public Response response;
    public JsonPath jsonPath;
    protected static JSONObject params = new JSONObject();


    // Database
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;


    ///////////Android/////////
    public static AppiumDriver mobileDriver;
    protected DesiredCapabilities dc;
    protected static String reportDirectory = "reports";
    protected static String reportFormat = "xml";
    protected static String testName = "Untitled";

    // Page Objects - Mobile
    protected static pageObjects.Appium.UnitConvertorPage unitConvertorPage;
}
