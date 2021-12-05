import extentions.VerificationActions;
import io.qameta.allure.Description;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.CommonOps;
import utilities.ManageDDT;

import static workflows.WebFlows.*;
import static workflows.WebFlows.getPluginsNumber;

public class WebTests extends CommonOps {
    @Test(description = "Web Test - loginToGrafana", dataProvider = "data-provider", dataProviderClass = ManageDDT.class)
    @Description("Test: login To Grafana")
    public void loginToGrafana(String userName, String password) throws FindFailed {
        login(userName, password);
        skipChangePassword();
    }

    @Test(dependsOnMethods = "loginToGrafana", priority = 1)
    @Description("Test: Add new user")
    @Parameters({"name", "email", "username", "password"})
    public void addNewUser(String name, String email, String username, String password) {
        enterToUsersPage();
        clickAddNewUser();
        addUser(name, email, username, password);
    }

    @Test(dependsOnMethods = "loginToGrafana", priority = 2)
    @Description("Test: delete user by email")
    @Parameters({"email"})
    public void deleteUser(String email) throws Exception {
        enterToUsersPage();
        deleteUserByEmail(email);
    }

    @Test(dependsOnMethods = "loginToGrafana", priority = 3)
    @Description("Test: check Number Of All Plugins")
    @Parameters({"expected"})
    public void checkNumberOfAllPlugins(int expected) throws Exception {
        enterToPluginsPage();
        VerificationActions.assertEquals(getPluginsNumber(), expected);
    }
}
