package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;

public class CommonOps extends Base {
    @BeforeClass
    public void startSessions(){
        initChromeDriver();
    }


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
}
