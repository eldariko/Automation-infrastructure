package extentions;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class APIAction extends CommonOps {

    public static Response Get(String url){
        response=request.get(url);
        return response;
    }
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
}
