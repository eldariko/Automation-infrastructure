package extentions;


import io.appium.java_client.MobileElement;
import io.appium.java_client.touch.offset.ElementOption;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppiumActions extends WebActions {

    @Step("Update Text Element")
    public static void updateText(MobileElement elem, String text) {
        wait.until((ExpectedConditions.visibilityOf(elem)));
        elem.clear();
        elem.setValue(text);
    }


    @Step("Single Tap on Element")
    public static void singleTap(MobileElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        touchAction.tap(new ElementOption().withElement(elem)).perform();
    }

//    @Step("Long press on Element")
//    public static void longPress(MobileElement elem) {
//        wait.until(ExpectedConditions.elementToBeClickable(elem));
//        touchAction.longPress(new ElementOption().withElement(elem)).perform();
//    }


//    @Step("Zoom Element")
//    public static void zoom(MobileElement elem) {
//        wait.until(ExpectedConditions.visibilityOf(elem));
//
////        mobileDriver.zoom(elem);
//    }

//    @Step("Zoom Element")
//    public static void pinch(MobileElement elem) {
//        wait.until(ExpectedConditions.visibilityOf(elem));
//    }

//    @Step("Execute Script")
//    public static void executeScript(String script) {
//        mobileDriver.executeScript(script);
//    }


}
