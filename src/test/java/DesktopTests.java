import org.testng.annotations.Test;
import pageObjects.Desktop.CalculatePage;
import utilities.CommonOps;
import workflows.DesktopWorkflows;

public class DesktopTests extends CommonOps {

    @Test
    public void test01_Plus() {
        DesktopWorkflows.Add(calculatePage.getButton_1(), calculatePage.getButton_2(), "3");
        DesktopWorkflows.Add(calculatePage.getButton_2(), calculatePage.getButton_2(), "4");
        softAssert.assertAll();
    }

    @Test
    public void test02_Minus() {
        DesktopWorkflows.Minus(calculatePage.getButton_3(), calculatePage.getButton_3(), "0");
        DesktopWorkflows.Minus(calculatePage.getButton_5(), calculatePage.getButton_4(), "1");
        softAssert.assertAll();
    }

    @Test
    public void test03_Multiply() {
        DesktopWorkflows.Mult(calculatePage.getButton_5(), calculatePage.getButton_6(), "30");
        DesktopWorkflows.Mult(calculatePage.getButton_5(), calculatePage.getButton_5(), "25");
        softAssert.assertAll();
    }

    @Test
    public void test04_Divide() {
        DesktopWorkflows.Divide(calculatePage.getButton_7(), calculatePage.getButton_7(), "1");
        DesktopWorkflows.Divide(calculatePage.getButton_9(), calculatePage.getButton_3(), "3");
        softAssert.assertAll();
    }
}