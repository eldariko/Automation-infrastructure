package extentions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

public class WebActions extends CommonOps {
    @Step("Click on an element ")
    public static void clickOnElement(WebElement element){
        element.click();
    }
    @Step("Enter key")
    public static void enterKey(WebElement element,String key){
        element.clear();
        element.sendKeys(key);
    }
    @Step("Get element text")
    public static void getElementText(WebElement element){
        element.getText();
    }
}
