package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
<<<<<<< Updated upstream
=======
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
>>>>>>> Stashed changes
import org.testng.annotations.BeforeClass;

import static utilities.ManagePages.initWebPages;

public class CommonOps extends Base {
    @BeforeClass
<<<<<<< Updated upstream
    public void startSessions(){
        initChromeDriver();
    }
=======
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


    //Close session
//    @AfterClass
//    public void closeSession() {
//        activeDB="no";
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

//     //Start video recording before starting a test
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
>>>>>>> Stashed changes


<<<<<<< Updated upstream
    @Step
    public static void initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
    @Step
    public static void initFireFoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
    }
    @Step
    public static void initIeDriver(){
        WebDriverManager.iedriver().setup();
        driver=new InternetExplorerDriver();
=======
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
>>>>>>> Stashed changes
    }
}
