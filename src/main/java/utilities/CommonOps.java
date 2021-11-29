package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class CommonOps extends Base {

    @BeforeClass
    @Parameters({"Platform", "Browser", "URL", "Timeout", "csvFile", "ActiveDB", "DBURL", "DBUsername", "DBPassword"})
    public void setUp(String platform, String browser, String URL, String Timeout, String DDTFile, String ActiveDB, String DBURL, String DBUsername, String DBPassword) {
        this.initParameters(platform, browser, URL, Timeout, DDTFile, ActiveDB, DBURL, DBUsername, DBPassword);
        switch (platform) {
            case "web":
                initWeb();
                break;
            case "mobile":
                initMobile();
                break;
            case "api":
                break;
            case "electron":
                break;
            case "desktop":
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

    @AfterMethod
    public void afterMethod() throws Exception {
        if (platform.equalsIgnoreCase("web"))
            driver.get(url);
        MonteScreenRecorder.stopRecord();
    }

    public void initMobile() {
        dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "359451150604");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.shivgadhia.android.ukMortgageCalc");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");


        try {
            mobileDriver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), dc);
            mobileDriver.setLogLevel(Level.INFO);
            mobileDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait = new WebDriverWait(mobileDriver, 10);
            touchAction = new TouchAction(mobileDriver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ManagePages.initMortgagePage();


    }

    private void initWeb() {
    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    private static void initParameters(String platform, String browser, String URL, String Timeout, String DDTFile, String ActiveDB, String DBURL, String DBUsername, String DBPassword) {
        Base.platform = platform;
        Base.browser = browser;
        Base.url = URL;
        Base.csvFile = DDTFile;
    }
}
