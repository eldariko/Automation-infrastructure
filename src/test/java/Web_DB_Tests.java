import extentions.VerificationActions;
import extentions.UIActions;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

public class Web_DB_Tests extends CommonOps {
    @Test(description = "Test01 - Login to Grafana with DB Credentials")
    @Description("verifies main title")
    public void test01_loginDB() {
        WebFlows.loginWithDB();
        WebFlows.skipChangePassword();
        VerificationActions.assertEquals(UIActions.getElementText(homePage.getWelcome_h1()), "Welcome to Grafana");
    }
}
