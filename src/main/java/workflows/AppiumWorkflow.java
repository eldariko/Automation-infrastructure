package workflows;

import extentions.AppiumActions;
import utilities.CommonOps;

public class AppiumWorkflow extends CommonOps {

    public static void calculateMortgage(String amount, String term, String rate) {
        AppiumActions.updateText(mortgagePage.getTxt_amount(), "12");
        AppiumActions.updateText(mortgagePage.getTxt_term(), "4");
        AppiumActions.updateText(mortgagePage.getTxt_rate(), "50");
        AppiumActions.singleTap(mortgagePage.getBtn_calculate());
    }
}
