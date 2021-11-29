import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import static workflows.webFlows.login;
import static workflows.webFlows.skipChangePassword;

public class webTests {
    @Test
    public void loginToGrafana() throws FindFailed {
        login("admin","admin");
        skipChangePassword();
    }
}
