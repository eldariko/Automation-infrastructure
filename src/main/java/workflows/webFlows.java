package workflows;

import extentions.WebActions;
import io.qameta.allure.Step;
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
        screen=new Screen();
        login_btn=new Pattern("C:\\Users\\Yonat\\Desktop"+"\\login_btn.png");
        screen.click(login_btn);
    }

}
