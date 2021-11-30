package pageObjects.Electron;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.CommonOps;

import java.util.List;


public class TodoPage extends CommonOps {
    @FindBy(xpath = "//div/input")
    private WebElement txt_enterTask;
    @FindBy(xpath = "/html/body/div/div[1]/div[4]/div[2]/div/div")
    private List<WebElement> btn_allTasks;


    @Step
    public List<WebElement> getBtn_allTasks() {
        return btn_allTasks;
    }

    @Step
    public WebElement getTxt_enterTask() {
        return txt_enterTask;
    }

    @Step
    public WebElement getBtn_deleteTaskByLocation(int index) {
        return driver.findElement(By.xpath("/html/body/div/div[1]/div[4]/div[2]/div/div[" + index + "]/div/div/*[name()='svg']"));
    }

    @Step
    public WebElement getTaskByLocation(int index) {
        return driver.findElement(By.xpath("/html/body/div/div[1]/div[4]/div[2]/div/div[" + index + "]"));
    }
}