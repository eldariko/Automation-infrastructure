import extentions.VerificationActions;
import extentions.WebActions;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObjects.webObject.HomePage;
import utilities.CommonOps;
import workflows.WebFlows;

public class Web_DB_Tests extends CommonOps {
    @Test(description = "Test01 - Login to Grafana with DB Credentials")
    @Description("This Test login with DB credentials and verifies the main header")
    public void test01_loginDB() {
        WebFlows.loginWithDB();
        WebFlows.skipChangePassword();
        VerificationActions.assertEquals(WebActions.getElementText(homePage.getWelcome_h1()), "Welcome to Grafana");
    }
}
