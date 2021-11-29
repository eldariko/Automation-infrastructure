import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import utilities.CommonOps;

import static workflows.webFlows.*;

public class webTests extends CommonOps {
    @Test
    public void loginToGrafana() throws FindFailed {
        login("admin","admin");
        skipChangePassword();
    }

    @Test(dependsOnMethods = "loginToGrafana")
    public void addNewUser(){
        enterToUsersPage();
        clickAddNewUser();
        addUser("yonatan","yoni@gmail.com","yoni","123456");
    }

    @Test(dependsOnMethods = "loginToGrafana")
    public void deleteUser() throws Exception {
        enterToUsersPage();
        deleteUserByLocation(2);
    }
}
