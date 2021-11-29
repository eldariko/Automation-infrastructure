package pageObjects.webObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(xpath = "//div/input")
    public static WebElement txt_userName;
    @FindBy(xpath = "//div[@class='css-1w5c5dq-input-inputWrapper']/input[@id='current-password']")
    public static WebElement txt_password;
}
