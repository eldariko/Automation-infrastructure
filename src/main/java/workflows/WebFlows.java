package workflows;

import extentions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import utilities.CommonOps;
import utilities.JDBC;

import java.util.List;


public class WebFlows extends CommonOps {
    @Step("Login to Grafana")
    public static void login(String userName, String password) throws FindFailed {
        UIActions.updateText(loginPage.getTxt_userName(), userName);
        UIActions.updateText(loginPage.getTxt_password(), password);
        screen = new Screen();
        login_btn = new Pattern(System.getProperty("user.dir") + "\\src\\main\\resources\\login_btn.png");
        screen.click(login_btn);
    }

    @Step("Login to Grafana with DB Credentials")
    public static void loginWithDB() {
        String query = "SELECT * FROM user where username='admin'";
        List<String> cred = JDBC.getCredentials(query);
        UIActions.updateText(loginPage.getTxt_userName(), cred.get(0));
        UIActions.updateText(loginPage.getTxt_password(), cred.get(1));
        screen = new Screen();
        login_btn = new Pattern(System.getProperty("user.dir") + "\\src\\main\\resources\\login_btn.png");
        try {
            screen.click(login_btn);
        } catch (FindFailed e) {
            e.printStackTrace();
        }

    }

    @Step
    public static void skipChangePassword() {
        UIActions.clickOnElement(loginPage.getBtn_skip());
    }

    @Step
    public static void enterToUsersPage() {
        action = new Actions(driver);
        UIActions.performAction(action.moveToElement(homePage.getBtn_serverAdmin()).moveToElement(homePage.getBtn_users()).click().build());
    }

    @Step
    public static void clickAddNewUser() {
        UIActions.clickOnElement(serverAdminPage.getBtn_createNewUser());
    }

    @Step
    public static void addUser(String name, String email, String username, String password) {
        UIActions.updateText(serverAdminPage.getTxt_name(), name);
        UIActions.updateText(serverAdminPage.getTxt_email(), email);
        UIActions.updateText(serverAdminPage.getTxt_username(), username);
        UIActions.updateText(serverAdminPage.getTxt_password(), password);
        UIActions.clickOnElement(serverAdminPage.getBtn_register());
    }

    @Step
    public static void deleteUserByEmail(String email) throws Exception {
        UIActions.clickOnElement(serverAdminPage.getRowByEmail(email));
        Thread.sleep(500);
        UIActions.clickOnElement(serverAdminPage.getBtn_deleteUser());
        UIActions.clickOnElement(serverAdminPage.getBtn_confirmDeleteUser());
    }

    @Step
    public static void enterToPluginsPage() {
        action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(homePage.getBtn_serverAdmin()));
        action.moveToElement(homePage.getBtn_serverAdmin()).build().perform();
        UIActions.clickOnElement(homePage.getBtn_plugins());
    }

    @Step
    public static int getPluginsNumber() throws Exception {
        UIActions.clickOnElement(serverAdminPage.getBtn_viewAllPlugins());
        Thread.sleep(1000);
        return UIActions.getElemListSize(serverAdminPage.getBtn_allPlugins());
    }
}
