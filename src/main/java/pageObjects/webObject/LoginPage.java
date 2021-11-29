package pageObjects.webObject;

<<<<<<< Updated upstream
=======
import io.qameta.allure.Step;
>>>>>>> Stashed changes
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
<<<<<<< Updated upstream
    @FindBy(xpath = "//div/input")
    public static WebElement txt_userName;
    @FindBy(xpath = "//div[@class='css-1w5c5dq-input-inputWrapper']/input[@id='current-password']")
    public static WebElement txt_password;
=======

    @FindBy(xpath = "//div/input")
    private WebElement txt_userName;
    @FindBy(xpath = "//div[@class='css-1w5c5dq-input-inputWrapper']/input[@id='current-password']")
    private WebElement txt_password;
    @FindBy(xpath = "//button[@class='css-1tbo7ox-button']")
    private WebElement btn_skip;

    @Step
    public WebElement getTxt_userName(){
        return txt_userName;
    }
    @Step
    public WebElement getTxt_password(){
        return txt_password;
    }
    @Step
    public WebElement getBtn_skip(){
        return btn_skip;
    }
>>>>>>> Stashed changes
}
