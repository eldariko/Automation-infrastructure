import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.APIWorkflows;

public class APITests extends CommonOps {

    @Test
    public void test01_GetStatus() {
        APIWorkflows.GetRequest("/stats");
        response.prettyPrint();
        APIWorkflows.AssertStatusCode(response.statusCode(), 200);
    }

    @Test()
    public void test02_GetSettings() {
        APIWorkflows.GetRequest("/settings");
        response.prettyPrint();
    }

    @Test
    public void test03_Post_NewUser() {
        APIWorkflows.PostRequest("/users", "Hana", "hana2@gmail.com", "123456", "12345", 1);
        response.prettyPrint();
    }

    @Test
    public void test04_DeleteUserById() {
        APIWorkflows.DeleteRequest("/users/6");
        response.prettyPrint();
    }

    @Test
    public void test05_PutUserPass() {
        APIWorkflows.PutRequest("/users/2/123");
        response.prettyPrint();
    }
}
