package utilities;

import io.appium.java_client.*;
import io.appium.java_client.windows.WindowsDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.Appium.MortgagePage;
import pageObjects.Desktop.CalculatePage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Base {
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static String platform;
    protected static String browser;
    protected static String timeout;
    protected static String url;
    protected static String csvFile;
    protected static String activeDB;
    protected static String dbURL;
    protected static String dbUserName;
    protected static String dbPassword;
    protected static Properties p;


    //WEB

    public static WebDriver driver;
    public static Screen screen;
    public static Pattern login_btn;

    //Electron
    public static ChromeOptions opt;

    // Database
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;


    ///////////Android/////////
    public static AppiumDriver<MobileElement> mobileDriver;
    protected static MultiTouchAction touchActions;
    protected static TouchAction touchAction;
    protected DesiredCapabilities dc;
    protected static String reportDirectory = "reports";
    protected static String reportFormat = "xml";
    protected static String testName = "Untitled";

    // Page Objects - Mobile
    protected static MortgagePage mortgagePage;

    //page object web
    public static pageObjects.webObject.LoginPage loginPage;
    public static pageObjects.webObject.HomePage homePage;
    public static pageObjects.webObject.ServerAdminPage serverAdminPage;

    //page object Electron
    public static pageObjects.Electron.TodoPage todoPage;

    //API
    protected static String restUrl;
    protected static RequestSpecification request;
    protected static Response response;
    protected static JsonPath jp;
    protected static JSONObject params;

    //Desktop
    protected static DesiredCapabilities capabilities;
    protected static WindowsDriver windowsDriver;
    protected static String calcApp;

    protected static CalculatePage calculatePage;
}
