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
    }
}
