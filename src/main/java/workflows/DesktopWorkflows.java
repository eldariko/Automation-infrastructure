package workflows;

import extentions.DesktopAction;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import pageObjects.Desktop.CalculatePage;
import utilities.CommonOps;

public class DesktopWorkflows extends CommonOps {

    @Step("Add")
    public static void Add(WebElement element1, WebElement element2, String expectedResult) {
        DesktopAction.click(element1);
        DesktopAction.click(calculatePage.getButton_plus());
        DesktopAction.click(element2);
        DesktopAction.click(calculatePage.getButton_equals());
        String s = GetNumberFromString(calculatePage.getResult().getText());
        softAssert.assertEquals(s, expectedResult);
    }

    @Step("Minus")
    public static void Minus(WebElement element1, WebElement element2, String expectedResult) {
        DesktopAction.click(element1);
        DesktopAction.click(calculatePage.getButton_minus());
        DesktopAction.click(element2);
        DesktopAction.click(calculatePage.getButton_equals());
        String s = GetNumberFromString(calculatePage.getResult().getText());
        softAssert.assertEquals(s, expectedResult);
    }

    @Step("Mult")
    public static void Mult(WebElement element1, WebElement element2, String expectedResult) {
        DesktopAction.click(element1);
        DesktopAction.click(calculatePage.getButton_mult());
        DesktopAction.click(element2);
        DesktopAction.click(calculatePage.getButton_equals());
        String s = GetNumberFromString(calculatePage.getResult().getText());
        softAssert.assertEquals(s, expectedResult);


    }

    @Step("Divide")
    public static void Divide(WebElement element1, WebElement element2, String expectedResult) {
        DesktopAction.click(element1);
        DesktopAction.click(calculatePage.getButton_divide());
        DesktopAction.click(element2);
        DesktopAction.click(calculatePage.getButton_equals());
        String s = GetNumberFromString(calculatePage.getResult().getText());
        softAssert.assertEquals(s, expectedResult);

    }

    @Step("SubString")
    public static String GetNumberFromString(String s) {
        s = s.substring(s.lastIndexOf(' ') + 1);
        System.out.println(s);
        return s;
    }


}