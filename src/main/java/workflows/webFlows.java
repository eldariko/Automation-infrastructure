package workflows;

import extentions.WebActions;
import io.qameta.allure.Step;
<<<<<<< Updated upstream
import org.testng.annotations.Test;
import pageObjects.webObject.LoginPage;
import utilities.Base;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class webFlows extends Base {
    @Step
    public static void logIn(String userName,String password) throws FindFailed {
        WebActions.enterKey(LoginPage.txt_userName,userName);
        WebActions.enterKey(LoginPage.txt_password,password);
=======
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import utilities.CommonOps;


public class webFlows extends CommonOps {

    @Step
    public static void login(String userName,String password) throws FindFailed {
        WebActions.enterKey(loginPage.getTxt_userName(),userName);
        WebActions.enterKey(loginPage.getTxt_password(),password);
>>>>>>> Stashed changes
        screen=new Screen();
        login_btn=new Pattern("C:\\Users\\Yonat\\Desktop"+"\\login_btn.png");
        screen.click(login_btn);
    }
<<<<<<< Updated upstream
=======
    @Step
    public static void skipChangePassword(){
        WebActions.clickOnElement(loginPage.getBtn_skip());
    }
>>>>>>> Stashed changes

}
