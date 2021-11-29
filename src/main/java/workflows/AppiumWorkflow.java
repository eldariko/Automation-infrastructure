package workflows;

import extentions.AppiumActions;
import utilities.CommonOps;

public class AppiumWorkflow extends CommonOps {

    public static void calculateMortgage(String amount, String term, String rate) {
        AppiumActions.updateText(mortgagePage.getTxt_amount(), amount);
        AppiumActions.updateText(mortgagePage.getTxt_term(), term);
        AppiumActions.updateText(mortgagePage.getTxt_rate(), rate);
        AppiumActions.singleTap(mortgagePage.getBtn_calculate());

    }
}
