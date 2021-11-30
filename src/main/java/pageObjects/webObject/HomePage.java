package pageObjects.webObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(xpath = "//*[@id='reactRoot']/div/nav/div[2]/div[7]/a")
    private WebElement btn_serverAdmin;
    @FindBy(xpath = "//*[@id='reactRoot']/div/nav/div[2]/div[7]/ul/li[2]/a")
    private WebElement btn_users;
    @FindBy(xpath = "//*[@id='reactRoot']/div/nav/div[2]/div[7]/ul/li[5]/a")
    private WebElement btn_plugins;

    @FindBy(className = "css-1aanzv4")
    private WebElement welcome_h1;

    @Step
    public WebElement getBtn_serverAdmin() {
        return btn_serverAdmin;
    }

    @Step
    public WebElement getBtn_users() {
        return btn_users;
    }

    @Step
    public WebElement getBtn_plugins() {
        return btn_plugins;
    }

    @Step
    public WebElement getWelcome_h1() {
        return welcome_h1;
    }
}
