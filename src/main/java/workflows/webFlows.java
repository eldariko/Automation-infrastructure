package workflows;

import extentions.WebActions;
import io.qameta.allure.Step;
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
        homePage.getBtn_users().click();
    }
    @Step
    public static void clickAddNewUser(){

    }

}
