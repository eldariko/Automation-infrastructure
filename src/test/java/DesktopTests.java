import extentions.VerificationActions;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopWorkflows;

public class DesktopTests extends CommonOps {

    @Test(description = "Adding numbers")
    public void test01_Plus() {
        DesktopWorkflows.Add(calculatePage.getButton_1(), calculatePage.getButton_2());
        VerificationActions.softAssertEqualsString(DesktopWorkflows.GetNumberFromString(calculatePage.getResult().getText()), "3");

        DesktopWorkflows.Add(calculatePage.getButton_2(), calculatePage.getButton_2());
        VerificationActions.softAssertEqualsString(DesktopWorkflows.GetNumberFromString(calculatePage.getResult().getText()), "4");

        softAssert.assertAll();
    }

    @Test(description = "Subtraction numbers")
    public void test02_Minus() {
        DesktopWorkflows.Minus(calculatePage.getButton_3(), calculatePage.getButton_3());
        VerificationActions.softAssertEqualsString(DesktopWorkflows.GetNumberFromString(calculatePage.getResult().getText()), "0");

        DesktopWorkflows.Minus(calculatePage.getButton_5(), calculatePage.getButton_4());
        VerificationActions.softAssertEqualsString(DesktopWorkflows.GetNumberFromString(calculatePage.getResult().getText()), "1");

        softAssert.assertAll();
    }

    @Test(description = "Multiply numbers")
    public void test03_Multiply() {
        DesktopWorkflows.Mult(calculatePage.getButton_5(), calculatePage.getButton_6());
        VerificationActions.softAssertEqualsString(DesktopWorkflows.GetNumberFromString(calculatePage.getResult().getText()), "30");

        DesktopWorkflows.Mult(calculatePage.getButton_5(), calculatePage.getButton_5());
        VerificationActions.softAssertEqualsString(DesktopWorkflows.GetNumberFromString(calculatePage.getResult().getText()), "25");

        softAssert.assertAll();
    }

    @Test(description = "Divide numbers")
    public void test04_Divide() {
        DesktopWorkflows.Divide(calculatePage.getButton_7(), calculatePage.getButton_7());
        VerificationActions.softAssertEqualsString(DesktopWorkflows.GetNumberFromString(calculatePage.getResult().getText()), "1");

        DesktopWorkflows.Divide(calculatePage.getButton_9(), calculatePage.getButton_3());
        VerificationActions.softAssertEqualsString(DesktopWorkflows.GetNumberFromString(calculatePage.getResult().getText()), "3");

        softAssert.assertAll();
    }
}