package extentions;


import io.appium.java_client.MobileElement;
import io.appium.java_client.touch.offset.ElementOption;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MobileActions extends UIActions {


    @Step("Update Text Element in mobile device")
    public static void updateText(MobileElement element, String text) {
        wait.until((ExpectedConditions.visibilityOf(element)));
        element.clear();
        element.setValue(text);
    }


    @Step("Single Tap on Element")
    public static void singleTap(MobileElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        touchAction.tap(new ElementOption().withElement(elem)).perform();
    }

/*
    @Step("Long press on Element")
    public static void longPress(MobileElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        touchAction.longPress(new ElementOption().withElement(elem)).perform();
    }
    @Step("Zoom Element")
    public static void zoom(MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));

//        mobileDriver.zoom(elem);
    }
    @Step("Zoom Element")
    public static void pinch(MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
    }
    @Step("Execute Script")
    public static void executeScript(String script) {
        mobileDriver.executeScript(script);
    }
*/


}
