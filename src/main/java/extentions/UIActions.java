package extentions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.List;

public class UIActions extends CommonOps {

    @Step("Get elements list size ")
    public static int getElemListSize(List<WebElement> elementsList) {
        return elementsList.size();
    }

    @Step("Click on an element ")
    public static void clickOnElement(WebElement element) {
        wait.until((ExpectedConditions.visibilityOf(element)));
        element.click();
    }

    @Step("Enter key")
    public static void updateText(WebElement element, String text) {
        wait.until((ExpectedConditions.visibilityOf(element)));
        element.clear();
        element.sendKeys(text);
    }

    @Step("Get element text")
    public static String getElementText(WebElement element) {
        return element.getText();
    }

    public static void moveToElement(Actions action, WebElement element) {
        action.moveToElement(element).build().perform();
    }


    @Step("Perform action ")
    public static void performAction(Action action) {
        action.perform();
    }
/*
    @Step("Element is displayed")
    public static void elementIsDisplayed(WebElement element) {
        element.isDisplayed();
    }

    @Step("Element is enabled")
    public static void elementIsEnabled(WebElement element) {
        element.isEnabled();
    }

    @Step("Element is selected")
    public static void elementIsSelected(WebElement element) {
        element.isSelected();
    }


    @Step("Assert true")
    public static void assertTrue(boolean flag) {
        Assert.assertTrue(flag);
    }

    @Step("Assert if numbers are equals")
    public static void assertEquals(int number1, int number2) {
        Assert.assertEquals(number1, number2);
    }

    @Step("Assert if strings are equals")
    public static void assertEquals(String str1, String str2) {
        Assert.assertEquals(str1, str2);
    }
*/
}
