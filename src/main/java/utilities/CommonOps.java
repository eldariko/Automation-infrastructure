package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;

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
    public static void startup(){
        RestAssured.baseURI = restUrl;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }
}
