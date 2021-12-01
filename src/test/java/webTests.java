import extentions.VerificationActions;
import io.qameta.allure.Description;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import utilities.CommonOps;
import utilities.ManageDDT;

import static workflows.webFlows.*;

public class WebTests extends CommonOps {
    @Test(description = "Web Test - loginToGrafana", dataProvider = "data-provider", dataProviderClass = ManageDDT.class)
    public void loginToGrafana(String userName, String password) throws FindFailed {
        login(userName, password);
        skipChangePassword();
    }

    @Test(dependsOnMethods = "loginToGrafana")
    public void addNewUser() {
        enterToUsersPage();
        clickAddNewUser();
        addUser("yonatan", "yoni@gmail.com", "yoni", "123456");
    }

    @Test(dependsOnMethods = "loginToGrafana")
    public void deleteUser() throws Exception {
        enterToUsersPage();
        deleteUserByLocation(2);
    }

    @Test(description = "Number of Plugins", dependsOnMethods = "loginToGrafana")
    @Description("This test checks the number of......")
    public void checkNumberOfAllPlugins() throws Exception {
        enterToPluginsPage();
        VerificationActions.assertEquals(getPluginsCount(), 213);
    }
}
