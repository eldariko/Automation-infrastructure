package pageObjects.Desktop;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatePage {
    @FindBy(xpath = "//*[@AutomationId='num1Button']")
    public WebElement button_1;

    @FindBy(xpath = "//*[@AutomationId='num2Button']")
    public WebElement button_2;

    @FindBy(xpath = "//*[@AutomationId='num3Button']")
    public WebElement button_3;

    @FindBy(xpath = "//*[@AutomationId='num4Button']")
    public WebElement button_4;

    @FindBy(xpath = "//*[@AutomationId='num5Button']")
    public WebElement button_5;

    @FindBy(xpath = "//*[@AutomationId='num6Button']")
    public WebElement button_6;

    @FindBy(xpath = "//*[@AutomationId='num7Button']")
    private WebElement button_7;

    @FindBy(xpath = "//*[@AutomationId='num8Button']")
    private WebElement button_8;

    @FindBy(xpath = "//*[@AutomationId='num9Button']")
    private WebElement button_9;

    @FindBy(xpath = "//*[@AutomationId='num0Button']")
    private WebElement button_0;

    @FindBy(xpath = "//*[@AutomationId='equalButton']")
    private WebElement button_equals;

    @FindBy(xpath = "//*[@AutomationId='plusButton']")
    private WebElement button_plus;

    @FindBy(xpath = "//*[@AutomationId='minusButton']")
    private WebElement button_minus;

    @FindBy(xpath = "//*[@AutomationId='multiplyButton']")
    private WebElement button_mult;

    @FindBy(xpath = "//*[@AutomationId='divideButton']")
    private WebElement button_divide;

    @FindBy(xpath = "//*[@AutomationId='CalculatorResults']")
    private WebElement result;

    public WebElement getButton_1() {
        return button_1;
    }

    public WebElement getButton_3() {
        return button_3;
    }

    public WebElement getButton_4() {
        return button_4;
    }

    public WebElement getButton_5() {
        return button_5;
    }

    public WebElement getButton_6() {
        return button_6;
    }

    public WebElement getButton_7() {
        return button_7;
    }

    public WebElement getButton_8() {
        return button_8;
    }

    public WebElement getButton_9() {
        return button_9;
    }

    public WebElement getButton_0() {
        return button_0;
    }

    public WebElement getButton_equals() {
        return button_equals;
    }

    public WebElement getButton_plus() {
        return button_plus;
    }

    public WebElement getButton_minus() {
        return button_minus;
    }

    public WebElement getButton_mult() {
        return button_mult;
    }

    public WebElement getButton_divide() {
        return button_divide;
    }

    public WebElement getResult() {
        return result;
    }

    public WebElement getButton_2() {
        return button_2;
    }


}


