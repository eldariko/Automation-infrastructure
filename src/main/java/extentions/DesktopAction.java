package extentions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

import static org.testng.Assert.assertEquals;

public class DesktopAction extends CommonOps {

    @Step("Click")
    public static void click(WebElement element) {
        element.click();
    }

    @Step("Assert")
    public static void AssertEquals(int x, int y) {
        assertEquals(x, y);
    }
}
