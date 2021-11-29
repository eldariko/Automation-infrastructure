package extentions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.CommonOps;

import java.util.List;

public class WebActions extends CommonOps {

    @Step("Get elements list size ")
    public static int getSize(List<WebElement> elementsList){
        return elementsList.size();
    }
    @Step("Click on an element ")
    public static void clickOnElement(WebElement element){
        element.click();
    }
    @Step("Enter key")
    public static void enterKey(WebElement element,String key){
        element.clear();
        element.sendKeys(key);
    }
    @Step("Element is displayed")
    public static void elementIsDisplayed(WebElement element){
        element.isDisplayed();
    }
    @Step("Element is enabled")
    public static void elementIsEnabled(WebElement element){
        element.isEnabled();
    }
    @Step("Element is selected")
    public static void elementIsSelected(WebElement element){
        element.isSelected();
    }
    @Step("Get element text")
    public static void getElementText(WebElement element){
        element.getText();
    }
}
