package workflows;

import extentions.AppiumActions;
import pageObjects.Appium.UnitConvertorPage;
import utilities.CommonOps;

public class AppiumWorkflow extends CommonOps {

    public static void getLengthBy(String unit) {
        AppiumActions.singleTap(unitConvertorPage.getLengthTab());
        AppiumActions.singleTap(unitConvertorPage.getTextInput());
        AppiumActions.updateText(unitConvertorPage.getTextInput(), "43");
    }
}
