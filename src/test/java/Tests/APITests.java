package Tests;

import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.APIWorkflows;

public class APITests extends CommonOps {
     @Test
    public void test01(){
    // APIWorkflows.GetRequest("/stats");
     APIWorkflows.GetRequest("/settings");
     response.prettyPrint();
 }
}
