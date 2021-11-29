package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static utilities.ManagePages.initWebPages;

public class CommonOps extends Base {

    @BeforeClass
    public void setUp() {
        platform = "web";

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


//    //Close session
//    @AfterClass
//    public void closeSession() {
//        activeDB="no";
//        if (activeDB.equalsIgnoreCase("yes")) {
//            //JDBC.closeConnection();
//        }
//        if (!platform.equalsIgnoreCase("api")) {
//            if (!platform.equalsIgnoreCase("mobile"))
//                driver.quit();
//            else
//                mobileDriver.quit();
//        }
//    }

//     //Start video recording before starting a test
//
//    @BeforeMethod
//    public void beforeMethod(Method method) {
//        if (!platform.equalsIgnoreCase("api")) {
//            try {
//                MonteScreenRecorder.startRecord(method.getName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//     //Re-navigate to Grafana URL after each test
//    @AfterMethod
//    public void afterMethod() throws Exception {
//        if (platform.equalsIgnoreCase("web"))
//            driver.get(url);
//        MonteScreenRecorder.stopRecord();
//    }

    public void initMobile() {
        dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "359451150604");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "kr.sira.unit");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".Intro");

        try {
            mobileDriver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
            mobileDriver.setLogLevel(Level.INFO);
            mobileDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ManagePages.initUnitConvertor();
    }


    public static void initWeb(){
        driverType="chrome";
                switch (driverType) {
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
        driver=new ChromeDriver();
        driver.get("http://localhost:3000");
        initWebPages();
    }
    public static void initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("http://localhost:3000");
    }
    public static void initIEDriver() {
        WebDriverManager.iedriver().setup();
        driver=new InternetExplorerDriver();
        driver.get("http://localhost:3000");
    }
}
