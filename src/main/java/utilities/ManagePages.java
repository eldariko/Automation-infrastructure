package utilities;

public class ManagePages extends Base {

    // Mobile: Initiate UK Mortgage Calc app page Objects
    public static void initUnitConvertor() {
        mortgagePage = new pageObjects.Appium.MortgagePage(mobileDriver);
    }

}
