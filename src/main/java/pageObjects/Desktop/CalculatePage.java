package pageObjects.Desktop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatePage {
    @FindBy(name = "אחת")
    public static WebElement button_1;

    @FindBy(name = "שתיים")
    public static WebElement button_2;

    @FindBy(name = "שלוש")
    public static WebElement button_3;

    @FindBy(name = "ארבע")
    public static WebElement button_4;

    @FindBy(name = "חמש")
    public static WebElement button_5;

    @FindBy(name = "שש")
    public static WebElement button_6;

    @FindBy(name = "שבע")
    public static WebElement button_7;

    @FindBy(name = "שמונה")
    public static WebElement button_8;

    @FindBy(name = "תשע")
    public static WebElement button_9;

    @FindBy(name = "עשר")
    public static WebElement button_10;

    @FindBy(name = "שווה")
    public static WebElement button_equals;

    @FindBy(name = "ועוד")
    public static WebElement button_plus;

    @FindBy(name = "פחות")
    public static WebElement button_minus;

    @FindBy(name = "הכפל ב")
    public static WebElement button_mult;

    @FindBy(name = "חלק ב")
    public static WebElement button_divide;
}


