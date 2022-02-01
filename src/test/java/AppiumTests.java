import extentions.VerificationActions;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import utilities.ManageDDT;
import workflows.AppiumWorkflow;


@Listeners(utilities.Listener.class)
public class AppiumTests extends CommonOps {

    @Test(description = "Test01 - Mortgage Calculation", dataProvider = "data-provider", dataProviderClass = ManageDDT.class)
    @Description("Test01 - Mortgage Calculation")
    public void test_01_MortgageCalculation(String amount, String term, String rate, String expected) {
        AppiumWorkflow.calculateMortgage(amount, term, rate);
        VerificationActions.assertEquals(mortgagePage.getTxt_repayment().getText(), expected);
    }


}
