package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static utilities.ManagePages.*;

public class CommonOps extends Base {

    @BeforeClass
    @Parameters({"Platform", "Browser", "URL", "Timeout", "csvFile", "ActiveDB", "DBURL", "DBUsername", "DBPassword"})
    public void setUp(String platform, String browser, String URL, String Timeout, String DDTFile, String ActiveDB, String DBURL, String DBUsername, String DBPassword) {
        initParameters(platform, browser, URL, Timeout, DDTFile, ActiveDB, DBURL, DBUsername, DBPassword);
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
                initElectron();
                break;
            case "desktop":
                initDesktop();
                break;
            default:
                throw new RuntimeException("Invalid platform name");
        }
    }

    @Step("SetUp: closeSession")
    @AfterClass
    public void closeSession() {
        if (activeDB.equalsIgnoreCase("yes")) {
            JDBC.closeConnection();
        }
        if (!platform.equalsIgnoreCase("api")) {
            if (platform.equalsIgnoreCase("mobile"))
                mobileDriver.quit();
            else if (platform.equalsIgnoreCase("desktop"))
                windowsDriver.quit();
                //Web OR Electron
            else driver.quit();
        }
    }

    @Step("SetUp: beforeMethod")
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


    @Step("SetUp: initMobile")
    public void initMobile() {
        dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, p.getProperty("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, p.getProperty("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, p.getProperty("APP_ACTIVITY"));


        try {

            mobileDriver = new AppiumDriver<>(new URL(url), dc);
            mobileDriver.setLogLevel(Level.INFO);
            setWaitTimeOut(mobileDriver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        touchAction = new TouchAction(mobileDriver);

        ManagePages.initMortgagePage();


    }

    @Step("SetUp: initWeb")
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
        if (activeDB.equals("yes")) {
            JDBC.createDatabaseExample();

        }
    }

    public static void initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        setWebDriver(driver);
    }

    public static void initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        setWebDriver(driver);
    }

    public static void initIEDriver() {
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        setWebDriver(driver);

    }

    private static void setWebDriver(WebDriver driver) {
        driver.get(url);
        setWaitTimeOut(driver);
        initWebPages();
    }

    @Step("SetUp: initApi")
    public static void initApi() {
        RestAssured.baseURI = url;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }

    @Step("SetUp: initDesktop")
    public static void initDesktop() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", p.getProperty("APP_ID"));
        try {
            windowsDriver = new WindowsDriver(new URL(url), capabilities);
            setWaitTimeOut(windowsDriver);
            softAssert = new SoftAssert();
            initDesktopPages();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @Step("SetUp: initElectron")
    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver", p.getProperty("ElectronAppDriverPath"));
        opt = new ChromeOptions();
        opt.setBinary(p.getProperty("ElectronAppPath"));
        driver = new ChromeDriver(opt);
        setWaitTimeOut(driver);
        initElectronPage();
    }

    @Step("SetUp: initParameters")

    private static void initParameters(String platform, String browser, String URL, String Timeout, String DDTFile, String ActiveDB, String DBURL, String DBUsername, String DBPassword) {
        Base.platform = platform;
        Base.browser = browser;
        Base.url = URL;
        Base.csvFile = DDTFile;
        Base.timeout = Timeout;
        Base.activeDB = ActiveDB;
        Base.dbURL = DBURL;
        Base.dbUserName = DBUsername;
        Base.dbPassword = DBPassword;

    }

    @Step("SetUp: setWaitTimeOut")
    private static void setWaitTimeOut(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Long.parseLong(timeout), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(timeout));

    }

}
