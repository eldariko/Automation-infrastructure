package extentions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilities.CommonOps;

import java.util.List;

public class WebActions extends CommonOps {

    @Step("Get elements list size ")
    public static int getSize(List<WebElement> elementsList) {
        return elementsList.size();
    }

    @Step("Click on an element ")
    public static void clickOnElement(WebElement element) {
        wait.until((ExpectedConditions.visibilityOf(element)));
        element.click();
    }

    @Step("Enter key")
    public static void enterKey(WebElement element, String key) {
        wait.until((ExpectedConditions.visibilityOf(element)));
        element.clear();
        element.sendKeys(key);
    }

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

    @Step("Get element text")
    public static String getElementText(WebElement element) {
        return element.getText();
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
}
