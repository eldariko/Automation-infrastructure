package workflows;

import extentions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

public class DesktopWorkflows extends CommonOps {

    @Step("Add")
    public static void Add(WebElement element1, WebElement element2) {
        calculate(element1, element2, calculatePage.getButton_plus());
    }

    @Step("Minus")
    public static void Minus(WebElement element1, WebElement element2) {
        calculate(element1, element2, calculatePage.getButton_minus());
    }

    @Step("Mult")
    public static void Mult(WebElement element1, WebElement element2) {
        calculate(element1, element2, calculatePage.getButton_mult());


    }

    @Step("Divide")
    public static void Divide(WebElement element1, WebElement element2) {
        calculate(element1, element2, calculatePage.getButton_divide());

    }

    @Step("SubString")
    public static String GetNumberFromString(String s) {
        s = s.substring(s.lastIndexOf(' ') + 1);
        System.out.println(s);
        return s;
    }

    private static void calculate(WebElement element1, WebElement element2, WebElement operation) {
        UIActions.clickOnElement(element1);
        UIActions.clickOnElement(operation);
        UIActions.clickOnElement(element2);
        UIActions.clickOnElement(calculatePage.getButton_equals());

    }


}