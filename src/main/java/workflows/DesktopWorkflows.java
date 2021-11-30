//package workflows;
//
//import extentions.DesktopAction;
//import io.qameta.allure.Step;
//import org.openqa.selenium.WebElement;
//import pageObjects.Desktop.CalculatePage;
//import utilities.CommonOps;
//
//public class DesktopWorkflows extends CommonOps {
//
//    @Step("Add")
//    public static void Add(WebElement element1, WebElement element2){
//        DesktopAction.click(element1);
//        DesktopAction.click(CalculatePage.button_plus);
//        DesktopAction.click(element2);
//        DesktopAction.click(CalculatePage.button_equals);
//    }
//
//    @Step("Minus")
//    public static void Minus(WebElement element1, WebElement element2){
//        DesktopAction.click(element1);
//        DesktopAction.click(CalculatePage.button_minus);
//        DesktopAction.click(element2);
//        DesktopAction.click(CalculatePage.button_equals);
//    }
//
//    @Step("Mult")
//    public static void Mult(WebElement element1, WebElement element2){
//        DesktopAction.click(element1);
//        DesktopAction.click(CalculatePage.button_mult);
//        DesktopAction.click(element2);
//        DesktopAction.click(CalculatePage.button_equals);
//    }
//
//    @Step("Divide")
//    public static void Divide(WebElement element1, WebElement element2){
//        DesktopAction.click(element1);
//        DesktopAction.click(CalculatePage.button_divide);
//        DesktopAction.click(element2);
//        DesktopAction.click(CalculatePage.button_equals);
//    }
//
//    @Step("Assert")
//    public static void AssertResult(int x, int y){
//        DesktopAction.AssertEquals(x,y);
//    }
//
//
//}
