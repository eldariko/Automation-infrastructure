package workflows;

import extentions.APIAction;
import io.qameta.allure.Step;

public class APIWorkflows {

    @Step("GetRequest")
    public static void GetRequest(String url) {
        APIAction.Get(url);
    }

    @Step("PostRequest")
    public static void PostRequest(String url, String name, String email,String login, String password,int OrgId) {
        APIAction.Post(url,name,email,login,password,OrgId);
    }

    @Step("DeleteRequest")
    public static void DeleteRequest(String url) {
        APIAction.Delete(url);
    }

    @Step("PutRequest")
    public static void PutRequest(String url) {
        APIAction.Put(url);
    }

    @Step("PutRequest")
    public static void AssertStatusCode(int actual, int expected) {
        APIAction.AssertEquals(actual, expected);
    }
}
