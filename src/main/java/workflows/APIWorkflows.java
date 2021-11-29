package workflows;

import extentions.APIAction;
import io.qameta.allure.Step;

public class APIWorkflows {

    @Step
    public static void GetRequest(String url) {
        APIAction.Get(url);
    }
    @Step
    public static void PostRequest(String url, String name, String email,String login, String password,int OrgId) {
        APIAction.Post(url,name,email,login,password,OrgId);
    }
}
