package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import pageObjects.CalculatePage;


import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {



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
    }

    @BeforeClass
    public static void startup() throws IOException {
        //init Api
        initApi();

        //init Desktop
        initDesktop();
    }

    @Step
    public static void initApi(){
        RestAssured.baseURI = restUrl;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }

    @Step
    public static void initDesktop() throws IOException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", calcApp);
        Windowsdriver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        Windowsdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        calculatePage = PageFactory.initElements(Windowsdriver, CalculatePage.class);
    }
}
