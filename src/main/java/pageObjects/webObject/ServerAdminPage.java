package pageObjects.webObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.CommonOps;

import java.util.List;

public class ServerAdminPage extends CommonOps {
    @FindBy(xpath = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/div[1]/a/span")
    private WebElement btn_createNewUser;
    @FindBy(xpath = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/form/div[1]/div[2]/div[1]/div/input")
    private WebElement txt_name;
    @FindBy(xpath = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/form/div[2]/div[2]/div/div/input")
    private WebElement txt_email;
    @FindBy(xpath = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/form/div[3]/div[2]/div/div/input")
    private WebElement txt_username;
    @FindBy(xpath = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/form/div[4]/div[2]/div/div/input")
    private WebElement txt_password;
    @FindBy(xpath = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/form/button/span")
    private WebElement btn_register;
    @FindBy(xpath = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/div[2]/table/tbody/tr")
    private List<WebElement> txt_tableBody;
    @FindBy(xpath = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/div[1]/div[2]/button[1]/span")
    private WebElement btn_deleteUser;
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/button/span")
    private WebElement btn_confirmDeleteUser;
    @FindBy(xpath = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/div/div/div[1]/div[2]/div[2]/div/label[1]")
    private WebElement btn_viewAllPlugins;
    @FindBy(xpath = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/div/div/div[2]/div/div")
    private List<WebElement> btn_allPlugins;


    @Step
    public WebElement getBtn_createNewUser() {
        return btn_createNewUser;
    }

    @Step
    public WebElement getTxt_name() {
        return txt_name;
    }

    @Step
    public WebElement getTxt_email() {
        return txt_email;
    }

    @Step
    public WebElement getTxt_username() {
        return txt_username;
    }

    @Step
    public WebElement getTxt_password() {
        return txt_password;
    }

    @Step
    public WebElement getBtn_register() {
        return btn_register;
    }

    @Step
    public List<WebElement> getTxt_tableBody() {
        return txt_tableBody;
    }

    @Step
    public WebElement getBtn_deleteUser() {
        return btn_deleteUser;
    }

    @Step
    public WebElement getBtn_confirmDeleteUser() {
        return btn_confirmDeleteUser;
    }

    @Step
    public WebElement getRowByIndex(int index) {
        return driver.findElement(By.xpath("//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/div[2]/table/tbody/tr[" + index + "]/td[2]"));
    }

    @Step
    public WebElement getBtn_viewAllPlugins() {
        return btn_viewAllPlugins;
    }

    @Step
    public List<WebElement> getBtn_allPlugins() {
        return btn_allPlugins;
    }
}
