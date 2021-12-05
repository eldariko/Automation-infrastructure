package workflows;

import extentions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class AppiumWorkflow extends CommonOps {

    @Step("AppiumWorkflow: calculateMortgage")
    public static void calculateMortgage(String amount, String term, String rate) {
        MobileActions.updateText(mortgagePage.getTxt_amount(), amount);
        MobileActions.updateText(mortgagePage.getTxt_term(), term);
        MobileActions.updateText(mortgagePage.getTxt_rate(), rate);
        MobileActions.singleTap(mortgagePage.getBtn_calculate());

    }
}
