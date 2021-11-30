package workflows;

import extentions.DBActions;
import extentions.WebActions;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import pageObjects.webObject.LoginPage;
import utilities.CommonOps;

import java.util.List;


public class WebFlows extends CommonOps {

    @Step
    public static void login(String userName, String password) throws FindFailed {
        WebActions.enterKey(loginPage.getTxt_userName(), userName);
        WebActions.enterKey(loginPage.getTxt_password(), password);
        screen = new Screen();
        login_btn = new Pattern(System.getProperty("user.dir") + "\\src\\main\\resources\\login_btn.png");
        screen.click(login_btn);
    }

    @Step("Login to Grafana with DB Credentials")
    public static void loginWithDB() {
        String query = "SELECT * FROM user where username='admin'";
        List<String> cred = DBActions.getCredentials(query);
        WebActions.enterKey(loginPage.getTxt_userName(), cred.get(0));
        WebActions.enterKey(loginPage.getTxt_password(), cred.get(1));
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
        WebActions.clickOnElement(loginPage.getBtn_skip());
    }

    @Step
    public static void enterToUsersPage() {
        action = new Actions(driver);
        action.moveToElement(homePage.getBtn_serverAdmin()).build().perform();
        WebActions.clickOnElement(homePage.getBtn_users());
    }

    @Step
    public static void clickAddNewUser() {
        WebActions.clickOnElement(serverAdminPage.getBtn_createNewUser());
        serverAdminPage.getBtn_createNewUser();
    }

    @Step
    public static void addUser(String name, String email, String username, String password) {
        WebActions.enterKey(serverAdminPage.getTxt_name(), name);
        WebActions.enterKey(serverAdminPage.getTxt_email(), email);
        WebActions.enterKey(serverAdminPage.getTxt_username(), username);
        WebActions.enterKey(serverAdminPage.getTxt_password(), password);
        WebActions.clickOnElement(serverAdminPage.getBtn_register());
    }

    @Step
    public static void deleteUserByLocation(int index) throws Exception {
        WebActions.clickOnElement(serverAdminPage.getRowByIndex(index));
        Thread.sleep(500);
        WebActions.clickOnElement(serverAdminPage.getBtn_deleteUser());
        WebActions.clickOnElement(serverAdminPage.getBtn_confirmDeleteUser());
    }

    @Step
    public static void enterToPluginsPage() {
        action = new Actions(driver);

        action.moveToElement(homePage.getBtn_serverAdmin()).build().perform();
        WebActions.clickOnElement(homePage.getBtn_plugins());
    }

    @Step
    public static int getPluginsNumber() throws Exception {
        WebActions.clickOnElement(serverAdminPage.getBtn_viewAllPlugins());
        Thread.sleep(3000);
        return WebActions.getSize(serverAdminPage.getBtn_allPlugins());
    }
}
