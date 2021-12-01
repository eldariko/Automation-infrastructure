package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageObjects.Desktop.CalculatePage;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static utilities.ManagePages.initWebPages;

public class CommonOps extends Base {

    @BeforeClass
    @Parameters({"Platform", "Browser", "URL", "Timeout", "csvFile", "ActiveDB", "DBURL", "DBUsername", "DBPassword"})
    public void setUp(String platform, String browser, String URL, String Timeout, String DDTFile, String ActiveDB, String DBURL, String DBUsername, String DBPassword) {
        this.initParameters(platform, browser, URL, Timeout, DDTFile, ActiveDB, DBURL, DBUsername, DBPassword);
        ConvertXmlToProperties.initPropertyFile();
        p = ConvertXmlToProperties.getProps();
        switch (platform) {
            case "web":
                initWeb();
                break;
            case "mobile":
                initMobile();
                break;
            case "api":
                initApi();
                break;
            case "electron":
                break;
            case "desktop":
                initDesktop();
                break;
            default:
                throw new RuntimeException("Invalid platform name");
        }
    }


    // Close session
//    @AfterClass
//    public void closeSession() {
//        if (activeDB.equalsIgnoreCase("yes")) {
//            JDBC.closeConnection();
//        }
//        if (!platform.equalsIgnoreCase("api")) {
//            if (!platform.equalsIgnoreCase("mobile"))
//                driver.quit();
//            else
//                mobileDriver.quit();
//        }
//    }

    // Start video recording before starting a test
    @BeforeMethod
    public void beforeMethod(Method method) {
        if (!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    public void initMobile() {
        dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, p.getProperty("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, p.getProperty("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, p.getProperty("APP_ACTIVITY"));


        try {
            mobileDriver = new AppiumDriver<MobileElement>(new URL(p.getProperty("url.mobile_url")), dc);
            mobileDriver.setLogLevel(Level.INFO);
            mobileDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait = new WebDriverWait(mobileDriver, 10);
            touchAction = new TouchAction(mobileDriver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ManagePages.initMortgagePage();


    }

    public static void initWeb() {

        switch (browser) {
            case "chrome":
                initChromeDriver();
                break;
            case "firefox":
                initFirefoxDriver();
                break;
            case "IE":
                initIEDriver();
                break;

            default:
                throw new RuntimeException("Invalid driverType name");
        }
    }

    public static void initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        setWaitTimeOut(driver);
        initWebPages();
    }

    public static void initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(url);
        setWaitTimeOut(driver);

        initWebPages();

    }

    public static void initIEDriver() {
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        driver.get(url);
        setWaitTimeOut(driver);
        initWebPages();

    }

    @Step
    public static void initApi() {
        RestAssured.baseURI = url;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }

    @Step
    public static void initDesktop() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", calcApp);
        try {
            Windowsdriver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            Windowsdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            calculatePage = PageFactory.initElements(Windowsdriver, CalculatePage.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    private static void initParameters(String platform, String browser, String URL, String Timeout, String DDTFile, String ActiveDB, String DBURL, String DBUsername, String DBPassword) {
        Base.platform = platform;
        Base.browser = browser;
        Base.url = URL;
        Base.csvFile = DDTFile;
        Base.timeout = Timeout;
    }

    private static void setWaitTimeOut(WebDriver driver) {
        wait = new WebDriverWait(driver, Integer.parseInt(timeout));

    }

}
