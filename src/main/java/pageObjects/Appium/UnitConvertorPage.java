package pageObjects.Appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class UnitConvertorPage {

    private AppiumDriver mobileDriver;

    public UnitConvertorPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        //PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id = "etAmount")
    public AndroidElement txt_amount;

}
