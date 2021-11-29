package pageObjects.Appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UnitConvertorPage {

    private AppiumDriver mobileDriver;

    public UnitConvertorPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(id = "etAmount")
    public AndroidElement txt_amount;


    @AndroidFindBy(xpath = "//*[@id='tab0_layout0']")
    private AndroidElement lengthTab;

    public AndroidElement getLengthTab() {
        return lengthTab;
    }

    @AndroidFindBy(xpath = "//*[@id='tab0_input']")
    private AndroidElement textInput;

//    @AndroidFindBy(xpath = "//*[@id='tab0_layout1']")

    public AndroidElement getTextInput() {
        return textInput;
    }
}
