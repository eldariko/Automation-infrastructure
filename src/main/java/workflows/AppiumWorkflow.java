package workflows;

import extentions.AppiumActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class AppiumWorkflow extends CommonOps {

    @Step("AppiumWorkflow: calculateMortgage")
    public static void calculateMortgage(String amount, String term, String rate) {
        AppiumActions.updateText(mortgagePage.getTxt_amount(), amount);
        AppiumActions.updateText(mortgagePage.getTxt_term(), term);
        AppiumActions.updateText(mortgagePage.getTxt_rate(), rate);
        AppiumActions.singleTap(mortgagePage.getBtn_calculate());

    }
}
