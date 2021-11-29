import extentions.VerificationActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.AppiumWorkflow;

import java.time.Duration;

@Listeners(utilities.Listener.class)
public class AppiumTests extends CommonOps {

    @Test(description = "Test01 - Mortgage Calculation")
    @Description("Test01 - Mortgage Calculation")
    public void test_01() {
        AppiumWorkflow.calculateMortgage("500", "5", "10");
        VerificationActions.assertEquals(mortgagePage.getTxt_repayment().getText(), "£30.03");
    }


}
