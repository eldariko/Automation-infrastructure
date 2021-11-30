import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopWorkflows;

public class DesktopTests extends CommonOps {

    @Test
    public void test01_Plus() {
        DesktopWorkflows.Add(calculatePage.button_1, calculatePage.button_2);
        //DesktopWorkflows.AssertResult();
    }
}
