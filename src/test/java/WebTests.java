import extentions.VerificationActions;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import utilities.CommonOps;
import utilities.ManageDDT;

import static workflows.WebFlows.*;

public class WebTests extends CommonOps {
    @Test(description = "Web Test - loginToGrafana", dataProvider = "data-provider", dataProviderClass = ManageDDT.class)
    public void loginToGrafana(String userName, String password) throws FindFailed {
        login(userName, password);
        skipChangePassword();
    }

    @Test(dependsOnMethods = "loginToGrafana", priority = 1)
    public void addNewUser() {
        enterToUsersPage();
        clickAddNewUser();
        addUser("yonatan", "yoni@gmail.com", "yoni", "123456");
    }

    @Test(dependsOnMethods = "loginToGrafana", priority = 2)
    public void deleteUser() throws Exception {
        enterToUsersPage();
        deleteUserByLocation(2);
    }

    @Test(dependsOnMethods = "loginToGrafana", priority = 3)
    public void checkNumberOfAllPlugins() throws Exception {
        int pluginsCount;
        enterToPluginsPage();
        pluginsCount = getPluginsNumber();
        VerificationActions.assertEquals(pluginsCount, 213);
    }
}
