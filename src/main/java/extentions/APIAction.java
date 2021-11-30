package extentions;

import static org.testng.Assert.*;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class APIAction extends CommonOps {

    @Step("Get")
    public static Response Get(String url){
        response=request.get(url);
        return response;
    }

    @Step("Post")
    public static Response Post(String url, String name, String email,String login, String password,int OrgId){

        params = new JSONObject();
        params.put("name", name);
        params.put("email", email);
        params.put("login", login);
        params.put("password", password);
        params.put("OrgId", OrgId);

        request.body(params.toJSONString());
        response = request.post(url);
        return response;
    }

    @Step("Delete")
    public static Response Delete(String url){
        request.delete(url);
        return response;
    }

    @Step("Put")
    public static Response Put(String url){
        request.put(url);
        return response;
    }

    @Step("Assert")
    public static void AssertEquals(int x, int y){
        assertEquals(x, y);
    }
}
