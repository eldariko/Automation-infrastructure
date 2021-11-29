package workflows;

import extentions.WebActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import utilities.CommonOps;


public class webFlows extends CommonOps {

    @Step
    public static void login(String userName,String password) throws FindFailed {
        WebActions.enterKey(loginPage.getTxt_userName(),userName);
        WebActions.enterKey(loginPage.getTxt_password(),password);
        screen=new Screen();
        login_btn=new Pattern("C:\\Users\\Yonat\\Desktop"+"\\login_btn.png");
        screen.click(login_btn);
    }
    @Step
    public static void skipChangePassword(){
        WebActions.clickOnElement(loginPage.getBtn_skip());
    }

    @Step
    public static void enterToUsersPage(){
        action=new Actions(driver);
        action.moveToElement(homePage.getBtn_serverAdmin()).build().perform();
        WebActions.clickOnElement(homePage.getBtn_users());
    }
    @Step
    public static void clickAddNewUser(){
        WebActions.clickOnElement(serverAdminPage.getBtn_createNewUser());
        serverAdminPage.getBtn_createNewUser();
    }
    @Step
    public static void addUser(String name,String email,String username,String password){
        WebActions.enterKey(serverAdminPage.getTxt_name(),name);
        WebActions.enterKey(serverAdminPage.getTxt_email(), email);
        WebActions.enterKey(serverAdminPage.getTxt_username(), username);
        WebActions.enterKey(serverAdminPage.getTxt_password(), password);
        WebActions.clickOnElement(serverAdminPage.getBtn_register());
    }
    @Step
    public static void deleteUserByLocation(int index)throws Exception{
        WebActions.clickOnElement(serverAdminPage.getRowByIndex(index));
        Thread.sleep(500);
        WebActions.clickOnElement(serverAdminPage.getBtn_deleteUser());
        WebActions.clickOnElement(serverAdminPage.getBtn_confirmDeleteUser());
    }
    @Step
    public static void enterToPluginsPage(){
        action=new Actions(driver);
        action.moveToElement(homePage.getBtn_serverAdmin()).build().perform();
        WebActions.clickOnElement(homePage.getBtn_plugins());
    }
    @Step
    public static int getPluginsNumber()throws Exception{
        WebActions.clickOnElement(serverAdminPage.getBtn_viewAllPlugins());
        Thread.sleep(3000);
        return WebActions.getSize(serverAdminPage.getBtn_allPlugins());
    }
}
